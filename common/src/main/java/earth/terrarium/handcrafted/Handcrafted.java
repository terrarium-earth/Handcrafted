package earth.terrarium.handcrafted;

import earth.terrarium.handcrafted.common.registry.*;

public class Handcrafted {
    public static final String MOD_ID = "handcrafted";

    public static void init() {
        ModEntityTypes.ENTITY_TYPES.init();
        ModBlocks.BLOCKS.init();
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.init();
        ModItems.ITEMS.init();
        ModPaintings.PAINTING_VARIANTS.init();
    }

    public static void postInit() {
        ModBlockEntityTypes.postInit();
    }
}