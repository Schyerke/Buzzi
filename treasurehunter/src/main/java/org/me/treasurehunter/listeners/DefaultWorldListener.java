package org.me.treasurehunter.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.me.treasurehunter.managers.WorldManager;

public class DefaultWorldListener implements Listener {
    private final WorldManager worldManager;

    public DefaultWorldListener(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    @EventHandler
    public void preventMainItemsToDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if(worldManager.compareToDefaultWorld(player.getWorld()))
            event.setCancelled(true);
    }

    @EventHandler
    public void preventFoodLevelToDecrease(FoodLevelChangeEvent event) {
        Player player = (Player) event.getEntity();
        if(worldManager.compareToDefaultWorld(player.getWorld()))
            event.setCancelled(true);
    }

    @EventHandler
    public void preventHealthToDecrease(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player) {
            if(worldManager.compareToDefaultWorld(player.getWorld()))
                event.setCancelled(true);
        }
    }
}
