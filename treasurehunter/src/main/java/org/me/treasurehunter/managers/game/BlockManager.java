package org.me.treasurehunter.managers.game;

import org.bukkit.block.Block;

public class BlockManager {
    private final GameManager gameManager;

    private Block chestBlock;

    public BlockManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public Block getChestBlock() {
        return chestBlock;
    }

    public void setChestBlock(Block chestBlock) {
        this.chestBlock = chestBlock;
    }
}
