package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.placer.FallenTrunkPlacer;
import com.terraformersmc.traverse.feature.placer.NoneFoliagePlacer;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class TraverseFeatures {
	public static final TreeConfiguration.TreeConfigurationBuilder RED_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.DARK_OAK_LOG, TraverseBlocks.RED_AUTUMNAL_LEAVES, 4);
	public static final TreeConfiguration.TreeConfigurationBuilder ORANGE_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, 4);
	public static final TreeConfiguration.TreeConfigurationBuilder YELLOW_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.BIRCH_LOG, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, 6);
	public static final TreeConfiguration.TreeConfigurationBuilder BROWN_AUTUMNAL_TREE_CONFIG = oakLike(Blocks.OAK_LOG, TraverseBlocks.BROWN_AUTUMNAL_LEAVES, 4);
	public static final TreeConfiguration FIR_TREE_CONFIG = new TreeConfiguration.TreeConfigurationBuilder(
			BlockStateProvider.simple(TraverseBlocks.FIR_LOG.defaultBlockState()),
			new StraightTrunkPlacer(15, 15, 4),
			BlockStateProvider.simple(TraverseBlocks.FIR_LEAVES.defaultBlockState()),
			new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(1, 1), UniformInt.of(4, 12)),
			new TwoLayersFeatureSize(2, 0, 4)
	).ignoreVines().build();
	public static final TreeConfiguration TALL_SWAMP_TREE_CONFIG = new TreeConfiguration.TreeConfigurationBuilder(
			BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),
			new StraightTrunkPlacer(7, 3, 0),
			BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
			new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
			new TwoLayersFeatureSize(1, 0, 1)
	).decorators(ImmutableList.of(new LeaveVineDecorator(0.25f))).build();
	public static final TreeConfiguration OAK_SHRUB_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0))).build();
	public static final TreeConfiguration FALLEN_OAK_TREE_CONFIG = new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new FallenTrunkPlacer(3, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new NoneFoliagePlacer(), new TwoLayersFeatureSize(0, 0, 0)).build();

	public static final SimpleBlockConfiguration LUSH_FLOWER_CONFIG = new SimpleBlockConfiguration(
			new WeightedStateProvider(new WeightedList.Builder<BlockState>()
					.add(Blocks.POPPY.defaultBlockState(), 12)
					.add(Blocks.AZURE_BLUET.defaultBlockState(), 12)
					.add(Blocks.OXEYE_DAISY.defaultBlockState(), 12)
					.add(Blocks.DANDELION.defaultBlockState(), 8)
					.add(Blocks.ORANGE_TULIP.defaultBlockState(), 1)
					.add(Blocks.PINK_TULIP.defaultBlockState(), 1)
					.add(Blocks.RED_TULIP.defaultBlockState(), 1)
					.add(Blocks.WHITE_TULIP.defaultBlockState(), 1))
	);

	private static TreeConfiguration.TreeConfigurationBuilder oakLike(Block trunk, Block leaves, int height) {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(trunk.defaultBlockState()),
				new StraightTrunkPlacer(height, 2, 0),
				BlockStateProvider.simple(leaves.defaultBlockState()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1)
		).ignoreVines();
	}

	public static void register() {}
}
