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

public class WoodlandsBiomes {
	public static Biome create(FabricDynamicRegistryProvider.Entries entries) {
		return new Biome.Builder()
				.generationSettings(createGenerationSettings(entries))
				.spawnSettings(createSpawnSettings())
				.precipitation(true)
				.temperature(0.8F)
				.downfall(0.4F)
				.effects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColor(0x99A955)
						.foliageColor(0x849E4A)
						.build()
				)
				.build();
	}

	private static GenerationSettings createGenerationSettings(FabricDynamicRegistryProvider.Entries entries) {
		GenerationSettings.LookupBackedBuilder builder = new GenerationSettings.LookupBackedBuilder(entries.placedFeatures(), entries.configuredCarvers());
		addBasicFeatures(builder);
		DefaultBiomeFeatures.addDefaultOres(builder);
		DefaultBiomeFeatures.addDefaultDisks(builder);
		builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, entries.ref(TraversePlacedFeatures.WOODLANDS_TREES));
		DefaultBiomeFeatures.addForestFlowers(builder);
		DefaultBiomeFeatures.addDefaultFlowers(builder);
		DefaultBiomeFeatures.addForestGrass(builder);
		DefaultBiomeFeatures.addDefaultMushrooms(builder);
		DefaultBiomeFeatures.addDefaultVegetation(builder);
		return builder.build();
	}

	private static SpawnSettings createSpawnSettings() {
		SpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4));
		return builder.build();
	}
}
