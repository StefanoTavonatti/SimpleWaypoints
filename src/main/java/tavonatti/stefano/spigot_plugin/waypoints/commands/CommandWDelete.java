package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class CommandWDelete implements CommandExecutor{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player= (Player) commandSender;

            if(strings.length<1){
                player.sendMessage("use /wdelete <name>");
                return true;
            }

            System.out.println("waypoints/"+player.getName()+"-"+
                    player.getWorld().getName()+".properties");

            //load file
            File waypointFile=new File("waypoints/"+player.getName()+"-"+
                    player.getWorld().getName()+".properties");

            Properties properties = new Properties();

            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return true;

            //check if the waypoint exists
            if(properties.getProperty(strings[0])!=null){
                properties.remove(strings[0]);
            }
            else {
                player.sendMessage("waypoint \""+strings[0]+"\" do not exists");
                return true;
            }


            //save file
            try {
                properties.store(new FileOutputStream(waypointFile),"");
            } catch (IOException e) {
                e.printStackTrace();
            }


            player.sendMessage("Waypoint deleted");
        }

        return true;
    }
}
