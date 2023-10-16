package earth.terrarium.handcrafted.common.blocks.base.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum DirectionalBlockProperty implements StringRepresentable {
    SINGLE,
    LEFT,
    MIDDLE,
    RIGHT,
    ;

    @Override
    public @NotNull String getSerializedName() {
        return name().toLowerCase();
    }

    @Override
    public String toString() {
        return getSerializedName();
    }
}
