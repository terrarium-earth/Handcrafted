package earth.terrarium.handcrafted.common.items;

import earth.terrarium.handcrafted.common.utils.TooltipUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {
    private final Component tooltip;

    public TooltipItem(Component tooltip, Properties properties) {
        super(properties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        TooltipUtils.addDescriptionComponent(tooltipComponents, tooltip);
    }
}
