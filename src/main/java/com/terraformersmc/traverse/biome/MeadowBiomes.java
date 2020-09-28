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

public class MeadowBiomes {
	static final Biome MEADOW = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES)
			.addStructureFeature(ConfiguredStructureFeatures.VILLAGE_PLAINS)
			.addStructureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(15))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.FLOWER.configure(TraverseFeatureConfigs.LUSH_FLOWER_CONFIG).decorate(ConfiguredFeatures.Decorators.SPREAD_32_ABOVE).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).repeat(10))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.OAK_BEES_005.decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(0, 0.2F, 1))))
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.depth(0.1F)
			.scale(0F)
			.temperature(0.8F)
			.downfall(0.7F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x65CC53)
					.foliageColor(0x5DD64A)
			)
			.build();
}
