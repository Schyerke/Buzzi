package org.me.treasurehunter.menusystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {
    private final Player owner;

    public PlayerMenuUtility(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
