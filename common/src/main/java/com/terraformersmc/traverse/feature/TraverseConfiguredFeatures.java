package com.terraformersmc.traverse.feature;

import com.google.common.base.Preconditions;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomPatchFeatureConfig;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class TraverseConfiguredFeatures {

	static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> OAK_SHRUB = register("oak_shrub", Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG);

	/* Autumnal Trees */
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> RED_AUTUMNAL_TREE = register("red_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_AUTUMNAL_TREE = register("orange_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> YELLOW_AUTUMNAL_TREE = register("yellow_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BROWN_AUTUMNAL_TREE = register("brown_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG);

	/* Fir Trees */
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FIR_TREE = register("fir_tree", Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG);

	/* Swamp Trees */
	static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TALL_SWAMP_TREE = register("tall_swamp_tree", Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG);

	/* Lush Vegetation */
	public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LUSH_FLOWERS = register("lush_flowers", Feature.FLOWER, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> FLATLANDS_GRASS = register("flatlands_grass", Feature.RANDOM_PATCH, ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.GRASS)), List.of(), 32));

	static  <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, F feature, FC config) {
		return register(id, new ConfiguredFeature<>(feature, config));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, ConfiguredFeature<FC, F> cf) {
		Identifier realId = new Identifier(Traverse.MOD_ID, id);
		Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
		return BuiltinRegistries.addCasted(BuiltinRegistries.CONFIGURED_FEATURE, realId.toString(), cf);
	}
}
