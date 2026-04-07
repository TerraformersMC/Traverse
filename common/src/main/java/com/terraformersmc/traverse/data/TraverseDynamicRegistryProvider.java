package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseDynamicRegistryProvider extends FabricDynamicRegistryProvider {
	protected TraverseDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	public static void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, TraverseConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, TraversePlacedFeatures::bootstrap);
		registryBuilder.add(Registries.BIOME, TraverseBiomes::bootstrap);
	}

	@Override
	public void configure(HolderLookup.Provider registries, Entries entries) {
		addAll(entries, registries.lookupOrThrow(Registries.CONFIGURED_FEATURE), Traverse.MOD_ID);
		addAll(entries, registries.lookupOrThrow(Registries.PLACED_FEATURE), Traverse.MOD_ID);
		addAll(entries, registries.lookupOrThrow(Registries.BIOME), Traverse.MOD_ID);
	}

	@Override
	public String getName() {
		return "Traverse Dynamic Registries";
	}

	/**
	 * Version of FabricDynamicRegistryProvider.Entries.addAll() using specified mod ID.
	 */
	@SuppressWarnings("UnusedReturnValue")
	public <T> List<Holder<T>> addAll(Entries entries, HolderLookup.RegistryLookup<T> registry, String modId) {
		return registry.listElementIds()
				.filter(registryKey -> registryKey.identifier().getNamespace().equals(modId))
				.map(key -> entries.add(registry, key))
				.toList();
	}
}
