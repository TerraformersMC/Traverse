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

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class ConiferousForestBiomes {
	public static Biome create(FabricDynamicRegistryProvider.Entries entries, boolean snowy) {
		return new Biome.Builder()
				.generationSettings(generationSettings(entries, snowy))
				.spawnSettings(spawnSettings())
				.precipitation(snowy ? Biome.Precipitation.SNOW : Biome.Precipitation.RAIN)
				.temperature(snowy ? -0.5F : 0.6F)
				.downfall(0.9F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(snowy ? 0x338251 : 0x338235)
						.foliageColor(snowy ? 0x338251 : 0x338235)
						.build()
				)
				.build();
	}

	private static GenerationSettings generationSettings(FabricDynamicRegistryProvider.Entries entries, boolean snowy) {
		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addLargeFerns(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.CONIFEROUS_TREES));
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addTaigaGrass(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		if (snowy) {
			DefaultBiomeFeatures.addSweetBerryBushesSnowy(builder);
		} else {
			DefaultBiomeFeatures.addSweetBerryBushes(builder);
		}
		return builder.build();
	}

	private static SpawnSettings spawnSettings() {
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
