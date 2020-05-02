package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class TraverseBiomeFeatures {
	public static final TreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG;
	public static final TreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG;
	public static final TreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG;
	public static final TreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG;
	public static final TreeFeatureConfig FIR_TREE_CONFIG;
	private static final TreeFeatureConfig TALL_SWAMP_TREE_CONFIG;
	private static final RandomPatchFeatureConfig LUSH_FLOWER_CONFIG;
	private static final TreeFeatureConfig OAK_SHRUB_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BushFoliagePlacer(2, 0, 1, 0, 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayersFeatureSize(0, 0, 0))).method_27375(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();

	private static TreeFeatureConfig oakLike(Block trunk, Block leaves, int height) {
		return new TreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(trunk.getDefaultState()),
				new SimpleBlockStateProvider(leaves.getDefaultState()),
				new BlobFoliagePlacer(2, 0, 0, 0, 3),
				new StraightTrunkPlacer(height, 2, 0),
				new TwoLayersFeatureSize(1, 0, 1)
		).method_27374().build();
	}

	static {
		RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, TraverseBlocks.RED_AUTUMNAL_LEAVES, 4);
		ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
		YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
		BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.BROWN_AUTUMNAL_LEAVES, 4);
		FIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(TraverseBlocks.FIR_LOG.getDefaultState()),
				new SimpleBlockStateProvider(TraverseBlocks.FIR_LEAVES.getDefaultState()),
				new SpruceFoliagePlacer(2, 1, 0, 2, 5, 3),
				new StraightTrunkPlacer(15, 15, 4),
				new TwoLayersFeatureSize(2, 0, 2)
		).method_27374().build();

		TALL_SWAMP_TREE_CONFIG = new TreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
				new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
				new BlobFoliagePlacer(3, 0, 0, 0, 3),
				new StraightTrunkPlacer(7, 3, 0),
				new TwoLayersFeatureSize(1, 0, 1)
		).baseHeight(1).method_27376(ImmutableList.of(new LeaveVineTreeDecorator())).build();

		WeightedBlockStateProvider provider = new WeightedBlockStateProvider();

		provider.addState(Blocks.POPPY.getDefaultState(), 12);
		provider.addState(Blocks.AZURE_BLUET.getDefaultState(), 12);
		provider.addState(Blocks.OXEYE_DAISY.getDefaultState(), 12);
		provider.addState(Blocks.DANDELION.getDefaultState(), 8);
		provider.addState(Blocks.ORANGE_TULIP.getDefaultState(), 1);
		provider.addState(Blocks.PINK_TULIP.getDefaultState(), 1);
		provider.addState(Blocks.RED_TULIP.getDefaultState(), 1);
		provider.addState(Blocks.WHITE_TULIP.getDefaultState(), 1);

		RandomPatchFeatureConfig.Builder lushGrassBuilder = new RandomPatchFeatureConfig.Builder(provider, new SimpleBlockPlacer());
		LUSH_FLOWER_CONFIG = lushGrassBuilder.tries(64).cannotProject().build();
	}

	public static void addShrubs(Biome biome, int count) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(OAK_SHRUB_CONFIG)
				.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.5F, count))));
	}

	public static void addAutumnalWoodsTrees(Biome biome) {
		biome.addFeature(
				GenerationStep.Feature.VEGETAL_DECORATION,
				Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
						ImmutableList.of(
								Feature.TREE.configure(RED_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
								Feature.TREE.configure(ORANGE_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
								Feature.TREE.configure(YELLOW_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
								Feature.TREE.configure(BROWN_AUTUMNAL_TREE_CONFIG).withChance(0.25F)
						),
						Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
						.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))));
	}

	public static void addCliffsMineables(Biome biome) {
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
		biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))));
	}

	public static void addConiferousForestTrees(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(FIR_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(7, 0.1F, 1))));
	}

	public static void addDesertShrublandFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(OAK_SHRUB_CONFIG)
				.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(OAK_SHRUB_CONFIG)
				.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
	}

	public static void addRollingHillsVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LUSH_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(5))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.2F, 1))));

	}

	public static void addLushSwampVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(TALL_SWAMP_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));

		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP.configure(new CountChanceDecoratorConfig(8, 0.25F))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG).createDecoratedFeature(Decorator.COUNT_CHANCE_HEIGHTMAP_DOUBLE.configure(new CountChanceDecoratorConfig(8, 0.125F))));
	}

	public static void addMeadowVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LUSH_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(10))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.2F, 1))));
	}

	public static void addMiniJungleVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
				ImmutableList.of(Feature.TREE.configure(
						DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
				Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(50, 0.1F, 1))));

		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
	}

	public static void addRockyEdgeFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))));
	}

	public static void addWoodlandsTrees(Biome biome, int count) {
		biome.addFeature(
				GenerationStep.Feature.VEGETAL_DECORATION,
				Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
						ImmutableList.of(Feature.TREE.configure(OAK_SHRUB_CONFIG)
										.withChance(0.2F),
								Feature.TREE.configure(new TreeFeatureConfig.Builder(
										new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new NoneFoliagePlacer(), new FallenTrunkPlacer(3, 2, 0), new TwoLayersFeatureSize(0, 0, 0)).build())
										.withChance(0.3F)),
						Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
						.createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(count))));
	}
}
