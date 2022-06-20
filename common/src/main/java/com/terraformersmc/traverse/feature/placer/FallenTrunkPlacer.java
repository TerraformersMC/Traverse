package com.terraformersmc.traverse.feature.placer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class FallenTrunkPlacer extends StraightTrunkPlacer {
	public static final Codec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).apply(instance, FallenTrunkPlacer::new));

	public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> getType() {
		return TraversePlacerTypes.FALLEN_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int trunkHeight, BlockPos pos, TreeFeatureConfig treeFeatureConfig) {
		setToDirt(world, replacer, random, pos.down(), treeFeatureConfig);

		List<FoliagePlacer.TreeNode> treeNodes = Lists.newArrayList();

		// Axis
		Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
		Direction direction = Direction.from(axis, random.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

		for (int i = 0; i < trunkHeight; ++i) {
			placeTrunkBlock(world, replacer, random, pos.offset(direction, i), treeFeatureConfig, axis, treeNodes);
		}

		return ImmutableList.of(new FoliagePlacer.TreeNode(pos, 0, false));
	}

	protected static boolean placeTrunkBlock(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, BlockPos blockPos, TreeFeatureConfig treeFeatureConfig, Direction.Axis axis, List<FoliagePlacer.TreeNode> treeNodes) {
		if (TreeFeature.canReplace(world, blockPos)) {
			replacer.accept(blockPos, treeFeatureConfig.trunkProvider.getBlockState(random, blockPos).with(PillarBlock.AXIS, axis));
			treeNodes.add(new FoliagePlacer.TreeNode(blockPos.toImmutable(), 0, false));
			return true;
		} else {
			return false;
		}
	}
}
