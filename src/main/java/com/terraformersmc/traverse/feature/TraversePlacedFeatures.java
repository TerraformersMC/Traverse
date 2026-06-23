package com.terraformersmc.traverse.feature;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

public class TraversePlacedFeatures {
	/* Shrubs */
	public static final ResourceKey<PlacedFeature> DESERT_EXTRA_CACTUS = resourceKey("desert_extra_cactus");
	public static final ResourceKey<PlacedFeature> DESERT_SHRUBS = resourceKey("desert_shrubs");

	/* Autumnal Trees */
	public static final ResourceKey<PlacedFeature> BROWN_AUTUMNAL_TREE = resourceKey("brown_autumnal_tree");
	public static final ResourceKey<PlacedFeature> ORANGE_AUTUMNAL_TREE = resourceKey("orange_autumnal_tree");
	public static final ResourceKey<PlacedFeature> RED_AUTUMNAL_TREE = resourceKey("red_autumnal_tree");
	public static final ResourceKey<PlacedFeature> YELLOW_AUTUMNAL_TREE = resourceKey("yellow_autumnal_tree");
	public static final ResourceKey<PlacedFeature> BROWN_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("brown_autumnal_tree_leaf_litter");
	public static final ResourceKey<PlacedFeature> ORANGE_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("orange_autumnal_tree_leaf_litter");
	public static final ResourceKey<PlacedFeature> RED_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("red_autumnal_tree_leaf_litter");
	public static final ResourceKey<PlacedFeature> YELLOW_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("yellow_autumnal_tree_leaf_litter");
	public static final ResourceKey<PlacedFeature> AUTUMNAL_TREES = resourceKey("autumnal_trees");

	/* Fir Trees */
	public static final ResourceKey<PlacedFeature> CONIFEROUS_TREES = resourceKey("coniferous_trees");

	/* Swamp Trees */
	public static final ResourceKey<PlacedFeature> LUSH_SWAMP_TREES = resourceKey("lush_swamp_trees");
	public static final ResourceKey<PlacedFeature> SWAMP_FUNGUS = resourceKey("swamp_fungus");

	/* Lush Vegetation */
	public static final ResourceKey<PlacedFeature> FLATLANDS_GRASS = resourceKey("flatlands_grass");
	public static final ResourceKey<PlacedFeature> FLATLANDS_TREES = resourceKey("flatlands_trees");
	public static final ResourceKey<PlacedFeature> LUSH_FLOWERS = resourceKey("lush_flowers");

	/* Woodlands */
	public static final ResourceKey<PlacedFeature> WOODLANDS_SHRUB = resourceKey("woodlands_shrub");
	public static final ResourceKey<PlacedFeature> WOODLANDS_FALLEN_LOG = resourceKey("woodlands_fallen_log");
	public static final ResourceKey<PlacedFeature> WOODLANDS_TREES = resourceKey("woodlands_trees");

	public static void bootstrap(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		/* Shrubs */
		TraverseRegistry.register(context, DESERT_EXTRA_CACTUS, VegetationFeatures.CACTUS, RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
		TraverseRegistry.register(context, DESERT_SHRUBS, TraverseConfiguredFeatures.OAK_SHRUB, VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 1), Blocks.OAK_SAPLING));

		/* Autumnal Trees */
		TraverseRegistry.register(context, BROWN_AUTUMNAL_TREE, TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.BROWN_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, ORANGE_AUTUMNAL_TREE, TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, RED_AUTUMNAL_TREE, TraverseConfiguredFeatures.RED_AUTUMNAL_TREE, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.RED_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, YELLOW_AUTUMNAL_TREE, TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING));

		TraverseRegistry.register(context, BROWN_AUTUMNAL_TREE_LEAF_LITTER, TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE_LEAF_LITTER, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.BROWN_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, ORANGE_AUTUMNAL_TREE_LEAF_LITTER, TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE_LEAF_LITTER, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, RED_AUTUMNAL_TREE_LEAF_LITTER, TraverseConfiguredFeatures.RED_AUTUMNAL_TREE_LEAF_LITTER, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.RED_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, YELLOW_AUTUMNAL_TREE_LEAF_LITTER, TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE_LEAF_LITTER, PlacementUtils.filteredByBlockSurvival(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING));
		TraverseRegistry.register(context, AUTUMNAL_TREES, TraverseConfiguredFeatures.AUTUMNAL_TREES, VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1f, 1)));

		/* Fir Trees */
		TraverseRegistry.register(context, CONIFEROUS_TREES, TraverseConfiguredFeatures.FIR_TREE, VegetationPlacements.treePlacement(PlacementUtils.countExtra(7, 0.1f, 1), TraverseBlocks.FIR_SAPLING));

		/* Swamp Trees */
		TraverseRegistry.register(context, LUSH_SWAMP_TREES, TraverseConfiguredFeatures.TALL_SWAMP_TREE, PlacementUtils.countExtra(2, 0.1f, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome(), BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)));
		TraverseRegistry.register(context, SWAMP_FUNGUS, TraverseConfiguredFeatures.SWAMP_FUNGUS, PlacementUtils.countExtra(0, 0.1f, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());

		/* Lush Vegetation */
		TraverseRegistry.register(context, FLATLANDS_GRASS, TraverseConfiguredFeatures.FLATLANDS_GRASS, VegetationPlacements.worldSurfaceSquaredWithCount(96));
		TraverseRegistry.register(context, FLATLANDS_TREES, TreeFeatures.OAK_BEES_005, PlacementUtils.countExtra(0, 0.2F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
		TraverseRegistry.register(context, LUSH_FLOWERS, TraverseConfiguredFeatures.LUSH_FLOWERS, RarityFilter.onAverageOnceEvery(32), CountPlacement.of(10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome(), CountPlacement.of(64), RandomOffsetPlacement.ofTriangle(7, 3), BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE));


		/* Woodlands */
		TraverseRegistry.register(context, WOODLANDS_SHRUB, TraverseConfiguredFeatures.OAK_SHRUB, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		TraverseRegistry.register(context, WOODLANDS_FALLEN_LOG, TraverseConfiguredFeatures.FALLEN_OAK_TREE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
		TraverseRegistry.register(context, WOODLANDS_TREES, TraverseConfiguredFeatures.WOODLANDS_TREES, CountPlacement.of(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
	}

	private static ResourceKey<PlacedFeature> resourceKey(String path) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, path));
	}
}
