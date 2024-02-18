package earth.terrarium.handcrafted.common.blocks.crockery;

import earth.terrarium.handcrafted.common.blocks.base.SimpleBlock;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("deprecation")
public class CrockeryComboBlock extends SimpleBlock implements EntityBlock {
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 3, 16);

    public CrockeryComboBlock(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof CrockeryBlockEntity crockery) {
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), crockery.getStack());
        }
        super.onRemove(state, level, pos, newState, moved);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CrockeryBlockEntity(pos, state);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        TooltipUtils.addDescriptionComponent(tooltip, ConstantComponents.CROCKERY_COMBO);
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.getBlockEntity(pos) instanceof CrockeryBlockEntity crockery) {
            ItemStack stack = crockery.getStack();
            if (stack.isEmpty()) {
                ItemStack itemInHand = player.getItemInHand(hand).copy();
                itemInHand.setCount(1);
                crockery.setStack(itemInHand);
                if (!player.getAbilities().instabuild) player.getItemInHand(hand).shrink(1);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, player.getSoundSource(), 1, 1);
            } else {
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
                crockery.setStack(ItemStack.EMPTY);
                level.playSound(null, pos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, player.getSoundSource(), 1, 1);
            }
        }

        return InteractionResult.CONSUME_PARTIAL;
    }
}
