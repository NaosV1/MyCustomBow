package fr.naos.mycustombow;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

import static fr.naos.mycustombow.cData.gravity_bow_noperm;

public class bowShootListener implements Listener {

    @EventHandler
    private void onShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        ItemStack bow = event.getBow();
        Entity arrow = event.getProjectile();
        String bowType = bow.getItemMeta().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1");

        switch (bowType) {
            case "fireball":
                arrow.remove();
                Fireball fireball = event.getEntity().launchProjectile(Fireball.class);
                int yield = (MyCustomBow.getPlugin(MyCustomBow.class).getConfig().getInt("fireball_bow_explosion.yield") > 0 ? MyCustomBow.getPlugin(MyCustomBow.class).getConfig().getInt("fireball_bow_explosion") : 2);
                fireball.setYield(8);
                event.getEntity().launchProjectile(fireball.getClass());
                break;
            case "snowball":
                arrow.remove();
                event.getEntity().launchProjectile(Snowball.class);
                break;
            case "teleport":
                arrow.remove();
                event.getEntity().launchProjectile(EnderPearl.class);
                break;
            case "lightning":
            case "dragon":
            case "tnt":
            case "switch":
            case "gravity":
                arrow.getPersistentDataContainer().set(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, bowType);
                break;
            default:
                break;
        }
    }

    @EventHandler
    private void projectileHit(ProjectileHitEvent event) {
        String bowType = event.getEntity().getPersistentDataContainer().getOrDefault(new NamespacedKey(MyCustomBow.getPlugin(MyCustomBow.class), "bow_type"), PersistentDataType.STRING, "-1");

        switch (bowType) {
            case "lightning":
                event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
                break;
            case "tnt":
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4);
                break;
            case "dragon":
                event.getEntity().getWorld().spawnParticle(org.bukkit.Particle.DRAGON_BREATH, event.getEntity().getLocation(), 100);
                event.getEntity().remove();
                ItemStack lingeringPotion = new ItemStack(org.bukkit.Material.LINGERING_POTION);
                PotionMeta meta = (PotionMeta) lingeringPotion.getItemMeta();
                meta.addCustomEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.HARM, 10, 2), true);
                lingeringPotion.setItemMeta(meta);

                ThrownPotion potion = event.getEntity().getWorld().spawn(event.getEntity().getLocation(), ThrownPotion.class);
                potion.setItem(lingeringPotion);
                break;
            default:
                Entity shooter = (Entity) event.getEntity().getShooter();
                Entity victim = event.getHitEntity();

                if (victim != null) {
                    if (bowType.equals("switch")) {
                        Location shooterLoc = shooter.getLocation();
                        Location victimLoc = victim.getLocation();
                        shooter.teleport(victimLoc);
                        victim.teleport(shooterLoc);
                        event.setCancelled(true);
                    } else if (bowType.equals("gravity")) {
                        victim.setGravity(!victim.hasGravity());
                    }
                }
                break;
        }
    }
}
