package com.terraformersmc.traverse.feature.placer;

import com.terraformersmc.terraform.tree.api.placer.PlacerTypes;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TraversePlacerTypes {
	public static final FoliagePlacerType<NoneFoliagePlacer> NONE_FOLIAGE_PLACER = PlacerTypes.registerFoliagePlacer("traverse:none", NoneFoliagePlacer.CODEC);
	public static final TrunkPlacerType<FallenTrunkPlacer> FALLEN_TRUNK_PLACER = PlacerTypes.registerTrunkPlacer("traverse:fallen", FallenTrunkPlacer.CODEC);

	public static void register() {
	}
}
