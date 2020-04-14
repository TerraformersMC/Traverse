package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.decorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

import com.terraformersmc.traverse.block.TraverseBlocks;

public class TraverseFeatureConfigs {
	public static final BranchedTreeFeatureConfig RED_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig ORANGE_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig YELLOW_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig BROWN_AUTUMNAL_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig FIR_TREE_CONFIG;
	public static final BranchedTreeFeatureConfig TALL_SWAMP_TREE_CONFIG;
	public static final RandomPatchFeatureConfig LUSH_FLOWER_CONFIG;

	private static BranchedTreeFeatureConfig oakLike(Block trunk, Block leaves, int height) {
		return new BranchedTreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(trunk.getDefaultState()),
				new SimpleBlockStateProvider(leaves.getDefaultState()),
				new BlobFoliagePlacer(2, 0)
		).baseHeight(height).heightRandA(2).foliageHeight(3).noVines().build();
	}

	static {
		RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, TraverseBlocks.RED_AUTUMNAL_LEAVES, 4);
		ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
		YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
		BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.BROWN_AUTUMNAL_LEAVES, 4);
		FIR_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(TraverseBlocks.FIR_LOG.getDefaultState()),
				new SimpleBlockStateProvider(TraverseBlocks.FIR_LEAVES.getDefaultState()),
				new SpruceFoliagePlacer(2, 1)
		).baseHeight(15).heightRandA(15).trunkHeight(3).trunkHeightRandom(3).trunkTopOffsetRandom(2).noVines().build();

		TALL_SWAMP_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder(
				new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
				new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
				new BlobFoliagePlacer(3, 0)
		).baseHeight(7).heightRandA(3).foliageHeight(3).maxWaterDepth(1).treeDecorators(ImmutableList.of(new LeaveVineTreeDecorator())).build();

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

}
