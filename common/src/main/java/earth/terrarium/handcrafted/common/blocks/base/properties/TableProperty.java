package earth.terrarium.handcrafted.common.blocks.base.properties;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TableProperty implements StringRepresentable {
    SINGLE,
    CENTER,
    NORTH_CENTER,
    EAST_CENTER,
    SOUTH_CENTER,
    WEST_CENTER,
    NORTH_SOUTH_CENTER,
    EAST_WEST_CENTER,
    NORTH_EAST_CORNER,
    NORTH_WEST_CORNER,
    SOUTH_EAST_CORNER,
    SOUTH_WEST_CORNER,
    NORTH_SIDE,
    EAST_SIDE,
    SOUTH_SIDE,
    WEST_SIDE,
    ;

    public String toString() {
        return getSerializedName();
    }

    public @NotNull String getSerializedName() {
        return name().toLowerCase();
    }
}
