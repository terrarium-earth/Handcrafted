package earth.terrarium.handcrafted.common.block.stackablebook;

import earth.terrarium.handcrafted.common.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StackableBookBlockEntity extends BlockEntity {
    public StackableBookBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.STACKABLE_BOOK.get(), blockPos, blockState);
    }
}
