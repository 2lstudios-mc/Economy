package dev._2lstudios.economy.commands.player;

import dev._2lstudios.economy.commands.Command;
import dev._2lstudios.economy.commands.CommandContext;
import dev._2lstudios.economy.commands.CommandListener;
import dev._2lstudios.economy.players.EconomyPlayer;

@Command(name = "balance")
public class BalanceCommand extends CommandListener {
    @Override
    public void onExecuteByPlayer(CommandContext ctx) {
        EconomyPlayer player = ctx.getPlayer();
        player.sendI18nMessage("balance.success",
                new String[] { "{balance}", String.valueOf(player.getBalance()) });
    }
}
