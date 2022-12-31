package earth.terrarium.handcrafted.common.block.table.nightstand;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class NightstandBlockEntity extends ItemHoldingBlockEntity {
    public NightstandBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.NIGHTSTAND.get(), blockPos, blockState);
    }
}
