package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableList;
import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class MiniJungleBiomes {
	static final Biome MINI_JUNGLE = TraverseBiomes.BIOME_TEMPLATE.builder()
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.JUNGLE_GRASS, DefaultFeature.JUNGLE_VEGETATION, DefaultFeature.EXTRA_DEFAULT_FLOWERS, DefaultFeature.BAMBOO)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_JUNGLE)
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SEAGRASS_SWAMP.decorate(Decorator.TOP_SOLID_HEIGHTMAP.configure(DecoratorConfig.DEFAULT)))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(ConfiguredFeatures.FANCY_OAK.withChance(0.1F)), ConfiguredFeatures.JUNGLE_TREE)).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(50, 0.1F, 1))))
			.addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.FLOWER_SWAMP)
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.PARROT, 40, 1, 2))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.PANDA, 1, 1, 2))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.TROPICAL_FISH, 30, 5, 8))
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.OCELOT, 2, 1, 1))
			.category(Biome.Category.JUNGLE)
			.depth(-0.1F)
			.scale(0.45F)
			.temperature(0.95F)
			.downfall(0.9F)
			.effects(TraverseBiomes.createDefaultBiomeEffects()
					.waterColor(0x003320)
					.waterFogColor(0x052721)
			)
			.build();
}
