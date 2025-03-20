package net.arcane.testermodarc.block;


import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.custom.CornCropBlock;
import net.arcane.testermodarc.block.custom.SoundBlock;
import net.arcane.testermodarc.block.custom.StrawberryCropBlock;
import net.arcane.testermodarc.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
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
    public static final RegistryObject<Block> Sound_Block = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> Soul_Sapphire_stairs = registerBlock("soul_sapphire_stairs",
            () -> new StairBlock(() -> ModBlocks.Soul_Sapphire_Block.get().defaultBlockState(),
                    (BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK))));
    public static final RegistryObject<Block> Soul_Sapphire_Slab = registerBlock("soul_sapphire_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> Soul_Sapphire_Button = registerBlock("soul_sapphire_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.AMETHYST),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> Soul_Sapphire_Pressure_Plate = registerBlock("soul_sapphire_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> Soul_Sapphire_Fence = registerBlock("soul_sapphire_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> Soul_Sapphire_Fence_Gate = registerBlock("soul_sapphire_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> Soul_Sapphire_wall = registerBlock("soul_sapphire_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> Soul_Sapphire_Door = registerBlock("soul_sapphire_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).noOcclusion(), BlockSetType.CHERRY));
    public static final RegistryObject<Block> Soul_Sapphire_TrapDoor = registerBlock("soul_sapphire_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK).noOcclusion(), BlockSetType.CHERRY));

    public static final RegistryObject<Block> Strawberry_Crop = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));


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
