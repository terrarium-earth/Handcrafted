package earth.terrarium.handcrafted.common.block.trim;

import earth.terrarium.handcrafted.common.block.SimpleBlock;
import earth.terrarium.handcrafted.common.block.property.TrimState;
import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.IntStream;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class CornerTrimBlock extends SimpleBlock implements Hammerable {
    public static final EnumProperty<TrimState> SHAPE = EnumProperty.create("trim", TrimState.class);
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final VoxelShape TOP_AABB = Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);
    public static final VoxelShape BOTTOM_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
    public static final VoxelShape OCTET_NNN = Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 8.0);
    public static final VoxelShape OCTET_NNP = Block.box(0.0, 0.0, 8.0, 8.0, 8.0, 16.0);
    public static final VoxelShape OCTET_NPN = Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 8.0);
    public static final VoxelShape OCTET_NPP = Block.box(0.0, 8.0, 8.0, 8.0, 16.0, 16.0);
    public static final VoxelShape OCTET_PNN = Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 8.0);
    public static final VoxelShape OCTET_PNP = Block.box(8.0, 0.0, 8.0, 16.0, 8.0, 16.0);
    public static final VoxelShape OCTET_PPN = Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 8.0);
    public static final VoxelShape OCTET_PPP = Block.box(8.0, 8.0, 8.0, 16.0, 16.0, 16.0);
    public static final VoxelShape[] TOP_SHAPES = makeShapes(TOP_AABB, OCTET_NNN, OCTET_PNN, OCTET_NNP, OCTET_PNP);
    public static final VoxelShape[] BOTTOM_SHAPES = makeShapes(BOTTOM_AABB, OCTET_NPN, OCTET_PPN, OCTET_NPP, OCTET_PPP);
    public static final int[] SHAPE_BY_STATE = new int[]{12, 5, 3, 10, 14, 13, 7, 11, 13, 7, 11, 14, 8, 4, 1, 2, 4, 1, 2, 8};

    public CornerTrimBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHAPE, TrimState.NORMAL).setValue(HALF, Half.BOTTOM).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
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
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(blockPos);
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(HALF, direction != Direction.DOWN && (direction == Direction.UP || !(context.getClickLocation().y - (double) blockPos.getY() > 0.5)) ? Half.BOTTOM : Half.TOP).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, HALF, WATERLOGGED);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (state.getValue(HALF) == Half.TOP ? TOP_SHAPES : BOTTOM_SHAPES)[SHAPE_BY_STATE[this.getShapeIndex(state)]];
    }

    private int getShapeIndex(BlockState state) {
        return state.getValue(FACING).get2DDataValue();
    }

    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        return IntStream.range(0, 16).mapToObj((i) -> makeStairShape(i, slabShape, nwCorner, neCorner, swCorner, seCorner)).toArray(VoxelShape[]::new);
    }

    private static VoxelShape makeStairShape(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        VoxelShape voxelShape = slabShape;
        if ((bitfield & 1) != 0) {
            voxelShape = Shapes.or(slabShape, nwCorner);
        }

        if ((bitfield & 2) != 0) {
            voxelShape = Shapes.or(voxelShape, neCorner);
        }

        if ((bitfield & 4) != 0) {
            voxelShape = Shapes.or(voxelShape, swCorner);
        }

        if ((bitfield & 8) != 0) {
            voxelShape = Shapes.or(voxelShape, seCorner);
        }

        return voxelShape;
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        switch (state.getValue(SHAPE)) {
            case NORMAL -> level.setBlockAndUpdate(pos, state.setValue(SHAPE, TrimState.THICC));
            case THICC -> level.setBlockAndUpdate(pos, state.setValue(SHAPE, TrimState.THIN));
            case THIN -> level.setBlockAndUpdate(pos, state.setValue(SHAPE, TrimState.NORMAL));
        }
    }
}
