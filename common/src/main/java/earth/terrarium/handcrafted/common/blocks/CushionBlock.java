package earth.terrarium.handcrafted.common.blocks;

import earth.terrarium.handcrafted.common.blocks.base.SittableBlock;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
public class CushionBlock extends Block implements SittableBlock {
    public static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);

    public CushionBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.sitOn(level, pos, player, null)) {
            return InteractionResult.CONSUME;
        }
        return InteractionResult.CONSUME_PARTIAL;
    }

    @Override
    public AABB getSeatSize(BlockState state) {
        return new AABB(0, 0, 0, 1, 0.4, 1);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.PLACE_ON_FURNITURE);
    }
}