package earth.terrarium.handcrafted;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class CommonUtils {
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> factory) {
        final var registryObject = new RegistryObject<T>(factory);
        Handcrafted.BLOCK_FACTORIES.put(name, registryObject);
        return registryObject;
    }

    @Environment(EnvType.CLIENT)
    public static void setBlockLayer(Supplier<? extends Block> block, RenderType renderType) {
        BlockRenderLayerMap.INSTANCE.putBlock(block.get(), renderType);
    }

    public static class RegistryObject<T> implements Supplier<T> {
        private final Supplier<T> factory;
        private T value;

        public RegistryObject(Supplier<T> factory) {
            this.factory = factory;
        }

        @Override
        public T get() {
            if (value == null) throw new NullPointerException("Accessed registry object before registry time.");
            return value;
        }

        public T initialize() {
            return value = factory.get();
        }
    }
}
