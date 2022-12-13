package earth.terrarium.handcrafted.common.block.property;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum TrimState implements StringRepresentable {
    NORMAL("normal"),
    THICC("thicc"),
    THIN("thin");

    private final String name;

    TrimState(String string2) {
        this.name = string2;
    }

    public String toString() {
        return this.name;
    }

    public @NotNull String getSerializedName() {
        return this.name;
    }
}
