package com.terraformersmc.traverse.feature;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class TraverseConfiguredFeatures {

	/* Shrubs */
	static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> OAK_SHRUB = register("oak_shrub", Feature.TREE, TraverseFeatureConfigs.OAK_SHRUB_CONFIG);

	/* Autumnal Trees */
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> RED_AUTUMNAL_TREE = register("red_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> ORANGE_AUTUMNAL_TREE = register("orange_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> YELLOW_AUTUMNAL_TREE = register("yellow_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> BROWN_AUTUMNAL_TREE = register("brown_autumnal_tree", Feature.TREE, TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG);

	/* Low Ores */
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LOW_DIRT = register("low_dirt", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.DIRT.getDefaultState(), 33));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LOW_GRAVEL = register("low_gravel", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.GRAVEL.getDefaultState(), 33));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LOW_GRANITE = register("low_granite", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.GRANITE.getDefaultState(), 33));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LOW_DIORITE = register("low_diorite", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.DIORITE.getDefaultState(), 33));
	public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> LOW_ANDESITE = register("low_andesite", Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.BASE_STONE_OVERWORLD, Blocks.ANDESITE.getDefaultState(), 33));

	/* Fir Trees */
	public static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> FIR_TREE = register("fir_tree", Feature.TREE, TraverseFeatureConfigs.FIR_TREE_CONFIG);

	/* Swamp Trees */
	static final RegistryEntry<ConfiguredFeature<TreeFeatureConfig, ?>> TALL_SWAMP_TREE = register("tall_swamp_tree", Feature.TREE, TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG);

	/* Lush Vegetation */
	public static final RegistryEntry<ConfiguredFeature<RandomPatchFeatureConfig, ?>> LUSH_FLOWERS = register("lush_flowers", Feature.FLOWER, TraverseFeatureConfigs.LUSH_FLOWER_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<?, ?>> MEADOW_GRASS = register("meadow_grass", Feature.RANDOM_PATCH, VegetationConfiguredFeatures.GRASS_CONFIG);
	public static final RegistryEntry<ConfiguredFeature<?, ?>> ROLLING_HILLS_GRASS = register("rolling_hills_grass", Feature.RANDOM_PATCH, ConfiguredFeatures.Configs.GRASS_CONFIG);

	/* Mini Jungle */
	public static final ConfiguredFeature<?, ?> MINI_JUNGLE_SEAGRASS = register("mini_jungle_seagrass", ConfiguredFeatures.SEAGRASS_SWAMP.decorate(ConfiguredFeatures.Decorators.TOP_SOLID_HEIGHTMAP));
	public static final ConfiguredFeature<?, ?> MINI_JUNGLE_TREES = register("mini_jungle_trees", Feature.RANDOM_SELECTOR.configure(
			new RandomFeatureConfig(
					ImmutableList.of(ConfiguredFeatures.FANCY_OAK.withChance(0.1F)),
					ConfiguredFeatures.JUNGLE_TREE
			))
			.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
			.decorate(Decorator.COUNT_EXTRA.configure(
					new CountExtraDecoratorConfig(50, 0.1F, 1))));

	/* Rocky Edge */
	public static final ConfiguredFeature<?, ?> ROCKY_EDGE_BOULDER = register("rocky_edge_boulder", Feature.FOREST_ROCK.configure(new SingleStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeatRandomly(2));

	/* Woodlands */
	public static final ConfiguredFeature<?, ?> WOODLANDS_TREES = register("woodlands_trees", Feature.RANDOM_SELECTOR.configure(
			new RandomFeatureConfig(
					ImmutableList.of(
							Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG).withChance(0.2F),
							Feature.TREE.configure(TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG).withChance(0.3F)
					), ConfiguredFeatures.OAK))
			.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
			.decorate(Decorator.COUNT.configure(new CountConfig(7))));

	static  <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, F feature, FC config) {
		return register(id, new ConfiguredFeature<>(feature, config));
	}

	private static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<FC, ?>> register(String id, ConfiguredFeature<FC, F> cf) {
		Identifier realId = new Identifier(Traverse.MOD_ID, id);
		Preconditions.checkState(!BuiltinRegistries.CONFIGURED_FEATURE.getIds().contains(realId), "Duplicate ID: %s", id);
		return BuiltinRegistries.method_40360(BuiltinRegistries.CONFIGURED_FEATURE, realId.toString(), cf);
	}
}
