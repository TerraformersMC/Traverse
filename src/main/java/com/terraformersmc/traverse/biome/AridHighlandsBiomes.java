package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class AridHighlandsBiomes {
	static final Biome ARID_HIGHLANDS = TraverseBiomes.BIOME_TEMPLATE
			//.configureSurfaceBuilder(TraverseSurfaceBuilders.ARID_HIGHLANDS, SurfaceBuilder.GRASS_CONFIG)
			.generationSettings(generationSettings())
			.spawnSettings(spawnSettings())
			.precipitation(Biome.Precipitation.NONE)
			.category(Biome.Category.DESERT)
			//.depth(1.3F)
			//.scale(0.3F)
			.temperature(2.0F)
			.downfall(0.0F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0xBACD78)
					.foliageColor(0x80A02E).build()
			)
			//.playerSpawnFriendly()
			.build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDesertLakes(builder);
		DefaultBiomeFeatures.addDesertDeadBushes(builder);
		DefaultBiomeFeatures.addDesertVegetation(builder);
		DefaultBiomeFeatures.addDesertFeatures(builder);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addSavannaGrass(builder);
		DefaultBiomeFeatures.addSavannaTrees(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.ARID_SHRUBS);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = new SpawnSettings.Builder();
		TraverseBiomes.addDefaultAmbientSpawnEntries(builder);
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE, 38, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ZOMBIE_VILLAGER, 2, 1, 1));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 100, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.WITCH, 5, 1, 1));

		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HUSK, 60, 4, 4));
		return builder.build();
	}
}
