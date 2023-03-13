package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.entity.FancyPainting;
import earth.terrarium.handcrafted.common.entity.SittingEntity;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(Registry.ENTITY_TYPE, Handcrafted.MOD_ID);

    public static final RegistryEntry<EntityType<FancyPainting>> FANCY_PAINTING = ENTITY_TYPES.register("fancy_painting", () -> EntityType.Builder.<FancyPainting>of(FancyPainting::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(Handcrafted.MOD_ID));
    public static final RegistryEntry<EntityType<SittingEntity>> SEAT = ENTITY_TYPES.register("seat", () -> EntityType.Builder.<SittingEntity>of(SittingEntity::new, MobCategory.MISC).sized(1.0f, 1.0f).noSave().fireImmune().noSummon().build(Handcrafted.MOD_ID));
}
