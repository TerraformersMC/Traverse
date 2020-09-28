package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.TerraformBiomeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class CliffsBiomes {
	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = MathHelper.clamp(f, -1.0F, 1.0F);
		return MathHelper.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	static final Biome CLIFFS = TerraformBiomeBuilder.create()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, LAKES, EMERALD_ORE, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, DEFAULT_GRASS, DEFAULT_FLOWERS)
			.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.DIRT.getDefaultState(), 33)).method_30377(70).spreadHorizontally().repeat(10))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.GRAVEL.getDefaultState(), 33)).method_30377(70).spreadHorizontally().repeat(8))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.GRANITE.getDefaultState(), 33)).method_30377(70).spreadHorizontally().repeat(10))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.DIORITE.getDefaultState(), 33)).method_30377(70).spreadHorizontally().repeat(10))
			.addCustomFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, Blocks.ANDESITE.getDefaultState(), 33)).method_30377(70).spreadHorizontally().repeat(10))
			.precipitation(Biome.Precipitation.RAIN)
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.waterColor(0x3F76E4)
					.waterFogColor(0x50533))
			.depth(3.6F)
			.scale(0.2F)
			.temperature(0.3F)
			.downfall(0.4F)
			.build();
}
