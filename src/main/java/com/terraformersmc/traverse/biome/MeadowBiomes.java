package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class MeadowBiomes {
	static final Biome MEADOW = TraverseBiomes.BIOME_TEMPLATE
			.generationSettings(generationSettings())
			.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
			.category(Biome.Category.PLAINS)
			//.depth(0.1F)
			//.scale(0F)
			.temperature(0.8F)
			.downfall(0.7F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x65CC53)
					.foliageColor(0x5DD64A).build()
			)
			//.playerSpawnFriendly()
			.build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDefaultLakes(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.MEADOW_GRASS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.LUSH_FLOWERS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.MEADOW_TREES);
		return builder.build();
	}
}
