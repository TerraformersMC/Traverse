package com.terraformersmc.traverse.biome;


import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class ConiferousForestBiomes {
	private static final Biome.Builder CONIFEROUS_FOREST_TEMPLATE = TraverseBiomes.BIOME_TEMPLATE
			.generationSettings(generationSettings(false))
			.spawnSettings(spawnSettings())
			.category(Biome.Category.FOREST)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338235)
					.foliageColor(0x338235).build()
			)
			.temperature(0.6F)
			.downfall(0.9F);

	static final Biome CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE
			//.depth(0.4F)
			//.scale(0.4F)
			//.playerSpawnFriendly()
			.build();

	/*static final Biome HIGH_CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1.6F)
			.scale(0.4F)
			.temperature(0.3F)
			.build();*/

	static final Biome SNOWY_CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE
			.generationSettings(generationSettings(true))
			.precipitation(Biome.Precipitation.SNOW)
			.category(Biome.Category.TAIGA)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338251)
					.foliageColor(0x338251).build()
			)
			//.depth(0.4F)
			//.scale(0.4F)
			//.playerSpawnFriendly()
			.temperature(-0.5F).build();

	/*static final Biome SNOWY_HIGH_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1.6F)
			.scale(0.4F)
			.temperature(-0.6F)
			.build();*/

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
