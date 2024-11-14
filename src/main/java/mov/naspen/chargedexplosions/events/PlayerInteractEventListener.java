package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

import static mov.naspen.chargedexplosions.events.ProjectileHitEventListener.makeLightning;
import static org.bukkit.Bukkit.getServer;

public class PlayerInteractEventListener implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_BLOCK && event.getHand() != null){
            if(event.getHand() != EquipmentSlot.HAND){
                return;
            }
            if(event.getPlayer().getCooldown(Material.TRIDENT) != 0){
                return;
            }
            if(event.getClickedBlock() != null && event.getClickedBlock().getType() == Material.LIGHTNING_ROD){
                if(event.getPlayer().getInventory().getItemInMainHand().getType() != Material.TRIDENT){
                    return;
                }
                event.getPlayer().setCooldown(Material.TRIDENT,20);
                ItemStack trident = event.getPlayer().getInventory().getItemInMainHand();
                if(isNotBroken(trident) && trident.containsEnchantment(org.bukkit.enchantments.Enchantment.CHANNELING)){
                    if(makeLightning(event.getClickedBlock())){
                        event.getPlayer().damageItemStack(EquipmentSlot.HAND,1);
                    }
                }
            }
        }
    }
    private boolean isNotBroken(ItemStack item){
        return !(((Damageable)item.getItemMeta()).getDamage() == item.getType().getMaxDurability()-1);
    }
}
