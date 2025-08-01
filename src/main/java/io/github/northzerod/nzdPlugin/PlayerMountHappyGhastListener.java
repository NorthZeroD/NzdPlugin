package io.github.northzerod.nzdPlugin;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HappyGhast;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityMountEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Map;

public final class PlayerMountHappyGhastListener implements Listener {

    @EventHandler
    public void onEntityMount(EntityMountEvent event) {
        Entity entity = event.getMount();

        if (entity instanceof HappyGhast happyGhast) {
            if (Configs.HARNESS_MODE) {
                Map<Material, Double> harness = Configs.HARNESS;
                Material type = happyGhast.getEquipment().getItem(EquipmentSlot.BODY).getType();

                if (harness.containsKey(type)) {
                    double base = Configs.BASE;
                    double add = harness.get(type);
                    happyGhast.getAttribute(Attribute.FLYING_SPEED).setBaseValue(base + add);
                }
            }
            else if(Configs.RANDOM_MODE && !Configs.HARNESS_MODE) {
                int hashCode = happyGhast.getUniqueId().hashCode() & Integer.MAX_VALUE;

                double base = Configs.BASE;
                int mod = Configs.MOD;
                int k = Configs.K;
                double scale = Configs.SCALE;

                double add = (hashCode % mod + k) * scale;

                happyGhast.getAttribute(Attribute.FLYING_SPEED).setBaseValue(base + add);
            }
        }
    }
}
