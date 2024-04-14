package fr.naos.mycustombow;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;

import static fr.naos.mycustombow.cData.*;
import static fr.naos.mycustombow.cData.lightning_bow_lore;

public class Util {

    public static void giveBow(Player player, String bow) {
        if (player == null) return;
        String bowType = bow;
        switch (bowType) {
            case "fireball":
                ItemStack fireballBow = new ItemStack(Material.BOW);
                ItemMeta fireballBowMeta = fireballBow.getItemMeta();
                fireballBowMeta.setDisplayName(fireball_bow_name);
                fireballBowMeta.setLore(Collections.singletonList(fireball_bow_lore));
                fireballBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "fireball");
                fireballBow.setItemMeta(fireballBowMeta);
                player.getInventory().addItem(fireballBow);
                break;
            case "lightning":
                ItemStack lightningBow = new ItemStack(Material.BOW);
                ItemMeta lightningBowMeta = lightningBow.getItemMeta();
                lightningBowMeta.setDisplayName(lightning_bow_name);
                lightningBowMeta.setLore(Collections.singletonList(lightning_bow_lore));
                lightningBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "lightning");
                lightningBow.setItemMeta(lightningBowMeta);
                player.getInventory().addItem(lightningBow);
                break;
            case "tnt":
                ItemStack tntBow = new ItemStack(Material.BOW);
                ItemMeta tntBowMeta = tntBow.getItemMeta();
                tntBowMeta.setDisplayName(tnt_bow_name);
                tntBowMeta.setLore(Collections.singletonList(tnt_bow_lore));
                tntBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "tnt");
                tntBow.setItemMeta(tntBowMeta);
                player.getInventory().addItem(tntBow);
                break;
            case "switch":
                ItemStack switchBow = new ItemStack(Material.BOW);
                ItemMeta switchBowMeta = switchBow.getItemMeta();
                switchBowMeta.setDisplayName(switch_name);
                switchBowMeta.setLore(Collections.singletonList(switch_lore));
                switchBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "switch");
                switchBow.setItemMeta(switchBowMeta);
                player.getInventory().addItem(switchBow);
                break;
            case "gravity":
                ItemStack gravityBow = new ItemStack(Material.BOW);
                ItemMeta gravityBowMeta = gravityBow.getItemMeta();
                gravityBowMeta.setDisplayName(gravity_bow_name);
                gravityBowMeta.setLore(Collections.singletonList(gravity_bow_lore));
                gravityBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "gravity");
                gravityBow.setItemMeta(gravityBowMeta);
                player.getInventory().addItem(gravityBow);
                break;
            case "snowball":
                ItemStack snowballBow = new ItemStack(Material.BOW);
                ItemMeta snowballBowMeta = snowballBow.getItemMeta();
                snowballBowMeta.setDisplayName(snowball_bow_name);
                snowballBowMeta.setLore(Collections.singletonList(snowball_bow_lore));
                snowballBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "snowball");
                snowballBow.setItemMeta(snowballBowMeta);
                player.getInventory().addItem(snowballBow);
                break;
            case "teleport":
                ItemStack teleportBow = new ItemStack(Material.BOW);
                ItemMeta teleportBowMeta = teleportBow.getItemMeta();
                teleportBowMeta.setDisplayName(teleport_bow_name);
                teleportBowMeta.setLore(Collections.singletonList(teleport_bow_lore));
                teleportBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "teleport");
                teleportBow.setItemMeta(teleportBowMeta);
                player.getInventory().addItem(teleportBow);
                break;
            case "dragon":
                ItemStack dragonBow = new ItemStack(Material.BOW);
                ItemMeta dragonBowMeta = dragonBow.getItemMeta();
                dragonBowMeta.setDisplayName(dragon_bow_name);
                dragonBowMeta.setLore(Collections.singletonList(dragon_bow_lore));
                dragonBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "dragon");
                dragonBow.setItemMeta(dragonBowMeta);
                player.getInventory().addItem(dragonBow);
                break;
            default:
                break;

        }
    }
}
