package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlockFamilies;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseRecipeProvider extends FabricRecipeProvider {
	protected TraverseRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
		return new RecipeProvider(registryLookup, exporter) {
			@Override
			public void buildRecipes() {
				// We don't really use feature sets, so this is good enough...
				FeatureFlagSet enabledFeatures = FeatureFlagSet.of(FeatureFlags.VANILLA);

				generateRecipes(TraverseBlockFamilies.FIR, enabledFeatures);

				planksFromLogs(TraverseBlocks.FIR_PLANKS, TraverseItemTags.FIR_LOGS, 4);

				woodFromLogs(TraverseBlocks.FIR_WOOD, TraverseBlocks.FIR_LOG);
				woodFromLogs(TraverseBlocks.STRIPPED_FIR_WOOD, TraverseBlocks.STRIPPED_FIR_LOG);

				woodenBoat(TraverseBoats.FIR_BOAT, TraverseBlocks.FIR_PLANKS);
				chestBoat(TraverseBoats.FIR_CHEST_BOAT, TraverseBoats.FIR_BOAT);

				hangingSign(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.STRIPPED_FIR_LOG);

				shelf(TraverseBlocks.FIR_SHELF, TraverseItems.STRIPPED_FIR_LOG);
			}
		};
	}

	@Override
	public String getName() {
		return "Traverse Recipes";
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return Identifier.fromNamespaceAndPath(Traverse.MOD_ID, identifier.getPath());
	}
}
