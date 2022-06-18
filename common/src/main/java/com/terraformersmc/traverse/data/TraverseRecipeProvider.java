package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.criterion.EnterBlockCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class TraverseRecipeProvider extends FabricRecipeProvider {
	public TraverseRecipeProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
		FabricRecipeProvider.offerBoatRecipe(exporter, TraverseBoatTypes.fir.getItem(), TraverseBlocks.FIR_PLANKS);
		FabricRecipeProvider.offerChestBoatRecipe(exporter, TraverseBoatTypes.fir.getChestItem(), TraverseBoatTypes.fir.getItem());

		new ShapelessRecipeJsonBuilder(TraverseBlocks.FIR_BUTTON, 1)
			.group("wooden_button")
			.input(TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_button"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_DOOR, 3)
			.group("wooden_door")
			.pattern("PP")
			.pattern("PP")
			.pattern("PP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_door"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_FENCE, 3)
			.group("wooden_fence")
			.pattern("PSP")
			.pattern("PSP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.input('S', Items.STICK)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_fence"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_FENCE_GATE, 3)
			.group("wooden_fence_gate")
			.pattern("SPS")
			.pattern("SPS")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.input('S', Items.STICK)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_fence_gate"));

		new ShapelessRecipeJsonBuilder(TraverseBlocks.FIR_PLANKS, 4)
			.group("planks")
			.input(TraverseItemTags.FIR_LOGS)
			.criterion("has_logs", InventoryChangedCriterion.Conditions.items(ItemPredicate.Builder.create().tag(TraverseItemTags.FIR_LOGS).build()))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_planks"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_PRESSURE_PLATE, 1)
			.group("wooden_pressure_plate")
			.pattern("PP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_pressure_plate"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_SIGN_ITEM, 3)
			.group("wooden_signs")
			.pattern("PPP")
			.pattern("PPP")
			.pattern(" S ")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.input('S', Items.STICK)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_sign"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_SLAB, 6)
			.group("wooden_slab")
			.pattern("PPP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_slab"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_STAIRS, 4)
			.group("wooden_stairs")
			.pattern("P  ")
			.pattern("PP ")
			.pattern("PPP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_stairs"));

		new ShapedRecipeJsonBuilder(TraverseBlocks.FIR_TRAPDOOR, 2)
			.group("wooden_trapdoor")
			.pattern("PPP")
			.pattern("PPP")
			.input('P', TraverseBlocks.FIR_PLANKS)
			.criterion("has_planks", InventoryChangedCriterion.Conditions.items(TraverseBlocks.FIR_PLANKS))
			.offerTo(exporter, new Identifier(Traverse.MOD_ID, "fir_trapdoor"));

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
