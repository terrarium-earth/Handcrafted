package earth.terrarium.handcrafted;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class HandcraftedBlocks {
    public static final Supplier<Block> NORDIC_BOOKCASE = CommonUtils.registerBlock("nordic_bookcase", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));
    public static final Supplier<Block> NORDIC_PLANKS = CommonUtils.registerBlock("nordic_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> NORDIC_STAIRS = CommonUtils.registerBlock("nordic_stairs", () -> new StairBlock(HandcraftedBlocks.NORDIC_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
    });
    public static final Supplier<Block> NORDIC_SLAB = CommonUtils.registerBlock("nordic_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> NORDIC_SMALL_TABLE = CommonUtils.registerBlock("nordic_small_table", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()) {
    });
    public static final Supplier<Block> NORDIC_NIGHTSTAND = CommonUtils.registerBlock("nordic_nightstand", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()) {
    });
    public static final Supplier<Block> NORDIC_ALTERNATE_NIGHTSTAND = CommonUtils.registerBlock("nordic_alternate_nightstand", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()) {
    });
    public static final Supplier<Block> NORDIC_CHAIR = CommonUtils.registerBlock("nordic_chair", () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> NORDIC_CLOCK = CommonUtils.registerBlock("nordic_clock", () -> new CarvedPumpkinBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()) {
    });
    public static final Supplier<Block> NORDIC_LITTLE_LAMP = CommonUtils.registerBlock("nordic_little_lamp", () -> new LittleLampBlock(BlockBehaviour.Properties.copy(Blocks.TORCH)));
    public static final Supplier<Block> NORDIC_TALL_LAMP = CommonUtils.registerBlock("nordic_tall_lamp", () -> new TallLampBlock(BlockBehaviour.Properties.copy(Blocks.TORCH).noOcclusion()));
    public static final Supplier<Block> NORDIC_LARGE_DESK = CommonUtils.registerBlock("nordic_large_desk", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> NORDIC_LARGE_TABLE = CommonUtils.registerBlock("nordic_large_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> NORDIC_CARPET = CommonUtils.registerBlock("nordic_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CARPET)));
    public static final Supplier<Block> NORDIC_WOOL = CommonUtils.registerBlock("nordic_wool", () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> NORDIC_TRAPDOOR = CommonUtils.registerBlock("nordic_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)) {
    });
    public static final Supplier<Block> NORDIC_TRAPDOOR_ALTERNATE = CommonUtils.registerBlock("nordic_trapdoor_alternate", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)) {
    });
    public static final Supplier<Block> NORDIC_DOOR = CommonUtils.registerBlock("nordic_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)) {
    });
    public static final Supplier<Block> NORDIC_FENCE = CommonUtils.registerBlock("nordic_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)) {
    });

    public static final Supplier<Block> VANILLA_TABLE = CommonUtils.registerBlock("vanilla_table", () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noOcclusion()));

    // We never use this class outside normally, so we must call this otherwise useless function so that it's resolved
    static void resolveClass() {
    }
}
