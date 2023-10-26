package earth.terrarium.handcrafted.common.tags;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class ModBlockTags {
    public static final TagKey<Block> TABLE_CONNECTABLE = tag("table_connectable");

    private static TagKey<Block> tag(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(Handcrafted.MOD_ID, name));
    }
}
