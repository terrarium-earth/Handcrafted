package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntityTypes {
//    public static final Supplier<EntityType<LargePainting>> LARGE_PAINTING = register("large_painting", () -> EntityType.Builder.of(LargePainting::new, MobCategory.CREATURE).sized(0.75f, 2.5f).build(Handcrafted.MOD_ID));

    private static <T extends EntityType<E>, E extends Entity> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.ENTITY_TYPE, id, object);
    }

    public static void init() {
    }
}
