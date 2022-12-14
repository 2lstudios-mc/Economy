package dev._2lstudios.economy.players;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import dev._2lstudios.economy.plugins.EconomyPlugin;

public class EconomyPlayerManager {
    private EconomyPlugin plugin;

    private Map<Player, EconomyPlayer> players;

    public EconomyPlayerManager(EconomyPlugin plugin) {
        this.plugin = plugin;
        this.players = new HashMap<>();
    }

    public EconomyPlayer addPlayer(Player bukkitPlayer) {
        EconomyPlayer player = new EconomyPlayer(this.plugin, bukkitPlayer);
        this.players.put(bukkitPlayer, player);
        return player;
    }

    public EconomyPlayer removePlayer(Player bukkitPlayer) {
        return this.players.remove(bukkitPlayer);
    }

    public EconomyPlayer getPlayer(Player bukkitPlayer) {
        return this.players.get(bukkitPlayer);
    }

    public EconomyPlayer getPlayer(String name) {
        Player bukkitPlayer = this.plugin.getServer().getPlayerExact(name);
        if (bukkitPlayer != null && bukkitPlayer.isOnline()) {
            return this.getPlayer(bukkitPlayer);
        } else {
            return null;
        }
    }

    public EconomyPlayer getPlayer(UUID uuid) {
        Player bukkitPlayer = this.plugin.getServer().getPlayer(uuid);
        if (bukkitPlayer != null && bukkitPlayer.isOnline()) {
            return this.getPlayer(bukkitPlayer);
        } else {
            return null;
        }
    }

    public Collection<EconomyPlayer> getPlayers() {
        return this.players.values();
    }

    public void clear() {
        this.players.clear();
    }

    public void addAll() {
        for (Player bukkitPlayer : this.plugin.getServer().getOnlinePlayers()) {
            this.addPlayer(bukkitPlayer).download();
        }
    }
}