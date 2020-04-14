package com.terraformersmc.traverse.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.VillageFeatureConfig;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;

public class MeadowBiomes {
	static final Biome MEADOW = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES)
			.addStructureFeature(Feature.VILLAGE, new VillageFeatureConfig("village/plains/town_centers", 6))
			.addStructureFeature(Feature.PILLAGER_OUTPOST)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(15))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(TraverseFeatureConfigs.LUSH_FLOWER_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_32.configure(new CountDecoratorConfig(10))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(DefaultBiomeFeatures.OAK_TREE_WITH_MORE_BEEHIVES_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(0, 0.2F, 1))))
			.addDefaultSpawnEntries()
			.category(Biome.Category.PLAINS)
			.depth(0.1F)
			.scale(0F)
			.temperature(0.8F)
			.downfall(0.7F)
			.grassColor(0x65CC53)
			.foliageColor(0x5DD64A)
			.build();
}
