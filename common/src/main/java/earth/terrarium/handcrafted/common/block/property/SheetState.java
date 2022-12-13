package earth.terrarium.handcrafted.common.block.property;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum SheetState implements StringRepresentable {
    SINGLE("single"),
    CENTER("center"),
    NORTH_SIDE("north_side"),
    EAST_SIDE("east_side"),
    SOUTH_SIDE("south_side"),
    WEST_SIDE("west_side"),
    NORTH_EAST_CORNER("north_east_corner"),
    NORTH_WEST_CORNER("north_west_corner"),
    SOUTH_EAST_CORNER("south_east_corner"),
    SOUTH_WEST_CORNER("south_west_coner"),
    NORTH_COVER("north_coverr"),
    EAST_COVER("east_cover"),
    SOUTH_COVER("south_cover"),
    WEST_COVER("west_cover");

    private final String name;

    SheetState(String string2) {
        this.name = string2;
    }

    public String toString() {
        return this.name;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
}
