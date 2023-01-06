package earth.terrarium.handcrafted.common.block.oven;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SmokerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class OvenBlockEntity extends SmokerBlockEntity {
    public OvenBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockPos, blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType() {
        return ModBlockEntityTypes.OVEN.get();
    }
}
