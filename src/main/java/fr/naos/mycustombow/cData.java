package fr.naos.mycustombow;

import org.bukkit.ChatColor;

public class cData {

    public static String lang = MyCustomBow.getInstance().getConfig().getString("lang");
    public static String prefix = MyCustomBow.getInstance().getConfig().getString("prefix");
    public static String no_perm;
    public static String title_menu;
    public static String not_player;
    public static String config_reloaded;
    public static String fireball_bow_name;
    public static String fireball_bow_lore;
    public static String lightning_bow_name;
    public static String lightning_bow_lore;
    public static String tnt_bow_name;
    public static String tnt_bow_lore;
    public static String switch_name;
    public static String switch_lore;
    public static String player_not_found;
    public static String bow_not_found;
    public static String bow_gived;

    public static void load() {
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        if (lang.equalsIgnoreCase("fr")) {
            no_perm = "§cVous n'avez pas la permission d'utiliser cette commande !";
            title_menu = "Arcs Custom";
            not_player = "§cVous devez être un joueur pour faire cela !";
            config_reloaded = "§aLa configuration a été rechargée !";
            fireball_bow_name = "§fArc de §cBoule De Feu";
            fireball_bow_lore = "§f    Cet arc vous permet de lancer des §cboules de feu";
            lightning_bow_name = "§fArc §eÉclair";
            lightning_bow_lore = "§f    Cet arc vous permet de lancer des §eéclairs";
            tnt_bow_name = "§fArc §cTNT";
            tnt_bow_lore = "§f    Cet arc vous permet de lancer des §cTNT";
            switch_name = "§fArc d'§eEchange";
            switch_lore = "§f    Cet arc vous permet de §echanger de position §fen tirant sur une §eentité";
            player_not_found = "§cLe joueur n'a pas été trouvé !";
            bow_not_found = "§cL'arc n'a pas été trouvé !";
            bow_gived = "§aVous avez donné §e%bow% §a!";


        } else {
            no_perm = prefix + " §cYou don't have the permission to use this command !";
            title_menu = "Custom Bows";
            not_player = "§cYou must be a player to do this !";
            config_reloaded = "§aThe configuration has been reloaded !";
            fireball_bow_name = "§cFire Ball §fBow";
            fireball_bow_lore = "§f    This bow allows you to shoot §cfire balls";
            lightning_bow_name = "§eLightning §fBow";
            lightning_bow_lore = "§f    This bow allows you to shoot §elightnings";
            tnt_bow_name = "§cTNT §fBow";
            tnt_bow_lore = "§f    This bow allows you to shoot §cTNT";
            switch_name = "§eSwitch §fBow";
            switch_lore = "§f    This bow allows you to §eswitch §fposition by shooting an §eentity";
            player_not_found = "§cThe player was not found !";
            bow_not_found = "§cThe bow was not found !";
            bow_gived = "§aYou gived the §e%bow% §a!";
        }
    }
}
