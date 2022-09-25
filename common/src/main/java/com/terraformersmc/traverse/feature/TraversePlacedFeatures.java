package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

import static com.terraformersmc.traverse.feature.TraverseConfiguredFeatures.register;

public class TraversePlacedFeatures {
	/* Shrubs */
	public static final RegistryEntry<PlacedFeature> DESERT_EXTRA_CACTUS = createPlacedFeature("desert_extra_cactus", VegetationConfiguredFeatures.PATCH_CACTUS, RarityFilterPlacementModifier.of(13), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
	public static final RegistryEntry<PlacedFeature> DESERT_SHRUBS = createPlacedFeature("desert_shrubs", TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	/* Autumnal Trees */
	private static final RegistryEntry<PlacedFeature> RED_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("red_autumnal_tree", TraverseConfiguredFeatures.RED_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> ORANGE_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("orange_autumnal_tree", TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> YELLOW_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("yellow_autumnal_tree", TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE);
	private static final RegistryEntry<PlacedFeature> BROWN_AUTUMNAL_TREE = createPlacedFeatureWithoutBiomeFilter("brown_autumnal_tree", TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE);
	private static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> AUTUMNAL_TREES_CONFIGURED = register("autumnal_trees",
			Feature.RANDOM_SELECTOR,
			new RandomFeatureConfig(
					ImmutableList.of(
							new RandomFeatureEntry(RED_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(ORANGE_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(YELLOW_AUTUMNAL_TREE, 0.25F),
							new RandomFeatureEntry(BROWN_AUTUMNAL_TREE, 0.25F)
					), TreePlacedFeatures.OAK_CHECKED
			)
	);
	public static final RegistryEntry<PlacedFeature> AUTUMNAL_TREES = createPlacedFeature("autumnal_trees", AUTUMNAL_TREES_CONFIGURED, PlacedFeatures.createCountExtraModifier(10, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	/* Fir Trees */
	public static final RegistryEntry<PlacedFeature> CONIFEROUS_TREES = createPlacedFeature("coniferous_trees", TraverseConfiguredFeatures.FIR_TREE, PlacedFeatures.createCountExtraModifier(7, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	/* Swamp Trees */
	public static final RegistryEntry<PlacedFeature> LUSH_SWAMP_TREES = createPlacedFeature("lush_swamp_trees", TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacedFeatures.createCountExtraModifier(2, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, SurfaceWaterDepthFilterPlacementModifier.of(3), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));
	private static final RegistryEntry<ConfiguredFeature<RandomBooleanFeatureConfig, ?>> SWAMP_FUNGUS_CONFIGURED = register("swamp_fungus",
			Feature.RANDOM_BOOLEAN_SELECTOR,
			new RandomBooleanFeatureConfig(
					PlacedFeatures.createEntry(TreeConfiguredFeatures.HUGE_RED_MUSHROOM),
					PlacedFeatures.createEntry(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM)
			)
	);
	public static final RegistryEntry<PlacedFeature> SWAMP_FUNGUS = createPlacedFeature("swamp_fungus", SWAMP_FUNGUS_CONFIGURED, PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	/* Lush Vegetation */
	public static final RegistryEntry<PlacedFeature> LUSH_FLOWERS = createPlacedFeature("lush_flowers", TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilterPlacementModifier.of(32), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));
	public static final RegistryEntry<PlacedFeature> FLATLANDS_GRASS = createPlacedFeature("flatlands_grass", TraverseConfiguredFeatures.FLATLANDS_GRASS, VegetationPlacedFeatures.modifiers(15));
	public static final RegistryEntry<PlacedFeature> FLATLANDS_TREES = createPlacedFeature("flatlands_trees", TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.createCountExtraModifier(0, 0.2F, 1), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	/* Woodlands */
	private static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> WOODLANDS_TREES_CONFIGURED = register("woodlands_trees", Feature.RANDOM_SELECTOR,
					new RandomFeatureConfig(
							ImmutableList.of(
									new RandomFeatureEntry(createPlacedFeatureWithoutBiomeFilter("oak_shrub", TraverseConfiguredFeatures.OAK_SHRUB), 0.2F),
									new RandomFeatureEntry(createPlacedFeatureWithoutBiomeFilter("fallen_oak_tree", register("fallen_aok_tree", Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG)), 0.3F)
							), TreePlacedFeatures.OAK_CHECKED));
	public static final RegistryEntry<PlacedFeature> WOODLANDS_TREES = createPlacedFeature("woodlands_trees", WOODLANDS_TREES_CONFIGURED, CountPlacementModifier.of(7), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)));

	public static void init() {
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		list.add(BiomePlacementModifier.of());
		return createPlacedFeature(id, feature, list);
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeatureWithoutBiomeFilter(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		return createPlacedFeature(id, feature, list);
	}

	public static <FC extends FeatureConfig> RegistryEntry<PlacedFeature> createPlacedFeature(String id, RegistryEntry<ConfiguredFeature<FC, ?>> feature, List<PlacementModifier> placementModifiers) {
		Identifier realID = new Identifier(Traverse.MOD_ID, id);
		if (BuiltinRegistries.PLACED_FEATURE.getIds().contains(realID))
			throw new IllegalStateException("Placed Feature ID: \"" + realID.toString() + "\" already exists in the Placed Features registry!");

		return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, realID, new PlacedFeature(RegistryEntry.upcast(feature), List.copyOf(placementModifiers)));
	}
}
