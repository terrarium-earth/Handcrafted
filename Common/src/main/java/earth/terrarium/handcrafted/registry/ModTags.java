package earth.terrarium.handcrafted.registry;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> CUSHIONS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "cushions"));
}
