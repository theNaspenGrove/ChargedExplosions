package mov.naspen.chargedexplosions.events;

import org.bukkit.Location;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import static mov.naspen.chargedexplosions.ChargedExplosions.chargedLocations;

public class EntitySpawnEventListener implements Listener {
    @EventHandler
    public void onEntitySpawnEvent(EntitySpawnEvent event) {
        if(event.getEntity() instanceof TNTPrimed){
            Location spawnLocation = event.getLocation().toBlockLocation();
            if(chargedLocations.contains(spawnLocation.getBlockX() + "," + spawnLocation.getBlockY() + "," + spawnLocation.getBlockZ())){
                event.getEntity().setGlowing(true);
                ((Explosive)event.getEntity()).setYield((float) 6);
                ((Explosive)event.getEntity()).setIsIncendiary(true);
                chargedLocations.remove(spawnLocation.getBlockX() + "," + spawnLocation.getBlockY() + "," + spawnLocation.getBlockZ());
            }
        }
    }
}
