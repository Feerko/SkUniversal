package us._donut_.skuniversal;

import ch.njol.skript.Skript;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import us._donut_.skuniversal.parties.PartiesRegister;
import java.util.ArrayList;
import java.util.List;

public class SkUniversal extends JavaPlugin {
    public static List<String> hookedPlugins = new ArrayList<>();

    @Override
    public void onEnable() {
        PartiesRegister.registerParties();
        if (hookedPlugins.isEmpty()) {
            getLogger().warning("Did not find any plugins to hook into.");
        } else {
            getLogger().info("Hooked Plugins: " + hookedPlugins);
        }
        getLogger().info("Enabled!");
    }

    @Override
    public void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("skuniversal")) {
            sender.sendMessage("");
            sender.sendMessage("§5§l§nSkUniversal v" + getDescription().getVersion());
            sender.sendMessage("");
            sender.sendMessage("§6Hooked plugins:");
            if (hookedPlugins.isEmpty()) {
                sender.sendMessage("§eNone");
            } else {
                sender.sendMessage("§e" + hookedPlugins);
            }
            sender.sendMessage("");
            sender.sendMessage("§6Plugin page:");
            sender.sendMessage("§ehttps://www.spigotmc.org/resources/skuniversal.45392/");
            sender.sendMessage("");
            sender.sendMessage("§6Documentation:");
            sender.sendMessage("§ehttps://github.com/OfficialDonut/SkUniversal/wiki");
            sender.sendMessage("");
            sender.sendMessage("§6Discord channel:");
            sender.sendMessage("§ehttps://discord.gg/UBGQhn8");
            return true;
        }
        return false;
    }
}