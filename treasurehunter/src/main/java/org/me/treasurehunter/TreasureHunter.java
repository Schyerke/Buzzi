package org.me.treasurehunter;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.me.treasurehunter.listeners.*;
import org.me.treasurehunter.managers.game.GameManager;
import org.me.treasurehunter.managers.PlayerManager;
import org.me.treasurehunter.managers.WorldManager;
import org.me.treasurehunter.menusystem.PlayerMenuUtility;
import org.me.treasurehunter.world.PlayerTravelWorldsListener;
import org.me.treasurehunter.world.WorldTraveler;

import java.util.HashMap;

public final class TreasureHunter extends JavaPlugin {
    private static TreasureHunter instance;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        WorldTraveler worldTraveler = new WorldTraveler();
        WorldManager worldManager = new WorldManager();

        PlayerManager playerManager = new PlayerManager(worldManager, worldTraveler);
        GameManager gameManager = new GameManager(playerManager, worldTraveler);

        //listeners
        getServer().getPluginManager().registerEvents(new PlayerTravelWorldsListener(worldTraveler), instance);

        getServer().getPluginManager().registerEvents(new ChestListener(gameManager), instance);
        getServer().getPluginManager().registerEvents(new DefaultWorldListener(worldManager), instance);
        getServer().getPluginManager().registerEvents(new MenuListener(), instance);
        getServer().getPluginManager().registerEvents(new PlayerItemTriggerListener(gameManager), instance);
        getServer().getPluginManager().registerEvents(new PlayerListener(playerManager, worldManager, worldTraveler, gameManager), instance);
        getServer().getPluginManager().registerEvents(new ChestListener(gameManager), instance);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TreasureHunter getInstance() {
        return instance;
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p);
        }
    }
}
