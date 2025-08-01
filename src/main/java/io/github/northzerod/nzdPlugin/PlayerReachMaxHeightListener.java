package io.github.northzerod.nzdPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class PlayerReachMaxHeightListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location playerLocation = player.getLocation();

        World world = playerLocation.getWorld();
        Environment environment = world.getEnvironment();

        int maxHeight = world.getMaxHeight() + 1;

        int blockX = playerLocation.getBlockX();
        int blockZ = playerLocation.getBlockZ();

        World overworld = Bukkit.getWorlds().get(0);
        World the_nether = Bukkit.getWorlds().get(1);
        World the_end = Bukkit.getWorlds().get(2);

        if (playerLocation.getY() > maxHeight) {
            if (environment == Environment.NORMAL) {
                playerLocation.setWorld(the_end);
                int blockY = the_end.getMinHeight();

                playerLocation.setY(blockY + 1);
                playerLocation.setX(blockX * Configs.OTE_SCALE + 0.5);
                playerLocation.setZ(blockZ * Configs.OTE_SCALE + 0.5);

                blockX = playerLocation.getBlockX();
                blockZ = playerLocation.getBlockZ();

                if (Configs.OTE_LEAVES_FLOOR) {
                    breakAndPlace(the_end, blockX, blockY, blockZ);
                }

                Location loc = new Location(the_end, blockX, blockY + 1, blockZ);
                Location loc2 = new Location(the_end, blockX, blockY + 2, blockZ);
                loc.getBlock().breakNaturally();
                loc2.getBlock().breakNaturally();

                player.teleport(playerLocation);
            }

            if (environment == Environment.NETHER) {
                playerLocation.setWorld(overworld);
                int blockY = overworld.getMinHeight();

                playerLocation.setY(blockY + 1);
                playerLocation.setX(blockX * Configs.NTO_SCALE + 0.5);
                playerLocation.setZ(blockZ * Configs.NTO_SCALE + 0.5);

                blockX = playerLocation.getBlockX();
                blockZ = playerLocation.getBlockZ();

                if (Configs.NTO_LEAVES_FLOOR) {
                    breakAndPlace(overworld, blockX, blockY, blockZ);
                }

                Location loc = new Location(overworld, blockX, blockY + 1, blockZ);
                Location loc2 = new Location(overworld, blockX, blockY + 2, blockZ);
                loc.getBlock().breakNaturally();
                loc2.getBlock().breakNaturally();

                player.teleport(playerLocation);
            }

            if (environment == Environment.THE_END) {
                playerLocation.setWorld(the_nether);
                int blockY = the_nether.getMinHeight();

                playerLocation.setY(blockY + 1);
                playerLocation.setX(blockX * Configs.ETN_SCALE + 0.5);
                playerLocation.setZ(blockZ * Configs.ETN_SCALE + 0.5);

                blockX = playerLocation.getBlockX();
                blockZ = playerLocation.getBlockZ();

                if (Configs.ETN_LEAVES_FLOOR) {
                    breakAndPlace(the_nether, blockX, blockY, blockZ);
                }

                Location loc = new Location(the_nether, blockX, blockY + 1, blockZ);
                Location loc2 = new Location(the_nether, blockX, blockY + 2, blockZ);
                loc.getBlock().breakNaturally();
                loc2.getBlock().breakNaturally();

                player.teleport(playerLocation);
            }
        }
    }

    private void breakAndPlace(World world, int blockX, int blockY, int blockZ) {

        for (int y = blockY; y <=blockY + 3; y++) {
            for (int x = blockX - 2; x <= blockX + 2; x++) {
                for (int z = blockZ - 2; z <= blockZ + 2; z++) {
                    Location loc = new Location(world, x, y, z);

                    Block block = loc.getBlock();
                    block.breakNaturally();
                }
            }
        }

        for (int x = blockX - 2; x <= blockX + 2; x++) {
            for (int z = blockZ - 2; z <= blockZ + 2; z++) {
                Location loc = new Location(world, x, blockY, z);

                Block block = loc.getBlock();
                block.setType(Material.OAK_LEAVES);
                BlockData data = Bukkit.createBlockData("minecraft:oak_leaves[persistent=true]");
                block.setBlockData(data);
            }
        }
    }
}
