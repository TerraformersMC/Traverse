package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;

public class RollingHillsBiomes {
	static final Biome ROLLING_HILLS = TraverseBiomes.BIOME_TEMPLATE
			.generationSettings(generationSettings())
			.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
			.category(Biome.Category.PLAINS)
			//.depth(0.4F)
			//.scale(0.3F)
			.temperature(0.5F)
			.downfall(0.8F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x7FE03E)
					.foliageColor(0x58EA33).build()
			)
			//.playerSpawnFriendly()
			.build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDefaultLakes(builder)
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.ROLLING_HILLS_GRASS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.LUSH_FLOWERS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.ROLLING_HILLS_TREES);

		return builder.build();
	}
}
