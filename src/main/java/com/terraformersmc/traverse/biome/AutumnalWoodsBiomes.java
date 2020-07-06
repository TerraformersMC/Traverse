package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;

public class AutumnalWoodsBiomes {
	private static final TerraformBiome.Template AUTUMNAL_WOODS_TEMPLATE = new TerraformBiome.Template(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addStructureFeature(DefaultBiomeFeatures.STANDARD_RUINED_PORTAL)
			.addCustomFeature(
					GenerationStep.Feature.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(
							ImmutableList.of(
									Feature.TREE.configure(TraverseFeatureConfigs.RED_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
									Feature.TREE.configure(TraverseFeatureConfigs.ORANGE_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
									Feature.TREE.configure(TraverseFeatureConfigs.YELLOW_AUTUMNAL_TREE_CONFIG).withChance(0.25F),
									Feature.TREE.configure(TraverseFeatureConfigs.BROWN_AUTUMNAL_TREE_CONFIG).withChance(0.25F)
							),
							Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
							.createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(10, 0.1F, 1))))
			.category(Biome.Category.FOREST)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.grassColor(0xD6C23D)
			.foliageColor(0xD2D31F)
			.temperature(0.8F)
			.downfall(0.4F)
	);

	static final Biome AUTUMNAL_WOODS = AUTUMNAL_WOODS_TEMPLATE.builder()
			.depth(0.2F)
			.scale(0.05F)
			.build();

	static final Biome AUTUMNAL_WOODED_HILLS = AUTUMNAL_WOODS_TEMPLATE.builder()
			.depth(0.45F)
			.scale(0.3F)
			.build();
}
