package earth.terrarium.handcrafted.datagen.provider.client;

import earth.terrarium.handcrafted.Handcrafted;
import earth.terrarium.handcrafted.common.constants.ConstantComponents;
import earth.terrarium.handcrafted.common.registry.ModBlocks;
import earth.terrarium.handcrafted.common.registry.ModEntityTypes;
import earth.terrarium.handcrafted.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;

public class ModLangProvider extends LanguageProvider {
    public ModLangProvider(PackOutput output) {
        super(output, Handcrafted.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ModBlocks.BLOCKS.stream()
            .forEach(entry -> addBlock(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModItems.ITEMS.stream()
            .filter(i -> !(i.get() instanceof BlockItem))
            .forEach(entry -> addItem(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModEntityTypes.ENTITY_TYPES.stream()
            .forEach(entry -> addEntityType(entry,
                StringUtils.capitaliseAllWords(entry
                    .getId()
                    .getPath()
                    .replace("_", " "))));

        ModItems.CUSHIONS.stream()
            .forEach(entry -> add("item.handcrafted.%s".formatted(entry.getId().getPath()), StringUtils.capitaliseAllWords(entry
                .getId()
                .getPath()
                .replace("_", " "))));

        add("itemGroup.handcrafted.main", "Handcrafted");

        add(ConstantComponents.HAMMER.getString(), "Changes the look of blocks.");
        add(ConstantComponents.HAMMER_USE_LOOK.getString(), "Right-click with a hammer to change the block's look.");
        add(ConstantComponents.HAMMER_USE_SHAPE.getString(), "Right-click with a hammer to change the block's shape.");
        add(ConstantComponents.HAMMER_USE_LOOK_SHIFT.getString(), "Shift-right-click with a hammer to change the block's look.");
        add(ConstantComponents.COUNTER.getString(), "Right-click with wood or stone to change the counter surface.");

        add(ConstantComponents.PLACE_ON_FURNITURE.getString(), "Can be placed on furniture.");
        add(ConstantComponents.CUSHION.getString(), "Right-click with a cushion to change the block's look.");
        add(ConstantComponents.SHEET.getString(), "Right-click with a sheet to change the block's look.");
        add(ConstantComponents.BED_PILLOW.getString(), "Right-click with a cushion to change the bed's pillow color.");
        add(ConstantComponents.BED_SHEET.getString(), "Right-click with a sheet to change the bedsheets.");

        add("subtitles.handcrafted.block.hammer_wood", "Wood is Hammered");
        add("subtitles.handcrafted.block.hammer_stone", "Stone is Hammered");

        add("tag.item.handcrafted.cushions", "Cushions");
        add("tag.item.handcrafted.sheets", "Sheets");
        add("tag.item.handcrafted.couches", "Couches");
        add("tag.item.handcrafted.chairs", "Chairs");
        add("tag.item.handcrafted.dining_benches", "Dining Benches");
        add("tag.item.handcrafted.side_tables", "Side Tables");
        add("tag.item.handcrafted.desks", "Desks");
        add("tag.item.handcrafted.nightstands", "Nightstands");
        add("tag.item.handcrafted.tables", "Tables");
        add("tag.item.handcrafted.fancy_beds", "Fancy Beds");
        add("tag.item.handcrafted.counters", "Counters");
        add("tag.item.handcrafted.cupboards", "Cupboards");
        add("tag.item.handcrafted.drawers", "Drawers");
        add("tag.item.handcrafted.shelves", "Shelves");
        add("tag.item.handcrafted.pots", "Pots");
        add("tag.item.handcrafted.trims", "Trims");
        add("tag.item.handcrafted.trophies", "Trophies");
        add("tag.item.handcrafted.crockery", "Crockery");
        add("tag.item.handcrafted.cups", "Cups");
        add("tag.item.handcrafted.plates", "Plates");
        add("tag.item.handcrafted.bowls", "Bowls");
        add("tag.item.handcrafted.crockery_combos", "Crockery Combos");
    }
}
