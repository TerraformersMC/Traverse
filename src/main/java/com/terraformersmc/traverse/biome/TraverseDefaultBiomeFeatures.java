package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;

public class TraverseDefaultBiomeFeatures {

	public static void addShrubs(Biome biome, int count) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseFeatures.OAK_SHRUB.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.5F, count))));
	}

	public static void addAutumnalWoodsTrees(Biome biome) {
		biome.addFeature(
			GenerationStep.Feature.VEGETAL_DECORATION,
			Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
				ImmutableList.of(TraverseFeatures.RED_AUTUMNAL_TREE.configure(new BranchedTreeFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(TraverseBlocks.RED_AUTUMNAL_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withChance(0.25F),
					TraverseFeatures.ORANGE_AUTUMNAL_TREE.configure(new BranchedTreeFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withChance(0.25F),
					TraverseFeatures.YELLOW_AUTUMNAL_TREE.configure(new BranchedTreeFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withChance(0.25F),
					TraverseFeatures.BROWN_AUTUMNAL_TREE.configure(new BranchedTreeFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(TraverseBlocks.BROWN_AUTUMNAL_LEAVES.getDefaultState()), new BlobFoliagePlacer(2, 0)).build())
						.withChance(0.25F)),
				Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
				.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure( new CountExtraChanceDecoratorConfig(10, 0.1F, 1))));
	}

	public static void addCliffsMineables(Biome biome) {
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
	}

	public static void addConiferousForestTrees(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseFeatures.FIR_TREE.configure(new BranchedTreeFeatureConfig.Builder(
			new SimpleStateProvider(TraverseBlocks.FIR_LOG.getDefaultState()), new SimpleStateProvider(TraverseBlocks.FIR_LEAVES.getDefaultState()), new PineFoliagePlacer(3, 0)
		).build()).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(7, 0.1F, 1))));
	}

	public static void addDesertShrublandFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseFeatures.OAK_SHRUB.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseFeatures.OAK_SHRUB.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
	}

	public static void addRollingHillsVegetation(Biome biome) {
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TraverseFeatures.LUSH_FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(5)));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21201).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.2F, 1))));

	}

	public static void addLushSwampVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseFeatures.TALL_SWAMP_TREE.configure(new BranchedTreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new PineFoliagePlacer(3, 0)
		).build()).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));

		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.field_21205).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21201).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21090).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21095).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.25F))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new CountChanceDecoratorConfig(8, 0.125F))));

//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.SWAMP_FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(1)));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(5)));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.DEAD_BUSH, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(1)));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.BROWN_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP, new CountChanceDecoratorConfig(8, 0.25F)));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.BUSH, new BushFeatureConfig(Blocks.RED_MUSHROOM.getDefaultState()), Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE, new CountChanceDecoratorConfig(8, 0.125F)));
	}

	public static void addMeadowVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21201).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
//		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TraverseFeatures.LUSH_FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(10)));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.2F, 1))));
	}

	public static void addMiniJungleVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
			ImmutableList.of( Feature.FANCY_TREE.configure(
				DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
			TraverseFeatures.MINI_JUNGLE_TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(50, 0.1F, 1))));

		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.field_21095).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
	}

	public static void addRockyEdgeFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))));
	}

	public static void addWoodlandsTrees(Biome biome, int count) {
		biome.addFeature(
			GenerationStep.Feature.VEGETAL_DECORATION,
			Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
				ImmutableList.of(TraverseFeatures.OAK_SHRUB.configure(new TreeFeatureConfig.Builder(
					new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
					.withChance(0.2F),
					TraverseFeatures.FALLEN_OAK_TREE.configure(new TreeFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
						.withChance(0.3F)),
				Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
				.createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(count))));
	}
}
