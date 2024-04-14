package fr.naos.mycustombow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class MyCustomBow extends JavaPlugin {

    private static MyCustomBow instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        registerCommandsAndListeners();
        cData.load();
        updateCheck();
    }

    private void registerCommandsAndListeners() {
        PluginManager pm = getServer().getPluginManager();
        getCommand("mycustombow").setExecutor(new MyCustomBowCommand());
        getCommand("mycustombow").setTabCompleter(new MyCustomBowTabCompleter());
        pm.registerEvents(new MyCustomBowListener(), this);
        pm.registerEvents(new bowShootListener(), this);

        if (!getConfig().contains("prefix")) {
            getConfig().set("prefix", "&8[&6MyCustomBow&8] ");
            saveConfig();
        }

        if (!getConfig().contains("lang")) {
            getConfig().set("lang", "en");
            saveConfig();
        }

        if (!getConfig().contains("fireball_bow_explosion")) {
            getConfig().set("fireball_bow_explosion", 2);
            saveConfig();
        }
    }

    private void updateCheck() {
        try {
            URL url = new URL("https://api.spigotmc.org/legacy/update.php?resource=108616");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            String latestVersion = content.toString();
            String currentVersion = getDescription().getVersion();

            if (!latestVersion.equals(currentVersion)) {
                Bukkit.getConsoleSender().sendMessage("\n§a[MyCustomBow] §fA new version is available\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=\n§fYour version : §b" + currentVersion + "\n§fNew version : §b" + latestVersion + "\n§fDownload it here :§e https://www.spigotmc.org/resources/mycustombow.108616/\n§fIf you §clike §fthe plugin, please leave a review, it help a lot !\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=\n");
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§cError checking update for ArmorStand Manager: §e" + e.getMessage());
        }
    }

    public static MyCustomBow getInstance() {
        return instance;
    }
}
