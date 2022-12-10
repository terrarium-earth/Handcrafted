package earth.terrarium.handcrafted.common.block.counter;

import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.Vec3;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class CupboardBlock extends Block implements Hammerable {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public CupboardBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH));
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        Block block = state.getBlock();
        ResourceLocation id = Registry.BLOCK.getKey(block);
        Block replacement = Registry.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", String.valueOf(Integer.parseInt(id.getPath().replaceAll("\\D+", "")) + 1))));
        if (replacement == Blocks.AIR) {
            level.setBlock(pos, Registry.BLOCK.get(new ResourceLocation(id.getNamespace(), id.getPath().replaceAll("\\d+", "1"))).defaultBlockState().setValue(FACING, state.getValue(FACING)), Block.UPDATE_ALL);
        } else {
            level.setBlock(pos, replacement.defaultBlockState().setValue(FACING, state.getValue(FACING)), Block.UPDATE_ALL);
        }
    }
}