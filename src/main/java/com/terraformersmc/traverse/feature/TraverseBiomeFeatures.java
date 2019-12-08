package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.PineFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedStateProvider;

public class TraverseBiomeFeatures {
	public static final BranchedTreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig FIR_TREE_CONFIG;
	private static final BranchedTreeFeatureConfig TALL_SWAMP_TREE_CONFIG;
	private static final RandomPatchFeatureConfig LUSH_FLOWER_CONFIG;

	private static BranchedTreeFeatureConfig oakLike(BlockState trunk) {
		return new BranchedTreeFeatureConfig.Builder(
				new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()),
				new SimpleStateProvider(trunk),
				new BlobFoliagePlacer(2, 0)
		).baseHeight(4).heightRandA(2).foliageHeight(3).noVines().build();
	}

	static {
		RED_AUTUMNAL_TREE_CONFIG = oakLike(TraverseBlocks.RED_AUTUMNAL_LEAVES.getDefaultState());
		ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES.getDefaultState());
		YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES.getDefaultState());
		BROWN_AUTUMNAL_TREE_CONFIG = oakLike(TraverseBlocks.BROWN_AUTUMNAL_LEAVES.getDefaultState());
		FIR_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder(
				new SimpleStateProvider(TraverseBlocks.FIR_LOG.getDefaultState()),
				new SimpleStateProvider(TraverseBlocks.FIR_LEAVES.getDefaultState()),
				new SpruceFoliagePlacer(2, 1)
		).baseHeight(15).heightRandA(15).trunkHeight(1).trunkHeightRandom(4).trunkTopOffsetRandom(2).noVines().build();

		TALL_SWAMP_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder (
				new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()),
				new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
				new BlobFoliagePlacer(3, 0)
		).baseHeight(7).heightRandA(3).foliageHeight(3).maxWaterDepth(1).treeDecorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();

		WeightedStateProvider provider = new WeightedStateProvider();

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
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.5F, count))));
	}

	public static void addAutumnalWoodsTrees(Biome biome) {
		biome.addFeature(
			GenerationStep.Feature.VEGETAL_DECORATION,
			Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
				ImmutableList.of(
					Feature.NORMAL_TREE.configure(RED_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
					Feature.NORMAL_TREE.configure(ORANGE_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
					Feature.NORMAL_TREE.configure(YELLOW_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
					Feature.NORMAL_TREE.configure(BROWN_AUTUMNAL_TREE_CONFIG).withChance(0.25F)
				),
				Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
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
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(FIR_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(7, 0.1F, 1))));
	}

	public static void addDesertShrublandFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
			new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
			.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));
	}

	public static void addRollingHillsVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(LUSH_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(5))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))));
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.2F, 1))));

	}

	public static void addLushSwampVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(TALL_SWAMP_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(2, 0.1F, 1))));

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
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.2F, 1))));
	}

	public static void addMiniJungleVegetation(Biome biome) {
		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
			ImmutableList.of( Feature.FANCY_TREE.configure(
				DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
			Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG))).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(50, 0.1F, 1))));

		biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.BLUE_ORCHID_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(4))));
	}

	public static void addRockyEdgeFeatures(Biome biome) {
		biome.addFeature(GenerationStep.Feature.LOCAL_MODIFICATIONS, Feature.FOREST_ROCK.configure(new BoulderFeatureConfig(Blocks.COBBLESTONE.getDefaultState(), 1)).createDecoratedFeature(Decorator.FOREST_ROCK.configure(new CountDecoratorConfig(3))));
	}

	public static void addWoodlandsTrees(Biome biome, int count) {
		biome.addFeature(
			GenerationStep.Feature.VEGETAL_DECORATION,
			Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
				ImmutableList.of(Feature.JUNGLE_GROUND_BUSH.configure(new TreeFeatureConfig.Builder(
					new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).build())
					.withChance(0.2F),
					TraverseFeatures.FALLEN_OAK_TREE.configure(new FallenLogFeatureConfig.Builder(
						new SimpleStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleStateProvider(Blocks.OAK_LEAVES.getDefaultState())).baseLength(3).lengthRandom(2).build())
						.withChance(0.3F)),
				Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
				.createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(count))));
	}
}
