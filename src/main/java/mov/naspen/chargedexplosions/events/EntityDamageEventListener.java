package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageEventListener implements Listener {
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if(event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
            if(event.getEntityType() == EntityType.ITEM){
                if(((Item) event.getEntity()).getItemStack().getType() == Material.BUDDING_AMETHYST){
                    event.setCancelled(true);
                }
            }
        }
    }
}
