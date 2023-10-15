package earth.terrarium.handcrafted.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.Handcrafted;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.decoration.PaintingVariant;

@SuppressWarnings("unused")
public class ModPaintingVariants {
    public static final ResourcefulRegistry<PaintingVariant> PAINTING_VARIANTS = ResourcefulRegistries.create(BuiltInRegistries.PAINTING_VARIANT, Handcrafted.MOD_ID);
    public static final ResourcefulRegistry<PaintingVariant> SMALL_PAINTING_VARIANTS = ResourcefulRegistries.create(PAINTING_VARIANTS);
    public static final ResourcefulRegistry<PaintingVariant> MEDIUM_PAINTING_VARIANTS = ResourcefulRegistries.create(PAINTING_VARIANTS);
    public static final ResourcefulRegistry<PaintingVariant> LARGE_PAINTING_VARIANTS = ResourcefulRegistries.create(PAINTING_VARIANTS);
    public static final ResourcefulRegistry<PaintingVariant> WIDE_PAINTING_VARIANTS = ResourcefulRegistries.create(PAINTING_VARIANTS);
    public static final ResourcefulRegistry<PaintingVariant> TALL_PAINTING_VARIANTS = ResourcefulRegistries.create(PAINTING_VARIANTS);

    public static final RegistryEntry<PaintingVariant> PRIDE_STEVE = SMALL_PAINTING_VARIANTS.register("pride_steve", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> BEACH_SUNRISE_MID = SMALL_PAINTING_VARIANTS.register("beach_sunrise_mid", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> APPLE = SMALL_PAINTING_VARIANTS.register("apple", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> SMALL_SAFARI_SUNSET = SMALL_PAINTING_VARIANTS.register("small_safari_sunset", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> MARIGOLD_MEADOWS = SMALL_PAINTING_VARIANTS.register("marigold_meadows", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> AD_ASTRA = SMALL_PAINTING_VARIANTS.register("ad_astra", () -> new PaintingVariant(16, 16));
    public static final RegistryEntry<PaintingVariant> LOVE_FLOWERS = SMALL_PAINTING_VARIANTS.register("love_flowers", () -> new PaintingVariant(16, 16));

    public static final RegistryEntry<PaintingVariant> MISTY_MOUNTAINS = MEDIUM_PAINTING_VARIANTS.register("misty_mountains", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> CORAL_DEPTHS = MEDIUM_PAINTING_VARIANTS.register("coral_depths", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> BROKEN_BIRCHES = MEDIUM_PAINTING_VARIANTS.register("broken_birches", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> MYSTERIOUS_MANGROVES = MEDIUM_PAINTING_VARIANTS.register("mysterious_mangroves", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> MY_MAN_DIORITE = MEDIUM_PAINTING_VARIANTS.register("my_man_diorite", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> COOKIES_ON_A_PLATE = MEDIUM_PAINTING_VARIANTS.register("cookies_on_a_plate", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> LAVA_PUDDLES = MEDIUM_PAINTING_VARIANTS.register("lava_puddles", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> THE_CAT_AND_THE_CUP = MEDIUM_PAINTING_VARIANTS.register("the_cat_and_the_cup", () -> new PaintingVariant(32, 32));
    public static final RegistryEntry<PaintingVariant> TERRARIUM = MEDIUM_PAINTING_VARIANTS.register("terrarium", () -> new PaintingVariant(32, 32));

    public static final RegistryEntry<PaintingVariant> GREEN_WOODS = LARGE_PAINTING_VARIANTS.register("green_woods", () -> new PaintingVariant(48, 32));
    public static final RegistryEntry<PaintingVariant> SAFARI_SUNSET = LARGE_PAINTING_VARIANTS.register("safari_sunset", () -> new PaintingVariant(48, 32));
    public static final RegistryEntry<PaintingVariant> ROCKY_BEACH = LARGE_PAINTING_VARIANTS.register("rocky_beach", () -> new PaintingVariant(48, 32));

    public static final RegistryEntry<PaintingVariant> MISTY_MOUNTAIN_LEFT_SIDEPANEL = WIDE_PAINTING_VARIANTS.register("misty_mountain_left_sidepanel", () -> new PaintingVariant(16, 32));
    public static final RegistryEntry<PaintingVariant> MISTY_MOUNTAIN_RIGHT_SIDEPANEL = WIDE_PAINTING_VARIANTS.register("misty_mountain_right_sidepanel", () -> new PaintingVariant(16, 32));
    public static final RegistryEntry<PaintingVariant> BROKEN_BIRCHES_LEFT_SIDEPANEL = WIDE_PAINTING_VARIANTS.register("broken_birches_left_sidepanel", () -> new PaintingVariant(16, 32));
    public static final RegistryEntry<PaintingVariant> BROKEN_BIRCHES_RIGHT_SIDEPANEL = WIDE_PAINTING_VARIANTS.register("broken_birches_right_sidepanel", () -> new PaintingVariant(16, 32));
    public static final RegistryEntry<PaintingVariant> FLOWER_IN_THE_DARKNESS = WIDE_PAINTING_VARIANTS.register("flower_in_the_darkness", () -> new PaintingVariant(16, 32));

    public static final RegistryEntry<PaintingVariant> DESERT_PLATEAU = TALL_PAINTING_VARIANTS.register("desert_plateau", () -> new PaintingVariant(32, 16));
    public static final RegistryEntry<PaintingVariant> BEACH_SUNRISE_RIGHT = TALL_PAINTING_VARIANTS.register("beach_sunrise_right", () -> new PaintingVariant(32, 16));
    public static final RegistryEntry<PaintingVariant> BEACH_SUNRISE_LEFT = TALL_PAINTING_VARIANTS.register("beach_sunrise_left", () -> new PaintingVariant(32, 16));
    public static final RegistryEntry<PaintingVariant> NIAN_CAT = TALL_PAINTING_VARIANTS.register("nian_cat", () -> new PaintingVariant(32, 16));
}
