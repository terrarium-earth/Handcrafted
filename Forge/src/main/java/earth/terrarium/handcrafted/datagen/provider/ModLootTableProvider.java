package earth.terrarium.handcrafted.datagen.provider;

import com.mojang.datafixers.util.Pair;
import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.block.CushionBlock;
import earth.terrarium.handcrafted.common.block.chair.bench.BenchBlock;
import earth.terrarium.handcrafted.common.block.chair.chair.ChairBlock;
import earth.terrarium.handcrafted.common.block.chair.couch.CouchBlock;
import earth.terrarium.handcrafted.common.block.chair.tablebench.TableBenchBlock;
import earth.terrarium.handcrafted.common.block.chair.woodenbench.WoodenBenchBlock;
import earth.terrarium.handcrafted.common.block.counter.CounterBlock;
import earth.terrarium.handcrafted.common.block.counter.CupboardBlock;
import earth.terrarium.handcrafted.common.block.counter.DrawerBlock;
import earth.terrarium.handcrafted.common.block.counter.ShelfBlock;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryBlock;
import earth.terrarium.handcrafted.common.block.crockery.CrockeryComboBlock;
import earth.terrarium.handcrafted.common.block.fancybed.FancyBedBlock;
import earth.terrarium.handcrafted.common.block.pot.PotBlock;
import earth.terrarium.handcrafted.common.block.stackablebook.StackableBookBlock;
import earth.terrarium.handcrafted.common.block.stackablejar.StackableJarBlock;
import earth.terrarium.handcrafted.common.block.table.desk.DeskBlock;
import earth.terrarium.handcrafted.common.block.table.nightstand.NightstandBlock;
import earth.terrarium.handcrafted.common.block.table.side_table.SideTableBlock;
import earth.terrarium.handcrafted.common.block.table.table.TableBlock;
import earth.terrarium.handcrafted.common.block.trim.CornerTrimBlock;
import earth.terrarium.handcrafted.common.block.trim.TrimBlock;
import earth.terrarium.handcrafted.common.block.trophy.HangingTrophyBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyBlock;
import earth.terrarium.handcrafted.common.block.trophy.StatueTrophyEntityBlock;
import earth.terrarium.handcrafted.common.block.trophy.WallTrophyBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            ForgeRegistries.BLOCKS.getValues().forEach(block -> {
                ResourceLocation blockId = ForgeRegistries.BLOCKS.getKey(block);
                if (blockId.getNamespace().equals(Handcrafted.MOD_ID)) {
                    if (block instanceof CushionBlock) {
                        dropSelf(block);
                    } else if (block instanceof StackableBookBlock) {
                        dropSelf(block);
                    } else if (block instanceof ChairBlock) {
                        dropSelf(block);
                    } else if (block instanceof TableBlock) {
                        dropSelf(block);
                    } else if (block instanceof WoodenBenchBlock) {
                        dropSelf(block);
                    } else if (block instanceof BenchBlock) {
                        dropSelf(block);
                    } else if (block instanceof CouchBlock) {
                        dropSelf(block);
                    } else if (block instanceof FancyBedBlock) {
                        this.add(block, (arg) -> createSinglePropConditionTable(arg, BedBlock.PART, BedPart.HEAD));
                    } else if (block instanceof TableBenchBlock) {
                        dropSelf(block);
                    } else if (block instanceof NightstandBlock) {
                        dropSelf(block);
                    } else if (block instanceof DeskBlock) {
                        dropSelf(block);
                    } else if (block instanceof SideTableBlock) {
                        dropSelf(block);
                    } else if (block instanceof CounterBlock) {
                        dropOther(block, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, blockId.getPath().substring(0, blockId.getPath().length() - 2))));
                    } else if (block instanceof DrawerBlock) {
                        dropOther(block, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, blockId.getPath().substring(0, blockId.getPath().length() - 2))));
                    } else if (block instanceof CupboardBlock) {
                        dropOther(block, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, blockId.getPath().substring(0, blockId.getPath().length() - 2))));
                    } else if (block instanceof ShelfBlock) {
                        dropOther(block, ForgeRegistries.ITEMS.getValue(new ResourceLocation(Handcrafted.MOD_ID, blockId.getPath().substring(0, blockId.getPath().length() - 2))));
                    } else if (block instanceof TrimBlock) {
                        dropSelf(block);
                    } else if (block instanceof CornerTrimBlock) {
                        dropSelf(block);
                    } else if (block instanceof StackableJarBlock) {
                        dropSelf(block);
                    } else if (block instanceof CrockeryBlock) {
                        dropSelf(block);
                    } else if (block instanceof CrockeryComboBlock) {
                        dropSelf(block);
                    } else if (block instanceof PotBlock) {
                        dropSelf(block);
                    } else if (block instanceof WallTrophyBlock) {
                        dropSelf(block);
                    } else if (block instanceof HangingTrophyBlock) {
                        dropSelf(block);
                    } else if (block instanceof StatueTrophyBlock) {
                        dropSelf(block);
                    } else if (block instanceof StatueTrophyEntityBlock) {
                        dropSelf(block);
                    }
                }
            });
            dropSelf(ModBlocks.OVEN.get());
            dropSelf(ModBlocks.KITCHEN_HOOD.get());
            dropSelf(ModBlocks.KITCHEN_HOOD_PIPE.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> ForgeRegistries.BLOCKS.getKey(b).getNamespace().equals(Handcrafted.MOD_ID)).toList();
        }
    }
}
