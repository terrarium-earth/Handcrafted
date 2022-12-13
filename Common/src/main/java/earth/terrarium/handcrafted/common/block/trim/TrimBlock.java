package earth.terrarium.handcrafted.common.block.trim;

import earth.terrarium.handcrafted.common.block.SimpleBlock;
import earth.terrarium.handcrafted.common.block.property.TrimState;
import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class TrimBlock extends SimpleBlock implements Hammerable {
    public static final EnumProperty<TrimState> SHAPE = EnumProperty.create("trim", TrimState.class);
    public static final VoxelShape NORTH_SHAPE = Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    public static final VoxelShape EAST_SHAPE = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);
    public static final VoxelShape SOUTH_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    public static final VoxelShape WEST_SHAPE = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);


    public TrimBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHAPE, TrimState.NORMAL).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = switch (state.getValue(FACING)) {
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> NORTH_SHAPE;
        };
        return shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SHAPE, WATERLOGGED);
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
