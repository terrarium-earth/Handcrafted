package earth.terrarium.handcrafted.datagen.provider.server;

import com.mojang.datafixers.util.Pair;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlock;
import earth.terrarium.handcrafted.common.block.stackablejar.StackableJarBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = new ArrayList<>();
        tables.add(Pair.of(BlockLootTables::new, LootContextParamSets.BLOCK));
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationTracker) {
    }

    public static class BlockLootTables extends BlockLoot {
        @Override
        protected void addTables() {
            ModBlocks.CUSHIONS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.STACKABLE_BOOKS.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(b, LootItem.lootTableItem(b).apply(List.of(2, 3, 4), (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(arg).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StackableBookBlock.BOOKS, integer)))))))));
            ModBlocks.CHAIRS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.TABLES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.BENCHES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.COUCHES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.FANCY_BEDS.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> createSinglePropConditionTable(arg, BedBlock.PART, BedPart.HEAD)));
            ModBlocks.DINING_BENCHES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.NIGHTSTANDS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.DESKS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.SIDE_TABLES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.COUNTERS.stream().map(RegistryEntry::get).forEach(b -> dropOther(b, Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, ForgeRegistries.BLOCKS.getKey(b).getPath().substring(0, ForgeRegistries.BLOCKS.getKey(b).getPath().length() - 2))))));
            ModBlocks.DRAWERS.stream().map(RegistryEntry::get).forEach(b -> dropOther(b, Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, ForgeRegistries.BLOCKS.getKey(b).getPath().substring(0, ForgeRegistries.BLOCKS.getKey(b).getPath().length() - 2))))));
            ModBlocks.CUPBOARDS.stream().map(RegistryEntry::get).forEach(b -> dropOther(b, Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, ForgeRegistries.BLOCKS.getKey(b).getPath().substring(0, ForgeRegistries.BLOCKS.getKey(b).getPath().length() - 2))))));
            ModBlocks.SHELVES.stream().map(RegistryEntry::get).forEach(b -> dropOther(b, Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, ForgeRegistries.BLOCKS.getKey(b).getPath().substring(0, ForgeRegistries.BLOCKS.getKey(b).getPath().length() - 2))))));
            ModBlocks.TRIMS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.CUPS.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(applyExplosionDecay(b, LootItem.lootTableItem(arg).apply(List.of(2, 3, 4, 5, 6), (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(arg).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CrockeryBlock.PIECES, integer)))))))));
            ModBlocks.PLATES.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(applyExplosionDecay(b, LootItem.lootTableItem(arg).apply(List.of(2, 3, 4, 5, 6), (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(arg).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CrockeryBlock.PIECES, integer)))))))));
            ModBlocks.BOWLS.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(applyExplosionDecay(b, LootItem.lootTableItem(arg).apply(List.of(2, 3, 4, 5, 6), (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(arg).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CrockeryBlock.PIECES, integer)))))))));
            ModBlocks.CROCKERY_COMBOS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.POTS.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.TROPHIES.stream().map(RegistryEntry::get).forEach(this::dropSelf);
            ModBlocks.STATUE_TROPHIES.stream().map(RegistryEntry::get).forEach(b -> this.add(b, (arg) -> createSinglePropConditionTable(arg, StatueBlock.HALF, DoubleBlockHalf.LOWER)));

            dropSelf(ModBlocks.OVEN.get());
            dropSelf(ModBlocks.KITCHEN_HOOD.get());
            dropSelf(ModBlocks.KITCHEN_HOOD_PIPE.get());
            this.add(ModBlocks.BERRY_JAM_JAR.get(), (arg) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(this.applyExplosionDecay(ModBlocks.BERRY_JAM_JAR.get(), LootItem.lootTableItem(ModBlocks.BERRY_JAM_JAR.get()).apply(List.of(2, 3), (integer) -> SetItemCountFunction.setCount(ConstantValue.exactly((float) integer)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(arg).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StackableJarBlock.JARS, integer))))))));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.stream().map(RegistryEntry::get).toList();
        }
    }
}
