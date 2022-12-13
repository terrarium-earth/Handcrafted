package earth.terrarium.handcrafted.common.block.chair.couch;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.registry.ModBlockEntities;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CouchBlockEntity extends ItemHoldingBlockEntity {
    public CouchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COUCH.get(), blockPos, blockState);
        this.setStack(ModItems.WHITE_CUSHION.get().getDefaultInstance());
    }
}