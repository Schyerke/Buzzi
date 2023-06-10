package org.me.blockdash.managers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

import static net.kyori.adventure.text.Component.text;

public class PlayerManager {

    public void teleportWhenJoin(Iterable<? extends Player> players) {
        World world = Bukkit.getWorld("world");
        assert world != null;
        Location spawnLocation = world.getSpawnLocation();
        for(Player player : players) {
            player.teleport(spawnLocation);
            settingsWhenJoin(player);
        }
    }

    public void teleportWhenJoin(Player player) {
        World world = Bukkit.getWorld("world");
        assert world != null;
        Location spawnLocation = world.getSpawnLocation();
        player.teleport(spawnLocation);

        settingsWhenJoin(player);
    }

    private void settingsWhenJoin(Player player) {
        player.setAllowFlight(true);
        player.setInvulnerable(true);
        player.setFoodLevel(20);
        player.setHealth(20);
        player.getInventory().clear();

        ItemStack[] items = playerJoinItems();
        player.getInventory().addItem(items);
    }

    private ItemStack[] playerJoinItems(){
        ItemStack mainMenuTrigger = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta mainMenuTriggerMeta = mainMenuTrigger.getItemMeta();
        mainMenuTriggerMeta.displayName(text("Main Menu"));
        mainMenuTriggerMeta.lore(List.of(text("Main Menu, right click on me to play!")));

        mainMenuTrigger.setItemMeta(mainMenuTriggerMeta);

        ItemStack[] items = {
                mainMenuTrigger
        };

        return items;
    }
}

