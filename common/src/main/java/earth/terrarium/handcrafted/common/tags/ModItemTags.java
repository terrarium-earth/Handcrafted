package earth.terrarium.handcrafted.common.tags;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModItemTags {
    public static final TagKey<Item> CUSHIONS = tag("cushions");
    public static final TagKey<Item> SHEETS = tag("sheets");
    public static final TagKey<Item> COUNTER_MATERIALS = tag("counter_materials");
    public static final TagKey<Item> TRIM_MATERIALS = tag("trim_materials");

    private static TagKey<Item> tag(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(Handcrafted.MOD_ID, name));
    }
}
