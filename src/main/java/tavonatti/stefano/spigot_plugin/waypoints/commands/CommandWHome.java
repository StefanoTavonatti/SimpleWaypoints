package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tavonatti.stefano.spigot_plugin.waypoints.utils.Permissions;
import tavonatti.stefano.spigot_plugin.waypoints.utils.TPUtils;

public class CommandWHome implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player= (Player) commandSender;

            if(!player.hasPermission(Permissions.WAYPOINTS.permission)){
                player.sendMessage(""+ ChatColor.RED+"You don't have the permission to do this!!!");
                return true;
            }

            if(player.getBedSpawnLocation()!=null)
                TPUtils.teleportPlayer(player,player.getBedSpawnLocation());
            else {
                player.sendMessage(""+ChatColor.RED+"Spawn point not found");
            }


        }
        return true;
    }
}
