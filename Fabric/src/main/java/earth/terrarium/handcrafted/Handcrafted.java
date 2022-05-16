package earth.terrarium.handcrafted;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;

public class Handcrafted implements ModInitializer {
    public static final String MOD_ID = "handcrafted";
    public static final CommonUtils.RegistryObject<EntityType<ChairSeatEntity>> SEAT_ENTITY = new CommonUtils.RegistryObject<>(() -> FabricEntityTypeBuilder.<ChairSeatEntity>create(MobCategory.MISC, ChairSeatEntity::new).dimensions(EntityDimensions.fixed(0.001F, 0.001F)).build());
    public static final CreativeModeTab TAB = FabricItemGroupBuilder.build(new ResourceLocation(MOD_ID, "tab"), () -> new ItemStack(HandcraftedBlocks.NORDIC_PLANKS.get()));

    static final Map<String, CommonUtils.RegistryObject<? extends Block>> BLOCK_FACTORIES = new LinkedHashMap<>();

    @Override
    public void onInitialize() {
        HandcraftedBlocks.resolveClass();

        for (Map.Entry<String, CommonUtils.RegistryObject<? extends Block>> entry : BLOCK_FACTORIES.entrySet()) {
            final Block block = entry.getValue().initialize();
            Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, entry.getKey()), new BlockItem(block, new Item.Properties().tab(TAB)));
            Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID, entry.getKey()), block);
        }

        Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(MOD_ID, "chair_seat"), SEAT_ENTITY.initialize());
    }
}
