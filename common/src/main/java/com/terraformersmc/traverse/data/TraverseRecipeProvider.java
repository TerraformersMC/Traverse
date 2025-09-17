package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlockFamilies;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class TraverseRecipeProvider extends FabricRecipeProvider {
	protected TraverseRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
		return new RecipeGenerator(registryLookup, exporter) {
			@Override
			public void generate() {
				// We don't really use feature sets, so this is good enough...
				FeatureSet enabledFeatures = FeatureSet.of(FeatureFlags.VANILLA);

				generateFamily(TraverseBlockFamilies.FIR, enabledFeatures);

				offerPlanksRecipe(TraverseBlocks.FIR_PLANKS, TraverseItemTags.FIR_LOGS, 4);

				offerBarkBlockRecipe(TraverseBlocks.FIR_WOOD, TraverseBlocks.FIR_LOG);
				offerBarkBlockRecipe(TraverseBlocks.STRIPPED_FIR_WOOD, TraverseBlocks.STRIPPED_FIR_LOG);

				offerBoatRecipe(TraverseBoats.FIR_BOAT, TraverseBlocks.FIR_PLANKS);
				offerChestBoatRecipe(TraverseBoats.FIR_CHEST_BOAT, TraverseBoats.FIR_BOAT);

				offerHangingSignRecipe(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.STRIPPED_FIR_LOG);

				offerShelfRecipe(TraverseBlocks.FIR_SHELF, TraverseItems.STRIPPED_FIR_LOG);
			}
		};
	}

	@Override
	public String getName() {
		return "Traverse Recipes";
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return Identifier.of(Traverse.MOD_ID, identifier.getPath());
	}
}
