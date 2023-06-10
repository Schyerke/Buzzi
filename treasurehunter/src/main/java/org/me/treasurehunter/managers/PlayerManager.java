package org.me.treasurehunter.managers;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.me.treasurehunter.world.WorldTraveler;

import java.util.List;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;
import static net.kyori.adventure.title.Title.title;

public class PlayerManager {
    private final WorldManager worldManager;
    private final WorldTraveler worldTraveler;

    public PlayerManager(WorldManager worldManager, WorldTraveler worldTraveler) {
        this.worldManager = worldManager;
        this.worldTraveler = worldTraveler;
    }

    public void managePlayerOnJoin(Iterable<? extends Player> players) {
        for(Player player : players) {
            managePlayerOnJoin(player);
        }
    }

    public void managePlayerOnJoin(Player player) {
        player.sendMessage(text("Welcome to treasure hunter!", color(0, 255, 0)));

        player.showTitle(
                title(
                        text("For my love Krisztina!", color(255, 0, 0)),
                        text("Have fun", color(0, 255, 0))
                )
        );

        worldManager.teleportToSpawn(player);
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

    public void settingsWhenTeleported(Player player) {
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
}
