package com.terraformersmc.traverse.feature.placer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.function.BiConsumer;

@NullMarked
public class FallenTrunkPlacer extends StraightTrunkPlacer {
	public static final MapCodec<FallenTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> trunkPlacerParts(instance).apply(instance, FallenTrunkPlacer::new));

	public FallenTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
		super(baseHeight, firstRandomHeight, secondRandomHeight);
	}

	@Override
	protected TrunkPlacerType<?> type() {
		return TraversePlacerTypes.FALLEN_TRUNK_PLACER;
	}

	@Override
	public List<FoliagePlacer.FoliageAttachment> placeTrunk(WorldGenLevel level, BiConsumer<BlockPos, BlockState> trunkSetter, RandomSource random, int treeHeight, BlockPos origin, TreeConfiguration config) {
		placeBelowTrunkBlock(level, trunkSetter, random, origin.below(), config);

		List<FoliagePlacer.FoliageAttachment> treeNodes = Lists.newArrayList();

		// Axis
		Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
		Direction direction = Direction.fromAxisAndDirection(axis, random.nextBoolean() ? Direction.AxisDirection.POSITIVE : Direction.AxisDirection.NEGATIVE);

		for (int i = 0; i < treeHeight; ++i) {
			placeTrunkBlock(level, trunkSetter, random, origin.relative(direction, i), config, axis, treeNodes);
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(origin, 0, false));
	}

	protected static boolean placeTrunkBlock(WorldGenLevel level, BiConsumer<BlockPos, BlockState> replacer, RandomSource random, BlockPos blockPos, TreeConfiguration treeFeatureConfig, Direction.Axis axis, List<FoliagePlacer.FoliageAttachment> treeNodes) {
		if (TreeFeature.validTreePos(level, blockPos)) {
			replacer.accept(blockPos, treeFeatureConfig.trunkProvider.getState(level, random, blockPos).setValue(RotatedPillarBlock.AXIS, axis));
			treeNodes.add(new FoliagePlacer.FoliageAttachment(blockPos.immutable(), 0, false));
			return true;
		} else {
			return false;
		}
	}
}
