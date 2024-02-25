package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class TraverseDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected TraverseDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	public static void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, TraverseConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, TraversePlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.BIOME, TraverseBiomes::bootstrap);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE), Traverse.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE), Traverse.MOD_ID);
		addAll(entries, registries.getWrapperOrThrow(RegistryKeys.BIOME), Traverse.MOD_ID);
	}

	@Override
	public String getName() {
		return "Traverse";
	}

	/**
	 * Version of FabricDynamicRegistryProvider.Entries.addAll() using specified mod ID.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public <T> List<RegistryEntry<T>> addAll(Entries entries, RegistryWrapper.Impl<T> registry, String modId) {
		return registry.streamKeys()
				.filter(registryKey -> registryKey.getValue().getNamespace().equals(modId))
				.map(key -> entries.add(registry, key))
				.toList();
	}
}
