package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.placer.FallenTrunkPlacer;
import com.terraformersmc.traverse.feature.placer.NoneFoliagePlacer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class TraverseFeatureConfigs {
	public static final TreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, TraverseBlocks.RED_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
	public static final TreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.BROWN_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig FIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
			BlockStateProvider.of(TraverseBlocks.FIR_LOG.getDefaultState()),
			new StraightTrunkPlacer(15, 15, 4),
			BlockStateProvider.of(TraverseBlocks.FIR_LEAVES.getDefaultState()),
			new SpruceFoliagePlacer(UniformIntProvider.create(2, 3), UniformIntProvider.create(1, 1), UniformIntProvider.create(4, 12)),
			new TwoLayersFeatureSize(2, 0, 4)
	).ignoreVines().build();
	public static final TreeFeatureConfig TALL_SWAMP_TREE_CONFIG = new TreeFeatureConfig.Builder(
			BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()),
			new StraightTrunkPlacer(7, 3, 0),
			BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()),
			new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 3),
			new TwoLayersFeatureSize(1, 0, 1)
	).decorators(ImmutableList.of(new LeavesVineTreeDecorator(0.25f))).build();
	public static final TreeFeatureConfig OAK_SHRUB_CONFIG = (new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()), new BushFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2), new TwoLayersFeatureSize(0, 0, 0))).build();
	public static final TreeFeatureConfig FALLEN_OAK_TREE_CONFIG = new TreeFeatureConfig.Builder(BlockStateProvider.of(Blocks.OAK_LOG.getDefaultState()), new FallenTrunkPlacer(3, 2, 0), BlockStateProvider.of(Blocks.OAK_LEAVES.getDefaultState()), new NoneFoliagePlacer(), new TwoLayersFeatureSize(0, 0, 0)).build();
	public static final RandomPatchFeatureConfig LUSH_FLOWER_CONFIG;

	private static TreeFeatureConfig oakLike(Block trunk, Block leaves, int height) {
		return new TreeFeatureConfig.Builder(
				BlockStateProvider.of(trunk.getDefaultState()),
				new StraightTrunkPlacer(height, 2, 0),
				BlockStateProvider.of(leaves.getDefaultState()),
				new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
				new TwoLayersFeatureSize(1, 0, 1)
		).ignoreVines().build();
	}

	private static DataPool.Builder<BlockState> createStatePoolBuilder() {
		return DataPool.builder();
	}

	static {
		{ // Lush Flower Config
			WeightedBlockStateProvider flowers = new WeightedBlockStateProvider(createStatePoolBuilder()
					.add(Blocks.POPPY.getDefaultState(), 12)
					.add(Blocks.AZURE_BLUET.getDefaultState(), 12)
					.add(Blocks.OXEYE_DAISY.getDefaultState(), 12)
					.add(Blocks.DANDELION.getDefaultState(), 8)
					.add(Blocks.ORANGE_TULIP.getDefaultState(), 1)
					.add(Blocks.PINK_TULIP.getDefaultState(), 1)
					.add(Blocks.RED_TULIP.getDefaultState(), 1)
					.add(Blocks.WHITE_TULIP.getDefaultState(), 1));

			LUSH_FLOWER_CONFIG = ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(flowers), List.of(), 64);
		}
	}
}
