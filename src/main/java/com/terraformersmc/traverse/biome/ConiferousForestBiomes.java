package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.Feature;

public class ConiferousForestBiomes {
	private static final BiomeTemplate CONIFEROUS_FOREST_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.CONIFEROUS_TREES)
			.addStructureFeature(ConfiguredStructureFeatures.PILLAGER_OUTPOST)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.category(Biome.Category.FOREST)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338235)
					.foliageColor(0x338235)
			)
			.temperature(0.6F)
			.downfall(0.9F)
	);

	static final Biome CONIFEROUS_FOREST = CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(0.4F)
			.scale(0.4F)
			.playerSpawnFriendly()
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

	private static final BiomeTemplate SNOWY_CONIFEROUS_FOREST_TEMPLATE = new BiomeTemplate(CONIFEROUS_FOREST_TEMPLATE.builder()
			.addDefaultFeature(DefaultFeature.SWEET_BERRY_BUSHES_SNOWY)
			.precipitation(Biome.Precipitation.SNOW)
			.category(Biome.Category.TAIGA)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0x338251)
					.foliageColor(0x338251)
			)
			.temperature(-0.5F)
	);

	static final Biome SNOWY_CONIFEROUS_FOREST = SNOWY_CONIFEROUS_FOREST_TEMPLATE.builder()
			.depth(0.4F)
			.scale(0.4F)
			.playerSpawnFriendly()
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
