package earth.terrarium.handcrafted.common.block.chair.chair;

import dev.architectury.injectables.annotations.PlatformOnly;
import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class ChairBlockEntity extends ItemHoldingBlockEntity {
    public ChairBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.CHAIR.get(), blockPos, blockState);
    }

    @PlatformOnly("forge")
    public AABB getRenderBoundingBox() {
        return new AABB(this.getBlockPos()).inflate(2);
    }
}