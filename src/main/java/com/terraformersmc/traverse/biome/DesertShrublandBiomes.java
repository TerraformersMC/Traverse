package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class DesertShrublandBiomes {
	static final Biome DESERT_SHRUBLAND = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(TraverseSurfaceBuilders.DESERT_SHRUBLAND, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.DESERT_LAKES, DefaultFeature.DESERT_DEAD_BUSHES, DefaultFeature.DESERT_VEGETATION, DefaultFeature.DESERT_FEATURES, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.DEFAULT_GRASS)
			.addStructureFeature(DefaultBiomeFeatures.DESERT_VILLAGE)
			.addStructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG)
					.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG)
					.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))))
			.precipitation(Biome.Precipitation.NONE)
			.addDefaultAmbientSpawnEntries()
			.addDefaultMonsterSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.HUSK, 80, 4, 4))
			.category(Biome.Category.DESERT)
			.depth(0.125F)
			.scale(0.125F)
			.temperature(2.0F)
			.downfall(0.0F)
			.build();
}
