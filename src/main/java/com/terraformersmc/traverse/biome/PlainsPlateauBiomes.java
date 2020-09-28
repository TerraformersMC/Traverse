package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.BiomeTemplate;
import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class PlainsPlateauBiomes {
	private static final BiomeTemplate PLATEAU_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.EMERALD_ORE)
			.addDefaultSpawnEntries()
			.depth(1.6F)
			.scale(0F)
			.temperature(0.8F)
			.downfall(0.2F)
	);

	static final Biome PLAINS_PLATEAU = PLATEAU_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS, DefaultFeature.PLAINS_FEATURES)
			.addStructureFeature(ConfiguredStructureFeatures.VILLAGE_PLAINS)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.category(Biome.Category.PLAINS)
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.RABBIT, 3, 2, 3))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.HORSE, 5, 2, 6))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.DONKEY, 1, 1, 3))
			.build();

	static final Biome ROCKY_EDGE = PLATEAU_TEMPLATE.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(DefaultFeature.PLAINS_TALL_GRASS)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.addCustomFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new SingleStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeatRandomly(2))
			.

					category(Biome.Category.PLAINS)
			.

					depth(0.9F)
			.

					build();

	static final Biome WOODED_PLATEAU = PLATEAU_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.FOREST_TREES, DefaultFeature.FOREST_GRASS, DefaultFeature.FOREST_FLOWERS)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.category(Biome.Category.FOREST)
			.build();
}
