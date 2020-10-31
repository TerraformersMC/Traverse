package com.terraformersmc.traverse.biome;

import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.DEFAULT_MUSHROOMS;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.DEFAULT_UNDERGROUND_STRUCTURES;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.DEFAULT_VEGETATION;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.DUNGEONS;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.FROZEN_TOP_LAYER;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.LAND_CARVERS;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.MINEABLES;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.ORES;
import static com.terraformersmc.terraform.biomebuilder.DefaultFeature.SPRINGS;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import com.terraformersmc.terraform.biomebuilder.TerraformBiomeBuilder;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class LushSwampBiomes {
	static final BiomeTemplate BIOME_TEMPLATE_NO_DISKS = new BiomeTemplate(TerraformBiomeBuilder.create()
			.configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(LAND_CARVERS, DEFAULT_UNDERGROUND_STRUCTURES, DUNGEONS, MINEABLES, ORES, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS, FROZEN_TOP_LAYER)
			.addStructureFeature(ConfiguredStructureFeatures.STRONGHOLD)
			.addStructureFeature(ConfiguredStructureFeatures.MINESHAFT)
			.precipitation(Biome.Precipitation.RAIN)
			.effects(TraverseBiomes.createDefaultBiomeEffects()));

	static final Biome LUSH_SWAMP = BIOME_TEMPLATE_NO_DISKS.builder()
			.configureSurfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.SWAMP_VEGETATION, DefaultFeature.FOSSILS)
			.addStructureFeature(ConfiguredStructureFeatures.SWAMP_HUT)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_SWAMP)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_SWAMP)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.LUSH_SWAMP_TREES)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1))
			.category(Biome.Category.SWAMP)
			.depth(-0.2F)
			.scale(0.1F)
			.temperature(0.8F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x7FE03E)
					.foliageColor(0x58EA33)
					.waterColor(0x617B64)
					.waterFogColor(0x232317))
			.build();
}
