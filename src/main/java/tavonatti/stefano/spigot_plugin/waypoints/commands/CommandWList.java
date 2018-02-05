package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;

public class CommandWList implements CommandExecutor{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            System.out.println("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            //load file
            File waypointFile = new File("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            Properties properties = new Properties();

            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return true;

            Iterator it=properties.keySet().iterator();
            String message="Waypoints:\n";

            while (it.hasNext()){
                String temp=it.next().toString();
                message+=""+ ChatColor.BLUE+temp+" "+ChatColor.WHITE+properties.getProperty(temp)+"\n";
            }
            player.chat(message);
        }

        return true;
    }
}