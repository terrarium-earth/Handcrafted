package earth.terrarium.handcrafted.common.blocks.base.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TrimProperty implements StringRepresentable {
    NORMAL,
    THICC,
    THIN,
    ;

    public String toString() {
        return getSerializedName();
    }

    public @NotNull String getSerializedName() {
        return name().toLowerCase();
    }
}
