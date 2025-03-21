package net.arcane.testermodarc.item;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.item.custom.FuelItem;
import net.arcane.testermodarc.item.custom.MetalDetectorItem;
import net.arcane.testermodarc.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
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
            ITEMS.register("soul_sapphire_sword",() -> new SwordItem(ModToolTiers.SOUL_SAPPHIRE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_PICKAXE =
            ITEMS.register("soul_sapphire_pickaxe",() -> new PickaxeItem(ModToolTiers.SOUL_SAPPHIRE, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_AXE =
            ITEMS.register("soul_sapphire_axe",() -> new AxeItem(ModToolTiers.SOUL_SAPPHIRE, 4, 1, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_SHOVEL =
            ITEMS.register("soul_sapphire_shovel",() -> new ShovelItem(ModToolTiers.SOUL_SAPPHIRE, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_HOE =
            ITEMS.register("soul_sapphire_hoe",() -> new HoeItem(ModToolTiers.SOUL_SAPPHIRE, 1, 2, new Item.Properties()));
    public static final RegistryObject<Item> CHINESE_SABER =
            ITEMS.register("chinese_saber",() -> new SwordItem(ModToolTiers.SOUL_SAPPHIRE, 8, 4, new Item.Properties()));

    public static final RegistryObject<Item> SOUL_SAPPHIRE_HELMET =
            ITEMS.register("soul_sapphire_helmet",() -> new ModArmorItem(ModArmorMaterials.SOUL_SAPPHIRE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_CHESTPLATE =
            ITEMS.register("soul_sapphire_chestplate",() -> new ArmorItem(ModArmorMaterials.SOUL_SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_LEGGINGS =
            ITEMS.register("soul_sapphire_leggings",() -> new ArmorItem(ModArmorMaterials.SOUL_SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SOUL_SAPPHIRE_BOOTS =
            ITEMS.register("soul_sapphire_boots",() -> new ArmorItem(ModArmorMaterials.SOUL_SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Properties()));



    public static final RegistryObject<Item> SAPPHIRE_STAFF =
            ITEMS.register("sapphire_staff",() -> new Item((new Item.Properties().stacksTo(1))));
    public static final RegistryObject<Item> STRAWBERRY =
            ITEMS.register("strawberry",() -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));
    public static final RegistryObject<Item> PINE_CONE =
            ITEMS.register("pine_cone",() -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> STRAWBERRY_SEEDS =
            ITEMS.register("strawberry_seeds",() -> new ItemNameBlockItem(ModBlocks.Strawberry_Crop.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_SEEDS =
            ITEMS.register("corn_seeds",() -> new ItemNameBlockItem(ModBlocks.CORN_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> Corn =
            ITEMS.register("corn",() -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
