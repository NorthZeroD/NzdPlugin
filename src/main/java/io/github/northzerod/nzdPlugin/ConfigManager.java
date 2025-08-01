package io.github.northzerod.nzdPlugin;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigManager {
    public static FileConfiguration fc;

    public static void reload() {
        NzdPlugin.instance.reloadConfig();
        fc = NzdPlugin.instance.getConfig();

        String hg = "happy_ghast.";
        Configs.HG_ENABLE = fc.getBoolean(hg + "enable", false);
        Configs.WHEN_DISMOUNT_RESET_SPEED = fc.getBoolean(hg + "when_dismount_reset_speed", false);
        Configs.BASE = fc.getDouble(hg + "base", 0.05);
        Configs.RANDOM_MODE = fc.getBoolean(hg + "random_mode", false);


        String ra = hg + "random.";
        Configs.MOD = fc.getInt(ra + "mod", 100);
        Configs.K = fc.getInt(ra + "k", 0);
        Configs.SCALE = fc.getDouble(ra + "scale", 0.001);

        Configs.HARNESS_MODE = fc.getBoolean(hg + "harness_mode", false);

        String hs = hg + "harness_speed.";

        Configs.HARNESS.put(Material.WHITE_HARNESS, fc.getDouble(hs + "white_harness"));
        Configs.HARNESS.put(Material.LIGHT_GRAY_HARNESS, fc.getDouble(hs + "light_gray_harness"));
        Configs.HARNESS.put(Material.GRAY_HARNESS, fc.getDouble(hs + "gray_harness"));
        Configs.HARNESS.put(Material.BLACK_HARNESS, fc.getDouble(hs + "black_harness"));
        Configs.HARNESS.put(Material.BROWN_HARNESS, fc.getDouble(hs + "brown_harness"));
        Configs.HARNESS.put(Material.RED_HARNESS, fc.getDouble(hs + "red_harness"));
        Configs.HARNESS.put(Material.ORANGE_HARNESS, fc.getDouble(hs + "orange_harness"));
        Configs.HARNESS.put(Material.YELLOW_HARNESS, fc.getDouble(hs + "yellow_harness"));
        Configs.HARNESS.put(Material.LIME_HARNESS, fc.getDouble(hs + "lime_harness"));
        Configs.HARNESS.put(Material.GREEN_HARNESS, fc.getDouble(hs + "green_harness"));
        Configs.HARNESS.put(Material.CYAN_HARNESS, fc.getDouble(hs + "cyan_harness"));
        Configs.HARNESS.put(Material.LIGHT_BLUE_HARNESS, fc.getDouble(hs + "light_blue_harness"));
        Configs.HARNESS.put(Material.BLUE_HARNESS, fc.getDouble(hs + "blue_harness"));
        Configs.HARNESS.put(Material.PURPLE_HARNESS, fc.getDouble(hs + "purple_harness"));
        Configs.HARNESS.put(Material.MAGENTA_HARNESS, fc.getDouble(hs + "magenta_harness"));
        Configs.HARNESS.put(Material.PINK_HARNESS, fc.getDouble(hs + "pink_harness"));

        String di = "dimension.";
        String ov = "overworld.";
        String tn = "the_nether.";
        String te = "the_end.";
        String to = "to.";

        String sfs = "slow_falling_seconds";
        String dr = "direct";
        String sc = "scale";
        String lf = "leaves_floor";

        Configs.DI_ENABLE = fc.getBoolean(di + "enable", true);

        Configs.OTN_SLOW_FALLING_SECONDS = fc.getInt(di + ov + to + tn + sfs, 30);
        Configs.OTN_DIRECT = fc.getBoolean(di + ov + to + tn + dr, false);
        Configs.OTN_SCALE = fc.getDouble(di + ov + to + tn + sc, 1);
        Configs.OTE_LEAVES_FLOOR = fc.getBoolean(di + ov + to + te + lf, true);
        Configs.OTE_SCALE = fc.getDouble(di + ov + to + te + sc, 1);

        Configs.NTE_SLOW_FALLING_SECONDS = fc.getInt(di + tn + to + te + sfs, 30);
        Configs.NTE_DIRECT = fc.getBoolean(di + tn + to + te + dr, false);
        Configs.NTE_SCALE = fc.getDouble(di + tn + to + te + sc, 1);
        Configs.NTO_LEAVES_FLOOR = fc.getBoolean(di + tn + to + ov + lf, true);
        Configs.NTO_SCALE = fc.getDouble(di + tn + to + ov + sc, 1);

        Configs.ETO_SLOW_FALLING_SECONDS = fc.getInt(di + te + to + ov + sfs, 30);
        Configs.ETO_DIRECT = fc.getBoolean(di + te + to + ov + dr, false);
        Configs.ETO_SCALE = fc.getDouble(di + te + to + ov + sc, 1);
        Configs.ETN_LEAVES_FLOOR = fc.getBoolean(di + te + to + tn + lf, true);
        Configs.ETN_SCALE = fc.getDouble(di + te + to + tn + sc, 1);

    }
}
