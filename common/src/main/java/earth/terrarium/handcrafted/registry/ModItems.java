package earth.terrarium.handcrafted.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModItems {

    private static <T extends Item> Supplier<T> register(String id, Supplier<T> item) {
        return ModRegistryHelpers.register(Registry.ITEM, id, item);
    }

    public static void init() {
    }
}
