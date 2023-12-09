package com.terraformersmc.traverse.feature;

import com.terraformersmc.traverse.Traverse;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class TraverseConfiguredFeatures {
	/* Logs and Shrubs */
	static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = createRegistryKey("fallen_oak_tree");
	static final RegistryKey<ConfiguredFeature<?, ?>> OAK_SHRUB = createRegistryKey("oak_shrub");

	/* Autumnal Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_AUTUMNAL_TREE = createRegistryKey("brown_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_AUTUMNAL_TREE = createRegistryKey("orange_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> RED_AUTUMNAL_TREE = createRegistryKey("red_autumnal_tree");
	public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_AUTUMNAL_TREE = createRegistryKey("yellow_autumnal_tree");

	/* Fir Trees */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FIR_TREE = createRegistryKey("fir_tree");

	/* Swamp Trees */
	static final RegistryKey<ConfiguredFeature<?, ?>> TALL_SWAMP_TREE = createRegistryKey("tall_swamp_tree");

	/* Lush Vegetation */
	public static final RegistryKey<ConfiguredFeature<?, ?>> FLATLANDS_GRASS = createRegistryKey("flatlands_grass");
	public static final RegistryKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = createRegistryKey("lush_flowers");

	public static void populate(FabricDynamicRegistryProvider.Entries entries) {
		/* Logs and Shrubs */
		entries.add(FALLEN_OAK_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG));
		entries.add(OAK_SHRUB, configureFeature(Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG));

		/* Autumnal Trees */
		entries.add(BROWN_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG));
		entries.add(ORANGE_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG));
		entries.add(RED_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG));
		entries.add(YELLOW_AUTUMNAL_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG));

		/* Fir Trees */
		entries.add(FIR_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG));

		/* Swamp Trees */
		entries.add(TALL_SWAMP_TREE, configureFeature(Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG));

		/* Lush Vegetation */
		entries.add(FLATLANDS_GRASS, configureFeature(Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)), List.of(), 32)));
		entries.add(LUSH_FLOWERS, configureFeature(Feature.FLOWER, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG));
	}

	public static RegistryKey<ConfiguredFeature<?, ?>> createRegistryKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Traverse.MOD_ID, name));
	}

	public static <FC extends FeatureConfig, F extends Feature<FC>> ConfiguredFeature<FC, ?> configureFeature(F feature, FC config) {
		return new ConfiguredFeature<>(feature, config);
	}

	public static void register() {
		// This just creates the registry keys.  Configured Features are requested and consumed by datagen now.
	}
}
