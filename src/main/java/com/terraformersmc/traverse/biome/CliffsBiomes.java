package com.terraformersmc.traverse.biome;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_FLOWERS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_GRASS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_MUSHROOMS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DEFAULT_VEGETATION;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DISKS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.DUNGEONS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.EMERALD_ORE;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.FROZEN_TOP_LAYER;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.LAKES;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.LAND_CARVERS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.ORES;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.SPRINGS;
import static com.terraformersmc.terraform.biome.builder.DefaultFeature.STRUCTURES;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;

public class CliffsBiomes {
	static final Biome CLIFFS = TerraformBiome.builder()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, STRUCTURES, DUNGEONS, LAKES, EMERALD_ORE, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, DEFAULT_GRASS, DEFAULT_FLOWERS)
			.addStructureFeature(DefaultBiomeFeatures.STRONGHOLD)
			.addStructureFeature(DefaultBiomeFeatures.NORMAL_MINESHAFT)
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIRT.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRAVEL.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(8, 0, 0, 70))))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.GRANITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.DIORITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, Blocks.ANDESITE.getDefaultState(), 33)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(10, 0, 0, 70))))
			.precipitation(Biome.Precipitation.RAIN)
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.waterColor(0x3F76E4)
			.waterFogColor(0x50533)
			.depth(3.6F)
			.scale(0.2F)
			.temperature(0.3F)
			.downfall(0.4F)
			.build();
}
