package earth.terrarium.handcrafted.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CushionBlockItem extends BlockItem {
    public CushionBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public ResourceLocation getTexture(boolean isDouble, ResourceLocation texture) {
        ResourceLocation item = BuiltInRegistries.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bed/" + (isDouble ? "double" : "single") + "/cushion/" + item.getPath() + ".png");
    }

    public ResourceLocation getBenchTexture(ResourceLocation texture) {
        ResourceLocation item = BuiltInRegistries.ITEM.getKey(this);
        return new ResourceLocation(texture.getNamespace(), "textures/block/bench/cushion/" + item.getPath() + ".png");
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.cushion_help").withStyle(ChatFormatting.GRAY));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.handcrafted.hold_shift").withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}