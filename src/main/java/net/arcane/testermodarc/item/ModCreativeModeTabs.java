package net.arcane.testermodarc.item;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.rmi.registry.Registry;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TesterModArc.MOD_ID);
    //registering new creative tab, and selecting item to display
    public static final RegistryObject<CreativeModeTab> TESTER_TAB = CREATIVE_MODE_TABS.register("tester_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOUL_SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tester_tab"))
                    .displayItems(((itemDisplayParameters, output) ->
                    {
                        output.accept(ModItems.SOUL_SAPPHIRE.get());
                        output.accept(ModItems.RAW_SOUL_SAPPHIRE.get());
                        output.accept(ModBlocks.Soul_Sapphire_Block.get());
                        output.accept(ModBlocks.Raw_Soul_Sapphire_Block.get());
                        output.accept(ModBlocks.Soul_Sapphire_Ore.get());
                        output.accept(ModBlocks.Deepslate_Soul_Sapphire_Ore.get());
                        output.accept(ModBlocks.Netherrack_Soul_Sapphire_Ore.get());
                        output.accept(ModBlocks.End_Stone_Soul_Sapphire_Ore.get());

                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModBlocks.Sound_Block.get());
                        output.accept(ModItems.STRAWBERRY.get());
                        output.accept(ModItems.PINE_CONE.get());

                        output.accept(ModBlocks.Soul_Sapphire_Door.get());
                        output.accept(ModBlocks.Soul_Sapphire_TrapDoor.get());
                        output.accept(ModBlocks.Soul_Sapphire_stairs.get());
                        output.accept(ModBlocks.Soul_Sapphire_Slab.get());
                        output.accept(ModBlocks.Soul_Sapphire_wall.get());
                        output.accept(ModBlocks.Soul_Sapphire_Button.get());
                        output.accept(ModBlocks.Soul_Sapphire_Pressure_Plate.get());
                        output.accept(ModBlocks.Soul_Sapphire_Fence.get());
                        output.accept(ModBlocks.Soul_Sapphire_Fence_Gate.get());

                        output.accept(ModItems.SOUL_SAPPHIRE_SWORD.get());
                        output.accept(ModItems.CHINESE_SABER.get());
                        output.accept(ModItems.SAPPHIRE_STAFF.get());

                        output.accept(ModItems.STRAWBERRY_SEEDS.get());

                        output.accept(ModItems.SOUL_SAPPHIRE_PICKAXE.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_AXE.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_HOE.get());

                        output.accept(ModItems.SOUL_SAPPHIRE_SHOVEL.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_HELMET.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_CHESTPLATE.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_LEGGINGS.get());
                        output.accept(ModItems.SOUL_SAPPHIRE_BOOTS.get());

                    }))
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
