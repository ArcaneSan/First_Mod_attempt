package net.arcane.testermodarc.datagen.loot;

import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.item.ModItems;
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




            this.add(ModBlocks.Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.Deepslate_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Deepslate_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.Netherrack_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.Netherrack_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
            this.add(ModBlocks.End_Stone_Soul_Sapphire_Ore.get(),
                block -> createCopperLikeOreDrops(ModBlocks.End_Stone_Soul_Sapphire_Ore.get(), ModItems.RAW_SOUL_SAPPHIRE.get()));
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
