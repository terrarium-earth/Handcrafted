package earth.terrarium.handcrafted.common.block.property;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TableState implements StringRepresentable {
    SINGLE("single"),
    CENTER("center"),
    NORTH_EAST_CORNER("north_east_corner"),
    NORTH_WEST_CORNER("north_west_corner"),
    SOUTH_EAST_CORNER("south_east_corner"),
    SOUTH_WEST_CORNER("south_west_corner"),
    NORTH_SIDE("north_side"),
    EAST_SIDE("east_side"),
    SOUTH_SIDE("south_side"),
    WEST_SIDE("west_side");

    private final String name;

    TableState(String string2) {
        this.name = string2;
    }

    public String toString() {
        return this.name;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
}
