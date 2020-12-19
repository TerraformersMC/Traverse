package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.*;

public class CliffsBiomes {
	static final BiomeTemplate CLIFFS_TEMPLATE = new BiomeTemplate(TerraformBiomeBuilder.create()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.STONE_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, LAKES, EMERALD_ORE, ORES, DISKS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER, DEFAULT_GRASS, DEFAULT_FLOWERS)
			.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_MOUNTAIN)
			.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, TraverseConfiguredFeatures.LOW_DIRT)
			.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, TraverseConfiguredFeatures.LOW_GRAVEL)
			.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, TraverseConfiguredFeatures.LOW_GRANITE)
			.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, TraverseConfiguredFeatures.LOW_DIORITE)
			.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, TraverseConfiguredFeatures.LOW_ANDESITE)
			.precipitation(Biome.Precipitation.RAIN)
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.waterColor(0x3F76E4)
					.waterFogColor(0x50533))
			.depth(3.6F)
			.scale(0.2F)
			.downfall(0.4F)
	);

	static final Biome CLIFFS = CLIFFS_TEMPLATE.builder().temperature(0.3F).build();

	static final Biome SNOWY_CLIFFS = CLIFFS_TEMPLATE.builder().temperature(0.22F).build();
}
