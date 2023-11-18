package earth.terrarium.handcrafted.datagen.provider.server;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.handcrafted.common.blocks.FancyBedBlock;
import earth.terrarium.handcrafted.common.blocks.StackableBookBlock;
import earth.terrarium.handcrafted.common.blocks.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.blocks.misc.StackableJarBlock;
import earth.terrarium.handcrafted.common.blocks.trophies.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(new SubProviderEntry(BlockLootTables::new, LootContextParamSets.BLOCK)));
    }

    private static class BlockLootTables extends BlockLootSubProvider {
        protected BlockLootTables() {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags());
        }

        @Override
        protected void generate() {
            dropSelf(ModBlocks.OVEN.get());
            dropSelf(ModBlocks.KITCHEN_HOOD.get());
            dropSelf(ModBlocks.KITCHEN_HOOD_PIPE.get());
            add(ModBlocks.BERRY_JAM_JAR.get(), this::createJarDrops);
            add(ModBlocks.STACKABLE_BOOK.get(), this::createStackableBookDrops);

            addSet(ModBlocks.CUSHIONS);
            addSet(ModBlocks.BENCHES);
            addSet(ModBlocks.COUCHES);
            addSet(ModBlocks.CHAIRS);
            addSet(ModBlocks.DINING_BENCHES);
            addSet(ModBlocks.SIDE_TABLES);
            addSet(ModBlocks.DESKS);
            addSet(ModBlocks.NIGHTSTANDS);
            addSet(ModBlocks.TABLES);
            ModBlocks.FANCY_BEDS.stream().forEach(b -> add(b.get(), b2 ->
                createSinglePropConditionTable(b2, FancyBedBlock.PART, BedPart.HEAD)));
            addSet(ModBlocks.COUNTERS);
            addSet(ModBlocks.CUPBOARDS);
            addSet(ModBlocks.DRAWERS);
            addSet(ModBlocks.SHELVES);
            addSet(ModBlocks.POTS);
            addSet(ModBlocks.TRIMS);
            addSet(ModBlocks.WALL_TROPHIES);
            addSet(ModBlocks.HANGING_TROPHIES);
            ModBlocks.STATUE_TROPHIES.stream().forEach(b -> add(b.get(), b2 ->
                createSinglePropConditionTable(b2, StatueTrophyBlock.HALF, DoubleBlockHalf.LOWER)));
            ModBlocks.CUPS.stream().forEach(b -> add(b.get(), this::createCrockeryDrops));
            ModBlocks.PLATES.stream().forEach(b -> add(b.get(), this::createCrockeryDrops));
            ModBlocks.BOWLS.stream().forEach(b -> add(b.get(), this::createCrockeryDrops));
            addSet(ModBlocks.CROCKERY_COMBOS);

        }

        protected LootTable.Builder createJarDrops(Block block) {
            return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(List.of(2, 3), i ->
                    SetItemCountFunction.setCount(ConstantValue.exactly(i))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(StackableJarBlock.JARS, i)))))));
        }

        protected LootTable.Builder createStackableBookDrops(Block block) {
            return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(List.of(2, 3, 4), i ->
                    SetItemCountFunction.setCount(ConstantValue.exactly(i))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(StackableBookBlock.BOOKS, i)))))));
        }

        protected LootTable.Builder createCrockeryDrops(Block block) {
            return LootTable.lootTable().withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(this.applyExplosionDecay(block, LootItem.lootTableItem(block).apply(List.of(2, 3, 4, 5, 6), i ->
                    SetItemCountFunction.setCount(ConstantValue.exactly(i))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CrockeryBlock.PIECES, i)))))));
        }

        private void addSet(ResourcefulRegistry<Block> registry) {
            registry.stream().forEach(b -> dropSelf(b.get()));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.stream().map(RegistryEntry::get).toList();
        }
    }
}
