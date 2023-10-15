package earth.terrarium.handcrafted.fabric;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.blocks.FancyBedBlock;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.mixins.common.fabric.PoiTypesAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

import java.util.Set;
import java.util.stream.Collectors;

public class HandcraftedFabric {

    public static void init() {
        Handcrafted.init();
        addBedPoi();
    }

    public static void addBedPoi() {
        Set<BlockState> states = ModBlocks.FANCY_BEDS.stream().flatMap(b ->
                b.get().getStateDefinition().getPossibleStates().stream()
                    .filter(b2 -> b2.getValue(FancyBedBlock.PART) == BedPart.HEAD))
            .collect(Collectors.toSet());

        Holder.Reference<PoiType> holder = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolderOrThrow(PoiTypes.HOME);
        states.forEach(s -> PoiTypesAccessor.getTypeByState().put(s, holder));
    }
}
