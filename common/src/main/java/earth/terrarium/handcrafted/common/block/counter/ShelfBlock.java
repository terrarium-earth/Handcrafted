package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.block.ItemHoldingBlockEntity;
import earth.terrarium.handcrafted.common.block.property.DirectionalBlockSide;
import earth.terrarium.handcrafted.common.registry.ModTags;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class ShelfBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<DirectionalBlockSide> SHELF_SHAPE = EnumProperty.create("shape", DirectionalBlockSide.class);

    public ShelfBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHELF_SHAPE, DirectionalBlockSide.SINGLE).setValue(FACING, Direction.NORTH));
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SHELF_SHAPE, FACING);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        return direction.getAxis().isHorizontal() ? state.setValue(SHELF_SHAPE, DirectionalBlockSide.getShape(this, FACING, state, level, currentPos)) : super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return ItemHoldingBlockEntity.placeItem(level, pos, player, ItemStack.EMPTY, f -> f.is(ModTags.SHELFABLE), SoundEvents.ITEM_FRAME_ADD_ITEM);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());
        return blockState.setValue(SHELF_SHAPE, DirectionalBlockSide.getShape(this, FACING, blockState, context.getLevel(), blockPos));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}