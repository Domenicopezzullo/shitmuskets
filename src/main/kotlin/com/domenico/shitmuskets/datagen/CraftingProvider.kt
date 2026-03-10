package com.domenico.shitmuskets.datagen;

import com.domenico.shitmuskets.items.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import java.util.concurrent.CompletableFuture

class CraftingProvider(output: FabricDataOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(output, registriesFuture) {
  override fun createRecipeProvider(p0: HolderLookup.Provider, p1: RecipeOutput): RecipeProvider {
    return object : RecipeProvider(p0, p1) {
      override fun buildRecipes() {
        shaped(RecipeCategory.COMBAT, ModItems.MUSKET)
          .pattern("X  ")
          .pattern(" XY")
          .pattern("  X")
          .define('X', ItemTags.PLANKS)
          .define('Y', Items.FLINT_AND_STEEL)
          .unlockedBy("has_planks", has(ItemTags.PLANKS))
          .unlockedBy("has_flint_and_steel", has(Items.FLINT_AND_STEEL))
          .save(p1)
      }
    }
  }

  override fun getName(): String = "shitmuskets"
}
