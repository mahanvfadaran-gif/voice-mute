package org.mahanvafadaran ;

import de.maxhenkel.voicechat.api.VoicechatApi;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoiceMuteCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("voicemute.use")) {
            sender.sendMessage("you don't have permission to use this command!");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("/voicemute <player> time");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("the player was offline");
            return true;
        }

        VoicechatApi api = mute.Main.getVoicechatApi();
        api.getPlayerStateManager()
                .setMuted(target.getUniqueId(), true);

        sender.sendMessage("the player has been muted");
        target.sendMessage("you are now muted");

        return true;
    }
}
