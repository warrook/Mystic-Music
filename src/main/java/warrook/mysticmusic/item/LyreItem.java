package warrook.mysticmusic.item;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import warrook.mysticmusic.MysticMusic;
import warrook.mysticmusic.network.NetworkPackets;
import warrook.mysticmusic.network.ServerNetwork;
import warrook.mysticmusic.util.Note;
import warrook.mysticmusic.util.Songs;
import warrook.mysticmusic.util.enums.NoteType;

public class LyreItem extends ItemBase {
    private int playnext = 0;

    public LyreItem() {
        super("lyre", new FabricItemSettings().group(MysticMusic.ITEM_GROUP).maxCount(1).rarity(Rarity.UNCOMMON));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        playNote(world, user, hand);
        return TypedActionResult.success(user.getStackInHand(hand));

    }

    private void playNote(World world, PlayerEntity user, Hand hand) {
        Note n = Songs.DAYLIGHT.get(playnext);

        if (world.isClient) {
            playnext = playnext < Songs.DAYLIGHT.getLength() - 1 ? playnext + 1 : 0;
            ClientPlayNetworking.send(NetworkPackets.NOTE_PACKET, NetworkPackets.toNoteBuffer(n.pitch(), n.duration()));

            //also need to send this to clients nearby maybe
            float angle = user.yaw;
            Vec3d vec = Vec3d.fromPolar(0, angle).normalize().multiply(0.5d);
            world.addParticle(ParticleTypes.NOTE, user.getX() + vec.x, user.getY() + 1.2d, user.getZ() + vec.z, n.type.noteblock() / 24d, 0d, 0d);
        }
    }
}
