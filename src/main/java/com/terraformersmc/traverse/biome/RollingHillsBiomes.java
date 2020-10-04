package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;

public class RollingHillsBiomes {
	static final Biome ROLLING_HILLS = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.ROLLING_HILLS_GRASS)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.LUSH_FLOWERS)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.ROLLING_HILLS_TREES)
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.depth(0.4F)
			.scale(0.3F)
			.temperature(0.5F)
			.downfall(0.8F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x7FE03E)
					.foliageColor(0x58EA33)
			)
			.build();
}
