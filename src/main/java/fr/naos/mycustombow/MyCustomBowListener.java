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
            Material type = event.getCurrentItem().getType();
            switch (type) {
                case FIRE_CHARGE:
                    Util.giveBow(player, "fireball");
                    break;
                case FIREWORK_ROCKET:
                    Util.giveBow(player, "lightning");
                    break;
                case TNT:
                    Util.giveBow(player, "tnt");
                    break;
                case ENDER_EYE:
                    Util.giveBow(player, "switch");
                    break;
                case FEATHER:
                    Util.giveBow(player, "gravity");
                    break;
                case SNOWBALL:
                    Util.giveBow(player, "snowball");
                    break;
                case ENDER_PEARL:
                    Util.giveBow(player, "teleport");
                    break;
                case DRAGON_BREATH:
                    Util.giveBow(player, "dragon");
                    break;
            }
        }
    }

}