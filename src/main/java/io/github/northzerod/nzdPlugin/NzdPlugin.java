package io.github.northzerod.nzdPlugin;

import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class NzdPlugin extends JavaPlugin {
    public static Logger LOGGER;
    public static NzdPlugin instance;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        LOGGER = this.getLogger();
        instance = getInstance();
        ConfigManager.reload();

        // 事件注册
        this.getServer().getPluginManager().registerEvents(new PlayerFallIntoVoidListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerReachMaxHeightListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerMountHappyGhastListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDismountHappyGhastListener(), this);

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {
            // 命令注册
            commands.registrar().register(ReloadCommand.getNode());
        });


        LOGGER.info("插件 NzdPlugin 已启用");
    }

    @Override
    public void onDisable() {
        LOGGER.info("插件 NzdPlugin 已禁用");
    }

    public static NzdPlugin getInstance(){
        return (NzdPlugin) Bukkit.getPluginManager().getPlugin("NzdPlugin");
    }
}
