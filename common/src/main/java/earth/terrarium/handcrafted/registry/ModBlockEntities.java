package earth.terrarium.handcrafted.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ModBlockEntities {

    private static <T extends BlockEntityType<B>, B extends BlockEntity> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.BLOCK_ENTITY_TYPE, id, object);
    }

    public static void init() {
    }
}
