package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.SeagrassFeatureConfig;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;

public class MiniJungleBiomes {
	static final Biome MINI_JUNGLE = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.JUNGLE_GRASS, DefaultFeature.JUNGLE_VEGETATION, DefaultFeature.EXTRA_DEFAULT_FLOWERS, DefaultFeature.BAMBOO)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.SEAGRASS.configure(new SeagrassFeatureConfig(64, 0.6D)).createDecoratedFeature(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)), Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(50, 0.1F, 1))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.PARROT, 40, 1, 2))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.PANDA, 1, 1, 2))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.CHICKEN, 10, 4, 4))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.TROPICAL_FISH, 30, 5, 8))
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.OCELOT, 2, 1, 1))
			.category(Biome.Category.JUNGLE)
			.depth(-0.1F)
			.scale(0.45F)
			.temperature(0.95F)
			.downfall(0.9F)
			.waterColor(0x003320)
			.waterFogColor(0x052721)
			.build();
}
