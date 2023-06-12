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
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

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
            if (!stack.is(ItemTags.PLANKS)) return;

            Supplier<Item> supplier = ModItems.PLANKS_TO_BOARDS.entrySet()
                .stream()
                .filter(entry -> stack.is(entry.getKey().get()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);

            if (supplier == null) return;
            ItemStack newStack = supplier.get().getDefaultInstance();

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
