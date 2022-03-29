package com.terraformersmc.traverse.biome;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class WoodedIslandBiomes {
	static final Biome WOODED_ISLAND = TraverseBiomes.BIOME_TEMPLATE
			//.configureSurfaceBuilder(TraverseSurfaceBuilders.WOODED_ISLAND, SurfaceBuilder.GRASS_CONFIG)
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
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addForestGrass(builder);
		DefaultBiomeFeatures.addForestTrees(builder);
		DefaultBiomeFeatures.addLessKelp(builder);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
