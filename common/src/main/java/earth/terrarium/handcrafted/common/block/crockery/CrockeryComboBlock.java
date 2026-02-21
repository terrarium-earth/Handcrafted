package earth.terrarium.handcrafted.common.block.crockery;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class CrockeryComboBlock extends SimpleEntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 3, 16);

    public CrockeryComboBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrockeryBlockEntity(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> true, SoundEvents.ITEM_FRAME_ADD_ITEM);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        this.handleHoldingItemRemoval(state, level, pos, newState);
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private void handleHoldingItemRemoval(BlockState state, Level level, BlockPos pos, BlockState newState) {
        if (state.is(newState.getBlock())) {
            return;
        }

        if (!(level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity)) {
            return;
        }

        if (entity.getStack().isEmpty()) {
            entity.clear();
            return;
        }

        ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
        itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
        level.addFreshEntity(itemEntity);
        level.updateNeighbourForOutputSignal(pos, this);
        entity.clear();
    }
}
