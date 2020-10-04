package com.terraformersmc.traverse.feature.placer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class FallenTrunkPlacer extends StraightTrunkPlacer {
	public static final Codec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> method_28904(instance).apply(instance, FallenTrunkPlacer::new));

	public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> getType() {
		return TraversePlacerTypes.FALLEN_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig) {
		method_27400(world, pos.down());

		// Axis
		Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
		Direction direction = Direction.from(axis, random.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

		for (int i = 0; i < trunkHeight; ++i) {
			placeTrunkBlock(world, random, pos.offset(direction, i), set, blockBox, treeFeatureConfig, axis);
		}

		return ImmutableList.of(new FoliagePlacer.TreeNode(pos, 0, false));
	}

	protected static boolean placeTrunkBlock(ModifiableTestableWorld modifiableTestableWorld, Random random, BlockPos blockPos, Set<BlockPos> set, BlockBox blockBox, TreeFeatureConfig treeFeatureConfig, Direction.Axis axis) {
		if (TreeFeature.canReplace(modifiableTestableWorld, blockPos)) {
			method_27404(modifiableTestableWorld, blockPos, treeFeatureConfig.trunkProvider.getBlockState(random, blockPos).with(PillarBlock.AXIS, axis), blockBox);
			set.add(blockPos.toImmutable());
			return true;
		} else {
			return false;
		}
	}
}
