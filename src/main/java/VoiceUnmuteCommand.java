package me.mahan.voicemute;

import de.maxhenkel.voicechat.api.VoicechatApi;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VoiceUnmuteCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("voicemute.use")) {
            sender.sendMessage("you  don't have permission to use this command!");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage("/voiceunmute <player> time");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage("the player was offline!");
            return true;
        }

        VoicechatApi api = mute.Main.getVoicechatApi();
        api.getPlayerStateManager()
                .setMuted(target.getUniqueId(), false);

        sender.sendMessage("the player wan unmute");
        target.sendMessage("the voice was unmuted");

        return true;
    }
}
