package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tavonatti.stefano.spigot_plugin.waypoints.utils.Permissions;

import java.io.File;
import java.util.Iterator;
import java.util.Properties;

public class CommandWList implements CommandExecutor{
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(!player.hasPermission(Permissions.WAYPOINTS.permission)){
                player.sendMessage(""+ ChatColor.RED+"You don't have the permission to do this!!!");
                return true;
            }

            System.out.println("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            //load file
            File waypointFile = new File("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            Properties properties = new Properties();

            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return true;

            Iterator it=properties.keySet().iterator();
            String message="Waypoints:\n";

            ChatColor chatColor=ChatColor.BLUE;

            if(player.getWorld().getEnvironment()== World.Environment.NETHER){
                chatColor=ChatColor.RED;
            }else if(player.getWorld().getEnvironment()== World.Environment.THE_END){
                chatColor=ChatColor.AQUA;
            }

            while (it.hasNext()){
                String temp=it.next().toString();
                message+=""+ chatColor+temp+" "+ChatColor.WHITE+properties.getProperty(temp)+"\n";
            }
            player.sendMessage(message);
        }

        return true;
    }
}
