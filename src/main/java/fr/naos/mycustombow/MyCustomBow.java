package fr.naos.mycustombow;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        updateCheck();
    }

    private void updateCheck(){
        try {
            URL url = new URL("https://api.spigotmc.org/legacy/update.php?resource=108616");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            if (!(content.toString().equals(getDescription().getVersion()))) {
                Bukkit.getConsoleSender().sendMessage("\n§a[MyCustomBow] §fA new version is available\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=\n§fYour version : §b" + getDescription().getVersion() + "\n§fNew version : §b" + content + "\n§fDownload it here :§e https://www.spigotmc.org/resources/mycustombow.108616/\n§fIf you §clike §fthe plugin, please leave a review, it help a lot !\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=\n");
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§cError checking update for ArmorStand Manager: §e" + e.getMessage());
        }

    }

    public static MyCustomBow getInstance() {
        return instance;
    }
}
