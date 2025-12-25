package  mute;
import de.maxhenkel.voicechat.api.BukkitVoicechatService;
import de.maxhenkel.voicechat.api.VoicechatApi;
import me.mahan.voicemute.VoiceUnmuteCommand;
import org.bukkit.plugin.java.JavaPlugin;
import org.mahanvafadaran.VoiceMuteCommand;

public class Main extends JavaPlugin {

    private static Class<?> voicechatApi;

    @Override
    public void onEnable() {
        BukkitVoicechatService service = getServer()
                .getServicesManager()
                .load(BukkitVoicechatService.class);

        if (service != null) {
            voicechatApi = service.getClass();
            getLogger().info("VoiceChat API loaded");
        } else {
            getLogger().severe("VoiceChat API not found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        getCommand("voicemute").setExecutor(new VoiceMuteCommand());
        getCommand("voiceunmute").setExecutor(new VoiceUnmuteCommand());
    }

    public static VoicechatApi getVoicechatApi() {
        return new VoicechatApi() {
        };
    }
}
