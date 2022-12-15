package earth.terrarium.handcrafted.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KitchenHoodPipeItem extends BlockItem {
    public KitchenHoodPipeItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.kitchen_hood_pipe_hammer").withStyle(ChatFormatting.GRAY));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.hold_shift").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}