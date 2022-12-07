package earth.terrarium.handcrafted.registry;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModPaintings {
    public static final Supplier<PaintingVariant> PRIDE_STEVE = register("pride_steve", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> BEACH_SUNRISE_MID = register("beach_sunrise_mid", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> APPLE = register("apple", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> SMALL_SAFARI_SUNSET = register("small_safari_sunset", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> MARIGOLD_MEADOWS = register("marigold_meadows", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> AD_ASTRA = register("ad_astra", () -> new PaintingVariant(16, 16));
    public static final Supplier<PaintingVariant> LOVE_FLOWERS = register("love_flowers", () -> new PaintingVariant(16, 16));

    public static final Supplier<PaintingVariant> MISTY_MOUNTAINS = register("misty_mountains", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> CORAL_DEPTHS = register("coral_depths", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> BROKEN_BIRCHES = register("broken_birches", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> MYSTERIOUS_MANGROVES = register("mysterious_mangroves", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> MY_MAN_DIORITE = register("my_man_diorite", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> COOKIES_ON_A_PLATE = register("cookies_on_a_plate", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> LAVA_PUDDLES = register("lava_puddles", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> THE_CAT_AND_THE_CUP = register("the_cat_and_the_cup", () -> new PaintingVariant(32, 32));
    public static final Supplier<PaintingVariant> TERRARIUM = register("terrarium", () -> new PaintingVariant(32, 32));

    public static final Supplier<PaintingVariant> GREEN_WOODS = register("green_woods", () -> new PaintingVariant(48, 32));
    public static final Supplier<PaintingVariant> SAFARI_SUNSET = register("safari_sunset", () -> new PaintingVariant(48, 32));
    public static final Supplier<PaintingVariant> ROCKY_BEACH = register("rocky_beach", () -> new PaintingVariant(48, 32));

    public static final Supplier<PaintingVariant> MISTY_MOUNTAIN_LEFT_SIDEPANEL = register("misty_mountain_left_sidepanel", () -> new PaintingVariant(16, 32));
    public static final Supplier<PaintingVariant> MISTY_MOUNTAIN_RIGHT_SIDEPANEL = register("misty_mountain_right_sidepanel", () -> new PaintingVariant(16, 32));
    public static final Supplier<PaintingVariant> BROKEN_BIRCHES_RIGHT_SIDEPANEL = register("broken_birches_right_sidepanel", () -> new PaintingVariant(16, 32));

    public static final Supplier<PaintingVariant> DESERT_PLATEAU = register("desert_plateau", () -> new PaintingVariant(32, 16));
    public static final Supplier<PaintingVariant> BEACH_SUNRISE_RIGHT = register("beach_sunrise_right", () -> new PaintingVariant(32, 16));
    public static final Supplier<PaintingVariant> BEACH_SUNRISE_LEFT = register("beach_sunrise_left", () -> new PaintingVariant(32, 16));
    public static final Supplier<PaintingVariant> NIAN_CAT = register("nian_cat", () -> new PaintingVariant(32, 16));

    private static <T extends PaintingVariant> Supplier<T> register(String id, Supplier<T> object) {
        return ModRegistryHelpers.register(Registry.PAINTING_VARIANT, id, object);
    }

    public static void init() {
    }
}
