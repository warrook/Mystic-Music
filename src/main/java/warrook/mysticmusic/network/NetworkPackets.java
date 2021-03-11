package warrook.mysticmusic.network;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import warrook.mysticmusic.MysticMusic;

public class NetworkPackets {
    public static final Identifier NOTE_PACKET = MysticMusic.id("note");

    public static PacketByteBuf toNoteBuffer(float pitch, int duration) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat(pitch);
        buf.writeInt(duration);
        return buf;
    }
}
