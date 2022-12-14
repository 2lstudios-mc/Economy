package dev._2lstudios.economy.commands;


import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dev._2lstudios.economy.errors.BadArgumentException;
import dev._2lstudios.economy.errors.MaterialNotFoundException;
import dev._2lstudios.economy.errors.PlayerOfflineException;
import dev._2lstudios.economy.errors.SoundNotFoundException;
import dev._2lstudios.economy.errors.WorldNotFoundException;
import dev._2lstudios.economy.players.EconomyPlayer;
import dev._2lstudios.economy.plugins.EconomyPlugin;

public class CommandContext {
    private EconomyPlugin plugin;
    private CommandExecutor executor;
    private CommandArguments arguments;

    public CommandContext(EconomyPlugin plugin, CommandSender sender, Argument[] requiredArguments) {
        if (sender instanceof Player) {
            this.executor = plugin.getPlayerManager().getPlayer((Player) sender);
        } else {
            this.executor = new CommandExecutor(plugin, sender);
        }

        this.plugin = plugin;
        this.arguments = new CommandArguments(plugin, requiredArguments);
    }

    public void parseArguments(String[] args) throws BadArgumentException, PlayerOfflineException, WorldNotFoundException, MaterialNotFoundException, SoundNotFoundException {
        this.arguments.parse(args);
    }

    public EconomyPlugin getPlugin() {
        return this.plugin;
    }

    public CommandExecutor getExecutor() {
        return this.executor;
    }

    public EconomyPlayer getPlayer() {
        return (EconomyPlayer) this.executor;
    }

    public boolean isPlayer() {
        return this.executor.isPlayer();
    }

    public CommandArguments getArguments() {
        return this.arguments;
    }
}