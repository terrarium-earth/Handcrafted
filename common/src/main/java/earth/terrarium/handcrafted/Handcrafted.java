package earth.terrarium.handcrafted;

import earth.terrarium.handcrafted.common.registry.*;

public class Handcrafted {

    public static final String MOD_ID = "handcrafted";

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.init();
        ModEntityTypes.ENTITY_TYPES.init();
        ModSoundEvents.SOUND_EVENTS.init();
        ModPaintingVariants.PAINTING_VARIANTS.init();
    }
}
