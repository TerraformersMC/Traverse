package io.github.terraformersmc.traverse.biome;

import io.github.terraformersmc.traverse.feature.TraverseFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

public class TraverseDefaultBiomeFeatures {

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
