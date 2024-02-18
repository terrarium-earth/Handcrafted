package earth.terrarium.handcrafted.common.blocks.trims;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
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
import java.util.stream.Stream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class CornerTrimBlock extends SimpleBlock implements Hammerable {
    public static final MapCodec<CornerTrimBlock> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            Codec.BOOL.fieldOf("wood").forGetter(CornerTrimBlock::isWood),
            propertiesCodec()
        ).apply(instance, CornerTrimBlock::new)
    );

    public static final EnumProperty<TrimProperty> SHAPE = EnumProperty.create("trim", TrimProperty.class);
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;

    public static final VoxelShape NORMAL_TOP_NORTH;
    public static final VoxelShape NORMAL_TOP_EAST;
    public static final VoxelShape NORMAL_TOP_SOUTH;
    public static final VoxelShape NORMAL_TOP_WEST;
    public static final VoxelShape NORMAL_BOTTOM_NORTH;
    public static final VoxelShape NORMAL_BOTTOM_EAST;
    public static final VoxelShape NORMAL_BOTTOM_SOUTH;
    public static final VoxelShape NORMAL_BOTTOM_WEST;
    public static final VoxelShape THICC_TOP_NORTH;
    public static final VoxelShape THICC_TOP_EAST;
    public static final VoxelShape THICC_TOP_SOUTH;
    public static final VoxelShape THICC_TOP_WEST;
    public static final VoxelShape THICC_BOTTOM_NORTH;
    public static final VoxelShape THICC_BOTTOM_EAST;
    public static final VoxelShape THICC_BOTTOM_SOUTH;
    public static final VoxelShape THICC_BOTTOM_WEST;
    public static final VoxelShape THIN_TOP_NORTH;
    public static final VoxelShape THIN_TOP_EAST;
    public static final VoxelShape THIN_TOP_SOUTH;
    public static final VoxelShape THIN_TOP_WEST;
    public static final VoxelShape THIN_BOTTOM_NORTH;
    public static final VoxelShape THIN_BOTTOM_EAST;
    public static final VoxelShape THIN_BOTTOM_SOUTH;
    public static final VoxelShape THIN_BOTTOM_WEST;

    private final boolean wood;

    public CornerTrimBlock(boolean wood, Properties properties) {
        super(properties);
        this.wood = wood;
        this.registerDefaultState(this.defaultBlockState()
            .setValue(SHAPE, TrimProperty.NORMAL)
            .setValue(HALF, Half.BOTTOM)
            .setValue(FACING, Direction.NORTH)
            .setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, HALF, WATERLOGGED);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos currentPos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, direction, neighborState, level, currentPos, neighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double) pos.getY() > 0.5)) ? Half.BOTTOM : Half.TOP).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        level.setBlockAndUpdate(pos, state.cycle(SHAPE));
        level.playSound(null, pos, wood ? ModSoundEvents.HAMMER_WOOD.get() : ModSoundEvents.HAMMER_STONE.get(), SoundSource.BLOCKS, 1, 1);
    }

    public boolean isWood() {
        return wood;
    }

    public VoxelShape getShape(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return switch (state.getValue(HALF)) {
            case TOP -> switch (state.getValue(SHAPE)) {
                case NORMAL -> switch (state.getValue(FACING)) {
                    case EAST -> NORMAL_TOP_EAST;
                    case SOUTH -> NORMAL_TOP_SOUTH;
                    case WEST -> NORMAL_TOP_WEST;
                    default -> NORMAL_TOP_NORTH;
                };
                case THIN -> switch (state.getValue(FACING)) {
                    case EAST -> THIN_TOP_EAST;
                    case SOUTH -> THIN_TOP_SOUTH;
                    case WEST -> THIN_TOP_WEST;
                    default -> THIN_TOP_NORTH;
                };
                case THICC -> switch (state.getValue(FACING)) {
                    case EAST -> THICC_TOP_EAST;
                    case SOUTH -> THICC_TOP_SOUTH;
                    case WEST -> THICC_TOP_WEST;
                    default -> THICC_TOP_NORTH;
                };
            };
            case BOTTOM -> switch (state.getValue(SHAPE)) {
                case NORMAL -> switch (state.getValue(FACING)) {
                    case EAST -> NORMAL_BOTTOM_EAST;
                    case SOUTH -> NORMAL_BOTTOM_SOUTH;
                    case WEST -> NORMAL_BOTTOM_WEST;
                    default -> NORMAL_BOTTOM_NORTH;
                };
                case THIN -> switch (state.getValue(FACING)) {
                    case EAST -> THIN_BOTTOM_EAST;
                    case SOUTH -> THIN_BOTTOM_SOUTH;
                    case WEST -> THIN_BOTTOM_WEST;
                    default -> THIN_BOTTOM_NORTH;
                };
                case THICC -> switch (state.getValue(FACING)) {
                    case EAST -> THICC_BOTTOM_EAST;
                    case SOUTH -> THICC_BOTTOM_SOUTH;
                    case WEST -> THICC_BOTTOM_WEST;
                    default -> THICC_BOTTOM_NORTH;
                };
            };
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.HAMMER_USE_SHAPE);
    }

    static {
        NORMAL_TOP_NORTH = Stream.of(
            Block.box(4, 0, 4, 12, 6, 8),
            Block.box(4, 8, 10, 12, 12, 16),
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 12, 4, 16, 16, 16),
            Block.box(2, 6, 4, 14, 12, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_TOP_EAST = Stream.of(
            Block.box(8, 0, 4, 12, 6, 12),
            Block.box(0, 8, 4, 6, 12, 12),
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 12, 0, 12, 16, 16),
            Block.box(6, 6, 2, 12, 12, 14)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_TOP_SOUTH = Stream.of(
            Block.box(4, 0, 8, 12, 6, 12),
            Block.box(4, 8, 0, 12, 12, 6),
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 12, 0, 16, 16, 12),
            Block.box(2, 6, 6, 14, 12, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_TOP_WEST = Stream.of(
            Block.box(4, 0, 4, 8, 6, 12),
            Block.box(10, 8, 4, 16, 12, 12),
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 12, 0, 16, 16, 16),
            Block.box(4, 6, 2, 10, 12, 14)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_BOTTOM_NORTH = Stream.of(
            Block.box(4, 10, 4, 12, 16, 8),
            Block.box(4, 4, 10, 12, 8, 16),
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 0, 4, 16, 4, 16),
            Block.box(2, 4, 4, 14, 10, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_BOTTOM_EAST = Stream.of(
            Block.box(8, 10, 4, 12, 16, 12),
            Block.box(0, 4, 4, 6, 8, 12),
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 0, 0, 12, 4, 16),
            Block.box(6, 4, 2, 12, 10, 14)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_BOTTOM_SOUTH = Stream.of(
            Block.box(4, 10, 8, 12, 16, 12),
            Block.box(4, 4, 0, 12, 8, 6),
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 0, 0, 16, 4, 12),
            Block.box(2, 4, 6, 14, 10, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        NORMAL_BOTTOM_WEST = Stream.of(
            Block.box(4, 10, 4, 8, 16, 12),
            Block.box(10, 4, 4, 16, 8, 12),
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 0, 0, 16, 4, 16),
            Block.box(4, 4, 2, 10, 10, 14)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_TOP_NORTH = Stream.of(
            Block.box(0, 0, 4, 16, 6, 8),
            Block.box(0, 8, 10, 16, 12, 16),
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 12, 4, 16, 16, 16),
            Block.box(0, 6, 4, 16, 12, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_TOP_EAST = Stream.of(
            Block.box(8, 0, 0, 12, 6, 16),
            Block.box(0, 8, 0, 6, 12, 16),
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 12, 0, 12, 16, 16),
            Block.box(6, 6, 0, 12, 12, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_TOP_SOUTH = Stream.of(
            Block.box(0, 0, 8, 16, 6, 12),
            Block.box(0, 8, 0, 16, 12, 6),
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 12, 0, 16, 16, 12),
            Block.box(0, 6, 6, 16, 12, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_TOP_WEST = Stream.of(
            Block.box(4, 0, 0, 8, 6, 16),
            Block.box(10, 8, 0, 16, 12, 16),
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 12, 0, 16, 16, 16),
            Block.box(4, 6, 0, 10, 12, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_BOTTOM_NORTH = Stream.of(
            Block.box(0, 10, 4, 16, 16, 8),
            Block.box(0, 4, 10, 16, 8, 16),
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 0, 4, 16, 4, 16),
            Block.box(0, 4, 4, 16, 10, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_BOTTOM_EAST = Stream.of(
            Block.box(8, 10, 0, 12, 16, 16),
            Block.box(0, 4, 0, 6, 8, 16),
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 0, 0, 12, 4, 16),
            Block.box(6, 4, 0, 12, 10, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_BOTTOM_SOUTH = Stream.of(
            Block.box(0, 10, 8, 16, 16, 12),
            Block.box(0, 4, 0, 16, 8, 6),
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 0, 0, 16, 4, 12),
            Block.box(0, 4, 6, 16, 10, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THICC_BOTTOM_WEST = Stream.of(
            Block.box(4, 10, 0, 8, 16, 16),
            Block.box(10, 4, 0, 16, 8, 16),
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 0, 0, 16, 4, 16),
            Block.box(4, 4, 0, 10., 10, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_TOP_NORTH = Stream.of(
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 12, 4, 16, 16, 16),
            Block.box(6, 0, 4, 10, 12, 6),
            Block.box(6, 10, 6, 10, 12, 16),
            Block.box(4, 6, 4, 12, 12, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_TOP_EAST = Stream.of(
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 12, 0, 12, 16, 16),
            Block.box(10, 0, 6, 12, 12, 10),
            Block.box(0, 10, 6, 10, 12, 10),
            Block.box(6, 6, 4, 12, 12, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_TOP_SOUTH = Stream.of(
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 12, 0, 16, 16, 12),
            Block.box(6, 0, 10, 10, 12, 12),
            Block.box(6, 10, 0, 10, 12, 10),
            Block.box(4, 6, 6, 12, 12, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_TOP_WEST = Stream.of(
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 12, 0, 16, 16, 16),
            Block.box(4, 0, 6, 6, 12, 10),
            Block.box(6, 10, 6, 16, 12, 10),
            Block.box(4, 6, 4, 10, 12, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_BOTTOM_NORTH = Stream.of(
            Block.box(0, 0, 0, 16, 16, 4),
            Block.box(0, 0, 4, 16, 4, 16),
            Block.box(6, 4, 4, 10, 16, 6),
            Block.box(6, 4, 6, 10, 6, 16),
            Block.box(4, 4, 4, 12, 10, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_BOTTOM_EAST = Stream.of(
            Block.box(12, 0, 0, 16, 16, 16),
            Block.box(0, 0, 0, 12, 4, 16),
            Block.box(10, 4, 6, 12, 16, 10),
            Block.box(0, 4, 6, 10, 6, 10),
            Block.box(6, 4, 4, 12, 10, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_BOTTOM_SOUTH = Stream.of(
            Block.box(0, 0, 12, 16, 16, 16),
            Block.box(0, 0, 0, 16, 4, 12),
            Block.box(6, 4, 10, 10, 16, 12),
            Block.box(6, 4, 0, 10, 6, 10),
            Block.box(4, 4, 6, 12, 10, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        THIN_BOTTOM_WEST = Stream.of(
            Block.box(0, 0, 0, 4, 16, 16),
            Block.box(4, 0, 0, 16, 4, 16),
            Block.box(4, 4, 6, 6, 16, 10),
            Block.box(6, 4, 6, 16, 6, 10),
            Block.box(4, 4, 4, 10, 10, 12)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
