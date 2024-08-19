package net.arcane.testermodarc.item;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TesterModArc.MOD_ID);

    public static final RegistryObject<Item> SOUL_SAPPHIRE =
            ITEMS.register("soul_sapphire",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SOUL_SAPPHIRE =
            ITEMS.register("raw_soul_sapphire",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR =
            ITEMS.register("metal_detector",() -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
