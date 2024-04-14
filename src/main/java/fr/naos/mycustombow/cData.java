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
    public static String gravity_bow_name;
    public static String gravity_bow_lore;
    public static String gravity_bow_noperm;
    public static String snowball_bow_name;
    public static String snowball_bow_lore;
    public static String teleport_bow_name;
    public static String teleport_bow_lore;
    public static String dragon_bow_name;
    public static String dragon_bow_lore;

    public static void load() {
        prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        if (lang.equalsIgnoreCase("fr")) {
            loadFrench();
        } else {
            loadEnglish();
        }
    }

    private static void loadFrench() {
        no_perm = "§cVous n'avez pas la permission d'utiliser cette commande !";
        title_menu = "Arcs Custom";
        not_player = "§cVous devez être un joueur pour faire cela !";
        config_reloaded = "§aLa configuration a été rechargée !";
        fireball_bow_name = "§fArc de §cBoule De Feu";
        fireball_bow_lore = "§f    Cet arc vous permet de lancer des §cboules de feu";
        teleport_bow_name = "§fArc de §5Téléportation";
        teleport_bow_lore = "§f    Cet arc vous permet de vous téléporter";
        dragon_bow_name = "§fArc du §dDragon";
        dragon_bow_lore = "§f    Cet arc vous permet de lancer un souffre du dragon";
        gravity_bow_name = "§fArc §9Anti-Gravité";
        gravity_bow_lore = "§f    Cet arc vous permet de faire perdre la gravité à un joueur";
        gravity_bow_noperm = "§cVous n'avez pas la permission d'utiliser cet arc car il est très dangereux ! (mycustombow.gravity)";
        lightning_bow_name = "§fArc §eÉclair";
        lightning_bow_lore = "§f    Cet arc vous permet de lancer des §eéclairs";
        tnt_bow_name = "§fArc §cTNT";
        tnt_bow_lore = "§f    Cet arc vous permet de lancer des §cTNT";
        snowball_bow_name = "§fArc à §bBoule De Neige";
        snowball_bow_lore = "§f    Cet arc vous permet de lancer des §bboules de neige";
        switch_name = "§fArc d'§eEchange";
        switch_lore = "§f    Cet arc vous permet de §echanger de position §fen tirant sur une §eentité";
        player_not_found = "§cLe joueur n'a pas été trouvé !";
        bow_not_found = "§cL'arc n'a pas été trouvé !";
        bow_gived = "§aVous avez donné §e%bow% §a!";
    }

    private static void loadEnglish() {
        no_perm = prefix + " §cYou don't have the permission to use this command !";
        title_menu = "Custom Bows";
        not_player = "§cYou must be a player to do this !";
        config_reloaded = "§aThe configuration has been reloaded !";
        teleport_bow_name = "§5Teleportation §fBow";
        teleport_bow_lore = "§f    This bow allows you to §5teleport";
        dragon_bow_name = "§dDragon §fBow";
        dragon_bow_lore = "§f    This bow allows you to shoot a §ddragon breath";
        snowball_bow_name = "§bSnow Ball §fBow";
        snowball_bow_lore = "§f    This bow allows you to shoot §bsnow balls";
        fireball_bow_name = "§cFire Ball §fBow";
        fireball_bow_lore = "§f    This bow allows you to shoot §cfire balls";
        gravity_bow_name = "§9Anti-Gravity §fBow";
        gravity_bow_lore = "§f    This bow allows you to make a player lose their gravity";
        gravity_bow_noperm = "§cYou don't have the permission to use this bow because it is very dangerous ! (mycustombow.gravity)";
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
