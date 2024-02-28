package com.terraformersmc.traverse.feature;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

public class TraversePlacedFeatures {
	/* Shrubs */
	public static final RegistryKey<PlacedFeature> DESERT_EXTRA_CACTUS = createRegistryKey("desert_extra_cactus");
	public static final RegistryKey<PlacedFeature> DESERT_SHRUBS = createRegistryKey("desert_shrubs");

	/* Autumnal Trees */
	public static final RegistryKey<PlacedFeature> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	public static final RegistryKey<PlacedFeature> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	public static final RegistryKey<PlacedFeature> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	public static final RegistryKey<PlacedFeature> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");
	public static final RegistryKey<PlacedFeature> AUTUMNAL_TREES = createRegistryKey("autumnal_trees");

	/* Fir Trees */
	public static final RegistryKey<PlacedFeature> CONIFEROUS_TREES = createRegistryKey("coniferous_trees");

	/* Swamp Trees */
	public static final RegistryKey<PlacedFeature> LUSH_SWAMP_TREES = createRegistryKey("lush_swamp_trees");
	public static final RegistryKey<PlacedFeature> SWAMP_FUNGUS = createRegistryKey("swamp_fungus");

	/* Lush Vegetation */
	public static final RegistryKey<PlacedFeature> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<PlacedFeature> FLATLANDS_TREES = createRegistryKey("flatlands_trees");
	public static final RegistryKey<PlacedFeature> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	/* Woodlands */
	public static final RegistryKey<PlacedFeature> WOODLANDS_SHRUB = createRegistryKey("woodlands_shrub");
	public static final RegistryKey<PlacedFeature> WOODLANDS_FALLEN_LOG = createRegistryKey("woodlands_fallen_log");
	public static final RegistryKey<PlacedFeature> WOODLANDS_TREES = createRegistryKey("woodlands_trees");

	public static void bootstrap(Registerable<PlacedFeature> registerable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

		/* Shrubs */
		register(registerable, DESERT_EXTRA_CACTUS, VegetationConfiguredFeatures.PATCH_CACTUS, RarityFilterPlacementModifier.of(13), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
		register(registerable, DESERT_SHRUBS, TraverseConfiguredFeatures.OAK_SHRUB, VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), Blocks.OAK_SAPLING));

		/* Autumnal Trees */
		register(registerable, BROWN_AUTUMNAL_TREE, TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE, PlacedFeatures.wouldSurvive(TraverseBlocks.BROWN_AUTUMNAL_SAPLING));
		register(registerable, ORANGE_AUTUMNAL_TREE, TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE, PlacedFeatures.wouldSurvive(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING));
		register(registerable, RED_AUTUMNAL_TREE, TraverseConfiguredFeatures.RED_AUTUMNAL_TREE, PlacedFeatures.wouldSurvive(TraverseBlocks.RED_AUTUMNAL_SAPLING));
		register(registerable, YELLOW_AUTUMNAL_TREE, TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE, PlacedFeatures.wouldSurvive(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING));
		register(registerable, AUTUMNAL_TREES, TraverseConfiguredFeatures.AUTUMNAL_TREES, VegetationPlacedFeatures.treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1f, 1)));

		/* Fir Trees */
		register(registerable, CONIFEROUS_TREES, TraverseConfiguredFeatures.FIR_TREE, VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(7, 0.1f, 1), TraverseBlocks.FIR_SAPLING));

		/* Swamp Trees */
		register(registerable, LUSH_SWAMP_TREES, TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacedFeatures.createCountExtraModifier(2, 0.1f, 1), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(3), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BiomePlacementModifier.of(), BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)));
		register(registerable, SWAMP_FUNGUS, TraverseConfiguredFeatures.SWAMP_FUNGUS, PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

		/* Lush Vegetation */
		register(registerable, FLATLANDS_GRASS, TraverseConfiguredFeatures.FLATLANDS_GRASS, VegetationPlacedFeatures.modifiers(15));
		register(registerable, FLATLANDS_TREES, TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.createCountExtraModifier(0, 0.2F, 1), SquarePlacementModifier.of(), SurfaceWaterDepthFilterPlacementModifier.of(0), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)), BiomePlacementModifier.of());
		register(registerable, LUSH_FLOWERS, TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilterPlacementModifier.of(32), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)), BiomePlacementModifier.of());

		/* Woodlands */
		register(registerable, WOODLANDS_SHRUB, TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
		register(registerable, WOODLANDS_FALLEN_LOG, TraverseConfiguredFeatures.FALLEN_OAK_TREE, PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING));
		register(registerable, WOODLANDS_TREES, TraverseConfiguredFeatures.WOODLANDS_TREES, CountPlacementModifier.of(7), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
	}

	private static RegistryKey<PlacedFeature> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	private static void register(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		register(registerable, key, feature, list);
	}

	private static void register(Registerable<PlacedFeature> registerable, RegistryKey<PlacedFeature> key, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
		PlacedFeatures.register(registerable, key, registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE).getOrThrow(feature), list);
	}
}
