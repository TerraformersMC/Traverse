package com.terraformersmc.traverse.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

import java.util.function.Supplier;

public class PlainsPlateauBiomes {
	private static final Biome.Builder PLATEAU_TEMPLATE = TraverseBiomes.BIOME_TEMPLATE
			.spawnSettings(TraverseBiomes.createDefaultSpawnSettings().build())
			//.depth(1.6F)
			//.scale(0F)
			.temperature(0.8F)
			.downfall(0.2F);

	static final Biome PLAINS_PLATEAU = PLATEAU_TEMPLATE
			.generationSettings(generationSettings(() -> {
				GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
				//DefaultBiomeFeatures.addDefaultLakes(builder);
				DefaultBiomeFeatures.addEmeraldOre(builder);
				DefaultBiomeFeatures.addPlainsTallGrass(builder);
				DefaultBiomeFeatures.addPlainsFeatures(builder);
				return builder;
			}))
			.spawnSettings(spawnSettings())
			//.addStructureFeature(ConfiguredStructureFeatures.VILLAGE_PLAINS)
			//.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.category(Biome.Category.PLAINS)
			.build();

	/*static final Biome ROCKY_EDGE = PLATEAU_TEMPLATE
			//.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, TraversePlacedFeatures.ROCKY_EDGE_BOULDER)
			.category(Biome.Category.PLAINS)
			.depth(0.9F)
			.build();*/

	static final Biome WOODED_PLATEAU = PLATEAU_TEMPLATE
			.generationSettings(generationSettings(() -> {
				GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
				DefaultBiomeFeatures.addForestTrees(builder);
				DefaultBiomeFeatures.addForestGrass(builder);
				DefaultBiomeFeatures.addForestFlowers(builder);
				return builder;
			}))
			//.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.category(Biome.Category.FOREST)
			.build();

	private static GenerationSettings generationSettings(Supplier<GenerationSettings.Builder> builderSupplier){
		GenerationSettings.Builder builder = builderSupplier.get();
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 3, 2, 3));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.HORSE, 5, 2, 6));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.DONKEY, 1, 1, 3));
		return builder.build();
	}
}
