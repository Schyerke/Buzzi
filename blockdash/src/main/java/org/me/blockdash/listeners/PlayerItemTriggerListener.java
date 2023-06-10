package org.me.blockdash.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.me.blockdash.BlockDash;
import org.me.blockdash.managers.GameManager;
import org.me.blockdash.menusystem.menu.MainMenu;

import java.util.List;

public class PlayerItemTriggerListener implements Listener {
    private final GameManager gameManager;

    public PlayerItemTriggerListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void openMainMenu(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem() == null)
                return;
            if(e.getItem().getItemMeta() == null)
                return;
            if(e.getItem().getItemMeta().lore() == null)
                return;
            List<Component> lore = e.getItem().getItemMeta().lore();

            if(lore == null)
                return;

            if(lore.contains(Component.text("Main Menu, right click on me to play!"))) {
                new MainMenu(BlockDash.getPlayerMenuUtility(e.getPlayer()), gameManager).open();
            }
        }
    }
}
