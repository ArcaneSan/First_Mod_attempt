package net.arcane.testermodarc.datagen;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        stairsBlock(((StairBlock) ModBlocks.Soul_Sapphire_stairs.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));
        slabBlock(((SlabBlock) ModBlocks.Soul_Sapphire_Slab.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));

        buttonBlock(((ButtonBlock) ModBlocks.Soul_Sapphire_Button.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.Soul_Sapphire_Pressure_Plate.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));

        fenceBlock(((FenceBlock) ModBlocks.Soul_Sapphire_Fence.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.Soul_Sapphire_Fence_Gate.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));
        wallBlock(((WallBlock) ModBlocks.Soul_Sapphire_wall.get()), blockTexture(ModBlocks.Soul_Sapphire_Block.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.Soul_Sapphire_Door.get()), modLoc("block/soul_sapphire_door_bottom"), modLoc("block/soul_sapphire_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.Soul_Sapphire_TrapDoor.get()), modLoc("block/soul_sapphire_trapdoor"), true, "cutout");


    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
