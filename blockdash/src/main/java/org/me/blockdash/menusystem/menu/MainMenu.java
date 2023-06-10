package org.me.blockdash.menusystem.menu;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.me.blockdash.managers.GameManager;
import org.me.blockdash.menusystem.Menu;
import org.me.blockdash.menusystem.PlayerMenuUtility;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;
import static net.kyori.adventure.title.Title.title;

public class MainMenu extends Menu {
    private final GameManager gameManager;

    public MainMenu(PlayerMenuUtility playerMenuUtility, GameManager gameManager) {
        super(playerMenuUtility);

        this.gameManager = gameManager;
    }

    @Override
    public TextComponent getMenuName() {
        return text("Main");
    }

    @Override
    public int getSlots() {
        return 9*2;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {
        e.setCancelled(true);

        if(e.getCurrentItem() == null) {
            return;
        }

        Player whoClicked = (Player) e.getWhoClicked();

        switch (e.getCurrentItem().getType()) {
            case DIAMOND_SWORD -> {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    player.closeInventory();
                    player.showTitle(title(
                            text("Launching a new game", color(255, 0, 0)),
                            text("Wait...", color(255, 255, 0)))
                    );
                }

                this.gameManager.queueOrStart(whoClicked);
            }
            default -> {
                whoClicked.sendMessage(text("Something went wrong...", color(255, 0, 0)));
            }
        }
    }

    @Override
    public void setMenuItems() {
        ItemStack startItem = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta startItemMeta = startItem.getItemMeta();
        startItemMeta.displayName(text("Start a Game!"));
        startItem.setItemMeta(startItemMeta);

        inventory.addItem(startItem);
    }
}
