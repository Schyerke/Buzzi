package org.me.treasurehunter.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.me.treasurehunter.TreasureHunter;
import org.me.treasurehunter.managers.game.GameManager;
import org.me.treasurehunter.menusystem.menu.MainMenu;

import java.util.List;

public class PlayerItemTriggerListener implements Listener {
    private final GameManager gameManager;

    public PlayerItemTriggerListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void openMainMenu(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() == null)
                return;
            if(event.getItem().getItemMeta() == null)
                return;
            if(event.getItem().getItemMeta().lore() == null)
                return;
            List<Component> lore = event.getItem().getItemMeta().lore();

            if(lore == null)
                return;

            if(lore.contains(Component.text("Main Menu, right click on me to play!"))) {
                new MainMenu(TreasureHunter.getPlayerMenuUtility(event.getPlayer()), gameManager).open();
            }
        }
    }
}
