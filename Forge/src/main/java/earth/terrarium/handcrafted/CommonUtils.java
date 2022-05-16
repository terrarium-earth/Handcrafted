package earth.terrarium.handcrafted;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public class CommonUtils {
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> factory) {
        var registryObject = Handcrafted.BLOCK_REGISTRAR.register(name, factory);
        Handcrafted.ITEM_REGISTRAR.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(Handcrafted.TAB)));
        return registryObject;
    }

    @OnlyIn(Dist.CLIENT)
    public static void setBlockLayer(Supplier<? extends Block> block, RenderType renderType) {
        ItemBlockRenderTypes.setRenderLayer(block.get(), renderType);
    }
}
