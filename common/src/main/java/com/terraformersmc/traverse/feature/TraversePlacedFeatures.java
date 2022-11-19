package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class TraversePlacedFeatures {
	/* Shrubs */
	public static final RegistryKey<PlacedFeature> DESERT_EXTRA_CACTUS = createRegistryKey("desert_extra_cactus");
	public static final RegistryKey<PlacedFeature> DESERT_SHRUBS = createRegistryKey("desert_shrubs");

	/* Autumnal Trees */
	private static final RegistryKey<PlacedFeature> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	private static final RegistryKey<PlacedFeature> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	private static final RegistryKey<PlacedFeature> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	private static final RegistryKey<PlacedFeature> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");
	private static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMNAL_TREES_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("autumnal_trees");
	public static final RegistryKey<PlacedFeature> AUTUMNAL_TREES = createRegistryKey("autumnal_trees");

	/* Fir Trees */
	public static final RegistryKey<PlacedFeature> CONIFEROUS_TREES = createRegistryKey("coniferous_trees");

	/* Swamp Trees */
	public static final RegistryKey<PlacedFeature> LUSH_SWAMP_TREES = createRegistryKey("lush_swamp_trees");
	private static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_FUNGUS_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("swamp_fungus");
	public static final RegistryKey<PlacedFeature> SWAMP_FUNGUS = createRegistryKey("swamp_fungus");

	/* Lush Vegetation */
	public static final RegistryKey<PlacedFeature> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<PlacedFeature> FLATLANDS_TREES = createRegistryKey("flatlands_trees");
	public static final RegistryKey<PlacedFeature> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	/* Woodlands */
	private static final RegistryKey<PlacedFeature> WOODLANDS_SHRUB = createRegistryKey("woodlands_shrub");
	private static final RegistryKey<PlacedFeature> WOODLANDS_FALLEN_LOG = createRegistryKey("woodlands_fallen_log");
	private static final RegistryKey<ConfiguredFeature<?, ?>> WOODLANDS_TREES_CONFIGURED = TraverseConfiguredFeatures.createRegistryKey("woodlands_trees");
	public static final RegistryKey<PlacedFeature> WOODLANDS_TREES = createRegistryKey("woodlands_trees");

	public static void populate(FabricDynamicRegistryProvider.Entries entries) {
		/* Shrubs */
		entries.add(DESERT_EXTRA_CACTUS, placeFeature(entries, VegetationConfiguredFeatures.PATCH_CACTUS, RarityFilterPlacementModifier.of(13), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP));
		entries.add(DESERT_SHRUBS, placeFeature(entries, TraverseConfiguredFeatures.OAK_SHRUB, PlacedFeatures.createCountExtraModifier(1, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Autumnal Trees */
		entries.add(BROWN_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE));
		entries.add(ORANGE_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE));
		entries.add(RED_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.RED_AUTUMNAL_TREE));
		entries.add(YELLOW_AUTUMNAL_TREE, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE));
		entries.add(AUTUMNAL_TREES_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfig(
						ImmutableList.of(
								new RandomFeatureEntry(entries.ref(BROWN_AUTUMNAL_TREE), 0.25F),
								new RandomFeatureEntry(entries.ref(ORANGE_AUTUMNAL_TREE), 0.25F),
								new RandomFeatureEntry(entries.ref(RED_AUTUMNAL_TREE), 0.25F),
								new RandomFeatureEntry(entries.ref(YELLOW_AUTUMNAL_TREE), 0.25F)
						), entries.ref(TreePlacedFeatures.OAK_CHECKED)
				)
		));
		entries.add(AUTUMNAL_TREES, placeFeature(entries, AUTUMNAL_TREES_CONFIGURED, PlacedFeatures.createCountExtraModifier(10, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Fir Trees */
		entries.add(CONIFEROUS_TREES, placeFeature(entries, TraverseConfiguredFeatures.FIR_TREE, PlacedFeatures.createCountExtraModifier(7, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Swamp Trees */
		entries.add(LUSH_SWAMP_TREES, placeFeature(entries, TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacedFeatures.createCountExtraModifier(2, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP, SurfaceWaterDepthFilterPlacementModifier.of(3), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));
		entries.add(SWAMP_FUNGUS_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
				Feature.RANDOM_BOOLEAN_SELECTOR,
				new RandomBooleanFeatureConfig(
						PlacedFeatures.createEntry(entries.ref(TreeConfiguredFeatures.HUGE_RED_MUSHROOM)),
						PlacedFeatures.createEntry(entries.ref(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM))
				)
		));
		entries.add(SWAMP_FUNGUS, placeFeature(entries, SWAMP_FUNGUS_CONFIGURED, PlacedFeatures.createCountExtraModifier(0, 0.1f, 1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Lush Vegetation */
		entries.add(FLATLANDS_GRASS, placeFeature(entries, TraverseConfiguredFeatures.FLATLANDS_GRASS, VegetationPlacedFeatures.modifiers(15)));
		entries.add(FLATLANDS_TREES, placeFeature(entries, TreeConfiguredFeatures.OAK_BEES_005, PlacedFeatures.createCountExtraModifier(0, 0.2F, 1), BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));
		entries.add(LUSH_FLOWERS, placeFeature(entries, TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilterPlacementModifier.of(32), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));

		/* Woodlands */
		entries.add(WOODLANDS_SHRUB, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.OAK_SHRUB));
		entries.add(WOODLANDS_FALLEN_LOG, placeFeatureWithoutBiomeFilter(entries, TraverseConfiguredFeatures.FALLEN_OAK_TREE));
		entries.add(WOODLANDS_TREES_CONFIGURED, TraverseConfiguredFeatures.configureFeature(
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfig(
						ImmutableList.of(
								new RandomFeatureEntry(entries.ref(WOODLANDS_SHRUB), 0.2F),
								new RandomFeatureEntry(entries.ref(WOODLANDS_FALLEN_LOG), 0.3F)
						), entries.ref(TreePlacedFeatures.OAK_CHECKED)
				)
		));
		entries.add(WOODLANDS_TREES, placeFeature(entries, WOODLANDS_TREES_CONFIGURED, CountPlacementModifier.of(7), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BlockFilterPlacementModifier.of(BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT))));
	}

	public static RegistryKey<PlacedFeature> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		list.add(BiomePlacementModifier.of());
		return placeFeature(entries, feature, list);

	}

	private static PlacedFeature placeFeatureWithoutBiomeFilter(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, PlacementModifier... placementModifiers) {
		List<PlacementModifier> list = new ArrayList<>(List.of(placementModifiers));
		return placeFeature(entries, feature, list);
	}

	private static PlacedFeature placeFeature(FabricDynamicRegistryProvider.Entries entries, RegistryKey<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> list) {
		return new PlacedFeature(entries.ref(feature), list);
	}

	public static void register() {
		// This just creates the registry keys.  Placed Features are requested and consumed by datagen now.
	}
}
