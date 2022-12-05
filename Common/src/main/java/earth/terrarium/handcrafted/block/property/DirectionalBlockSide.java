package earth.terrarium.handcrafted.block.property;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.NotNull;

public enum DirectionalBlockSide implements StringRepresentable {
    SINGLE("single"),
    LEFT("left"),
    MIDDLE("middle"),
    RIGHT("right");

    private final String name;

    DirectionalBlockSide(String string2) {
        this.name = string2;
    }

    public String toString() {
        return this.name;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }

    public static DirectionalBlockSide getShape(Block block, DirectionProperty facing, BlockState state, BlockGetter level, BlockPos pos) {
        Direction direction = state.getValue(facing);
        BlockState blockState3 = level.getBlockState(pos.relative(direction.getClockWise()));
        BlockState blockState4 = level.getBlockState(pos.relative(direction.getClockWise().getOpposite()));
        if (!blockState3.is(block) && !blockState4.is(block)) {
            return DirectionalBlockSide.SINGLE;
        } else if (!blockState3.is(block)) {
            return DirectionalBlockSide.RIGHT;
        } else if (!blockState4.is(block)) {
            return DirectionalBlockSide.LEFT;
        } else {
            return DirectionalBlockSide.MIDDLE;
        }
    }
}