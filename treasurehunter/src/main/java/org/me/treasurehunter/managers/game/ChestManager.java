package org.me.treasurehunter.managers.game;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.me.treasurehunter.world.WorldTraveler;

import java.util.Random;

public class ChestManager {
    private static final boolean DEBUG = true;

    private final GameManager gameManager;
    private final WorldTraveler worldTraveler;

    private Block chestBlock;
    private Location chestLocation;
    private Inventory chestInventory;

    public ChestManager(GameManager gameManager, WorldTraveler worldTraveler) {
        this.gameManager = gameManager;
        this.worldTraveler = worldTraveler;
    }

    public void spawnChest(double offsetX, double offsetY, double offsetZ){
        if(DEBUG) {
            offsetX = 0;
            offsetY = 0;
            offsetZ = 0;
        }

        World currentWorld = worldTraveler.getWorldByWorldEnv(World.Environment.NORMAL);
        Location spawnLocation = currentWorld.getSpawnLocation();

        double maxX = spawnLocation.getX() + offsetX;
        double minX = spawnLocation.getX() - offsetX;

        double maxY = spawnLocation.getY() + offsetY;
        double minY = spawnLocation.getY() - offsetY;

        double maxZ = spawnLocation.getZ() + offsetZ;
        double minZ = spawnLocation.getZ() - offsetZ;

        Random random = new Random();

        double randomX = random.nextDouble(minX-1, maxX+1);
        double randomY = random.nextDouble(minY-1, maxY+1);
        double randomZ = random.nextDouble(minZ-1, maxZ+1);

        Location chestLocation = new Location(currentWorld, randomX, randomY, randomZ);

        Block block = chestLocation.getBlock();
        block.setType(Material.CHEST);
        Chest chest = (Chest) block.getState();

        this.chestInventory = chest.getInventory();
        this.chestBlock = block;
    }

    public void fillChestInventory(){
        if(this.chestInventory == null)
            return;

        if(DEBUG) {
            ItemStack diamond = new ItemStack(Material.DIAMOND, 32);
            this.chestInventory.addItem(diamond);

            return;
        }
    }

    public Block getChestBlock() {
        return chestBlock;
    }

    public Inventory getChestInventory() {
        return chestInventory;
    }

    public Location getChestLocation() {
        return chestLocation;
    }
}
