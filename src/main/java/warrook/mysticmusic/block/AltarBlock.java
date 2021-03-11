package warrook.mysticmusic.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class AltarBlock extends BlockBase implements BlockEntityProvider {
    private static final VoxelShape HITBOX;

    public AltarBlock() {
        super("altar",
                FabricBlockSettings.of(Material.STONE).nonOpaque()
        );
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return null;
    }

    static {
        HITBOX = createCuboidShape(0,0,0,16,11,16);
    }
}
