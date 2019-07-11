package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import tavonatti.stefano.spigot_plugin.waypoints.utils.Permissions;
import tavonatti.stefano.spigot_plugin.waypoints.utils.TPUtils;

import java.io.File;
import java.util.Properties;

public class CommandWTP implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if(!player.hasPermission(Permissions.WAYPOINTS.permission)){
                player.sendMessage(""+ ChatColor.RED+"You don't have the permission to do this!!!");
                return true;
            }

            if (strings.length < 1) {
                player.sendMessage("use /wtp <name>");
                return true;
            }

            System.out.println("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            //load file
            File waypointFile = new File("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            Properties properties = new Properties();

            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return true;

            if(properties.getProperty(strings[0])==null){
                player.sendMessage("Waypoint do not exists");
                return true;
            }

            String waypointString[]=properties.getProperty(strings[0]).split(" ");

            double x,y,z;

            x=Double.parseDouble(waypointString[0]);
            y=Double.parseDouble(waypointString[1]);
            z=Double.parseDouble(waypointString[2]);

            Location location=new Location(player.getWorld(),x,y,z);

            TPUtils.teleportPlayer(player,location);

        }

        return true;
    }


}
