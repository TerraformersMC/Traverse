package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;

import java.util.concurrent.CompletableFuture;

public class TraverseEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	protected TraverseEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		// TODO: Hard-coded hack until Terraform API provides access to boat entity types.
		//       This relies on the fact the API uses the same resource name for item and entity type.

		/*
		 * Basic entity type tags
		 */
		getOrCreateTagBuilder(EntityTypeTags.BOAT)
				.add(TraverseBoats.FIR.withSuffixedPath("_boat"));


		/*
		 * Conventional entity type tags
		 */
		getOrCreateTagBuilder(ConventionalEntityTypeTags.BOATS)
				.add(TraverseBoats.FIR.withSuffixedPath("_chest_boat"));
	}

	@Override
	public String getName() {
		return "Traverse Entity Type Tags";
	}
}
