package io.github.northzerod.nzdPlugin;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import static io.github.northzerod.nzdPlugin.NzdPlugin.LOGGER;

public final class ReloadCommand {
    public static LiteralCommandNode<CommandSourceStack> getNode() {
        LiteralArgumentBuilder<CommandSourceStack> nzd = Commands.literal("nzd");

        LiteralArgumentBuilder<CommandSourceStack> reload = Commands.literal("reload")
                .executes(
                        ctx -> {
                            ConfigManager.reload();
                            ctx.getSource().getSender().sendRichMessage("<green>已重载 NzdPlugin 配置文件");
                            LOGGER.info("已重载 NzdPlugin 配置文件");
                            return Command.SINGLE_SUCCESS;
                        }
                )
                .requires(sender ->
                        sender.getSender().isOp() || sender.getSender().hasPermission("nzdplugin.command.nzd.reload")
                );

        nzd.then(reload);
        return nzd.build();
    }
}
