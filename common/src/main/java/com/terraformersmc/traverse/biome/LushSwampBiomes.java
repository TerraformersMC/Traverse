package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class LushSwampBiomes {
	public static Biome create(FabricDynamicRegistryProvider.Entries entries) {
		return new Biome.Builder()
				.generationSettings(createGenerationSettings(entries))
				.spawnSettings(createSpawnSettings())
				.precipitation(true)
				.temperature(0.8F)
				.downfall(0.9F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(0x7FE03E)
						.foliageColor(0x58EA33)
						.waterColor(0x617B64)
						.waterFogColor(0x232317)
						.build())
				.build();
	}

	public static GenerationSettings createGenerationSettings(FabricDynamicRegistryProvider.Entries entries) {
		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());
		DefaultBiomeFeatures.addFossils(builder);
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addClayDisk(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.SWAMP_FUNGUS));
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.LUSH_SWAMP_TREES));
		DefaultBiomeFeatures.addSwampFeatures(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addSwampVegetation(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, OceanPlacedFeatures.SEAGRASS_SWAMP);
		return builder.build();
	}

	private static SpawnSettings createSpawnSettings() {
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.SLIME, 1, 1, 1));
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FROG, 10, 2, 5));
		return builder.build();
	}
}
