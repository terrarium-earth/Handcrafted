package earth.terrarium.handcrafted.common.item;

import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BoardItem extends Item {
    public BoardItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.board_help").withStyle(ChatFormatting.GRAY));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.hold_shift").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }

    public static void handleStoneCutter(Level level, BlockPos pos, Entity entity) {
        if (entity instanceof ItemEntity item) {
            ItemStack stack = item.getItem();
            if (!stack.is(ItemTags.PLANKS)) {
                return;
            }
            ItemStack newStack = ItemStack.EMPTY;

            // TODO: make this a recipe
            if (stack.is(Items.ACACIA_PLANKS)) newStack = ModItems.ACACIA_BOARD.get().getDefaultInstance();
            if (stack.is(Items.BIRCH_PLANKS)) newStack = ModItems.BIRCH_BOARD.get().getDefaultInstance();
            if (stack.is(Items.DARK_OAK_PLANKS)) newStack = ModItems.DARK_OAK_BOARD.get().getDefaultInstance();
            if (stack.is(Items.JUNGLE_PLANKS)) newStack = ModItems.JUNGLE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.MANGROVE_PLANKS)) newStack = ModItems.MANGROVE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.OAK_PLANKS)) newStack = ModItems.OAK_BOARD.get().getDefaultInstance();
            if (stack.is(Items.SPRUCE_PLANKS)) newStack = ModItems.SPRUCE_BOARD.get().getDefaultInstance();
            if (stack.is(Items.CRIMSON_PLANKS)) newStack = ModItems.CRIMSON_BOARD.get().getDefaultInstance();
            if (stack.is(Items.WARPED_PLANKS)) newStack = ModItems.WARPED_BOARD.get().getDefaultInstance();

            // Give 4 boards per plank.
            newStack.setCount(stack.getCount() * 4);
            if (!newStack.isEmpty()) {
                entity.discard();
                ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, newStack);
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().scale(0.5));
                level.addFreshEntity(itemEntity);
            }
        }
    }
}
