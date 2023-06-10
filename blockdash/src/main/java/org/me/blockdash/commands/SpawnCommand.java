package org.me.blockdash.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.me.blockdash.managers.GameManager;

public class SpawnCommand implements CommandExecutor {

    private final GameManager gameManager;

    public SpawnCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            Bukkit.broadcast(Component.text("Really... " + player.getName() + " wants to go to spawn...", TextColor.color(255, 255, 0)));

            gameManager.endByPlayerQuit(player);
            return true;
        }
        return false;
    }
}
