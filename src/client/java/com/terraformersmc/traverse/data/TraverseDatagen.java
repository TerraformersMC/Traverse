package com.terraformersmc.traverse.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TraverseDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(TraverseDynamicRegistryProvider::new);
		pack.addProvider(TraverseBiomeTagsProvider::new);
		pack.addProvider(TraverseBlockLootSubProvider::new);
		TraverseBlockTagsProvider blockTagProvider = pack.addProvider(TraverseBlockTagsProvider::new);
		pack.addProvider((output, registries) -> new TraverseItemTagsProvider(output, registries, blockTagProvider));
		pack.addProvider(TraverseVillagerTradeKeyTagProvider::new);
		pack.addProvider(TraverseEntityTypeTagsProvider::new);
		pack.addProvider(TraverseModelProvider::new);
		pack.addProvider(TraverseRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		TraverseDynamicRegistryProvider.buildRegistry(registryBuilder);
	}
}
