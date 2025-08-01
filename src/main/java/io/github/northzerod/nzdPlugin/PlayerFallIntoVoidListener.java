package io.github.northzerod.nzdPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public final class PlayerFallIntoVoidListener implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

        if (event.getEntity() instanceof Player player
                && event.getCause() == DamageCause.VOID
                && player.getY() < player.getLocation().getWorld().getMinHeight() - 64
        ) {
            Location playerLocation = player.getLocation();

            World world = playerLocation.getWorld();
            Environment environment = world.getEnvironment();

            int blockX = playerLocation.getBlockX();
            int blockZ = playerLocation.getBlockZ();

            World overworld = Bukkit.getWorlds().get(0);
            World the_nether = Bukkit.getWorlds().get(1);
            World the_end = Bukkit.getWorlds().get(2);

            if (environment == Environment.NORMAL) {
                playerLocation.setWorld(the_nether);
                playerLocation.setY(the_nether.getMaxHeight() + 1);
                playerLocation.setX(((int)(blockX * Configs.OTN_SCALE)) + 0.5);
                playerLocation.setZ(((int)(blockZ * Configs.OTN_SCALE)) + 0.5);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, Configs.OTN_SLOW_FALLING_SECONDS * 20, 0, false, false, false));
                player.teleport(playerLocation);
            }

            if (environment == Environment.NETHER) {
                playerLocation.setWorld(the_end);
                playerLocation.setY(the_end.getMaxHeight() + 1);
                playerLocation.setX(((int)(blockX * Configs.NTE_SCALE)) + 0.5);
                playerLocation.setZ(((int)(blockZ * Configs.NTE_SCALE)) + 0.5);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, Configs.NTE_SLOW_FALLING_SECONDS * 20, 0, false, false, false));
                player.teleport(playerLocation);
            }

            if (environment == Environment.THE_END) {
                playerLocation.setWorld(overworld);
                playerLocation.setY(overworld.getMaxHeight() + 1);
                playerLocation.setX(((int)(blockX * Configs.ETO_SCALE)) + 0.5);
                playerLocation.setZ(((int)(blockZ * Configs.ETO_SCALE)) + 0.5);
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, Configs.ETO_SLOW_FALLING_SECONDS * 20, 0, false, false, false));
                player.teleport(playerLocation);
            }
        }
    }
}