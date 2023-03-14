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
        if (bow.equalsIgnoreCase("fireball")) {
            ItemStack fireballBow = new ItemStack(Material.BOW);
            ItemMeta fireballBowMeta = fireballBow.getItemMeta();
            fireballBowMeta.setDisplayName(fireball_bow_name);
            fireballBowMeta.setLore(Collections.singletonList(fireball_bow_lore));
            fireballBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "fireball");
            fireballBow.setItemMeta(fireballBowMeta);
            player.getInventory().addItem(fireballBow);
        } else if (bow.equalsIgnoreCase("lightning")) {
            ItemStack lightningBow = new ItemStack(Material.BOW);
            ItemMeta lightningBowMeta = lightningBow.getItemMeta();
            lightningBowMeta.setDisplayName(lightning_bow_name);
            lightningBowMeta.setLore(Collections.singletonList(lightning_bow_lore));
            lightningBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "lightning");
            lightningBow.setItemMeta(lightningBowMeta);
            player.getInventory().addItem(lightningBow);
        } else if (bow.equalsIgnoreCase("tnt")) {
            ItemStack tntBow = new ItemStack(Material.BOW);
            ItemMeta tntBowMeta = tntBow.getItemMeta();
            tntBowMeta.setDisplayName(tnt_bow_name);
            tntBowMeta.setLore(Collections.singletonList(tnt_bow_lore));
            tntBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "tnt");
            tntBow.setItemMeta(tntBowMeta);
            player.getInventory().addItem(tntBow);
        } else if (bow.equalsIgnoreCase("switch")) {
            ItemStack switchBow = new ItemStack(Material.BOW);
            ItemMeta switchBowMeta = switchBow.getItemMeta();
            switchBowMeta.setDisplayName(switch_name);
            switchBowMeta.setLore(Collections.singletonList(switch_lore));
            switchBowMeta.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "switch");
            switchBow.setItemMeta(switchBowMeta);
            player.getInventory().addItem(switchBow);
        }
    }
}
