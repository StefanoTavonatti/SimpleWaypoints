package tavonatti.stefano.spigot_plugin.waypoints.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.io.File;
import java.util.*;

public class CommandCompleter implements TabCompleter
{
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if(commandSender instanceof Player){
            Player p = (Player) commandSender;

            //load file
            File waypointFile = new File("waypoints/" + p.getName() + "-" + p.getWorld().getName() + ".properties");
            Properties properties = new Properties();
            if (CommandWSave.loadWaypointFile(waypointFile, properties)) return null;
            Iterator it=properties.keySet().iterator();

            //fill ArrayList with names
            List<String> waypointList = new ArrayList<String>();
            while (it.hasNext()){
                waypointList.add(it.next().toString());
            }

            //filtering result based on what player types
            List<String> filteredList = new ArrayList<String>();
            StringUtil.copyPartialMatches(strings[0], waypointList, filteredList);
            Collections.sort(filteredList);

            return filteredList;
        }

        return null;
    }
}
