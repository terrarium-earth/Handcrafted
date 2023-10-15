package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class ModSoundEvents {
    public static final ResourcefulRegistry<SoundEvent> SOUND_EVENTS = ResourcefulRegistries.create(BuiltInRegistries.SOUND_EVENT, Handcrafted.MOD_ID);

    public static final RegistryEntry<SoundEvent> HAMMER_WOOD = SOUND_EVENTS.register("hammer_wood", () ->
        SoundEvent.createVariableRangeEvent(new ResourceLocation(Handcrafted.MOD_ID, "hammer_wood")));

    public static final RegistryEntry<SoundEvent> HAMMER_STONE = SOUND_EVENTS.register("hammer_stone", () ->
        SoundEvent.createVariableRangeEvent(new ResourceLocation(Handcrafted.MOD_ID, "hammer_stone")));
}
