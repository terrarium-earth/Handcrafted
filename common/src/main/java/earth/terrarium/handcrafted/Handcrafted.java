package earth.terrarium.handcrafted;

import earth.terrarium.handcrafted.registry.ModBlockEntities;
import earth.terrarium.handcrafted.registry.ModBlocks;
import earth.terrarium.handcrafted.registry.ModItems;

public class Handcrafted
{
	public static final String MOD_ID = "handcrafted";

	public static void init() {
		ModBlocks.init();
		ModBlockEntities.init();
		ModItems.init();
	}
}