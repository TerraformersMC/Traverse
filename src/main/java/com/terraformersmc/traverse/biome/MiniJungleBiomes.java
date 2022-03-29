package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

public class MiniJungleBiomes {
	static final Biome MINI_JUNGLE = TraverseBiomes.BIOME_TEMPLATE
			.generationSettings(generationSettings())
			.spawnSettings(spawnSettings())
			.category(Biome.Category.JUNGLE)
			//.depth(-0.1F)
			//.scale(0.45F)
			.temperature(0.95F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.waterColor(0x003320)
					.waterFogColor(0x052721).build()
			)
			.build();

	private static GenerationSettings generationSettings(){
		GenerationSettings.Builder builder = TraverseBiomes.createDefaultGenerationSettings();
		//DefaultBiomeFeatures.addDefaultLakes(builder);
		DefaultBiomeFeatures.addJungleGrass(builder);
		//DefaultBiomeFeatures.addJungleVegetation(builder);
		DefaultBiomeFeatures.addExtraDefaultFlowers(builder);
		DefaultBiomeFeatures.addBamboo(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.MINI_JUNGLE_SEAGRASS);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, TraversePlacedFeatures.MINI_JUNGLE_TREES);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_SWAMP);
		return builder.build();
	}

	private static SpawnSettings spawnSettings(){
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PARROT, 40, 1, 2));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.PANDA, 1, 1, 2));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		builder.spawn(SpawnGroup.WATER_AMBIENT, new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 30, 5, 8));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.OCELOT, 2, 1, 1));
		return builder.build();
	}
}
