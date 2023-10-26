package fr.naos.mycustombow;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import static fr.naos.mycustombow.cData.gravity_bow_noperm;

public class bowShootListener implements Listener {

    @EventHandler
    private void onShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        ItemStack bow = event.getBow();
        Entity arrow = event.getProjectile();
        if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("fireball")) {
            arrow.remove();
            event.getEntity().launchProjectile(Fireball.class);
        } else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("lightning")) {
            arrow.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "lightning");
        } else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("tnt")) {
            arrow.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "tnt");
        } else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("switch")) {
            arrow.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "switch");
        }  else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("gravity")) {
            if (!event.getEntity().hasPermission("mycustombow.gravity")) {
                event.setCancelled(true);
                event.getEntity().sendMessage(gravity_bow_noperm);
                return;
            }
            arrow.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "gravity");
        } else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("snowball")) {
            arrow.remove();
            event.getEntity().launchProjectile(Snowball.class);
        } else if (bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("teleport")) {
            arrow.remove();
            event.getEntity().launchProjectile(EnderPearl.class);
        }
    }

    @EventHandler
    private void projectileHit(ProjectileHitEvent event) {
        if (event.getEntity().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("lightning")) {
            event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
        } else if (event.getEntity().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("tnt")) {
            event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4);
        }
        if (event.getHitEntity() != null) {
            Entity shooter = (Entity) event.getEntity().getShooter();
            Entity victim = event.getHitEntity();
            if (event.getEntity().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("switch")) {
                Location shooterLoc = shooter.getLocation();
                Location victimLoc = victim.getLocation();
                shooter.teleport(victimLoc);
                victim.teleport(shooterLoc);
                event.setCancelled(true);
            } else if (event.getEntity().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1").equals("gravity")) {
                victim.setGravity(!victim.hasGravity());
            }
        }
    }
}
