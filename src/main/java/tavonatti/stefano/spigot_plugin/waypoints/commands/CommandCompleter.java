package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class CommandCompleter implements TabCompleter
{
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if(commandSender instanceof Player)
        {
            Player player = (Player) commandSender;

            //load file
            File waypointFile = new File("waypoints/" + player.getName() + "-" +
                    player.getWorld().getName() + ".properties");

            Properties properties = new Properties();
            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return null;
            Iterator it=properties.keySet().iterator();

            //fill ArrayList with names
            List<String> waypointList = new ArrayList<String>();
            while (it.hasNext()){
                waypointList.add(it.next().toString());
            }

            return waypointList;
        }

        return null;
    }
}
