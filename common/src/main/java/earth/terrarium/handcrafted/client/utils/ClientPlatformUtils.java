package earth.terrarium.handcrafted.client.utils;

import com.teamresourceful.resourcefullib.common.exceptions.NotImplementedException;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class ClientPlatformUtils {

    @ExpectPlatform
    public static <T extends Entity> void registerRenderer(Supplier<EntityType<T>> entity, EntityRendererProvider<T> provider) {
        throw new NotImplementedException();
    }

    @FunctionalInterface
    public interface BlockRendererRegistry {
        <T extends BlockEntity> void register(RegistryEntry<? extends BlockEntityType<? extends T>> type, BlockEntityRendererProvider<T> factory);
    }

    @FunctionalInterface
    public interface LayerDefinitionRegistry {
        void register(ModelLayerLocation location, Supplier<LayerDefinition> definition);
    }
}
