package earth.terrarium.handcrafted.common.blocks.trims;

import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.blocks.base.properties.TrimProperty;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.registry.ModSoundEvents;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FaceAttachedHorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class PillarTrimBlock extends FaceAttachedHorizontalDirectionalBlock implements Hammerable, SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final IntegerProperty TYPE = IntegerProperty.create("type", 1, 2);
    public static final EnumProperty<TrimProperty> SHAPE = EnumProperty.create("trim", TrimProperty.class);

    public static final VoxelShape NORMAL_NORTH_SHAPE;
    public static final VoxelShape NORMAL_EAST_SHAPE;
    public static final VoxelShape NORMAL_SOUTH_SHAPE;
    public static final VoxelShape NORMAL_WEST_SHAPE;
    public static final VoxelShape NORMAL_UP_X_AXIS_SHAPE;
    public static final VoxelShape NORMAL_UP_Z_AXIS_SHAPE;
    public static final VoxelShape NORMAL_DOWN_X_AXIS_SHAPE;
    public static final VoxelShape NORMAL_DOWN_Z_AXIS_SHAPE;
    public static final VoxelShape THICC_NORTH_SHAPE;
    public static final VoxelShape THICC_EAST_SHAPE;
    public static final VoxelShape THICC_SOUTH_SHAPE;
    public static final VoxelShape THICC_WEST_SHAPE;
    public static final VoxelShape THICC_UP_SHAPE;
    public static final VoxelShape THICC_DOWN_SHAPE;
    public static final VoxelShape THIN_NORTH_SHAPE;
    public static final VoxelShape THIN_EAST_SHAPE;
    public static final VoxelShape THIN_SOUTH_SHAPE;
    public static final VoxelShape THIN_WEST_SHAPE;
    public static final VoxelShape THIN_UP_X_AXIS_SHAPE;
    public static final VoxelShape THIN_UP_Z_AXIS_SHAPE;
    public static final VoxelShape THIN_DOWN_X_AXIS_SHAPE;
    public static final VoxelShape THIN_DOWN_Z_AXIS_SHAPE;

    private final boolean wood;

    public PillarTrimBlock(Properties properties, boolean wood) {
        super(properties);
        this.wood = wood;
        this.registerDefaultState(this.defaultBlockState()
            .setValue(TYPE, 1)
            .setValue(SHAPE, TrimProperty.NORMAL)
            .setValue(FACING, Direction.NORTH)
            .setValue(FACE, AttachFace.WALL)
            .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, FACE, TYPE, SHAPE, WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(SHAPE)) {
            case NORMAL -> switch (state.getValue(FACE)) {
                case FLOOR ->
                    state.getValue(FACING).getAxis() == Direction.Axis.X ? NORMAL_DOWN_X_AXIS_SHAPE : NORMAL_DOWN_Z_AXIS_SHAPE;
                case CEILING ->
                    state.getValue(FACING).getAxis() == Direction.Axis.X ? NORMAL_UP_X_AXIS_SHAPE : NORMAL_UP_Z_AXIS_SHAPE;
                default -> switch (state.getValue(FACING)) {
                    case EAST -> NORMAL_EAST_SHAPE;
                    case SOUTH -> NORMAL_SOUTH_SHAPE;
                    case WEST -> NORMAL_WEST_SHAPE;
                    default -> NORMAL_NORTH_SHAPE;
                };
            };
            case THICC -> switch (state.getValue(FACE)) {
                case FLOOR -> THICC_DOWN_SHAPE;
                case CEILING -> THICC_UP_SHAPE;
                default -> switch (state.getValue(FACING)) {
                    case EAST -> THICC_EAST_SHAPE;
                    case SOUTH -> THICC_SOUTH_SHAPE;
                    case WEST -> THICC_WEST_SHAPE;
                    default -> THICC_NORTH_SHAPE;
                };
            };
            case THIN -> switch (state.getValue(FACE)) {
                case FLOOR ->
                    state.getValue(FACING).getAxis() == Direction.Axis.X ? THIN_DOWN_X_AXIS_SHAPE : THIN_DOWN_Z_AXIS_SHAPE;
                case CEILING ->
                    state.getValue(FACING).getAxis() == Direction.Axis.X ? THIN_UP_X_AXIS_SHAPE : THIN_UP_Z_AXIS_SHAPE;
                default -> switch (state.getValue(FACING)) {
                    case EAST -> THIN_EAST_SHAPE;
                    case SOUTH -> THIN_SOUTH_SHAPE;
                    case WEST -> THIN_WEST_SHAPE;
                    default -> THIN_NORTH_SHAPE;
                };
            };
        };
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        if (user.isShiftKeyDown()) level.setBlockAndUpdate(pos, state.cycle(TYPE));
        else level.setBlockAndUpdate(pos, state.cycle(SHAPE));
        level.playSound(null, pos, wood ? ModSoundEvents.HAMMER_WOOD.get() : ModSoundEvents.HAMMER_STONE.get(), SoundSource.BLOCKS, 1, 1);
    }

    public boolean isWood() {
        return wood;
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidState = ctx.getLevel().getFluidState(ctx.getClickedPos());
        BlockState placementState = super.getStateForPlacement(ctx);
        if (placementState == null) return null;
        return placementState.setValue(WATERLOGGED, fluidState.getType().equals(Fluids.WATER));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.HAMMER_USE_SHAPE, ConstantComponents.HAMMER_USE_LOOK_SHIFT);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return true;
    }

    static {
        NORMAL_NORTH_SHAPE = Shapes.join(
            Block.box(4, 0, 8, 12, 16, 12),
            Block.box(0, 0, 12, 16, 16, 16),
            BooleanOp.OR);

        NORMAL_EAST_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 0, 4, 8, 16, 12),
            BooleanOp.OR);

        NORMAL_SOUTH_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(4, 0, 4, 12, 16, 8),
            BooleanOp.OR);

        NORMAL_WEST_SHAPE = Shapes.join(
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(8, 0, 4, 12, 16, 12),
            BooleanOp.OR);

        NORMAL_UP_X_AXIS_SHAPE = Shapes.join(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 8, 4, 16, 12, 12),
            BooleanOp.OR);

        NORMAL_UP_Z_AXIS_SHAPE = Shapes.join(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(4, 8, 0, 12, 12, 16),
            BooleanOp.OR);

        NORMAL_DOWN_X_AXIS_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 4, 16, 8, 12),
            BooleanOp.OR);

        NORMAL_DOWN_Z_AXIS_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(4, 4, 0, 12, 8, 16),
            BooleanOp.OR);

        THICC_NORTH_SHAPE = Block.box(0, 0, 8, 16, 16, 16);
        THICC_EAST_SHAPE = Block.box(0, 0, 0, 8, 16, 16);
        THICC_SOUTH_SHAPE = Block.box(0, 0, 0, 16, 16, 8);
        THICC_WEST_SHAPE = Block.box(8, 0, 0, 16, 16, 16);

        THICC_UP_SHAPE = Block.box(0, 8, 0, 16, 16, 16);
        THICC_DOWN_SHAPE = Block.box(0, 0, 0, 16, 8, 16);

        THIN_NORTH_SHAPE = Shapes.join(
            Block.box(6, 0, 10, 10, 16, 12),
            Block.box(0, 0, 12, 16, 16, 16),
            BooleanOp.OR);

        THIN_EAST_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 0, 6, 6, 16, 10),
            BooleanOp.OR);

        THIN_SOUTH_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(6, 0, 4, 10, 16, 6),
            BooleanOp.OR);

        THIN_WEST_SHAPE = Shapes.join(
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(10, 0, 6, 12, 16, 10),
            BooleanOp.OR);

        THIN_UP_X_AXIS_SHAPE = Shapes.join(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(0, 10, 6, 16, 12, 10),
            BooleanOp.OR);

        THIN_UP_Z_AXIS_SHAPE = Shapes.join(
            Block.box(0, 12, 0, 16, 16, 16),
            Block.box(6, 10, 0, 10, 12, 16),
            BooleanOp.OR);

        THIN_DOWN_X_AXIS_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(0, 4, 6, 16, 6, 10),
            BooleanOp.OR);

        THIN_DOWN_Z_AXIS_SHAPE = Shapes.join(
            Block.box(0, 0, 0, 16, 4, 16),
            Block.box(6, 4, 0, 10, 6, 16),
            BooleanOp.OR);
    }
}
