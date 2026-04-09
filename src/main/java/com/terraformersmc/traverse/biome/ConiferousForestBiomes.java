package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static com.terraformersmc.traverse.biome.TraverseBiomes.addBasicFeatures;

public class ConiferousForestBiomes {
	public static Biome create(BootstrapContext<Biome> registerable, boolean snowy) {
		return new Biome.BiomeBuilder()
				.generationSettings(createGenerationSettings(registerable, snowy))
				.mobSpawnSettings(createSpawnSettings())
				.hasPrecipitation(true)
				.temperature(snowy ? -0.5F : 0.6F)
				.downfall(0.9F)
				.specialEffects(TraverseBiomes.createDefaultBiomeEffects()
						.grassColorOverride(snowy ? 0x338251 : 0x338235)
						.foliageColorOverride(snowy ? 0x338251 : 0x338235)
						.build()
				)
				.putAttributes(TraverseBiomes.createDefaultEnvironmentAttributes()
						.set(EnvironmentAttributes.INCREASED_FIRE_BURNOUT, true)
						.build()
				)
				.build();
	}

	private static BiomeGenerationSettings createGenerationSettings(BootstrapContext<Biome> registerable, boolean snowy) {
		HolderGetter<ConfiguredWorldCarver<?>> configuredCarvers = registerable.lookup(Registries.CONFIGURED_CARVER);
		HolderGetter<PlacedFeature> placedFeatures = registerable.lookup(Registries.PLACED_FEATURE);

		BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(placedFeatures, configuredCarvers);
		addBasicFeatures(builder);
		BiomeDefaultFeatures.addFerns(builder);
		BiomeDefaultFeatures.addDefaultOres(builder);
		BiomeDefaultFeatures.addDefaultSoftDisks(builder);
		builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, placedFeatures.getOrThrow(TraversePlacedFeatures.CONIFEROUS_TREES));
		BiomeDefaultFeatures.addDefaultFlowers(builder);
		BiomeDefaultFeatures.addTaigaGrass(builder);
		BiomeDefaultFeatures.addDefaultExtraVegetation(builder, true);
		if (snowy) {
			BiomeDefaultFeatures.addRareBerryBushes(builder);
		} else {
			BiomeDefaultFeatures.addCommonBerryBushes(builder);
		}
		return builder.build();
	}

	private static MobSpawnSettings createSpawnSettings() {
		net.minecraft.world.level.biome.MobSpawnSettings.Builder builder = TraverseBiomes.createDefaultSpawnSettings();
		builder.addSpawn(MobCategory.CREATURE, 5, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 4));
		return builder.build();
	}
}
