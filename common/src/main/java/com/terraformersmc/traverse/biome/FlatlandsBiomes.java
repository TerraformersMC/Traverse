package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class FlatlandsBiomes {
	public static Biome create(FabricDynamicRegistryProvider.Entries entries) {
		return new Biome.Builder()
				.generationSettings(generationSettings(entries))
				.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
				.precipitation(Biome.Precipitation.RAIN)
				.temperature(0.8F)
				.downfall(0.7F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(0x65CC53)
						.foliageColor(0x5DD64A)
						.build()
				)
				.build();
	}

	private static GenerationSettings generationSettings(FabricDynamicRegistryProvider.Entries entries) {
		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.FLATLANDS_TREES));
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.LUSH_FLOWERS));
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.FLATLANDS_GRASS));
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder.build();
	}
}
