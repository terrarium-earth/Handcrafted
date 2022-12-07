package earth.terrarium.handcrafted;

import earth.terrarium.handcrafted.registry.*;

public class Handcrafted
{
	public static final String MOD_ID = "handcrafted";

	public static void init() {
		ModEntityTypes.init();
		ModBlocks.init();
		ModBlockEntities.init();
		ModItems.init();
		ModPaintings.init();
	}
}