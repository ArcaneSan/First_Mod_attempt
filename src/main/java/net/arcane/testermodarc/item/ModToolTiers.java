package net.arcane.testermodarc.item;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SOUL_SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500,5f,4f,25,
                    ModTags.Blocks.NEEDS_SOUL_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SOUL_SAPPHIRE.get())),
            new ResourceLocation(TesterModArc.MOD_ID,"soul_sapphire"), List.of(Tiers.NETHERITE), List.of());
}
