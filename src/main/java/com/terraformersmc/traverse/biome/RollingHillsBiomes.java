package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
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
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(TraverseFeatureConfigs.LUSH_FLOWER_CONFIG).decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeat(10))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(3))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.OAK.decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.2F, 1))))
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
