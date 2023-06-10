package org.me.treasurehunter.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.me.treasurehunter.menusystem.Menu;

public class MenuListener implements Listener {

    @EventHandler
    public void mainMenuTriggered(InventoryClickEvent e){
        InventoryHolder holder = e.getInventory().getHolder();
        if (holder instanceof Menu menu) {
            e.setCancelled(true); //prevent them from fucking with the inventory
            if (e.getCurrentItem() == null)
                return;

            menu.handleMenu(e);
        }
    }
}
