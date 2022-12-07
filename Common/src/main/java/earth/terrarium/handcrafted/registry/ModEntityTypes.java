package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.entity.fancypainting.FancyPainting;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntityTypes {
    public static final Supplier<EntityType<FancyPainting>> FANCY_PAINTING = register("fancy_painting", () -> EntityType.Builder.of(FancyPainting::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(Handcrafted.MOD_ID));

    private static <T extends EntityType<E>, E extends Entity> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.ENTITY_TYPE, id, object);
    }

    public static void init() {
    }
}
