package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHitEventListener implements Listener {
    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event) {
        if(event.getEntity().getType() != org.bukkit.entity.EntityType.TRIDENT) {
            return;
        }
        if(!(event.getEntity().getShooter() instanceof org.bukkit.entity.Player)) {
            return;
        }
        if(event.getHitBlock() == null) {
            return;
        }
        if(((Trident) event.getEntity()).getItem().getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.CHANNELING)) {
            if(event.getHitBlock().getType() == Material.LIGHTNING_ROD){
                if(!event.getEntity().getWorld().isBedWorks()) {
                    if(event.getHitBlock().getWorld().getHighestBlockAt(event.getHitBlock().getLocation()).getLocation().getBlockY() == event.getHitBlock().getLocation().getBlockY()){
                        event.getHitBlock().getWorld().strikeLightning(event.getHitBlock().getLocation().add(0,1,0));
                    }
                }
            }
        }
    }
}
