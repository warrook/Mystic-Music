package warrook.mysticmusic.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import warrook.mysticmusic.network.ClientNetwork;

@Environment(EnvType.CLIENT)
public class MysticMusicClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientNetwork.registerAll();
    }
}
