package net.arcane.testermodarc.datagen;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {


    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TesterModArc.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.Soul_Sapphire_Ore.get()).addTags(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.Soul_Sapphire_Block.get(),
                        ModBlocks.Soul_Sapphire_Ore.get(),
                        ModBlocks.Deepslate_Soul_Sapphire_Ore.get(),
                        ModBlocks.Netherrack_Soul_Sapphire_Ore.get(),
                        ModBlocks.End_Stone_Soul_Sapphire_Ore.get(),
                        ModBlocks.Raw_Soul_Sapphire_Block.get(),
                        ModBlocks.Sound_Block.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.Soul_Sapphire_Block.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.Raw_Soul_Sapphire_Block.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.Netherrack_Soul_Sapphire_Ore.get());

    }
}
