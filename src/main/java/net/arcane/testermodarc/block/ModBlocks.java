package net.arcane.testermodarc.block;


import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        //register new blocks here!
    public static final RegistryObject<Block> Soul_Sapphire_Block = registerBlock("soul_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK))); //registers block, copies existing properties
    public static final RegistryObject<Block> Raw_Soul_Sapphire_Block = registerBlock("raw_soul_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK)));

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