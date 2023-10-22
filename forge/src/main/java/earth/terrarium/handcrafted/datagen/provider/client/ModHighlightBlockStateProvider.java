package earth.terrarium.handcrafted.datagen.provider.client;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blocks.*;
import earth.terrarium.handcrafted.common.blocks.base.properties.ColorProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.DirectionalBlockProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.ModularSeatProperty;
import earth.terrarium.handcrafted.common.blocks.base.properties.OptionalColorProperty;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.blocks.misc.StackableJarBlock;
import earth.terrarium.handcrafted.common.blocks.trophies.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.minecraft.core.Direction;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModHighlightBlockStateProvider implements DataProvider {

    private final PackOutput output;
    private final Map<Block, JsonObject> highlights = new HashMap<>();

    public ModHighlightBlockStateProvider(PackOutput output) {
        this.output = output;
    }

    public void createHighlights() {
        ModBlocks.WALL_TROPHIES.stream().map(RegistryEntry::get).forEach(this::createHorizontalFacing);
        ModBlocks.HANGING_TROPHIES.stream().map(RegistryEntry::get).forEach(this::createHorizontalFacing);
        ModBlocks.STATUE_TROPHIES.stream().map(RegistryEntry::get).forEach(this::createStatue);

        ModBlocks.CHAIRS.stream().map(RegistryEntry::get).forEach(this::createChair);
        ModBlocks.WOODEN_BENCHES.stream().map(RegistryEntry::get).forEach(this::createBench);
        ModBlocks.METAL_BENCHES.stream().map(RegistryEntry::get).forEach(this::createMetalBench);
        ModBlocks.COUCHES.stream().map(RegistryEntry::get).forEach(this::createCouch);
        ModBlocks.DINING_BENCHES.stream().map(RegistryEntry::get).forEach(this::createDiningBench);
        ModBlocks.FANCY_BEDS.stream().map(RegistryEntry::get).forEach(this::createFancyBed);

        createJar(ModBlocks.BERRY_JAM_JAR.get());
        createStackableBook(ModBlocks.STACKABLE_BOOK.get());
        ModBlocks.CROCKERY_COMBOS.stream().map(RegistryEntry::get).forEach(b -> createHorizontalFacing(b, "crockery/combo"));
        ModBlocks.BOWLS.stream().map(RegistryEntry::get).forEach(b -> createCrockery(b, "bowl"));
        ModBlocks.CUPS.stream().map(RegistryEntry::get).forEach(b -> createCrockery(b, "cup"));
        ModBlocks.PLATES.stream().map(RegistryEntry::get).forEach(b -> createCrockery(b, "plate"));
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache) {
        createHighlights();
        CompletableFuture<?>[] futures = new CompletableFuture<?>[highlights.size()];
        int i = 0;
        for (var entry : highlights.entrySet()) {
            futures[i++] = saveHighlight(cache, entry.getValue(), entry.getKey());
        }
        return CompletableFuture.allOf(futures);
    }

    public void createHorizontalFacing(Block block) {
        createHorizontalFacing(block, "%s_shape".formatted(name(block)));
    }

    public void createHorizontalFacing(Block block, String shape) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(HorizontalDirectionalBlock.FACING);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", "%s:%s".formatted(Handcrafted.MOD_ID, shape));
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s".formatted(facing.getName().toLowerCase(Locale.ROOT)), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createStatue(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(StatueTrophyBlock.FACING);
            DoubleBlockHalf half = state.getValue(StatueTrophyBlock.HALF);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":statue/" + name(block) + "_shape");
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            if (half == DoubleBlockHalf.UPPER) {
                JsonArray translationJson = new JsonArray();
                translationJson.add(0);
                translationJson.add(-1);
                translationJson.add(0);
                stateJson.add("translation", translationJson);
            }

            variantsJson.add("facing=%s,half=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), half.name().toLowerCase(Locale.ROOT)), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createChair(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(ChairBlock.FACING);
            OptionalColorProperty color = state.getValue(ChairBlock.COLOR);
            boolean hasCushion = color != OptionalColorProperty.NONE;

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":chair/" + (hasCushion ? "chair_cushion_shape" : "chair_shape"));
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,color=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), color.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createBench(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(BenchBlock.FACING);
            ModularSeatProperty shape = state.getValue(BenchBlock.SHAPE);
            OptionalColorProperty color = state.getValue(BenchBlock.COLOR);
            boolean hasCushion = color != OptionalColorProperty.NONE;

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":bench/" + shape.getLocation() + (hasCushion ? "_cushion" : ""));
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360 + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0));
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,shape=%s,color=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), shape.getSerializedName(), color.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createMetalBench(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(BenchBlock.FACING);
            ModularSeatProperty shape = state.getValue(BenchBlock.SHAPE);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":metal_bench/" + shape.getLocation());
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360 + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0));
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,shape=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), shape.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createCouch(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(CouchBlock.FACING);
            ModularSeatProperty shape = state.getValue(CouchBlock.SHAPE);
            ColorProperty color = state.getValue(CouchBlock.COLOR);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":couch/" + shape.getLocation());
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360 + (shape == ModularSeatProperty.OUTER_LEFT || shape == ModularSeatProperty.INNER_LEFT ? -90 : 0));
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,shape=%s,color=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), shape.getSerializedName(), color.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createDiningBench(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(DiningBenchBlock.FACING);
            DirectionalBlockProperty shape = state.getValue(DiningBenchBlock.SHAPE);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":dining_bench/" + shape.getSerializedName());
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,shape=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), shape.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createJar(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(StackableJarBlock.FACING);
            int jars = state.getValue(StackableJarBlock.JARS);
            String amount = switch (jars) {
                case 2 -> "double";
                case 3 -> "triple";
                default -> "single";
            };

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":jar/" + amount);
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,jars=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), jars), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createCrockery(Block block, String type) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(CrockeryBlock.FACING);
            int pieces = state.getValue(CrockeryBlock.PIECES);
            String amount = CrockeryBlock.piecesName(state);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":crockery/" + type + "/" + amount);
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,pieces=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), pieces), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createStackableBook(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(StackableBookBlock.FACING);
            int books = state.getValue(StackableBookBlock.BOOKS);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":stackable_book/" + StackableBookBlock.bookName(state));
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            variantsJson.add("facing=%s,books=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), books), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    public void createFancyBed(Block block) {
        JsonObject highlightJson = new JsonObject();
        JsonObject variantsJson = new JsonObject();
        highlightJson.add("variants", variantsJson);

        block.getStateDefinition().getPossibleStates().forEach(state -> {
            Direction facing = state.getValue(FancyBedBlock.FACING);
            BedPart part = state.getValue(FancyBedBlock.PART);
            DirectionalBlockProperty shape = state.getValue(FancyBedBlock.SHAPE);

            JsonObject stateJson = new JsonObject();
            stateJson.addProperty("highlight", Handcrafted.MOD_ID + ":fancy_bed/" + shape);
            JsonObject rotationJson = new JsonObject();
            rotationJson.addProperty("y", ((int) (facing.toYRot()) + 180) % 360);
            stateJson.add("rotation", rotationJson);

            if (part == BedPart.HEAD) {
                JsonArray translationJson = new JsonArray();
                translationJson.add(-facing.getNormal().getX());
                translationJson.add(-facing.getNormal().getY());
                translationJson.add(-facing.getNormal().getZ());
                stateJson.add("translation", translationJson);
            }

            variantsJson.add("facing=%s,part=%s,shape=%s".formatted(facing.getName().toLowerCase(Locale.ROOT), part.name().toLowerCase(Locale.ROOT), shape.getSerializedName()), stateJson);
        });

        highlights.put(block, highlightJson);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private CompletableFuture<?> saveHighlight(CachedOutput cache, JsonObject stateJson, Block owner) {
        ResourceLocation blockName = Preconditions.checkNotNull(key(owner));
        Path outputPath = this.output.getOutputFolder(PackOutput.Target.RESOURCE_PACK)
            .resolve(blockName.getNamespace()).resolve("resourcefullib/highlights").resolve(blockName.getPath() + ".json");
        return DataProvider.saveStable(cache, stateJson, outputPath);
    }

    @NotNull
    @Override
    public String getName() {
        return "Handcrafted Highlight States";
    }
}
