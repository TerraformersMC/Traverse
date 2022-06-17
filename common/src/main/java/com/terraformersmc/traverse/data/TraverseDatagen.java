package com.terraformersmc.traverse.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TraverseDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		dataGenerator.addProvider(TraverseBiomeTagProvider::new);
		dataGenerator.addProvider(TraverseBlockLootTableProvider::new);
		dataGenerator.addProvider(TraverseBlockTagProvider::new);
		dataGenerator.addProvider(TraverseItemTagProvider::new);
		dataGenerator.addProvider(TraverseRecipeProvider::new);
	}
}
