package mov.naspen.chargedexplosions.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Directional;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

import static mov.naspen.chargedexplosions.ChargedExplosions.coreProtectHelper;

public class BlockRedstoneEventListener implements Listener {
    @EventHandler
    public void onBlockRedstoneEvent(BlockRedstoneEvent event) {
        if(event.getBlock().getType() == Material.LIGHTNING_ROD){
            Block lightningRod = event.getBlock();
            Block attachedBlock = event.getBlock().getWorld().getBlockAt(lightningRod.getLocation().add(((Directional) event.getBlock().getBlockData()).getFacing().getOppositeFace().getDirection()));
            if(attachedBlock.getType() == Material.DEEPSLATE_DIAMOND_ORE){
                coreProtectHelper.setBlock(attachedBlock,Material.BEDROCK,"#lightning_rod");
            } else if (attachedBlock.getType() == Material.BEDROCK) {
                coreProtectHelper.setBlock(attachedBlock,Material.AIR,"#lightning_rod");
            }
        }
    }
}
