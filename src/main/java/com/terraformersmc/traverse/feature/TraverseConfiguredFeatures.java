package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomBooleanFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.PlaceOnGroundDecorator;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class TraverseConfiguredFeatures {
	private static final PlaceOnGroundDecorator LEAF_LITTER = new PlaceOnGroundDecorator(96, 4, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 3)));
	private static final PlaceOnGroundDecorator DENSE_LEAF_LITTER = new PlaceOnGroundDecorator(150, 2, 2, new WeightedStateProvider(VegetationFeatures.leafLitterPatchBuilder(1, 4)));

	/* Logs and Shrubs */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = createRegistryKey("fallen_oak_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = createRegistryKey("oak_shrub");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WOODLANDS_TREES = createRegistryKey("woodlands_trees");

	/* Autumnal Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE_LEAF_LITTER = createRegistryKey("brown_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE_LEAF_LITTER = createRegistryKey("orange_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE_LEAF_LITTER = createRegistryKey("red_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE_LEAF_LITTER = createRegistryKey("yellow_autumnal_tree_leaf_litter");
	public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_TREES = createRegistryKey("autumnal_trees");

	/* Fir Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FIR_TREE = createRegistryKey("fir_tree");

	/* Swamp Trees */
	public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SWAMP_TREE = createRegistryKey("tall_swamp_tree");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SWAMP_FUNGUS = createRegistryKey("swamp_fungus");

	/* Lush Vegetation */
	public static final ResourceKey<ConfiguredFeature<?, ?>> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> registerable) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = registerable.lookup(Registries.CONFIGURED_FEATURE);
		HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

		/* Logs and Shrubs */
		TraverseRegistry.register(registerable, FALLEN_OAK_TREE, Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG);
		TraverseRegistry.register(registerable, OAK_SHRUB, Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG);
		TraverseRegistry.register(registerable, WOODLANDS_TREES,
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(
						ImmutableList.of(
								new WeightedPlacedFeature(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_SHRUB), 0.2F),
								new WeightedPlacedFeature(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_FALLEN_LOG), 0.3F)
						), placedFeatures.getOrThrow(TreePlacements.OAK_LEAF_LITTER)
				)
		);

		/* Autumnal Trees */
		TraverseRegistry.register(registerable, BROWN_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG.build());
		TraverseRegistry.register(registerable, ORANGE_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG.build());
		TraverseRegistry.register(registerable, RED_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG.build());
		TraverseRegistry.register(registerable, YELLOW_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG.build());

		TraverseRegistry.register(registerable, BROWN_AUTUMNAL_TREE_LEAF_LITTER, Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER)).build());
		TraverseRegistry.register(registerable, ORANGE_AUTUMNAL_TREE_LEAF_LITTER, Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER)).build());
		TraverseRegistry.register(registerable, RED_AUTUMNAL_TREE_LEAF_LITTER, Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER)).build());
		TraverseRegistry.register(registerable, YELLOW_AUTUMNAL_TREE_LEAF_LITTER, Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG.decorators(ImmutableList.of(LEAF_LITTER, DENSE_LEAF_LITTER)).build());
		TraverseRegistry.register(registerable, AUTUMNAL_TREES,
				Feature.SIMPLE_RANDOM_SELECTOR,
				new SimpleRandomFeatureConfiguration(
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
		TraverseRegistry.register(registerable, FIR_TREE, Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG);

		/* Swamp Trees */
		TraverseRegistry.register(registerable, TALL_SWAMP_TREE, Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG);
		TraverseRegistry.register(registerable, SWAMP_FUNGUS,
				Feature.RANDOM_BOOLEAN_SELECTOR,
				new RandomBooleanFeatureConfiguration(
						PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_BROWN_MUSHROOM)),
						PlacementUtils.inlinePlaced(configuredFeatures.getOrThrow(TreeFeatures.HUGE_RED_MUSHROOM))
				)
		);

		/* Lush Vegetation */
		TraverseRegistry.register(registerable, FLATLANDS_GRASS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SHORT_GRASS)));
		TraverseRegistry.register(registerable, LUSH_FLOWERS, Feature.SIMPLE_BLOCK, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG);
	}

	private static ResourceKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, name));
	}
}
