package net.arcane.testermodarc.datagen;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.block.custom.CornCropBlock;
import net.arcane.testermodarc.block.custom.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

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

        makeStrawberryCrop((CropBlock) ModBlocks.Strawberry_Crop.get(), "strawberry_stage", "strawberry_stage");
        makeCornCrop(((CropBlock) ModBlocks.CORN_CROP.get()), "corn_stage_", "corn_stage_");


    }

    public void makeStrawberryCrop (CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberrystates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }



    private ConfiguredModel[] strawberrystates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(TesterModArc.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeCornCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cornStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cornStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((CornCropBlock) block).getAgeProperty()),
                new ResourceLocation(TesterModArc.MOD_ID, "block/" + textureName + state.getValue(((CornCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
