package fr.naos.mycustombow;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static fr.naos.mycustombow.cData.*;

public class MyCustomBowCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player) && args.length == 0) sender.sendMessage(not_player);
        Player player = (Player) sender;
        if (args.length == 0) bowMenu(player);
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("give")) {
                if (args.length >= 2) {
                    Player target = player.getServer().getPlayer(args[1]);
                    if (target == null) player.sendMessage(player_not_found);
                    if (args.length >= 3) {
                        String bow = args[2];
                        switch (bow) {
                            case "fireball":
                                Util.giveBow(target, "fireball");
                                player.sendMessage(bow_gived.replace("%bow%", fireball_bow_name));
                            case "lightning":
                                Util.giveBow(target, "lightning");
                                player.sendMessage(bow_gived.replace("%bow%", lightning_bow_name));
                            case "tnt":
                                Util.giveBow(target, "tnt");
                                player.sendMessage(bow_gived.replace("%bow%", tnt_bow_name));
                            case "gravity":
                                Util.giveBow(target, "gravity");
                                player.sendMessage(bow_gived.replace("%bow%", gravity_bow_name));
                            case "switch":
                                Util.giveBow(target, "switch");
                                player.sendMessage(bow_gived.replace("%bow%", switch_name));
                            case "dragon":
                                Util.giveBow(target, "dragon");
                                player.sendMessage(bow_gived.replace("%bow%", dragon_bow_name));
                            default:
                                player.sendMessage(bow_not_found);
                        }
                    } else {
                        player.sendMessage(bow_not_found);
                    }
                }
            }
        }
        return false;
    }



    public static void bowMenu(Player player) {
        Inventory inventory = org.bukkit.Bukkit.createInventory(new MenuHolder(), 4 * 9, cData.title_menu);
        bowMenuItem(inventory);
        player.openInventory(inventory);
    }

    private static void bowMenuItem(Inventory inventory) {

        inventory.setItem(10, ItemManage.createItem(false, Material.FIRE_CHARGE, fireball_bow_name, 1, " ", fireball_bow_lore, " "));
        inventory.setItem(11, ItemManage.createItem(false, Material.SNOWBALL, snowball_bow_name, 1, " ", snowball_bow_lore, " "));
        inventory.setItem(12, ItemManage.createItem(false, Material.FIREWORK_ROCKET, lightning_bow_name, 1, " ", lightning_bow_lore, " "));
        inventory.setItem(13, ItemManage.createItem(false, Material.FEATHER, gravity_bow_name, 1, " ", gravity_bow_lore, " "));
        inventory.setItem(14, ItemManage.createItem(false, Material.TNT, tnt_bow_name, 1, " ", tnt_bow_lore, " "));
        inventory.setItem(15, ItemManage.createItem(false, Material.ENDER_PEARL, teleport_bow_name, 1, " ", teleport_bow_lore, " "));
        inventory.setItem(16, ItemManage.createItem(false, Material.ENDER_EYE, switch_name, 1, " ", switch_lore, " "));
        inventory.setItem(22, ItemManage.createItem(false, Material.DRAGON_BREATH, dragon_bow_name, 1, " ", dragon_bow_lore, " "));
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, ItemManage.createItem(false, Material.GRAY_STAINED_GLASS_PANE, " ", 1));
            }
        }
    }
}
