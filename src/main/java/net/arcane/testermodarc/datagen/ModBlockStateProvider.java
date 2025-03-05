package net.arcane.testermodarc.datagen;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TesterModArc.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.Soul_Sapphire_Block);
        blockWithItem(ModBlocks.Raw_Soul_Sapphire_Block);

        blockWithItem(ModBlocks.Soul_Sapphire_Ore);
        blockWithItem(ModBlocks.Deepslate_Soul_Sapphire_Ore);
        blockWithItem(ModBlocks.Netherrack_Soul_Sapphire_Ore);
        blockWithItem(ModBlocks.End_Stone_Soul_Sapphire_Ore);

        blockWithItem(ModBlocks.Sound_Block);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
