package org.me.blockdash.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.me.blockdash.BlockDash;
import org.me.blockdash.tasks.StandOnBlockTask;
import org.me.blockdash.world.WorldTraveler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;

public class GameManager {
    private final List<Player> readyList = new ArrayList<>();
    private final List<Player> wonList = new ArrayList<>();
    private final List<Player> lostList = new ArrayList<>();
    private final HashMap<Player, Material> blocksToStandOn = new HashMap<>();

    private final WorldTraveler worldTraveler;
    private final PlayerManager playerManager;

    private final BlockManager blockManager;

    private GameState gameState;
    private StandOnBlockTask standOnBlockTask;

    public GameManager(WorldTraveler worldTraveler, PlayerManager playerManager) {
        this.worldTraveler = worldTraveler;
        this.playerManager = playerManager;

        this.blockManager = new BlockManager(this);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;

        switch (this.gameState){
            case STARTING -> {
                worldTraveler.createNormalWorlds();
                for(Player online : Bukkit.getOnlinePlayers()) {
                    settingsWhenTeleported(online);
                }

                setGameState(GameState.ACTIVE_NEXT_CHALLENGE);
            }
            case ACTIVE_NEXT_CHALLENGE -> {
                try{
                    if(standOnBlockTask != null) {
                        standOnBlockTask.cancel();
                    }
                } catch (IllegalStateException ignored) {

                }

                this.wonList.clear();
                this.lostList.clear();
                this.blocksToStandOn.clear();

                for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                    this.blocksToStandOn.put(onlinePlayer, BlockDash.BLOCKS.get(new Random().nextInt(BlockDash.BLOCKS.size())));
                }
                standOnBlockTask = new StandOnBlockTask(this, this.blocksToStandOn);
                standOnBlockTask.runTaskTimer(BlockDash.getInstance(), 2*20, 20);
            }
            case END -> {
                try {
                    this.standOnBlockTask.cancel();
                } catch (IllegalStateException ignored) {

                }
                for (Player player : Bukkit.getOnlinePlayers()) {
                    playerManager.teleportWhenJoin(player);
                    if(wonList.contains(player)) {
                        Bukkit.broadcast(text(player.getName() + " loves Kriz", color(0, 255, 0)));
                    } else {
                        Bukkit.broadcast(text(player.getName() + " couldn't stand on a funny block!", color(255, 0, 0)));
                    }
                }
                this.readyList.clear();
                this.wonList.clear();
                this.lostList.clear();
                this.blocksToStandOn.clear();
            }
        }
    }

    public void queueOrStart(Player whoClicked) {
        if(readyList.contains(whoClicked)) {
            whoClicked.sendMessage(text("You are already in the ready list", color(0, 255, 0)));
            return;
        }

        readyList.add(whoClicked);

        if(sameSize(Bukkit.getOnlinePlayers(), readyList)) {
            setGameState(GameState.STARTING);
            return;
        }
        whoClicked.sendMessage(text("Not enough players!", color(255, 0, 0)));
    }

    private void settingsWhenTeleported(Player player) {
        player.teleport(worldTraveler.getWorldByWorldEnv(World.Environment.NORMAL).getSpawnLocation());
        player.setHealth(20);
        player.setExp(0);
        player.setBedSpawnLocation(worldTraveler.getWorldByWorldEnv(World.Environment.NORMAL).getSpawnLocation());
        player.setAllowFlight(false);
        player.setLevel(0);
        player.setTotalExperience(0);
        player.setInvulnerable(false);
        player.getInventory().clear();
    }

    public boolean sameSize(Iterable<? extends Player> players1, Iterable<? extends Player> players2) {
        int p1index = 0;
        int p2index = 0;
        for(Player ignored : players1) {
            p2index++;
        }
        for(Player ignored : players2) {
            p1index++;
        }
        return p1index == p2index;
    }


    public List<Player> getReadyList() {
        return readyList;
    }

    public HashMap<Player, Material> getBlocksToStandOn() {
        return blocksToStandOn;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<Player> getLostList() {
        return lostList;
    }

    public List<Player> getWonList() {
        return wonList;
    }

    public BlockManager getBlockManager() {
        return blockManager;
    }

    public StandOnBlockTask getStandOnBlockTask() {
        return standOnBlockTask;
    }

    public void endByPlayerQuit(Player commandIssuer) {
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if(onlinePlayer.equals(commandIssuer)) {
                lostList.add(onlinePlayer);
            } else {
                wonList.add(onlinePlayer);
            }
        }

        Bukkit.getScheduler().runTaskLater(BlockDash.getInstance(), () -> setGameState(GameState.END), 20*8);
    }
}
