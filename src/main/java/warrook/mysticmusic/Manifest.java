package warrook.mysticmusic;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import warrook.mysticmusic.block.AltarBlock;
import warrook.mysticmusic.block.BlockBase;
import warrook.mysticmusic.block.entity.AltarBlockEntity;
import warrook.mysticmusic.item.ItemBase;
import warrook.mysticmusic.item.LyreItem;

import static warrook.mysticmusic.MysticMusic.*;

public class Manifest {
    public static void registerAll() {
        Blocks.registerAll();
        Items.registerAll();
    }

    public static class Items {
        public static final LyreItem LYRE = new LyreItem();

        static void registerAll() {
            register(LYRE);
            log(Level.INFO, "Items registered");
        }

        private static void register(ItemBase item) {
            Registry.register(Registry.ITEM, id(item.registryName), item);
        }
    }

    public static class Blocks {
        public static final AltarBlock ALTAR = new AltarBlock();
        public static final BlockEntityType<AltarBlockEntity> ALTAR_BLOCK_ENTITY = BlockEntityType.Builder.create(AltarBlockEntity::new, ALTAR).build(null);

        static void registerAll() {
            register(ALTAR, ALTAR_BLOCK_ENTITY);
            log(Level.INFO, "Blocks registered");
        }

        private static void register(BlockBase block, BlockEntityType<?> blockEntityType) {
            register(block, blockEntityType, ITEM_GROUP);
        }

        private static void register(BlockBase block) {
            registerBlock(block, ITEM_GROUP);
        }

        private static void register(BlockBase block, BlockEntityType<?> blockEntityType, ItemGroup group) {
            registerBlock(block, group);
            registerBlockEntity(block, blockEntityType);
        }

        private static void registerBlock(BlockBase block, ItemGroup group) {
            registerBlockOnly(block);
            registerBlockItem(block, group);
        }

        private static void registerBlockItem(BlockBase block, ItemGroup group) {
            Registry.register(Registry.ITEM, id(block.registryName), new BlockItem(block, new FabricItemSettings().group(group)));
        }

        private static void registerBlockOnly(BlockBase block) {
            Registry.register(Registry.BLOCK, id(block.registryName), block);
        }

        private static void registerBlockEntity(BlockBase block, BlockEntityType<?> blockEntityType) {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, id(block.registryName), blockEntityType);
        }
    }
}
