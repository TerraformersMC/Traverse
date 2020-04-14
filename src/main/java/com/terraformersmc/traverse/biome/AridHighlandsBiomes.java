package com.terraformersmc.traverse.biome;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;

public class AridHighlandsBiomes {
	static final Biome ARID_HIGHLANDS = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(TraverseSurfaceBuilders.ARID_HIGHLANDS, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.DESERT_LAKES, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DESERT_VEGETATION, DefaultFeature.DESERT_FEATURES, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.SAVANNA_GRASS, DefaultFeature.SAVANNA_TREES)
			.addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/desert/town_centers", 6))
			.addStructureFeature(Feature.PILLAGER_OUTPOST)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
					new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
					.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.5F, 1))))
			.precipitation(Biome.Precipitation.NONE)
			.addDefaultAmbientSpawnEntries()
			.addDefaultMonsterSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.HUSK, 80, 4, 4))
			.category(Biome.Category.DESERT)
			.depth(1.3F)
			.scale(0.3F)
			.temperature(2.0F)
			.downfall(0.0F)
			.grassColor(0xBACD78)
			.foliageColor(0x80A02E)
			.build();
}
