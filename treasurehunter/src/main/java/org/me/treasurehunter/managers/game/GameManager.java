package org.me.treasurehunter.managers.game;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.me.treasurehunter.TreasureHunter;
import org.me.treasurehunter.managers.PlayerManager;
import org.me.treasurehunter.utils.IterableUtility;
import org.me.treasurehunter.world.WorldTraveler;

import java.util.HashSet;
import java.util.Set;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;
import static net.kyori.adventure.title.Title.title;

public class GameManager {

    public enum GameState{
        SPAWN,
        STARTING,
        START
    }

    private GameState gameState;
    private final PlayerManager playerManager;
    private final WorldTraveler worldTraveler;
    private final BlockManager blockManager;
    private final ChestManager chestManager;

    private final Set<Player> readySet = new HashSet<>();

    public GameManager(PlayerManager playerManager, WorldTraveler worldTraveler) {
        this.playerManager = playerManager;
        this.worldTraveler = worldTraveler;

        this.blockManager = new BlockManager(this);
        this.chestManager = new ChestManager(this, worldTraveler);
    }

    public void queueOrStart(Player whoClicked) {
        if(readySet.contains(whoClicked)) {
            whoClicked.sendMessage(text("You are already queueing!", TextColor.color(0, 255, 0)));
            return;
        }

        readySet.add(whoClicked);

        if(IterableUtility.sameSize(Bukkit.getOnlinePlayers(), readySet)) {
            setGameState(GameState.STARTING);
        }
    }

    private void setGameState(GameState gameState) {
        this.gameState = gameState;

        switch (gameState) {
            case SPAWN -> {
                playerManager.managePlayerOnJoin(Bukkit.getOnlinePlayers());
            }
            case STARTING -> {
                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    onlinePlayer.closeInventory();
                    onlinePlayer.showTitle(title(
                            text("Launching a new game", color(255, 0, 0)),
                            text("Wait...", color(255, 255, 0)))
                    );
                }

                worldTraveler.createNormalWorlds();

                for(Player online : Bukkit.getOnlinePlayers()) {
                    playerManager.settingsWhenTeleported(online);
                }

                Bukkit.getScheduler().runTaskLater(TreasureHunter.getInstance(), () -> setGameState(GameState.START), 20 * 2);
            }
            case START -> {
                chestManager.spawnChest(3000, 40, 3000);
            }
            default -> {
                Bukkit.broadcast(text("Error occurred in setGameState(GameState): No such GameState instance found in the switch statement"));
            }
        }
    }

    public GameState getGameState(){
        return this.gameState;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public ChestManager getChestManager() {
        return chestManager;
    }
}
