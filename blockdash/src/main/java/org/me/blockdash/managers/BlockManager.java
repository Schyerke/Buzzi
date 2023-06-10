package org.me.blockdash.managers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;

public class BlockManager {

    private final GameManager gameManager;

    public BlockManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public boolean playerIsNotOnTheBlock(Player player) {
        Material blockToStandOn = gameManager.getBlocksToStandOn().get(player);
        return playerIsNotOnTheBlock(player, blockToStandOn);
    }

    public boolean playerIsNotOnTheBlock(Player player, Material blockToStandOn) {
        boolean no = true;
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if(block.getType() != blockToStandOn) {
            Block upperBlock = block.getRelative(BlockFace.UP);
            if (upperBlock.getType() == blockToStandOn) {
                gameManager.getWonList().add(player);
                no = false;
            }
        } else {
            gameManager.getWonList().add(player);
            no = false;
        }

        if(!no){
            player.sendMessage(text("Good job man", color(255, 255, 0)));
            Bukkit.broadcast(text(player.getName() + " has completed their task", color(255, 255, 0)));

            if (gameManager.sameSize(Bukkit.getOnlinePlayers(), gameManager.getWonList())) {
                gameManager.setGameState(GameState.ACTIVE_NEXT_CHALLENGE);
                return true;
            }
        }
        return no;
    }
}
