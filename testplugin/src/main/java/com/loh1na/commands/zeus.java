package com.loh1na.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class zeus implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //if (!(sender instanceof Player)){
        //    msg.send(sender, "ok");
        //    return true;
        //}

        Player p = (Player) sender;
        p.sendMessage("Зевс УЛЬТУЙ!!!!");
        spawnCreature(p.getLocation(), EntityType.LIGHTNING);
        return true;
    }
    private void spawnCreature(Location loc, EntityType thunder) {
        loc.getWorld().spawnEntity(loc,thunder);
    }
}
