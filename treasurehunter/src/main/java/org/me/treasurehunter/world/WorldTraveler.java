package org.me.treasurehunter.world;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;

public class WorldTraveler {
    public final String filepath;

    private World normalWorld;
    private World netherWorld;
    private World endWorld;

    private WorldType worldType = WorldType.NORMAL;

    public WorldTraveler(){
        this("./worlds/");
    }

    public WorldTraveler(String filepath){
        this.filepath = filepath;
    }

    public void createNormalWorlds() {
        createWorld(this.worldType, World.Environment.NORMAL);
        createWorld(this.worldType, World.Environment.NETHER);
        createWorld(this.worldType, World.Environment.THE_END);
    }

    public void createWorld(final WorldType worldType, final World.Environment environment){
        WorldCreator worldCreator = new WorldCreator(filepath + environment.name() + System.nanoTime());

        worldCreator.environment(environment);
        worldCreator.type(worldType);

        World world = worldCreator.createWorld();

        switch(environment) {
            case NORMAL, CUSTOM -> this.normalWorld = world;
            case NETHER -> this.netherWorld = world;
            case THE_END -> this.endWorld = world;
        }
    }

    public World getWorldByWorldEnv(World.Environment worldEnv){
        return switch(worldEnv) {
            case NORMAL, CUSTOM -> this.normalWorld;
            case NETHER -> this.netherWorld;
            case THE_END -> this.endWorld;
        };
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public void setWorldType(WorldType worldType) {
        this.worldType = worldType;
    }
}
