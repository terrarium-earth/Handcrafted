package earth.terrarium.handcrafted.mixin;

import earth.terrarium.handcrafted.common.item.BoardItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

// Convert planks into boards by throwing them onto the Stone Cutter.
@Mixin(StonecutterBlock.class)
public abstract class StoneCutterMixin extends Block {
    public StoneCutterMixin(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        BoardItem.handleStoneCutter(level, pos, entity);
    }
}
