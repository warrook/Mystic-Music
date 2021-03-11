package warrook.mysticmusic.block;

import net.minecraft.block.Block;

public class BlockBase extends Block {
    public final String registryName;


    public BlockBase(String name, Settings settings) {
        super(settings);
        registryName = name;
    }
}
