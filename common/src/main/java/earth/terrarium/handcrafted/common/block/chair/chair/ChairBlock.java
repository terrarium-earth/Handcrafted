package earth.terrarium.handcrafted.common.block.chair.chair;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.chair.couch.ExpandableCouchBlock;
import earth.terrarium.handcrafted.common.registry.ModTags;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
public class ChairBlock extends ExpandableCouchBlock {
    public static final VoxelShape NORTH_SHAPE = Shapes.or(Block.box(1, 0, 0, 15, 9, 15), Block.box(1, 9, 0, 15, 24, 3));
    public static final VoxelShape EAST_SHAPE = Shapes.or(Block.box(1, 0, 1, 16, 9, 15), Block.box(13, 9, 1, 16, 24, 15));
    public static final VoxelShape SOUTH_SHAPE = Shapes.or(Block.box(1, 0, 1, 15, 9, 16), Block.box(1, 9, 13, 15, 24, 16));
    public static final VoxelShape WEST_SHAPE = Shapes.or(Block.box(0, 0, 1, 15, 9, 15), Block.box(0, 9, 1, 3, 24, 15));

    public ChairBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ChairBlockEntity(pos, state);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof ItemHoldingBlockEntity entity) {
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, entity.getStack());
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                level.addFreshEntity(itemEntity);
                level.updateNeighbourForOutputSignal(pos, this);
                entity.clear();
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult interactionResult = ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> f.is(ModTags.CUSHIONS), SoundEvents.WOOL_PLACE);
        if (!interactionResult.consumesAction()) {
            return super.use(state, level, pos, player, hand, hit);
        }
        return interactionResult;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return new AABB(0, 0, 0, 1, 0.5, 1);
    }
}
