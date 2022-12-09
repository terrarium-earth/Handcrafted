package earth.terrarium.handcrafted.common.block.table.side_table;

import earth.terrarium.handcrafted.common.block.SimpleEntityBlock;
import earth.terrarium.handcrafted.common.block.table.table.TableBlock;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class SideTableBlock extends SimpleEntityBlock {
    public SideTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return TableBlock.sheetUse(level, pos, player, ItemStack.EMPTY);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SideTableBlockEntity(pos, state);
    }
}
