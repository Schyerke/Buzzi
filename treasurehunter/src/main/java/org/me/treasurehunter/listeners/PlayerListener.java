package org.me.treasurehunter.listeners;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.me.treasurehunter.managers.game.GameManager;
import org.me.treasurehunter.managers.PlayerManager;
import org.me.treasurehunter.managers.WorldManager;
import org.me.treasurehunter.world.WorldTraveler;

public class PlayerListener implements Listener {
    private final PlayerManager playerManager;
    private final WorldManager worldManager;
    private final WorldTraveler worldTraveler;
    private final GameManager gameManager;

    public PlayerListener(PlayerManager playerManager, WorldManager worldManager, WorldTraveler worldTraveler, GameManager gameManager) {
        this.playerManager = playerManager;
        this.worldManager = worldManager;
        this.worldTraveler = worldTraveler;
        this.gameManager = gameManager;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        playerManager.managePlayerOnJoin(event.getPlayer());
    }

    @EventHandler
    public void playerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        if(gameManager.getGameState() == GameManager.GameState.STARTING || gameManager.getGameState() == GameManager.GameState.START)
            return;

        if(worldManager.compareToDefaultWorld(player.getWorld()))
            return;

        Location spawnLocationGameWorld = worldTraveler.getWorldByWorldEnv(World.Environment.NORMAL).getSpawnLocation();
        player.teleport(spawnLocationGameWorld.add(0, 0.1, 0));
    }
}
