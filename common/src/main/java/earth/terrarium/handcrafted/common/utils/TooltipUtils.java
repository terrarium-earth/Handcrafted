package earth.terrarium.handcrafted.common.utils;

import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;

public class TooltipUtils {

    public static void addDescriptionComponent(List<Component> tooltipComponents, Component... description) {
        Component combined = CommonComponents.joinLines(description);

        if (!Screen.hasShiftDown()) {
            tooltipComponents.add(ConstantComponents.SHIFT_DESCRIPTION);
            return;
        }

        // Split the description into multiple lines if it's too long
        for (FormattedCharSequence text : Minecraft.getInstance().font.split(combined, 200)) {
            StringBuilder builder = new StringBuilder();
            text.accept((i, style, codePoint) -> {
                builder.appendCodePoint(codePoint);
                return true;
            });
            tooltipComponents.add(Component.literal(builder.toString()).withStyle(ChatFormatting.GRAY));
        }
    }
}
