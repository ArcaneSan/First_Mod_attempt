package net.arcane.testermodarc.datagen.loot;

import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.block.custom.CornCropBlock;
import net.arcane.testermodarc.block.custom.StrawberryCropBlock;
import net.arcane.testermodarc.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
            this.dropSelf(ModBlocks.Soul_Sapphire_Block.get());
            this.dropSelf(ModBlocks.Raw_Soul_Sapphire_Block.get());
            this.dropSelf(ModBlocks.Sound_Block.get());

            this.dropSelf(ModBlocks.Soul_Sapphire_TrapDoor.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_Fence.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_stairs.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_Fence_Gate.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_Button.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_Pressure_Plate.get());
            this.dropSelf(ModBlocks.Soul_Sapphire_wall.get());

            this.add(ModBlocks.Soul_Sapphire_Slab.get(),
                    block -> createSlabItemTable(ModBlocks.Soul_Sapphire_Slab.get()));
            this.add(ModBlocks.Soul_Sapphire_Door.get(),
                    block -> createDoorTable(ModBlocks.Soul_Sapphire_Door.get()));


            this.add(ModBlocks.Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.Deepslate_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Deepslate_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.Netherrack_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Netherrack_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.End_Stone_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.End_Stone_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.Strawberry_Crop.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ModBlocks.Strawberry_Crop.get(), createCropDrops(ModBlocks.Strawberry_Crop.get(), ModItems.STRAWBERRY.get(),
                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));

        // LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
        //         .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
        //         .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8));

        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.Corn.get(),
                ModItems.CORN_SEEDS.get(), lootitemcondition$builder2));


    }



    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock,
                LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
