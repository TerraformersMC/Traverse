package com.terraformersmc.traverse.feature.placer;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class NoneFoliagePlacer extends FoliagePlacer {
	public static final MapCodec<NoneFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((instance) -> foliagePlacerParts(instance).apply(instance, (uniformIntDistribution, uniformIntDistribution2) -> new NoneFoliagePlacer()));

	public NoneFoliagePlacer() {
		super(ConstantInt.of(0), ConstantInt.of(0));
	}

	@Override
	protected FoliagePlacerType<?> type() {
		return TraversePlacerTypes.NONE_FOLIAGE_PLACER;
	}

	@Override
	protected void createFoliage(WorldGenLevel level, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration config, int treeHeight, FoliageAttachment foliageAttachment, int foliageHeight, int leafRadius, int offset) {
		// It's the "None" placer, after all...
	}

	@Override
	public int foliageHeight(RandomSource random, int trunkHeight, TreeConfiguration config) {
		return 0;
	}

	@Override
	protected boolean shouldSkipLocation(RandomSource random, int baseHeight, int dx, int dy, int dz, boolean bl) {
		return false;
	}
}
