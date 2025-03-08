package net.arcane.testermodarc.item;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.item.custom.FuelItem;
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
    public static final RegistryObject<Item> SOUL_SAPPHIRE_SWORD =
            ITEMS.register("soul_sapphire_sword",() -> new Item(new Item.Properties().durability(1000)));
    public static final RegistryObject<Item> CHINESE_SABER =
            ITEMS.register("chinese_saber",() -> new Item(new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> STRAWBERRY =
            ITEMS.register("strawberry",() -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> PINE_CONE =
            ITEMS.register("pine_cone",() -> new FuelItem(new Item.Properties(), 400));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
