package org.me.blockdash.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.me.blockdash.managers.GameManager;
import org.me.blockdash.managers.GameState;
import org.me.blockdash.managers.PlayerManager;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;
import static net.kyori.adventure.text.format.TextDecoration.BOLD;
import static net.kyori.adventure.title.Title.title;

public class PlayerListener implements Listener {
    private final GameManager gameManager;
    private final PlayerManager playerManager;

    public PlayerListener(GameManager gameManager, PlayerManager playerManager) {
        this.gameManager = gameManager;
        this.playerManager = playerManager;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.showTitle(title(
                text("BlockDash", color(255, 0, 0)),
                text("For my love Krisztina", color(255, 255, 0)))
        );

        playerManager.teleportWhenJoin(player);
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        gameManager.getReadyList().remove(player);
        gameManager.getLostList().remove(player);
        gameManager.getWonList().remove(player);

        if(gameManager.getGameState() == GameState.ACTIVE_NEXT_CHALLENGE) {
            gameManager.endByPlayerQuit(player);
        }
    }

    @EventHandler
    public void playerGotBlockToStandOn(EntityPickupItemEvent event) {
        if(event.getEntity() instanceof Player player) {
            if(event.getItem().getItemStack().getType() == gameManager.getBlocksToStandOn().get(player)){
                Bukkit.broadcast(text(player.getName() + " has found their block!", color(255, 182, 193)).decorate(BOLD));
            }
        }
    }

    @EventHandler
    public void checkPlayerUnderBlock(PlayerMoveEvent event) {
        if(event.getPlayer().getWorld() == Bukkit.getWorld("world")){
            return;
        }

        if(gameManager.getGameState() != GameState.ACTIVE_NEXT_CHALLENGE){
            return;
        }

        if(gameManager.getBlockManager().playerIsNotOnTheBlock(event.getPlayer())){
            return;
        }

        if(gameManager.sameSize(gameManager.getWonList(), Bukkit.getOnlinePlayers())) {
            gameManager.setGameState(GameState.ACTIVE_NEXT_CHALLENGE);
        }
    }

    @EventHandler
    public void foodLevel(FoodLevelChangeEvent e) {
        Player player = (Player) e.getEntity();
        if(Bukkit.getWorld("world") == player.getWorld()){
            e.setCancelled(true);
        }
    }
}
