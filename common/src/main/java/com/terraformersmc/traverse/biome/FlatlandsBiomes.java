package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class FlatlandsBiomes {
	static final Biome FLATLANDS = new Biome.Builder()
			.precipitation(Biome.Precipitation.RAIN)
			.generationSettings(generationSettings())
			.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
			.category(Biome.Category.PLAINS)
			.temperature(0.8F)
			.downfall(0.7F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x65CC53)
					.foliageColor(0x5DD64A).build()
			)
			.build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.FLATLANDS_TREES);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.LUSH_FLOWERS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.FLATLANDS_GRASS);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder.build();
	}
}
