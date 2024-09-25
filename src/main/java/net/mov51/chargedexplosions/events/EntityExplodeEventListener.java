package net.mov51.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import static mov.naspen.periderm.helpers.BlockManager.setBlock;
import static net.mov51.chargedexplosions.utilities.BlockSearch.SearchByExplosion;

public class EntityExplodeEventListener implements Listener {
    @EventHandler
    public void onEntityExplodeEvent(EntityExplodeEvent event) {
        if(event.getEntityType() == EntityType.PRIMED_TNT) {
            if (event.getEntity().isGlowing() || (event.getEntity().getType() == EntityType.CREEPER && ((Creeper)event.getEntity()).isPowered())) {
                for (Block block : event.blockList()) {
                    if (block.getType() == Material.BUDDING_AMETHYST) {
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.BUDDING_AMETHYST, 1));
                    }
                }
                for(Block bedrock : SearchByExplosion(event.getLocation(), 8 ,Material.BEDROCK)){
                    setBlock(bedrock,Material.AIR,"#charged_tnt");
                }
            }
        }
    }
}
