package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.trim.TrimMaterial;

public class EntityDamageEventListener implements Listener {
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if(event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION){
            if(event.getEntityType() == EntityType.ITEM){
                if(((Item) event.getEntity()).getItemStack().getType() == Material.BUDDING_AMETHYST){
                    event.setCancelled(true);
                }
            }
        }else if(event.getCause() == EntityDamageEvent.DamageCause.LIGHTNING){
            if(event.getEntityType() == EntityType.PLAYER){
                Player player = (Player) event.getEntity();
                if(player.getInventory().getBoots() != null && player.getInventory().getBoots().getType() == Material.IRON_BOOTS){
                    event.setCancelled(true);
                    if(((ArmorMeta) player.getInventory().getBoots().getItemMeta()).hasTrim()) {
                        if (((ArmorMeta) player.getInventory().getBoots().getItemMeta()).getTrim().getMaterial() == TrimMaterial.COPPER) {
                            return;
                        }
                    }
                    player.damageItemStack(EquipmentSlot.FEET,1);

                }
            }
        }
    }
}
