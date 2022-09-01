package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class TraverseRecipeProvider extends FabricRecipeProvider {
	public TraverseRecipeProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		offerBoatRecipe(exporter, TraverseBoatTypes.fir.getItem(), TraverseBlocks.FIR_PLANKS);
		offerChestBoatRecipe(exporter, TraverseBoatTypes.fir.getChestItem(), TraverseBoatTypes.fir.getItem());

		offerSingleOutputShapelessRecipe(exporter, TraverseBlocks.FIR_BUTTON, TraverseBlocks.FIR_PLANKS, "wooden_button");

		createDoorRecipe(TraverseBlocks.FIR_DOOR, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createFenceRecipe(TraverseBlocks.FIR_FENCE, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createFenceGateRecipe(TraverseBlocks.FIR_FENCE_GATE, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		offerPlanksRecipe(exporter, TraverseBlocks.FIR_PLANKS, TraverseItemTags.FIR_LOGS);

		offerPressurePlateRecipe(exporter, TraverseBlocks.FIR_PRESSURE_PLATE, TraverseBlocks.FIR_PLANKS);

		createSignRecipe(TraverseBlocks.FIR_SIGN, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		offerSlabRecipe(exporter, TraverseBlocks.FIR_SLAB, TraverseBlocks.FIR_PLANKS);

		createStairsRecipe(TraverseBlocks.FIR_STAIRS, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		createTrapdoorRecipe(TraverseBlocks.FIR_TRAPDOOR, Ingredient.ofItems(TraverseBlocks.FIR_PLANKS))
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter);

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_WOOD, 3)
			.group("bark")
			.pattern("LL")
			.pattern("LL")
			.input('L', TraverseBlocks.FIR_LOG)
			.criterion("has_logs", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_LOG))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_wood"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.STRIPPED_FIR_WOOD, 3)
			.group("bark")
			.pattern("LL")
			.pattern("LL")
			.input('L', TraverseBlocks.STRIPPED_FIR_LOG)
			.criterion("has_logs", InventoryChangedCriterion.Conditions.items(TraverseBlocks.STRIPPED_FIR_LOG))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "stripped_fir_wood"));
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return new Identifier(Traverse.MOD_ID, identifier.getPath());
	}
}
