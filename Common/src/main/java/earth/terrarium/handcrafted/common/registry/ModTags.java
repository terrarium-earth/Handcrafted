package earth.terrarium.handcrafted.common.registry;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final TagKey<Item> CUSHIONS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "cushions"));
    public static final TagKey<Item> SHEETS = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "sheets"));
    public static final TagKey<Item> SHELFABLE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "shelfable"));
    public static final TagKey<Item> COUNTER_SURFACE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "counter_surface"));

    public static final TagKey<Block> TABLE_ATTACHMENTS = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Handcrafted.MOD_ID, "table_attachments"));
}
