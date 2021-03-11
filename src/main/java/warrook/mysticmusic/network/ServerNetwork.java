package warrook.mysticmusic.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.enums.Instrument;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Identifier;
import warrook.mysticmusic.MysticMusic;
import warrook.mysticmusic.util.enums.NoteType;

public class ServerNetwork {
    public static void registerAll() {
        ServerPlayNetworking.registerGlobalReceiver(NetworkPackets.NOTE_PACKET, NOTE_HANDLER);
    }

    public static final ServerPlayNetworking.PlayChannelHandler NOTE_HANDLER = ((server, player, handler, buf, responseSender) -> {
        float pitch = buf.readFloat();
        int duration = buf.readInt();

        server.execute(() -> {
            ServerWorld w = player.getServerWorld();
            if (w != null) {
                w.playSound(null, player.getX(), player.getY(), player.getZ(), Instrument.HARP.getSound(), SoundCategory.RECORDS, 3f, pitch);
            }
        });
    });
}
