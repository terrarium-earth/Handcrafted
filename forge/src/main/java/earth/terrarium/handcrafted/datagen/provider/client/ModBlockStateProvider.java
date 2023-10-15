package earth.terrarium.handcrafted.datagen.provider.client;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blocks.*;
import earth.terrarium.handcrafted.common.blocks.base.properties.*;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.blocks.misc.PotBlock;
import earth.terrarium.handcrafted.common.blocks.trims.CornerTrimBlock;
import earth.terrarium.handcrafted.common.blocks.trims.PillarTrimBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class ModBlockStateProvider extends BlockStateProvider {
    public static final ResourceLocation CUSHION = new ResourceLocation(Handcrafted.MOD_ID, "block/cushion");

    private final ExistingFileHelper existingFileHelper;

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Handcrafted.MOD_ID, existingFileHelper);
        this.existingFileHelper = existingFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.CUSHIONS.stream().map(RegistryEntry::get).forEach(this::cushion);
        ModBlocks.WOOD_BENCHES.stream().map(RegistryEntry::get).forEach(this::bench);
        ModBlocks.METAL_BENCHES.stream().map(RegistryEntry::get).forEach(this::metalBench);
        ModBlocks.COUCHES.stream().map(RegistryEntry::get).forEach(this::couch);
        ModBlocks.CHAIRS.stream().map(RegistryEntry::get).forEach(this::chair);
        ModBlocks.DINING_BENCHES.stream().map(RegistryEntry::get).forEach(this::diningBench);
        ModBlocks.SIDE_TABLES.stream().map(RegistryEntry::get).forEach(this::sideTable);
        ModBlocks.DESKS.stream().map(RegistryEntry::get).forEach(this::desk);
        ModBlocks.NIGHTSTANDS.stream().map(RegistryEntry::get).forEach(this::nightstand);
        ModBlocks.TABLES.stream().map(RegistryEntry::get).forEach(this::table);
        ModBlocks.COUNTERS.stream().map(RegistryEntry::get).forEach(this::counter);
        ModBlocks.CUPBOARDS.stream().map(RegistryEntry::get).forEach(this::cupboard);
        ModBlocks.DRAWERS.stream().map(RegistryEntry::get).forEach(this::drawer);
        ModBlocks.SHELVES.stream().map(RegistryEntry::get).forEach(this::shelf);
        ModBlocks.PILLAR_TRIMS.stream().map(RegistryEntry::get).forEach(this::pillarTrim);
        ModBlocks.CORNER_TRIMS.stream().map(RegistryEntry::get).forEach(this::cornerTrim);
        ModBlocks.POTS.stream().map(RegistryEntry::get).forEach(this::pot);
        ModBlocks.TROPHIES.stream().map(RegistryEntry::get).forEach(this::trophy);
        ModBlocks.BOWLS.stream().map(RegistryEntry::get).forEach(this::bowl);
        ModBlocks.CUPS.stream().map(RegistryEntry::get).forEach(this::cup);
        ModBlocks.PLATES.stream().map(RegistryEntry::get).forEach(this::plate);
        ModBlocks.CROCKERY_COMBOS.stream().map(RegistryEntry::get).forEach(this::crockeryCombo);
        ModBlocks.FANCY_BEDS.stream().map(RegistryEntry::get).forEach(this::fancyBed);

        stackableBook(ModBlocks.STACKABLE_BOOK.get());
        simpleBlockItem(ModBlocks.OVEN.get(), models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/oven/oven")));
        simpleBlockItem(ModBlocks.KITCHEN_HOOD.get(), models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/kitchen_hood/kitchen_hood")));
        simpleBlockItem(ModBlocks.KITCHEN_HOOD_PIPE.get(), models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/kitchen_hood/kitchen_hood_straight_pipe")));
        simpleBlockItem(ModBlocks.BERRY_JAM_JAR.get(), models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/jar/single")));
    }

    private void cushion(Block block) {
        simpleBlock(block, models().getBuilder(name(block))
            .parent(models().getExistingFile(CUSHION))
            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/cushion/" + name(block)))
            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_cushion") + "_wool")));
    }

    private void bench(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single_none"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(BenchBlock.FACING);
                ModularSeatProperty shape = state.getValue(BenchBlock.SHAPE);
                OptionalColorProperty color = state.getValue(BenchBlock.COLOR);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/bench/" + shape.getLocation());
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/bench/" + getTruncatedId(block, "_bench") + "_bench");
                ResourceLocation cushionTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/bench/cushion/" + color.getSerializedName() + "_" + "cushion");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), shape.getSerializedName(), color.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("cushion", cushionTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_bench") + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360) + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0))
                    .build();
            });
    }

    private void metalBench(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(BenchBlock.FACING);
                ModularSeatProperty shape = state.getValue(BenchBlock.SHAPE);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/metal_bench/" + shape.getLocation());
                ResourceLocation texture = new ResourceLocation(Handcrafted.MOD_ID, "block/bench/" + getTruncatedId(block, "_bench") + "_bench");
                if (block.equals(ModBlocks.BENCH.get())) {
                    texture = new ResourceLocation(Handcrafted.MOD_ID, "block/bench/bench");
                }

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), shape.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", texture)
                            .texture("particle", new ResourceLocation(Handcrafted.MOD_ID, "block/bench/metal_particles")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360) + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0))
                    .build();
            });
    }

    private void couch(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single_white"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CouchBlock.FACING);
                ModularSeatProperty shape = state.getValue(CouchBlock.SHAPE);
                ColorProperty color = state.getValue(CouchBlock.COLOR);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/couch/" + shape.getLocation());
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/couch/" + getTruncatedId(block, "_couch") + "_couch");
                ResourceLocation cushionTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/couch/cushion/" + color.getSerializedName() + "_" + "cushion");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), shape.getSerializedName(), color.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("cushion", cushionTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_couch") + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360) + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0))
                    .build();
            });
    }

    private void chair(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_none"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(ChairBlock.FACING);
                OptionalColorProperty color = state.getValue(ChairBlock.COLOR);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/chair/chair");
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/chair/" + getTruncatedId(block, "_chair") + "_chair");
                ResourceLocation cushionTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/chair/cushion/" + color.getSerializedName() + "_" + "cushion");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), color.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("cushion", cushionTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_chair") + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void diningBench(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(DiningBenchBlock.FACING);
                DirectionalBlockProperty shape = state.getValue(DiningBenchBlock.SHAPE);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/dining_bench/" + shape.getSerializedName());
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/dining_bench/" + getTruncatedId(block, "_dining_bench") + "_dining_bench");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), shape.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_dining_bench") + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void sideTable(Block block) {
        simpleTable(block, "side_table");
    }

    private void desk(Block block) {
        simpleTable(block, "desk");
    }

    private void nightstand(Block block) {
        simpleTable(block, "nightstand");
    }

    private void simpleTable(Block block, String name) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_none"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(ChairBlock.FACING);
                OptionalColorProperty color = state.getValue(ChairBlock.COLOR);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/" + name);
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/table/" + name + "/" + getTruncatedId(block, "_" + name) + "_" + name);
                ResourceLocation sheetTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/table/sheet/" + color.getSerializedName() + "_" + "sheet");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), color.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("sheet", sheetTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_" + name) + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void table(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single_none"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                TableProperty shape = state.getValue(TableBlock.SHAPE);
                OptionalColorProperty color = state.getValue(TableBlock.COLOR);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/table/" + shape.getSerializedName());
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/table/table/" + getTruncatedId(block, "_table") + "_table");
                ResourceLocation sheetTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/table/sheet/" + color.getSerializedName() + "_" + "sheet");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), shape.getSerializedName(), color.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("sheet", sheetTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_table") + "_planks")))
                    .build();
            });
    }

    private void counter(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_calcite_1"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CounterBlock.FACING);
                int type = state.getValue(CounterBlock.TYPE);
                CounterProperty counter = state.getValue(CounterBlock.COUNTER);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/counter");
                ResourceLocation woodTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/counter/" + getTruncatedId(block, "_counter") + "_counter_" + type);
                ResourceLocation topTexture = new ResourceLocation(Handcrafted.MOD_ID, "block/counter/top/" + counter.getSerializedName());

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), counter.getSerializedName(), type))
                            .parent(models().getExistingFile(parent))
                            .texture("top", topTexture)
                            .texture("wood", woodTexture)
                            .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_counter") + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void cupboard(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_1"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CounterBlock.FACING);
                int type = state.getValue(CupboardBlock.TYPE);
                String woodType = getTruncatedId(block, "_cupboard");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().cube(
                            String.format("%s_%s", name(block), type),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_top"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_top"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_" + type),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_back"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_side"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/cupboard/" + woodType + "/cupboard_side")
                        ).texture("particle", new ResourceLocation("block/" + woodType + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void drawer(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single_1"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(DrawerBlock.FACING);
                int type = state.getValue(DrawerBlock.TYPE);
                String woodType = getTruncatedId(block, "_drawer");
                DirectionalBlockProperty shape = state.getValue(DrawerBlock.SHAPE);

                return ConfiguredModel.builder()
                    .modelFile(
                        models().cube(
                            String.format("%s_%s_%s", name(block), shape.getSerializedName(), type),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/drawer/" + woodType + "/drawer_bottom"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/drawer/" + woodType + "/drawer_top"),
                            new ResourceLocation(Handcrafted.MOD_ID, type != 4 ?
                                "block/drawer/" + woodType + "/front_" + type + "/drawer_" + shape.getSerializedName() :
                                "block/drawer/" + woodType + "/front_" + type + "/drawer"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/drawer/" + woodType + "/drawer_back"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/drawer/" + woodType + "/drawer_side_left"),
                            new ResourceLocation(Handcrafted.MOD_ID, "block/drawer/" + woodType + "/drawer_side_right")
                        ).texture("particle", new ResourceLocation("block/" + woodType + "_planks")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void shelf(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_single_1"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(ShelfBlock.FACING);
                int type = state.getValue(ShelfBlock.TYPE);

                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/shelf");
                String woodType = getTruncatedId(block, "_shelf");
                DirectionalBlockProperty shape = state.getValue(ShelfBlock.SHAPE);
                ResourceLocation woodTexture = new ResourceLocation("block/" + woodType + "_planks");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), shape.getSerializedName(), type))
                            .parent(models().getExistingFile(parent))
                            .texture("back", new ResourceLocation(Handcrafted.MOD_ID, "block/shelf/" + woodType + "/shelf_back"))
                            .texture("left", new ResourceLocation(Handcrafted.MOD_ID, "block/shelf/" + woodType + "/shelf_side_left"))
                            .texture("right", new ResourceLocation(Handcrafted.MOD_ID, "block/shelf/" + woodType + "/shelf_side_right"))
                            .texture("front", new ResourceLocation(Handcrafted.MOD_ID, "block/shelf/" + woodType + "/shelf_" + shape.getSerializedName()))
                            .texture("overlay", new ResourceLocation(Handcrafted.MOD_ID, "block/shelf/overlay/" + switch (type) {
                                case 2 -> "books_%s".formatted(shape.getSerializedName());
                                case 3 -> "cobwebs_%s".formatted(shape.getSerializedName());
                                case 4 -> "potions_%s".formatted(shape.getSerializedName());
                                case 5 -> "pots_%s".formatted(shape.getSerializedName());
                                default -> "none";
                            }))
                            .texture("wood", woodTexture))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void pillarTrim(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_normal_1"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(PillarTrimBlock.FACING);
                AttachFace face = state.getValue(PillarTrimBlock.FACE);
                int type = state.getValue(PillarTrimBlock.TYPE);
                TrimProperty shape = state.getValue(PillarTrimBlock.SHAPE);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/trim/" + shape.getSerializedName() + "_pillar_trim");

                ResourceLocation texture = new ResourceLocation(Handcrafted.MOD_ID, "block/trim/pillar/" + name(block) + "_2_" + shape.getSerializedName());
                if (type == 1 || !existingFileHelper.exists(texture, PackType.CLIENT_RESOURCES, ".png", "textures")) {
                    texture = new ResourceLocation(Handcrafted.MOD_ID, "block/trim/pillar/" + name(block) + "_" + shape.getSerializedName());
                }

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), shape.getSerializedName(), type))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", texture))
                    .rotationX(face == AttachFace.FLOOR ? 270 : (face == AttachFace.WALL ? 0 : 90))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void cornerTrim(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block) + "_normal"));
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CornerTrimBlock.FACING);
                Half half = state.getValue(CornerTrimBlock.HALF);
                TrimProperty shape = state.getValue(CornerTrimBlock.SHAPE);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/trim/" + shape.getSerializedName() + "_corner_trim");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), shape.getSerializedName()))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/trim/corner/" + name(block) + "_" + shape.getSerializedName())))
                    .rotationX(half == Half.BOTTOM ? 180 : 0)
                    .rotationY(((((int) dir.toYRot()) + 180) % 360) + (half == Half.BOTTOM ? 0 : 180))
                    .build();
            });
    }

    private void pot(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block)));
        PotBlock.PotSize size = ((PotBlock) block).size();
        simpleBlock(block, models().getBuilder(name(block))
            .parent(models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, switch (size) {
                case THIN -> "block/pot/thin_pot";
                case MEDIUM -> "block/pot/medium_pot";
                case WIDE -> "block/pot/wide_pot";
                case THICK -> "block/pot/thick_pot";
            })))
            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/pot/" + name(block))));
    }

    private void bowl(Block block) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CrockeryBlock.FACING);
                String piecesName = CrockeryBlock.piecesName(state);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/bowl/" + piecesName);

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), piecesName))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/bowl/" + getTruncatedId(block, "_bowl") + "_crockery")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void cup(Block block) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CrockeryBlock.FACING);
                String piecesName = CrockeryBlock.piecesName(state);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/cup/" + piecesName);

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), piecesName))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/" + getTruncatedId(block, "_cup") + "_crockery")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void plate(Block block) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CrockeryBlock.FACING);
                String piecesName = CrockeryBlock.piecesName(state);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/plate/" + piecesName);

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s", name(block), piecesName))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/" + getTruncatedId(block, "_plate") + "_crockery")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void crockeryCombo(Block block) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(CrockeryBlock.FACING);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/combo");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(name(block))
                            .parent(models().getExistingFile(parent))
                            .texture("texture", new ResourceLocation(Handcrafted.MOD_ID, "block/crockery/" + getTruncatedId(block, "_crockery_combo") + "_crockery")))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void stackableBook(Block block) {
        getVariantBuilder(block)
            .forAllStates(state -> {
                Direction dir = state.getValue(StackableBookBlock.FACING);
                int seed = state.getValue(StackableBookBlock.SEED);
                ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/stackable_book/" + StackableBookBlock.bookName(state));

                Random random = new Random(seed);
                int randomInt = random.nextInt(15) + 1;
                ResourceLocation book1 = new ResourceLocation(Handcrafted.MOD_ID, "block/stackable_book/" + DyeColor.byId(randomInt).getName() + "_book");
                ResourceLocation book2 = new ResourceLocation(Handcrafted.MOD_ID, "block/stackable_book/" + DyeColor.byId((randomInt + 1) % 15 + 1).getName() + "_book");
                ResourceLocation book3 = new ResourceLocation(Handcrafted.MOD_ID, "block/stackable_book/" + DyeColor.byId((randomInt + 2) % 15 + 1).getName() + "_book");
                ResourceLocation book4 = new ResourceLocation(Handcrafted.MOD_ID, "block/stackable_book/" + DyeColor.byId((randomInt + 3) % 15 + 1).getName() + "_book");

                return ConfiguredModel.builder()
                    .modelFile(
                        models().getBuilder(String.format("%s_%s_%s", name(block), StackableBookBlock.bookName(state), seed))
                            .parent(models().getExistingFile(parent))
                            .texture("book1", book1)
                            .texture("book2", book2)
                            .texture("book3", book3)
                            .texture("book4", book4))
                    .rotationY(((((int) dir.toYRot()) + 180) % 360))
                    .build();
            });
    }

    private void fancyBed(Block block) {
        itemModels().getBuilder(name(block))
            .parent(models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/bed_single_occupied")))
            .texture("frame", new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/single/" + getTruncatedId(block, "_fancy_bed") + "_fancy_bed"))
            .texture("sheets", new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/sheets/white_sheet"))
            .texture("cushion", new ResourceLocation(Handcrafted.MOD_ID, "block/bench/cushion/white_cushion"));

        getVariantBuilder(block)
            .forAllStates(state -> {
                BedPart part = state.getValue(FancyBedBlock.PART);
                Direction dir = state.getValue(FancyBedBlock.FACING);
                boolean occupied = state.getValue(FancyBedBlock.OCCUPIED);
                DirectionalBlockProperty shape = state.getValue(FancyBedBlock.SHAPE);
                ColorProperty color = state.getValue(FancyBedBlock.COLOR);

                if (part == BedPart.HEAD) {
                    ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/cushion");

                    return ConfiguredModel.builder()
                        .modelFile(
                            models().getBuilder(String.format("%s_%s_%s_%s", name(block), shape.getSerializedName(), color.getSerializedName(), part.getSerializedName()) + (occupied ? "_occupied" : ""))
                                .parent(models().getExistingFile(parent))
                                .texture("cushion", new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/cushion/" + color.getSerializedName() + "_cushion"))
                                .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_fancy_bed") + "_planks")))
                        .rotationY(((((int) dir.toYRot()) + 180) % 360))
                        .build();
                } else {
                    ResourceLocation parent = new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/bed_" + shape.getSerializedName() + (occupied ? "_occupied" : ""));
                    String woodType = getTruncatedId(block, "_fancy_bed");

                    return ConfiguredModel.builder()
                        .modelFile(
                            models().getBuilder(String.format("%s_%s_%s_%s", name(block), shape.getSerializedName(), color.getSerializedName(), part.getSerializedName()) + (occupied ? "_occupied" : ""))
                                .parent(models().getExistingFile(parent))
                                .texture("frame", new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/" + (shape == DirectionalBlockProperty.SINGLE ? "single" : "double") + "/" + woodType + "_fancy_bed"))
                                .texture("sheets", new ResourceLocation(Handcrafted.MOD_ID, "block/fancy_bed/sheets/" + color.getSerializedName() + "_sheet"))
                                .texture("cushion", new ResourceLocation(Handcrafted.MOD_ID, "block/bench/cushion/none_cushion"))
                                .texture("particle", new ResourceLocation("block/" + getTruncatedId(block, "_fancy_bed") + "_planks")))
                        .rotationY(((((int) dir.toYRot()) + 180) % 360))
                        .build();
                }
            });
    }

    private void trophy(Block block) {
        simpleBlockItem(block, models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/trophy/" + name(block))));
        horizontalBlock(block, models().getExistingFile(new ResourceLocation(Handcrafted.MOD_ID, "block/trophy/" + name(block))));
    }

    public String getTruncatedId(Block block, String cut) {
        return name(block).replace(cut, "");
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }
}
