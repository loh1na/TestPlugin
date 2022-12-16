package com.loh1na;

import com.loh1na.commands.bomb;
import com.loh1na.commands.zeus;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TestPlugin extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {;
        //loading commands
        this.getCommand("bomb").setExecutor(new bomb());
        this.getCommand("zeus").setExecutor(new zeus());
        //end of initialisation
        Bukkit.getLogger().info("Plugin sucsessfully loaded! Enjoy\ntestplugin 0.1 created by loh1na");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Bye");
    }

    @EventHandler
    public void onPlayerJoin(PlayerLoginEvent event) {
        Player p = event.getPlayer();
        Bukkit.getLogger().info("player " + p + " has connected!");
        if (config.getBoolean("KazahstanMode")) {
            Bukkit.getLogger().info("enabled" + p.getLocation());
            p.sendMessage("Казахстан Угрожает вам бомбордировкой");
            spawnCreature(p.getLocation(), EntityType.PRIMED_TNT);
        }
        else {
            p.sendMessage("тест");
        }
    }
    private void spawnCreature(Location loc, EntityType creeper) {
        loc.getWorld().spawnEntity(loc,creeper);
    }

}
