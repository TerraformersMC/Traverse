package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class TraverseConfiguredFeatures {
	/* Logs and Shrubs */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = createRegistryKey("fallen_oak_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_SHRUB = createRegistryKey("oak_shrub");
	public static final RegistryKey<ConfiguredFeature<?, ?>> WOODLANDS_TREES = createRegistryKey("woodlands_trees");

	/* Autumnal Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMNAL_TREES = createRegistryKey("autumnal_trees");

	/* Fir Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FIR_TREE = createRegistryKey("fir_tree");

	/* Swamp Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_SWAMP_TREE = createRegistryKey("tall_swamp_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_FUNGUS = createRegistryKey("swamp_fungus");

	/* Lush Vegetation */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> registerable) {
		RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatures = registerable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
		RegistryEntryLookup<PlacedFeature> placedFeatures = registerable.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

		/* Logs and Shrubs */
		register(registerable, FALLEN_OAK_TREE, Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG);
		register(registerable, OAK_SHRUB, Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG);
		register(registerable, WOODLANDS_TREES,
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfig(
						ImmutableList.of(
								new RandomFeatureEntry(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_SHRUB), 0.2F),
								new RandomFeatureEntry(placedFeatures.getOrThrow(TraversePlacedFeatures.WOODLANDS_FALLEN_LOG), 0.3F)
						), placedFeatures.getOrThrow(TreePlacedFeatures.OAK_CHECKED)
				)
		);

		/* Autumnal Trees */
		register(registerable, BROWN_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG);
		register(registerable, ORANGE_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG);
		register(registerable, RED_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG);
		register(registerable, YELLOW_AUTUMNAL_TREE, Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG);
		register(registerable, AUTUMNAL_TREES,
				Feature.SIMPLE_RANDOM_SELECTOR,
				new SimpleRandomFeatureConfig(
						RegistryEntryList.of(
								placedFeatures.getOrThrow(TraversePlacedFeatures.BROWN_AUTUMNAL_TREE),
								placedFeatures.getOrThrow(TraversePlacedFeatures.ORANGE_AUTUMNAL_TREE),
								placedFeatures.getOrThrow(TraversePlacedFeatures.RED_AUTUMNAL_TREE),
								placedFeatures.getOrThrow(TraversePlacedFeatures.YELLOW_AUTUMNAL_TREE),
								placedFeatures.getOrThrow(TreePlacedFeatures.OAK_CHECKED)
						)
				)
		);

		/* Fir Trees */
		register(registerable, FIR_TREE, Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG);

		/* Swamp Trees */
		register(registerable, TALL_SWAMP_TREE, Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG);
		register(registerable, SWAMP_FUNGUS,
				Feature.RANDOM_BOOLEAN_SELECTOR,
				new RandomBooleanFeatureConfig(
						PlacedFeatures.createEntry(configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM)),
						PlacedFeatures.createEntry(configuredFeatures.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM))
				)
		);

		/* Lush Vegetation */
		register(registerable, FLATLANDS_GRASS, Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)), List.of(), 32));
		register(registerable, LUSH_FLOWERS, Feature.FLOWER, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG);
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
		ConfiguredFeatures.register(registerable, key, feature, config);
	}
}
