package earth.terrarium.handcrafted.block.stackablebook;

import earth.terrarium.handcrafted.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StackableBookBlockEntity extends BlockEntity {
    public StackableBookBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.STACKABLE_BOOK.get(), blockPos, blockState);
    }
}
