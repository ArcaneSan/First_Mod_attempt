package net.arcane.testermodarc.datagen;

import net.arcane.testermodarc.TesterModArc;
import net.arcane.testermodarc.block.ModBlocks;
import net.arcane.testermodarc.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SOUL_SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SOUL_SAPPHIRE.get(),
            ModBlocks.Soul_Sapphire_Ore.get(), ModBlocks.Deepslate_Soul_Sapphire_Ore.get(),
            ModBlocks.Netherrack_Soul_Sapphire_Ore.get(), ModBlocks.End_Stone_Soul_Sapphire_Ore.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SOUL_SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SOUL_SAPPHIRE.get(), 0.25f, 100, "soul_sapphire");
        oreSmelting(pWriter, SOUL_SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SOUL_SAPPHIRE.get(), 0.25f, 200, "soul_sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModBlocks.Soul_Sapphire_Block.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SOUL_SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SOUL_SAPPHIRE.get()), has(ModItems.SOUL_SAPPHIRE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SOUL_SAPPHIRE.get(), 9)
                .requires(ModBlocks.Soul_Sapphire_Block.get())
                .unlockedBy(getHasName(ModBlocks.Soul_Sapphire_Block.get()), has(ModBlocks.Soul_Sapphire_Block.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).
                    unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TesterModArc.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
