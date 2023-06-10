package org.me.blockdash;

import org.bukkit.Material;
import org.bukkit.block.data.*;
import org.bukkit.block.data.type.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.me.blockdash.commands.SpawnCommand;
import org.me.blockdash.listeners.MenuListener;
import org.me.blockdash.listeners.PlayerItemTriggerListener;
import org.me.blockdash.listeners.PlayerListener;
import org.me.blockdash.managers.GameManager;
import org.me.blockdash.managers.PlayerManager;
import org.me.blockdash.menusystem.PlayerMenuUtility;
import org.me.blockdash.world.PlayerTravelWorldsListener;
import org.me.blockdash.world.WorldTraveler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.bukkit.Material.*;

public final class BlockDash extends JavaPlugin {
    private static BlockDash plugin;

    private final WorldTraveler worldTraveler = new WorldTraveler("./worlds/");

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();

    public static final List<Material> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.addAll(List.of(
                STONE,
                GRANITE,
                POLISHED_GRANITE,
                DIORITE,
                POLISHED_DIORITE,
                ANDESITE,
                POLISHED_ANDESITE,
                DEEPSLATE,
                COBBLED_DEEPSLATE,
                POLISHED_DEEPSLATE,
                CALCITE,
                TUFF,
                DRIPSTONE_BLOCK,
                GRASS_BLOCK,
                DIRT,
                COARSE_DIRT,
                COBBLESTONE,
                OAK_PLANKS,
                SPRUCE_PLANKS,
                BIRCH_PLANKS,
                JUNGLE_PLANKS,
                ACACIA_PLANKS,
                DARK_OAK_PLANKS,
                BEDROCK,
                SAND,
                RED_SAND,
                IRON_ORE,
                COAL_ORE,
                GRAVEL,
                COPPER_ORE,
                GOLD_ORE,
                REDSTONE_ORE,
                EMERALD_ORE,
                LAPIS_ORE,
                DIAMOND_ORE,
                COAL_BLOCK,
                NETHER_GOLD_ORE,
                NETHER_QUARTZ_ORE,
                IRON_BLOCK,
                COPPER_BLOCK,
                GOLD_BLOCK,
                DIAMOND_BLOCK,
                OAK_LOG,
                SPRUCE_LOG,
                BIRCH_LOG,
                JUNGLE_LOG,
                ACACIA_LOG,
                DARK_OAK_LOG,
                STRIPPED_OAK_LOG,
                STRIPPED_SPRUCE_LOG,
                STRIPPED_BIRCH_LOG,
                STRIPPED_JUNGLE_LOG,
                STRIPPED_ACACIA_LOG,
                STRIPPED_DARK_OAK_LOG,
                OAK_LEAVES,
                SPRUCE_LEAVES,
                BIRCH_LEAVES,
                JUNGLE_LEAVES,
                ACACIA_LEAVES,
                DARK_OAK_LEAVES,
                GLASS,
                LAPIS_BLOCK,
                SANDSTONE,
                COBWEB,
                GRASS,
                WHITE_WOOL,
                PINK_WOOL,
                KELP,
                OAK_SLAB,
                SPRUCE_SLAB,
                BIRCH_SLAB,
                JUNGLE_SLAB,
                ACACIA_SLAB,
                DARK_OAK_SLAB,
                STONE_SLAB,
                SMOOTH_STONE_SLAB,
                SANDSTONE_SLAB,
                COBBLESTONE_SLAB,
                QUARTZ_SLAB,
                NETHER_BRICK_SLAB,
                STONE_BRICK_SLAB,
                PRISMARINE_SLAB,
                PRISMARINE_BRICK_SLAB,
                SMOOTH_QUARTZ,
                SMOOTH_SANDSTONE,
                SMOOTH_STONE,
                BRICKS,
                BOOKSHELF,
                OBSIDIAN,
                TORCH,
                OAK_STAIRS,
                CHEST,
                CRAFTING_TABLE,
                FURNACE,
                LADDER,
                COBBLESTONE_STAIRS,
                SNOW,
                ICE,
                SNOW_BLOCK,
                CACTUS,
                CLAY,
                OAK_FENCE,
                SPRUCE_FENCE,
                BIRCH_FENCE,
                JUNGLE_FENCE,
                ACACIA_FENCE,
                DARK_OAK_FENCE,
                NETHERRACK,
                SOUL_SAND,
                BASALT,
                DEEPSLATE_BRICKS,
                CHAIN,
                IRON_BARS,
                GLASS_PANE,
                BRICK_STAIRS,
                STONE_BRICK_STAIRS,
                EMERALD_BLOCK,
                SPRUCE_STAIRS,
                BIRCH_STAIRS,
                JUNGLE_STAIRS,
                COBBLESTONE_WALL,
                ANVIL,
                REDSTONE_BLOCK,
                REPEATER,
                PISTON,
                HOPPER,
                TNT,
                OAK_BUTTON,
                SPRUCE_BUTTON,
                BIRCH_BUTTON,
                JUNGLE_BUTTON,
                ACACIA_BUTTON,
                DARK_OAK_BUTTON,
                WHITE_BED
        ));
    }

    @Override
    public void onEnable() {
        plugin = this;

        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager(worldTraveler, playerManager);

        //listeners
        getServer().getPluginManager().registerEvents(new PlayerTravelWorldsListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(gameManager, playerManager), this);
        getServer().getPluginManager().registerEvents(new PlayerItemTriggerListener(gameManager), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);

        //commands
        getCommand("spawn").setExecutor(new SpawnCommand(gameManager));
    }

    @Override
    public void onDisable() {
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) { //See if the player has a playermenuutility "saved" for them

            //This player doesn't. Make one for them add it to the hashmap
            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p); //Return the object by using the provided player
        }
    }


    public static BlockDash getInstance() {
        return plugin;
    }

    public WorldTraveler getWorldTraveler() {
        return worldTraveler;
    }
}
