package tavonatti.stefano.spigot_plugin.waypoints.utils;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TPUtils {

    /**
     * teleport the player (and the vehicle) to a location
     * @param player
     * @param location
     */
    public static void teleportPlayer(Player player, Location location){
        if(player.isInsideVehicle()){

            double x=location.getX();
            double y=location.getY();
            double z=location.getZ();

            /*if the player is inside a veichle, move the veichle*/
            Entity veichle=player.getVehicle();
            location=new Location(player.getWorld(),x,y+1,z);

            veichle.eject();//eject the player from the veichle

            //teleport the player and the veichle
            veichle.teleport(location);
            player.teleport(location);

            //put the player on the veichle
            veichle.addPassenger(player);
        }
        else {
            player.teleport(location);
        }
        player.spawnParticle(Particle.END_ROD,location,500);
        player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT,1,1);

    }
}
