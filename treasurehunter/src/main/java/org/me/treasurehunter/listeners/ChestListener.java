package org.me.treasurehunter.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.me.treasurehunter.managers.game.ChestManager;
import org.me.treasurehunter.managers.game.GameManager;

public class ChestListener implements Listener {
    private final GameManager gameManager;
    private final ChestManager chestManager;

    public ChestListener(GameManager gameManager) {
        this.gameManager = gameManager;

        this.chestManager = gameManager.getChestManager();
    }

    @EventHandler
    public void chestOpen(PlayerInteractEvent event) {
        if(event.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        Block block = event.getClickedBlock();

        if(block == null)
            return;

        if(block.equals(chestManager.getChestBlock())
                    && block.getLocation().equals(chestManager.getChestLocation())) {
            
        }
    }
}
