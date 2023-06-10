package org.me.treasurehunter.managers;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldManager {

    public void teleportToSpawn(Player player) {
        World defaultWorld = getDefaultWorld();
        player.teleport(defaultWorld.getSpawnLocation().add(0, 0.1, 0));
    }

    public boolean compareToDefaultWorld(World worldToCompare) {
        World defaultWorld = getDefaultWorld();
        return defaultWorld.getName().equalsIgnoreCase(worldToCompare.getName());
    }

    private World getDefaultWorld(){
        World defaultWorld = Bukkit.getWorld("world");
        assert defaultWorld != null : "Default world is null";
        return defaultWorld;
    }
}
