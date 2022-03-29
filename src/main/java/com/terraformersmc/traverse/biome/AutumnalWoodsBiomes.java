package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class AutumnalWoodsBiomes {

	static final Biome AUTUMNAL_WOODS = TraverseBiomes.BIOME_TEMPLATE
			.generationSettings(generationSettings())
			.category(Biome.Category.FOREST)
			.spawnSettings(spawnSettings())
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.grassColor(0xD6C23D)
					.foliageColor(0xD2D31F).build()
			)
			.temperature(0.8F)
			.downfall(0.4F)
			//.depth(0.2F)
			//.scale(0.05F)
			//.playerSpawnFriendly()
			.build();

	/*static final Biome AUTUMNAL_WOODED_HILLS = AUTUMNAL_WOODS_TEMPLATE.builder()
			.depth(0.45F)
			.scale(0.3F)
			.build();*/

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addForestGrass(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraverseConfiguredFeatures.AUTUMNAL_TREES);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
