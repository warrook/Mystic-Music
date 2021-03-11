package warrook.mysticmusic.item;

import net.minecraft.item.Item;

public class ItemBase extends Item {
    public final String registryName;

    public ItemBase(String name, Settings settings) {
        super(settings);
        registryName = name;
    }
}
