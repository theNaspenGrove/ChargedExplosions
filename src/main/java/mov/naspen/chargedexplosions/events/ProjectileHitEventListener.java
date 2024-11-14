package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
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
        if(((Trident) event.getEntity()).getItemStack().getEnchantments().containsKey(org.bukkit.enchantments.Enchantment.CHANNELING)) {
            if(event.getHitBlock().getType() == Material.LIGHTNING_ROD){
                makeLightning(event.getHitBlock());
            }
        }
    }

    public static boolean makeLightning(Block block) {
        if(!block.getWorld().isBedWorks() || block.getWorld().hasStorm()){
            if(block.getWorld().getHighestBlockAt(block.getLocation()).getLocation().getBlockY() == block.getLocation().getBlockY()){
                block.getWorld().strikeLightning(block.getLocation().add(0.5,1,0.5));
                return true;
            }
        }
        return false;
    }
}
