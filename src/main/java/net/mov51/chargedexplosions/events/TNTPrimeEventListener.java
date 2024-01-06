package net.mov51.chargedexplosions.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;

import static net.mov51.chargedexplosions.ChargedExplosions.chargedLocations;

public class TNTPrimeEventListener implements Listener {
    @EventHandler
    public void onTNTPrimeEvent(TNTPrimeEvent event) {
        Location primeLocation = event.getBlock().getLocation().toBlockLocation();
        if(event.getCause() == TNTPrimeEvent.PrimeCause.REDSTONE){
            if(event.getPrimingBlock() != null && event.getPrimingBlock().getType() == Material.LIGHTNING_ROD) {
                chargedLocations.add(primeLocation.getBlockX() + "," + primeLocation.getBlockY() + "," + primeLocation.getBlockZ());
            }
        }
    }
}
