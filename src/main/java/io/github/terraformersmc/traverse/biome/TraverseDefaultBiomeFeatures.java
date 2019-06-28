package io.github.terraformersmc.traverse.biome;

import io.github.terraformersmc.traverse.feature.TraverseFeatures;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.GrassFeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

public class TraverseDefaultBiomeFeatures {

    public static void addAridHighlandsShrubs(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TraverseFeatures.OAK_SHRUB, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.5F, 1)));
    }

    public static void addMeadowFeatures(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(net.minecraft.world.gen.feature.Feature.GRASS, new GrassFeatureConfig(Blocks.GRASS.getDefaultState()), Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(15)));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TraverseFeatures.MEADOW_FLOWER, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_32, new CountDecoratorConfig(10)));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.NORMAL_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(0, 0.2F, 1)));
    }

    public static void addConiferousForestTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TraverseFeatures.FIR_TREE, FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(7, 0.1F, 1)));
    }

    public static void addMiniJungleTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(
                new Feature[]{Feature.FANCY_TREE},
                new FeatureConfig[]{FeatureConfig.DEFAULT},
                new float[]{0.1F},
                TraverseFeatures.MINI_JUNGLE_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(50, 0.1F, 1)));
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(net.minecraft.world.gen.feature.Feature.WATERLILY, FeatureConfig.DEFAULT, Decorator.COUNT_HEIGHTMAP_DOUBLE, new CountDecoratorConfig(4)));
    }

    public static void addAutumnalWoodsTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(
                new Feature[]{TraverseFeatures.RED_AUTUMNAL_TREE, TraverseFeatures.BROWN_AUTUMNAL_TREE, TraverseFeatures.ORANGE_AUTUMNAL_TREE, TraverseFeatures.YELLOW_AUTUMNAL_TREE},
                new FeatureConfig[]{FeatureConfig.DEFAULT, FeatureConfig.DEFAULT, FeatureConfig.DEFAULT, FeatureConfig.DEFAULT},
                new float[]{0.25F, 0.25F, 0.25F, 0.25F},
                Feature.NORMAL_TREE, FeatureConfig.DEFAULT), Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(10, 0.1F, 1)));
    }

    public static void addWoodlandsTrees(Biome biome) {
        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(Feature.RANDOM_SELECTOR, new RandomFeatureConfig(
                new Feature[]{Feature.NORMAL_TREE},
                new FeatureConfig[]{FeatureConfig.DEFAULT},
                new float[]{0.2F},
                TraverseFeatures.OAK_SHRUB, FeatureConfig.DEFAULT), Decorator.COUNT_HEIGHTMAP, new CountDecoratorConfig(5)));
    }

}
