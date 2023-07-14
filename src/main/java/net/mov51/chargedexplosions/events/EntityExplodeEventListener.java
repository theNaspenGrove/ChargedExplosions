package net.mov51.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import static net.mov51.chargedexplosions.utilities.BlockSearch.SearchByExplosion;

public class EntityExplodeEventListener implements Listener {
    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        if(event.getEntityType() == EntityType.PRIMED_TNT) {
            if (event.getEntity().isGlowing()) {
                for (Block block : event.blockList()) {
                    if (block.getType() == Material.BUDDING_AMETHYST) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BUDDING_AMETHYST, 1));
                    }
                }
                for(Block bedrock : SearchByExplosion(event.getLocation(), Material.BEDROCK)){
                    bedrock.setType(Material.AIR);
                }
            }
        }
    }
}
