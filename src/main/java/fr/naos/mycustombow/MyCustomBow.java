package fr.naos.mycustombow;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyCustomBow extends JavaPlugin {

    public static MyCustomBow instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Metrics metrics = new Metrics(this, 17950);
        PluginManager pm = getServer().getPluginManager();
        getCommand("mycustombow").setExecutor(new MyCustomBowCommand());
        getCommand("mycustombow").setTabCompleter(new MyCustomBowTabCompleter());
        pm.registerEvents(new MyCustomBowListener(), this);
        pm.registerEvents(new bowShootListener(), this);
        cData.load();
    }

    public static MyCustomBow getInstance() {
        return instance;
    }
}
