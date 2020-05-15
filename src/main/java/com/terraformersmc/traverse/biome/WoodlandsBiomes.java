package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.VillageFeatureConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;
import com.terraformersmc.traverse.feature.TraverseFeatures;

public class WoodlandsBiomes {
	static final Biome WOODLANDS = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/plains/town_centers", 6))
			.addStructureFeature(Feature.PILLAGER_OUTPOST)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
							ImmutableList.of(Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
											new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
											.withChance(0.2F),
									TraverseFeatures.FALLEN_OAK_TREE.configure(new FallenLogFeatureConfig.Builder(
											new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState())).baseLength(3).lengthRandom(2).build())
											.withChance(0.3F)),
							Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
							.createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(7))))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.category(Biome.Category.FOREST)
			.depth(0.15F)
			.scale(0.05F)
			.temperature(0.8F)
			.downfall(0.4F)
			.grassColor(0x99A955)
			.foliageColor(0x849E4A)
			.build();
}
