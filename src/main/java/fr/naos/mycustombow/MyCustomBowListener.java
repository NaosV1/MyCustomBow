package fr.naos.mycustombow;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MyCustomBowListener implements Listener {

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inv = event.getClickedInventory();
        if (inv == null) return;
        if (event.getWhoClicked() instanceof Player && inv.getHolder() instanceof MenuHolder) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return;
            else if (event.getCurrentItem().getType() == Material.FIRE_CHARGE) Util.giveBow(player, "fireball");
            else if (event.getCurrentItem().getType() == Material.FIREWORK_ROCKET) Util.giveBow(player, "lightning");
            else if (event.getCurrentItem().getType() == Material.TNT) Util.giveBow(player, "tnt");
            else if (event.getCurrentItem().getType() == Material.ENDER_EYE) Util.giveBow(player, "switch");
        }
    }

}