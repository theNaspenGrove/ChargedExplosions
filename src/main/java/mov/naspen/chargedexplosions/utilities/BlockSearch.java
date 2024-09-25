package mov.naspen.chargedexplosions.utilities;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockSearch {
    public static List<Block> SearchByExplosion(Location location, float strength ,Material material){
        Random r = new Random();
        int k;
        int l;
        List<Block> blocks = new ArrayList<>();
        for(int j = 0; j < 16; ++j) {
            for(k = 0; k < 16; ++k) {
                for(l = 0; l < 16; ++l) {
                    if (j == 0 || j == 15 || k == 0 || k == 15 || l == 0 || l == 15) {
                        double d = (double)((float)j / 15.0F * 2.0F - 1.0F);
                        double e = (double)((float)k / 15.0F * 2.0F - 1.0F);
                        double f = (double)((float)l / 15.0F * 2.0F - 1.0F);
                        double g = Math.sqrt(d * d + e * e + f * f);
                        d /= g;
                        e /= g;
                        f /= g;
                        //4 is the default strength of tnt explosions
                        strength = strength == 0 ? strength : 4;
                        float h = strength * (0.7F + r.nextFloat() * 0.6F);
                        double m = location.getX();
                        double n = location.getY();
                        double o = location.getZ();

                        for(float p = 0.3F; h > 0.0F; h -= 0.22500001F) {
                            Location loc = new Location(location.getWorld(),m,n,o);
                            if (location.getWorld().getBlockAt(loc).getType() == material){
                                blocks.add(location.getWorld().getBlockAt(loc));
                            }
                            h -= (((location.getWorld().getBlockAt(loc).getType().getBlastResistance() + 0.1F)) * 0.1F)/2;

                            //m n o are the coordinates of the explosion and iterate along the direction of the explosion
                            m += d * 0.30000001192092896;
                            n += e * 0.30000001192092896;
                            o += f * 0.30000001192092896;
                        }
                    }
                }
            }
        }
        return blocks;
    }
}
