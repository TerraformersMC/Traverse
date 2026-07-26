package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.placer.FallenTrunkPlacer;
import com.terraformersmc.traverse.feature.placer.NoneFoliagePlacer;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.Weighted;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TraverseConfiguredFeatures {
	private static final PlaceOnGroundDecorator LEAF_LITTER = new PlaceOnGroundDecorator(96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
	private static final PlaceOnGroundDecorator DENSE_LEAF_LITTER = new PlaceOnGroundDecorator(150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));

	/* Logs and Shrubs */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = resourceKey("fallen_oak_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = resourceKey("oak_shrub");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODLANDS_TREES = resourceKey("woodlands_trees");

	/* Autumnal Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE = resourceKey("brown_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE = resourceKey("orange_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE = resourceKey("red_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE = resourceKey("yellow_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("brown_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("orange_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("red_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE_LEAF_LITTER = resourceKey("yellow_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_TREES = resourceKey("autumnal_trees");

	/* Fir Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE = resourceKey("fir_tree");

	/* Swamp Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SWAMP_TREE = resourceKey("tall_swamp_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_FUNGUS = resourceKey("swamp_fungus");

	/* Lush Vegetation */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FLATLANDS_GRASS = resourceKey("flatlands_grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = resourceKey("lush_flowers");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		BlockStateProvider belowTrunkProvider = TreeConfiguration.defaultPlaceBelowTreeTrunkProvider(biomes);

		/* Logs and Shrubs */
		TraverseRegistry.register(context, FALLEN_OAK_TREE,
				Feature.TREE,
				fallenLog(
						Blocks.OAK_LOG,
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);
		TraverseRegistry.register(context, OAK_SHRUB,
				Feature.TREE,
				shrub(
						Blocks.OAK_LOG,
						Blocks.OAK_LEAVES,
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);
		TraverseRegistry.register(context, WOODLANDS_TREES,
				Feature.WEIGHTED_RANDOM_SELECTOR,
				new WeightedRandomFeatureConfiguration(
						WeightedList.of(
								new Weighted<>(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_SHRUB), 1),
								new Weighted<>(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_FALLEN_LOG), 1),
								new Weighted<>(placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER), 3)
						)
				)
		);

		/* Autumnal Trees */
		TraverseRegistry.register(context, BROWN_AUTUMNAL_TREE,
				Feature.TREE,
				oakLike(
						Blocks.OAK_LOG,
						TraverseBlocks.BROWN_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);
		TraverseRegistry.register(context, ORANGE_AUTUMNAL_TREE,
				Feature.TREE,
				oakLike(
						Blocks.OAK_LOG,
						TraverseBlocks.ORANGE_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
			.ignoreVines()
			.build()
		);
		TraverseRegistry.register(context, RED_AUTUMNAL_TREE,
				Feature.TREE,
				oakLike(
						Blocks.DARK_OAK_LOG,
						TraverseBlocks.RED_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);
		TraverseRegistry.register(context, YELLOW_AUTUMNAL_TREE,
				Feature.TREE,
				oakLike(
						Blocks.BIRCH_LOG,
						TraverseBlocks.YELLOW_AUTUMNAL_LEAVES,
						6,
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);

		TraverseRegistry.register(context, BROWN_AUTUMNAL_TREE_LEAF_LITTER,
				Feature.TREE,
				oakLike(
						Blocks.OAK_LOG,
						TraverseBlocks.BROWN_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
				.ignoreVines()
				.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER))
				.build()
		);
		TraverseRegistry.register(context, ORANGE_AUTUMNAL_TREE_LEAF_LITTER,
				Feature.TREE,
				oakLike(
						Blocks.OAK_LOG,
						TraverseBlocks.ORANGE_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
				.ignoreVines()
				.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER))
				.build()
		);
		TraverseRegistry.register(context, RED_AUTUMNAL_TREE_LEAF_LITTER,
				Feature.TREE,
				oakLike(
						Blocks.DARK_OAK_LOG,
						TraverseBlocks.RED_AUTUMNAL_LEAVES,
						4,
						belowTrunkProvider
				)
				.ignoreVines()
				.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER))
				.build()
		);
		TraverseRegistry.register(context, YELLOW_AUTUMNAL_TREE_LEAF_LITTER,
				Feature.TREE,
				oakLike(
						Blocks.BIRCH_LOG,
						TraverseBlocks.YELLOW_AUTUMNAL_LEAVES,
						6,
						belowTrunkProvider
				)
				.ignoreVines()
				.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER))
				.build()
		);
		TraverseRegistry.register(context, AUTUMNAL_TREES,
				Feature.SIMPLE_RANDOM_SELECTOR,
				new CompositeFeatureConfiguration(
						HolderSet.direct(
								placedFeatures.getOrThrow(TraversePlacedFeatures.BROWN_AUTUMNAL_TREE_LEAF_LITTER),
								placedFeatures.getOrThrow(TraversePlacedFeatures.ORANGE_AUTUMNAL_TREE_LEAF_LITTER),
								placedFeatures.getOrThrow(TraversePlacedFeatures.RED_AUTUMNAL_TREE_LEAF_LITTER),
								placedFeatures.getOrThrow(TraversePlacedFeatures.YELLOW_AUTUMNAL_TREE_LEAF_LITTER),
								placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER)
						)
				)
		);

		/* Fir Trees */
		TraverseRegistry.register(context, FIR_TREE,
				Feature.TREE,
				new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(TraverseBlocks.FIR_LOG),
						new StraightTrunkPlacer(15, 15, 4),
						BlockStateProvider.simple(TraverseBlocks.FIR_LEAVES),
						new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(1, 1), UniformInt.of(4, 12)),
						new TwoLayersFeatureSize(2, 0, 4),
						belowTrunkProvider
				)
				.ignoreVines()
				.build()
		);

		/* Swamp Trees */
		TraverseRegistry.register(context, TALL_SWAMP_TREE,
				Feature.TREE,
				new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(Blocks.OAK_LOG),
						new StraightTrunkPlacer(7, 3, 0),
						BlockStateProvider.simple(Blocks.OAK_LEAVES),
						new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3),
						new TwoLayersFeatureSize(1, 0, 1),
						belowTrunkProvider
				)
				.decorators(ImmutableList.of(new LeaveVineDecorator(0.25f)))
				.build()
		);
		TraverseRegistry.register(context, SWAMP_FUNGUS,
				Feature.RANDOM_BOOLEAN_SELECTOR,
				new RandomBooleanFeatureConfiguration(
						PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM)),
						PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM))
				)
		);

		/* Lush Vegetation */
		TraverseRegistry.register(context, FLATLANDS_GRASS,
				Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS))
		);
		TraverseRegistry.register(context, LUSH_FLOWERS,
				Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(new WeightedStateProvider(new WeightedList.Builder<BlockState>()
						.add(Blocks.POPPY.defaultBlockState(), 12)
						.add(Blocks.AZURE_BLUET.defaultBlockState(), 12)
						.add(Blocks.OXEYE_DAISY.defaultBlockState(), 12)
						.add(Blocks.DANDELION.defaultBlockState(), 8)
						.add(Blocks.ORANGE_TULIP.defaultBlockState(), 1)
						.add(Blocks.PINK_TULIP.defaultBlockState(), 1)
						.add(Blocks.RED_TULIP.defaultBlockState(), 1)
						.add(Blocks.WHITE_TULIP.defaultBlockState(), 1)
				))
		);
	}

	private static TreeConfiguration.TreeConfigurationBuilder fallenLog(Block trunk, BlockStateProvider belowTrunkProvider) {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(trunk),
				new FallenTrunkPlacer(3, 2, 0),
				BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()),
				new NoneFoliagePlacer(),
				new TwoLayersFeatureSize(0, 0, 0),
				belowTrunkProvider
		);
	}

	private static TreeConfiguration.TreeConfigurationBuilder shrub(Block trunk, Block leaves, BlockStateProvider belowTrunkProvider) {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(trunk),
				new StraightTrunkPlacer(1, 0, 0),
				BlockStateProvider.simple(leaves),
				new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
				new TwoLayersFeatureSize(0, 0, 0),
				belowTrunkProvider
		);
	}

	private static TreeConfiguration.TreeConfigurationBuilder oakLike(Block trunk, Block leaves, int height, BlockStateProvider belowTrunkProvider) {
		return new TreeConfiguration.TreeConfigurationBuilder(
				BlockStateProvider.simple(trunk.defaultBlockState()),
				new StraightTrunkPlacer(height, 2, 0),
				BlockStateProvider.simple(leaves.defaultBlockState()),
				new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
				new TwoLayersFeatureSize(1, 0, 1),
				belowTrunkProvider
		).ignoreVines();
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> resourceKey(String path) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, path));
	}
}
