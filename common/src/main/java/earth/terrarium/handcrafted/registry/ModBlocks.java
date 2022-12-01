package earth.terrarium.handcrafted.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModBlocks {

    private static <T extends Block> Supplier<T> register(String id, Supplier<T> block) {
        return ModRegistryHelpers.register(Registry.BLOCK, id, block);
    }

    public static void init() {
    }
}
