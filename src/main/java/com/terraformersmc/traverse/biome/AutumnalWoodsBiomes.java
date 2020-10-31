package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biomebuilder.BiomeTemplate;
import com.terraformersmc.terraform.biomebuilder.DefaultFeature;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;

public class AutumnalWoodsBiomes {
	private static final BiomeTemplate AUTUMNAL_WOODS_TEMPLATE = new BiomeTemplate(TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.FOREST_GRASS)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.AUTUMNAL_TREES)
			.category(Biome.Category.FOREST)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0xD6C23D)
					.foliageColor(0xD2D31F)
			)
			.temperature(0.8F)
			.downfall(0.4F)
	);

	static final Biome AUTUMNAL_WOODS = AUTUMNAL_WOODS_TEMPLATE.builder()
			.depth(0.2F)
			.scale(0.05F)
			.playerSpawnFriendly()
			.build();

	static final Biome AUTUMNAL_WOODED_HILLS = AUTUMNAL_WOODS_TEMPLATE.builder()
			.depth(0.45F)
			.scale(0.3F)
			.build();
}
