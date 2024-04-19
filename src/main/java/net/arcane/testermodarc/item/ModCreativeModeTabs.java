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
                    }))
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
