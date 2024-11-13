package mov.naspen.chargedexplosions;

import mov.naspen.chargedexplosions.events.*;
import mov.naspen.periderm.helpers.coreProtect.CoreProtectHelper;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ChargedExplosions extends JavaPlugin {
    public static Plugin plugin;
    public static ArrayList<Entity>chargedEntities;
    public static ArrayList<String>chargedLocations;
    public static CoreProtectHelper coreProtectHelper;
    @Override
    public void onEnable() {
        plugin = this;
        chargedEntities = new ArrayList<>();
        chargedLocations = new ArrayList<>();
        coreProtectHelper = CoreProtectHelper.getInstance();
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new TNTPrimeEventListener(), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnEventListener(), this);
        getServer().getPluginManager().registerEvents(new EntityExplodeEventListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageEventListener(), this);
        getServer().getPluginManager().registerEvents(new BlockRedstoneEventListener(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEventListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
