package earth.terrarium.handcrafted.common.block.kitchenhood;

import earth.terrarium.handcrafted.common.block.SimpleBlock;
import earth.terrarium.handcrafted.common.item.Hammerable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;

public class KitchenHoodPipe extends SimpleBlock implements Hammerable {
    public static final BooleanProperty CORNER = BooleanProperty.create("corner");

    public KitchenHoodPipe(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CORNER, false).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CORNER, WATERLOGGED);
    }

    @Override
    public void onHammer(Level level, BlockPos pos, BlockState state, Direction side, Player user, Vec3 hitPos) {
        level.setBlock(pos, state.setValue(CORNER, !state.getValue(CORNER)).setValue(FACING, side.getAxis().isHorizontal() ? side : state.getValue(FACING)), Block.UPDATE_ALL);
    }
}
