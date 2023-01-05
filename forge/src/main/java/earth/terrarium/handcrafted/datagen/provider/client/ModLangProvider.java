package earth.terrarium.handcrafted.datagen.provider.client;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.codehaus.plexus.util.StringUtils;

import java.util.Objects;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, Handcrafted.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.handcrafted.main", "Handcrafted");
        add("tooltip.handcrafted.board_help", "Obtained by throwing planks on a Stone Cutter");
        add("tooltip.handcrafted.counter_help", "Place a wood or stone material to change the counter surface");
        add("tooltip.handcrafted.cushion_help", "Place on furniture to change the color");
        add("tooltip.handcrafted.hammer_help", "Changes the look of blocks");
        add("tooltip.handcrafted.hammerable_help", "Hammer to change the look of this block");
        add("tooltip.handcrafted.hold_shift", "Hold shift for more info");
        add("tooltip.handcrafted.kitchen_hood_pipe_hammer", "Hammer to change the direction");
        add("tooltip.handcrafted.sheet_help", "Place on furniture to change the color");
        add("tooltip.handcrafted.shelf_help", "Holds: Potions, Books, Crockery, and Cobwebs");

        ModBlocks.BLOCKS.stream().forEach(block -> {
            addBlock(block, StringUtils.capitaliseAllWords(Objects.requireNonNull(block.getId()).getPath()
                    .replace("_1", "")
                    .replace("_2", "")
                    .replace("_3", "")
                    .replace("_4", "")
                    .replace("_", " ")
            ));
        });

        ModItems.ITEMS.stream().forEach(item -> {
            if (!(item.get() instanceof BlockItem)) {
                addItem(item, StringUtils.capitaliseAllWords(Objects.requireNonNull(item.getId()).getPath().replace("_", " ")));
            }
        });

        ModEntityTypes.ENTITY_TYPES.stream().forEach(entity -> {
            ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(entity.get());
            assert id != null;
            addEntityType(entity, StringUtils.capitaliseAllWords(id.getPath().replace("_", " ")));
        });
    }
}
