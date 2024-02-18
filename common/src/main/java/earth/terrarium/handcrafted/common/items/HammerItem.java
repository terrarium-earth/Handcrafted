package earth.terrarium.handcrafted.common.items;

import earth.terrarium.handcrafted.common.blocks.base.Hammerable;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HammerItem extends Item {
    public HammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.getBlockState(context.getClickedPos()).getBlock() instanceof Hammerable block) {
            block.onHammer(level, context.getClickedPos(), level.getBlockState(context.getClickedPos()), context.getClickedFace(), context.getPlayer(), context.getClickLocation());
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        TooltipUtils.addDescriptionComponent(tooltipComponents, ConstantComponents.HAMMER);
    }
}
