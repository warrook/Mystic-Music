package warrook.mysticmusic;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import warrook.mysticmusic.network.ClientNetwork;
import warrook.mysticmusic.network.ServerNetwork;

public class MysticMusic implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "mysticmusic";
    public static final String MOD_NAME = "Mystic Music";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(id("common"), () -> new ItemStack(Blocks.OAK_DOOR));

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        Manifest.registerAll();

        ServerNetwork.registerAll();
        ClientNetwork.registerAll();
    }

    public static Identifier id(String objectName) {
        return new Identifier(MOD_ID, objectName);
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
}
