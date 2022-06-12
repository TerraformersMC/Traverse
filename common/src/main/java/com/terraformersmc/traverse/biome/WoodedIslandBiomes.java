package com.terraformersmc.traverse.biome;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class WoodedIslandBiomes {
	static final Biome WOODED_ISLAND = TraverseBiomes.BIOME_TEMPLATE
			//.configureSurfaceBuilder(TraverseSurfaceRules.WOODED_ISLAND, SurfaceBuilder.GRASS_CONFIG)
			//.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.generationSettings(generationSettings())
			.spawnSettings(spawnSettings())
			.category(Biome.Category.FOREST)
			//.depth(0.1F)
			//.scale(0.6F)
			.temperature(0.8F)
			.downfall(0.8F)
			.build();
	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = new GenerationSettings.Builder();
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		DefaultBiomeFeatures.addForestTrees(builder);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addForestGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		DefaultBiomeFeatures.addLessKelp(builder);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
