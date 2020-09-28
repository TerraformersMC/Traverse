package com.terraformersmc.traverse.biome;

import com.terraformersmc.terraform.biome.builder.DefaultFeature;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class WoodedIslandBiomes {
	static final Biome WOODED_ISLAND = TraverseBiomes.BIOME_TEMPLATE.builder()
			.configureSurfaceBuilder(TraverseSurfaceBuilders.WOODED_ISLAND, SurfaceBuilder.GRASS_CONFIG)
			.addDefaultFeatures(DefaultFeature.LAKES, DefaultFeature.FOREST_FLOWERS, DefaultFeature.DEFAULT_FLOWERS, DefaultFeature.FOREST_GRASS, DefaultFeature.FOREST_TREES, DefaultFeature.LESS_KELP)
			.addStructureFeature(ConfiguredStructureFeatures.RUINED_PORTAL)
			.addDefaultSpawnEntries()
			.addSpawnEntry(new SpawnSettings.SpawnEntry(EntityType.WOLF, 5, 4, 4))
			.category(Biome.Category.FOREST)
			.depth(0.1F)
			.scale(0.6F)
			.temperature(0.8F)
			.downfall(0.8F)
			.build();
}
