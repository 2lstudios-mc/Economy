package dev._2lstudios.economy.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import dev._2lstudios.economy.Economy;

public class PlayerQuitListener implements Listener {
  private Economy plugin;

  public PlayerQuitListener(Economy plugin) {
    this.plugin = plugin;
  }
  
  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent e) {
    this.plugin.getPlayerManager().removePlayer(e.getPlayer());
  }
}
