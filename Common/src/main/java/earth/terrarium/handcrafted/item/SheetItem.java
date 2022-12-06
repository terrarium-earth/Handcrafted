package earth.terrarium.handcrafted.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class SheetItem extends Item {
    public SheetItem(Properties properties) {
        super(properties);
    }

    public ResourceLocation getTexture(boolean isDouble, ResourceLocation texture) {
        ResourceLocation item = Registry.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bed/" + (isDouble ? "double" : "single") + "/sheet/" + item.getPath() + ".png");
    }
}