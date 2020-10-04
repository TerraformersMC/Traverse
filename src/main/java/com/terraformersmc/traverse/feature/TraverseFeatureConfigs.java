package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.placer.FallenTrunkPlacer;
import com.terraformersmc.traverse.feature.placer.NoneFoliagePlacer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.tree.LeaveVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class TraverseFeatureConfigs {
	public static final TreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, TraverseBlocks.RED_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
	public static final TreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.BROWN_AUTUMNAL_LEAVES, 4);
	public static final TreeFeatureConfig FIR_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(TraverseBlocks.FIR_LOG.getDefaultState()),
			new SimpleBlockStateProvider(TraverseBlocks.FIR_LEAVES.getDefaultState()),
			new SpruceFoliagePlacer(UniformIntDistribution.of(2, 1), UniformIntDistribution.of(0, 2), UniformIntDistribution.of(5, 3)),
			new StraightTrunkPlacer(15, 15, 4),
			new TwoLayersFeatureSize(2, 0, 2)
	).ignoreVines().build();
	public static final TreeFeatureConfig TALL_SWAMP_TREE_CONFIG = new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
			new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
			new BlobFoliagePlacer(UniformIntDistribution.of(3, 0), UniformIntDistribution.of(0, 0), 3),
			new StraightTrunkPlacer(7, 3, 0),
			new TwoLayersFeatureSize(1, 0, 1)
	).maxWaterDepth(1).decorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();
	public static final TreeFeatureConfig OAK_SHRUB_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new BushFoliagePlacer(UniformIntDistribution.of(2, 0), UniformIntDistribution.of(1, 0), 2), new StraightTrunkPlacer(1, 0, 0), new TwoLayersFeatureSize(0, 0, 0))).heightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES).build();
	public static final TreeFeatureConfig FALLEN_OAK_TREE_CONFIG = new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()), new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()), new NoneFoliagePlacer(), new FallenTrunkPlacer(3, 2, 0), new TwoLayersFeatureSize(0, 0, 0)).build();
	public static final RandomPatchFeatureConfig LUSH_FLOWER_CONFIG;

	private static TreeFeatureConfig oakLike(Block trunk, Block leaves, int height) {
		return new TreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(trunk.getDefaultState()),
				new SimpleBlockStateProvider(leaves.getDefaultState()),
				new BlobFoliagePlacer(UniformIntDistribution.of(2, 0), UniformIntDistribution.of(0, 0), 3),
				new StraightTrunkPlacer(height, 2, 0),
				new TwoLayersFeatureSize(1, 0, 1)
		).ignoreVines().build();
	}

	static {
		{ // Lush Flower Config
			WeightedBlockStateProvider flowers = new WeightedBlockStateProvider();

			flowers.addState(Blocks.POPPY.getDefaultState(), 12);
			flowers.addState(Blocks.AZURE_BLUET.getDefaultState(), 12);
			flowers.addState(Blocks.OXEYE_DAISY.getDefaultState(), 12);
			flowers.addState(Blocks.DANDELION.getDefaultState(), 8);
			flowers.addState(Blocks.ORANGE_TULIP.getDefaultState(), 1);
			flowers.addState(Blocks.PINK_TULIP.getDefaultState(), 1);
			flowers.addState(Blocks.RED_TULIP.getDefaultState(), 1);
			flowers.addState(Blocks.WHITE_TULIP.getDefaultState(), 1);

			LUSH_FLOWER_CONFIG = new RandomPatchFeatureConfig.Builder(flowers, new SimpleBlockPlacer()).tries(64).cannotProject().build();
		}
	}

}
