package io.github.northzerod.nzdPlugin;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HappyGhast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDismountEvent;

public class PlayerDismountHappyGhastListener implements Listener {
    @EventHandler
    public void onEntityDismount(EntityDismountEvent event) {
        if (Configs.WHEN_DISMOUNT_RESET_SPEED) {
            Entity entity = event.getDismounted();

            if (entity instanceof HappyGhast happyGhast) {
                double base = Configs.BASE;
                happyGhast.getAttribute(Attribute.FLYING_SPEED).setBaseValue(base);
            }
        }
    }
}
