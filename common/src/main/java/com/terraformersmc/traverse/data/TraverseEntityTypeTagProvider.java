package com.terraformersmc.traverse.data;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatData;
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
		/*
		 * Basic entity type tags
		 */
		getTagBuilder(EntityTypeTags.BOAT)
				.add(TerraformBoatData.get(TraverseBoats.FIR).boatEntityTypeId());


		/*
		 * Conventional entity type tags
		 */
		getTagBuilder(ConventionalEntityTypeTags.BOATS)
				.add(TerraformBoatData.get(TraverseBoats.FIR).chestBoatEntityTypeId());
	}

	@Override
	public String getName() {
		return "Traverse Entity Type Tags";
	}
}
