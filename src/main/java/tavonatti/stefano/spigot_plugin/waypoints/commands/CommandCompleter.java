package tavonatti.stefano.spigot_plugin.waypoints.commands;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

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

            //filter list
            List<String> filteredList = Lists.newArrayList(Collections2.filter(
                    waypointList, Predicates.containsPattern(strings[0])));
            Collections.sort(filteredList);

            return filteredList;
        }

        return null;
    }
}
