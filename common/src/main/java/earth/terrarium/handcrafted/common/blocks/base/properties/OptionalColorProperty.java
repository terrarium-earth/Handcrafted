package earth.terrarium.handcrafted.common.blocks.base.properties;

import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public enum OptionalColorProperty implements StringRepresentable {
    NONE,
    WHITE,
    ORANGE,
    MAGENTA,
    LIGHT_BLUE,
    YELLOW,
    LIME,
    PINK,
    GRAY,
    LIGHT_GRAY,
    CYAN,
    PURPLE,
    BLUE,
    BROWN,
    GREEN,
    RED,
    BLACK,
    ;

    @Override
    public @NotNull String getSerializedName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getSerializedName();
    }

    public static OptionalColorProperty fromCushion(Item cushion) {
        return OptionalColorProperty.valueOf(BuiltInRegistries.ITEM.getKey(cushion).getPath().replace("_cushion", "").toUpperCase(Locale.ROOT));
    }

    public ItemStack toCushion() {
        if (this == NONE) return ItemStack.EMPTY;
        return BuiltInRegistries.ITEM.get(new ResourceLocation(Handcrafted.MOD_ID, getSerializedName() + "_cushion")).getDefaultInstance();
    }

    public static OptionalColorProperty fromSheet(Item sheet) {
        return OptionalColorProperty.valueOf(BuiltInRegistries.ITEM.getKey(sheet).getPath().replace("_sheet", "").toUpperCase(Locale.ROOT));
    }

    public ItemStack toSheet() {
        if (this == NONE) return ItemStack.EMPTY;
        return BuiltInRegistries.ITEM.get(new ResourceLocation(Handcrafted.MOD_ID, getSerializedName() + "_sheet")).getDefaultInstance();
    }
}
