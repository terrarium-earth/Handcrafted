package earth.terrarium.handcrafted.registry;

import com.mojang.datafixers.util.Pair;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ModRegistryHelpers {

    @ExpectPlatform
    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityFactory<E> factory, Block... blocks) {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static <V, T extends V> Pair<Supplier<T>, ResourceLocation> registerFull(Registry<V> registry, String id, Supplier<T> object) {
        throw new NotImplementedException();
    }

    public static <V, T extends V> Supplier<T> register(Registry<V> registry, String id, Supplier<T> object) {
        return registerFull(registry, id, object).getFirst();
    }

    @FunctionalInterface
    public interface BlockEntityFactory<T extends BlockEntity> {
        @NotNull T create(BlockPos blockPos, BlockState blockState);
    }
}
