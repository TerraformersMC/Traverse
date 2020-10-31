package com.terraformersmc.traverse.feature;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class TraverseConfiguredFeatures {

	/* Shrubs */
	public static final ConfiguredFeature<?, ?> OAK_SHRUB = register("oak_shrub", Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG));
	public static final ConfiguredFeature<?, ?> ARID_SHRUBS = register("arid_shrubs", OAK_SHRUB.decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.5F, 1))));
	public static final ConfiguredFeature<?, ?> DESERT_SHRUBS = register("desert_shrubs", OAK_SHRUB.decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1F, 1))));

	/* Autumnal Trees */
	public static final ConfiguredFeature<TreeFeatureConfig, ?> RED_AUTUMNAL_TREE = register("red_autumnal_tree", Feature.TREE.configure(TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG));
	public static final ConfiguredFeature<TreeFeatureConfig, ?> ORANGE_AUTUMNAL_TREE = register("orange_autumnal_tree", Feature.TREE.configure(TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG));
	public static final ConfiguredFeature<TreeFeatureConfig, ?> YELLOW_AUTUMNAL_TREE = register("yellow_autumnal_tree", Feature.TREE.configure(TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG));
	public static final ConfiguredFeature<TreeFeatureConfig, ?> BROWN_AUTUMNAL_TREE = register("brown_autumnal_tree", Feature.TREE.configure(TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG));
	public static final ConfiguredFeature<?, ?> AUTUMNAL_TREES = register("autumnal_trees",
			Feature.RANDOM_SELECTOR.configure(
					new RandomFeatureConfig(
							ImmutableList.of(
									RED_AUTUMNAL_TREE.withChance(0.25F),
									ORANGE_AUTUMNAL_TREE.withChance(0.25F),
									YELLOW_AUTUMNAL_TREE.withChance(0.25F),
									BROWN_AUTUMNAL_TREE.withChance(0.25F)
							), ConfiguredFeatures.OAK
					)
			).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP)
					.decorate(Decorator.COUNT_EXTRA.configure(
							new CountExtraDecoratorConfig(10, 0.1F, 1))));

	/* Low Ores */
	public static final ConfiguredFeature<?, ?> LOW_DIRT = register("low_dirt", ((Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.DIRT.getDefaultState(), 33)).method_30377(70)).spreadHorizontally()).repeat(10));
	public static final ConfiguredFeature<?, ?> LOW_GRAVEL = register("low_gravel", ((Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.GRAVEL.getDefaultState(), 33)).method_30377(70)).spreadHorizontally()).repeat(8));
	public static final ConfiguredFeature<?, ?> LOW_GRANITE = register("low_granite", ((Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.GRANITE.getDefaultState(), 33)).method_30377(70)).spreadHorizontally()).repeat(10));
	public static final ConfiguredFeature<?, ?> LOW_DIORITE = register("low_diorite", ((Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.DIORITE.getDefaultState(), 33)).method_30377(70)).spreadHorizontally()).repeat(10));
	public static final ConfiguredFeature<?, ?> LOW_ANDESITE = register("low_andesite", ((Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.ANDESITE.getDefaultState(), 33)).method_30377(70)).spreadHorizontally()).repeat(10));

	/* Fir Trees */
	public static final ConfiguredFeature<TreeFeatureConfig, ?> FIR_TREE = register("fir_tree", Feature.TREE.configure(TraverseFeatureConfigs.FIR_TREE_CONFIG));
	public static final ConfiguredFeature<?, ?> CONIFEROUS_TREES = register("coniferous_trees", FIR_TREE.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(7, 0.1F, 1))));

	/* Swamp Trees */
	public static final ConfiguredFeature<?, ?> TALL_SWAMP_TREE = register("tall_swamp_tree", Feature.TREE.configure(TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG));
	public static final ConfiguredFeature<?, ?> LUSH_SWAMP_TREES = register("lush_swamp_trees", TALL_SWAMP_TREE.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1F, 1))));

	/* Lush Vegetation */
	public static final ConfiguredFeature<?, ?> LUSH_FLOWERS = register("lush_flowers", Feature.FLOWER.configure(TraverseFeatureConfigs.LUSH_FLOWER_CONFIG).decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeat(10));
	public static final ConfiguredFeature<?, ?> MEADOW_GRASS = register("meadow_grass", Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(15));
	public static final ConfiguredFeature<?, ?> MEADOW_TREES = register("meadow_trees", ConfiguredFeatures.OAK_BEES_005.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.2F, 1))));
	public static final ConfiguredFeature<?, ?> ROLLING_HILLS_GRASS = register("rolling_hills_grass", Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(3));
	public static final ConfiguredFeature<?, ?> ROLLING_HILLS_TREES = register("rolling_hills_trees", ConfiguredFeatures.OAK_BEES_005.decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.2F, 1))));

	/* Mini Jungle */
	public static final ConfiguredFeature<?, ?> MINI_JUNGLE_SEAGRASS = register("mini_jungle_seagrass", ConfiguredFeatures.SEAGRASS_SWAMP.decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)));
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

	private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
		return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(Traverse.MOD_ID, id), feature);
	}
}
