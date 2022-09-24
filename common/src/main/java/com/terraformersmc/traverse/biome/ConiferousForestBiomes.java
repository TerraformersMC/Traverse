package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class ConiferousForestBiomes {
	static final Biome CONIFEROUS_FOREST = new Biome.Builder()
			.generationSettings(generationSettings(false))
			.spawnSettings(spawnSettings())
			.precipitation(Biome.Precipitation.RAIN)
			.temperature(0.6F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338235)
					.foliageColor(0x338235).build()
			)
			.build();

	static final Biome SNOWY_CONIFEROUS_FOREST = new Biome.Builder()
			.generationSettings(generationSettings(true))
			.spawnSettings(spawnSettings())
			.precipitation(Biome.Precipitation.SNOW)
			.temperature(-0.5F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338251)
					.foliageColor(0x338251).build()
			)
			.build();

	private static GenerationSettings generationSettings(boolean snowy){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addLargeFerns(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.CONIFEROUS_TREES);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addTaigaGrass(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		if (snowy) {
			DefaultBiomeFeatures.addSweetBerryBushesSnowy(builder);
		} else {
			DefaultBiomeFeatures.addSweetBerryBushes(builder);
		}
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
