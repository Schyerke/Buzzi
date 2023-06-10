package org.me.blockdash.tasks;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.me.blockdash.managers.GameManager;
import org.me.blockdash.managers.GameState;
import org.me.blockdash.utility.ListUtility;
import org.me.blockdash.BlockDash;

import java.util.HashMap;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.TextColor.color;

public class StandOnBlockTask extends BukkitRunnable {

    private final GameManager gameManager;

    private int timeLeft = 5*60;

    public StandOnBlockTask(GameManager gameManager, HashMap<Player, Material> blockToStandOn) {
        this.gameManager = gameManager;

        for(Player player : blockToStandOn.keySet()) {
            player.sendMessage(text("Your block is: " + blockToStandOn.get(player).toString(), color(255, 255, 0)));
            player.getInventory().addItem(new ItemStack(blockToStandOn.get(player), 1));
        }
    }

    @Override
    public void run() {
        if(timeLeft <= 0) {
            cancel();
            Bukkit.broadcast(text("TIMEOUT!!!", TextColor.color(255, 0, 0)));
            for(Player player : Bukkit.getOnlinePlayers()) {
                if(gameManager.getBlockManager().playerIsNotOnTheBlock(player)){
                    gameManager.getLostList().add(player);
                }
            }

            if(ListUtility.elementSize(gameManager.getLostList()) == 0) {
                gameManager.setGameState(GameState.ACTIVE_NEXT_CHALLENGE);
                return;
            }

            Bukkit.getScheduler().runTaskLater(BlockDash.getInstance(), () -> gameManager.setGameState(GameState.END), 8*20);
            return;
        }

        if(timeLeft <= 10) {
            Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(text(timeLeft + " seconds remaining for the objective", color(245,100,103))));
        }

        timeLeft--;
    }
}
