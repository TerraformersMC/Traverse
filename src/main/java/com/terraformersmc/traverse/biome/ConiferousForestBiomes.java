package com.terraformersmc.traverse.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.Feature;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;

public class ConiferousForestBiomes {
	private static final TerraformBiome.Template CONIFEROUS_FOREST_TEMPLATE = new TerraformBiome.Template(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE.configure(TraverseFeatureConfigs.FIR_TREE_CONFIG).createDecoratedFeature(Decorator.COUNT_EXTRA_HEIGHTMAP.configure(new CountExtraChanceDecoratorConfig(7, 0.1F, 1))))
			.addStructureFeature(Feature.PILLAGER_OUTPOST)
			.category(Biome.Category.FOREST)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.grassColor(0x338235)
			.foliageColor(0x338235)
			.temperature(0.6F)
			.downfall(0.9F)
	);

	static final Biome CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(0.4F)
			.scale(0.4F)
			.build();

	static final Biome CONIFEROUS_WOOODED_HILLS = CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1F)
			.scale(0.3F)
			.build();

	static final Biome HIGH_CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1.6F)
			.scale(0.4F)
			.temperature(0.3F)
			.build();

	private static final TerraformBiome.Template SNOWY_CONIFEROUS_FOREST_TEMPLATE = new TerraformBiome.Template(CONIFEROUS_FOREST_TEMPLATE.builder()
			.addDefaultFeature(DefaultFeature.SWEET_BERRY_BUSHES_SNOWY)
			.precipitation(Biome.Precipitation.SNOW)
			.category(Biome.Category.TAIGA)
			.grassColor(0x338251)
			.foliageColor(0x338251)
			.temperature(-0.5F)
	);

	static final Biome SNOWY_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(0.4F)
			.scale(0.4F)
			.build();

	static final Biome SNOWY_CONIFEROUS_WOOODED_HILLS = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1F)
			.scale(0.3F)
			.build();

	static final Biome SNOWY_HIGH_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(1.6F)
			.scale(0.4F)
			.temperature(-0.6F)
			.build();
}
