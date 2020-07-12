package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

public class WoodlandsBiomes {
	static final Biome WOODLANDS = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addStructureFeature(DefaultBiomeFeatures.PLAINS_VILLAGE)
			.addStructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST)
			.addStructureFeature(DefaultBiomeFeatures.STANDARD_RUINED_PORTAL)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
							ImmutableList.of(Feature.TREE.configure(TraverseFeatureConfigs.OAK_SHRUB_CONFIG)
											.withChance(0.2F),
									Feature.TREE.configure(TraverseFeatureConfigs.FALLEN_OAK_TREE_CONFIG)
											.withChance(0.3F)),
							Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
							.createDecoratedFeature(Decorator.COUNT_HEIGHTMAP.configure(new CountDecoratorConfig(7))))
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.category(Biome.Category.FOREST)
			.depth(0.15F)
			.scale(0.05F)
			.temperature(0.8F)
			.downfall(0.4F)
			.grassColor(0x99A955)
			.foliageColor(0x849E4A)
			.build();
}
