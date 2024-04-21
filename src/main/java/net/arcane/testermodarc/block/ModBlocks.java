package net.arcane.testermodarc.block;


import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TesterModArc.MOD_ID);
        //register new blocks here! Select properties or copy existing ones
    public static final RegistryObject<Block> Soul_Sapphire_Block = registerBlock("soul_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK))); //registers block, copies existing properties
    public static final RegistryObject<Block> Raw_Soul_Sapphire_Block = registerBlock("raw_soul_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    //ore block added, strength = time to mine, experienceblock for ore
    public static final RegistryObject<Block> Soul_Sapphire_Ore = registerBlock("soul_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,8)));
    public static final RegistryObject<Block> Deepslate_Soul_Sapphire_Ore = registerBlock("deepslate_soul_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(6,10)));
    public static final RegistryObject<Block> Netherrack_Soul_Sapphire_Ore = registerBlock("netherrack_soul_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,8)));
    public static final RegistryObject<Block> End_Stone_Soul_Sapphire_Ore = registerBlock("end_stone_soul_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(6,15)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        //registers block item, then returns it
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn);
        return toReturn;

    }

    //registering item with block that has been registered. helper method to associate block with item
    private static <T extends Block>RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
