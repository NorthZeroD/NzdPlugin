package io.github.northzerod.nzdPlugin;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public final class Configs {
    public static boolean HG_ENABLE = false;
    public static boolean WHEN_DISMOUNT_RESET_SPEED = false;
    public static boolean RANDOM_MODE = false;
    public static double BASE = 0.05;
    public static int MOD = 100;
    public static int K = 0;
    public static double SCALE = 0.001;
    public static boolean HARNESS_MODE = false;

    public static Map<Material, Double> HARNESS = new HashMap<>();

    static {
        HARNESS.put(Material.WHITE_HARNESS, 0.0);
        HARNESS.put(Material.LIGHT_GRAY_HARNESS, 0.01);
        HARNESS.put(Material.GRAY_HARNESS, 0.02);
        HARNESS.put(Material.BLACK_HARNESS, 0.03);
        HARNESS.put(Material.BROWN_HARNESS, 0.04);
        HARNESS.put(Material.RED_HARNESS, 0.05);
        HARNESS.put(Material.ORANGE_HARNESS, 0.06);
        HARNESS.put(Material.YELLOW_HARNESS, 0.07);
        HARNESS.put(Material.LIME_HARNESS, 0.08);
        HARNESS.put(Material.GREEN_HARNESS, 0.09);
        HARNESS.put(Material.CYAN_HARNESS, 0.1);
        HARNESS.put(Material.LIGHT_BLUE_HARNESS, 0.11);
        HARNESS.put(Material.BLUE_HARNESS, 0.12);
        HARNESS.put(Material.PURPLE_HARNESS, 0.13);
        HARNESS.put(Material.MAGENTA_HARNESS, 0.14);
        HARNESS.put(Material.PINK_HARNESS, 0.15);
    }

    public static boolean DI_ENABLE = true;

    public static int OTN_SLOW_FALLING_SECONDS = 30;
    public static boolean OTN_DIRECT = false;
    public static double OTN_SCALE = 1;
    public static boolean OTE_LEAVES_FLOOR = true;
    public static double OTE_SCALE = 1;

    public static int NTE_SLOW_FALLING_SECONDS = 30;
    public static boolean NTE_DIRECT = false;
    public static double NTE_SCALE = 1;
    public static boolean NTO_LEAVES_FLOOR = true;
    public static double NTO_SCALE = 1;

    public static int ETO_SLOW_FALLING_SECONDS = 30;
    public static boolean ETO_DIRECT = false;
    public static double ETO_SCALE = 1;
    public static boolean ETN_LEAVES_FLOOR = true;
    public static double ETN_SCALE = 1;

}
