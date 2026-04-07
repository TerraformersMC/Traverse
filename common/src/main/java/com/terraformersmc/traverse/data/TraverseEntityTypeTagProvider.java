package com.terraformersmc.traverse.data;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatData;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	protected TraverseEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Basic entity type tags
		 */
		getOrCreateRawBuilder(EntityTypeTags.BOAT)
				.addElement(TerraformBoatData.get(TraverseBoats.FIR).boatEntityTypeId());


		/*
		 * Conventional entity type tags
		 */
		getOrCreateRawBuilder(ConventionalEntityTypeTags.BOATS)
				.addElement(TerraformBoatData.get(TraverseBoats.FIR).chestBoatEntityTypeId());
	}

	@Override
	public String getName() {
		return "Traverse Entity Type Tags";
	}
}
