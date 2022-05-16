package earth.terrarium.handcrafted;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.EnumMap;
import java.util.Map;

// TODO this and TallLampBlock are pretty similar, they probably should share a base class.
public class ChairBlock extends HorizontalDirectionalBlock {
    private static final BooleanProperty TOP = BooleanProperty.create("top");

    private static final Map<Direction, VoxelShape> UPPER_SHAPES = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH, Block.box(0.0D, 0.0D, 12.0D, 16.0D, 16.0D, 16.0D));
        map.put(Direction.EAST, Block.box(0.0D, 0.0D, 0.0D, 4.0D, 16.0D, 16.0D));
        map.put(Direction.WEST, Block.box(12.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D));
        map.put(Direction.SOUTH, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 4.0D));
    });

    private static final Map<Direction, VoxelShape> LOWER_SHAPES = Util.make(new EnumMap<>(Direction.class), map -> {
        map.put(Direction.NORTH, Shapes.or(
                Block.box(0.0D, 10.0D, 12.0D, 16.0D, 16.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
        ));

        map.put(Direction.EAST, Shapes.or(
                Block.box(0.0D, 10.0D, 0.0D, 4.0D, 16.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
        ));

        map.put(Direction.WEST, Shapes.or(
                Block.box(12.0D, 10.0D, 0.0D, 16.0D, 16.0D, 16.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
        ));

        map.put(Direction.SOUTH, Shapes.or(
                Block.box(0.0D, 10.0D, 0.0D, 16.0D, 16.0D, 4.0D),
                Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D)
        ));
    });

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public ChairBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(TOP, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        final var entities = level.getEntitiesOfClass(ChairSeatEntity.class, new AABB(pos));
        ChairSeatEntity seat;
        if (entities.isEmpty()) {
            seat = Handcrafted.SEAT_ENTITY.get().create(level);
            level.addFreshEntity(seat);
        } else {
            seat = entities.get(0);
        }
        if (seat != null && !blockState.getValue(TOP) && !level.isClientSide() && player.getItemInHand(interactionHand).isEmpty()) {
            seat.setPos(pos.getX() + .5, pos.getY() + .325, pos.getZ() + .5);
            player.startRiding(seat);
            return InteractionResult.SUCCESS;
        }
        return super.use(blockState, level, pos, player, interactionHand, blockHitResult);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction direction = blockState.getValue(FACING);
        return blockState.getValue(TOP) ? UPPER_SHAPES.get(direction) : LOWER_SHAPES.get(direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(TOP, FACING));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Direction direction = blockPlaceContext.getHorizontalDirection().getOpposite();
        if (blockPlaceContext.getLevel().getBlockState(blockPlaceContext.getClickedPos().above()).canBeReplaced(blockPlaceContext))
            return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, direction);
        return null;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        super.setPlacedBy(level, blockPos, blockState, livingEntity, itemStack);
        level.setBlock(blockPos.above(), blockState.setValue(TOP, true), 3);
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        Direction disallowed = blockState.getValue(TOP) ? Direction.DOWN : Direction.UP;
        if (direction == disallowed && !blockState2.is(this)) return Blocks.AIR.defaultBlockState();

        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide && player.isCreative() && blockState.getValue(TOP)) {
            BlockPos below = blockPos.below();
            BlockState belowState = level.getBlockState(below);
            if (belowState.is(this) && !belowState.getValue(TOP)) {
                level.setBlock(below, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, below, Block.getId(belowState));
            }
        }
        super.playerWillDestroy(level, blockPos, blockState, player);
    }
}
