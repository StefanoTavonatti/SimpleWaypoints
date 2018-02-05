package tavonatti.stefano.spigot_plugin.waypoints;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("plugin enabled");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        System.out.println("plugin disabled");
    }
}
