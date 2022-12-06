package earth.terrarium.handcrafted.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class CushionBlockItem extends BlockItem {
    public CushionBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public ResourceLocation getTexture(boolean isDouble, ResourceLocation texture) {
        ResourceLocation item = Registry.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bed/" + (isDouble ? "double" : "single") + "/cushion/" + item.getPath() + ".png");
    }

    public ResourceLocation getBenchTexture(ResourceLocation texture) {
        ResourceLocation item = Registry.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bench/cushion/" + item.getPath() + ".png");
    }
}