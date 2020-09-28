package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class LushSwampBiomes {
	static final Biome LUSH_SWAMP = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(SurfaceBuilder.SWAMP, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.SWAMP_VEGETATION, DefaultFeature.FOSSILS)
			.addStructureFeature(ConfiguredStructureFeatures.SWAMP_HUT)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_SWAMP)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_SWAMP)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.TREE.configure(TraverseFeatureConfigs.TALL_SWAMP_TREE_CONFIG).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1F, 1))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_GRASS_NORMAL)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.PATCH_WATERLILLY)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.BROWN_MUSHROOM_SWAMP)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.RED_MUSHROOM_SWAMP)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1))
			.slimeSpawnBiome()
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
