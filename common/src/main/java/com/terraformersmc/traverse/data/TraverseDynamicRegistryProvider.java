package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class TraverseDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected TraverseDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		TraverseConfiguredFeatures.populate(entries);
		TraversePlacedFeatures.populate(entries);
		TraverseBiomes.populate(entries);
	}

	@Override
	public String getName() {
		return "Traverse";
	}
}
