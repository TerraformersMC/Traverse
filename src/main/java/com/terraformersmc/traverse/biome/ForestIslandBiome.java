package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.MineshaftFeature;
import net.minecraft.world.gen.feature.MineshaftFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class ForestIslandBiome extends Biome {

	/*
	 * FOREST_ISLAND = register("forest_island", TerrestriaBiome.builder()
	 * 				.configuredSurfaceBuilder(TerrestriaSurfaces.BEACH, SurfaceBuilder.GRASS_CONFIG)
	 * 				.precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST)
	 * 				.depth(0.1F)
	 * 				.scale(0.6F)
	 * 				.temperature(0.8F)
	 * 				.downfall(0.8F)
	 * 				.waterColor(4159204)
	 * 				.waterFogColor(329011)
	 * 				.addDefaultFeatures(LAND_CARVERS, STRUCTURES, LAKES, DUNGEONS, FOREST_FLOWERS, MINEABLES, ORES,
	 * 						FOREST_TREES, DEFAULT_FLOWERS, FOREST_GRASS, DEFAULT_MUSHROOMS, DEFAULT_VEGETATION, SPRINGS,
	 * 						FROZEN_TOP_LAYER, MORE_SEAGRASS, LESS_KELP)
	 * 				.addStructureFeature(Feature.STRONGHOLD)
	 * 				.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL))
	 * 				.addDefaultSpawnEntries()
	 * 				.addSpawnEntry(new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4))
	 * 				.build());
	 */

	static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(TraverseSurfaceBuilders.FOREST_ISLAND, SurfaceBuilder.GRASS_CONFIG);
	static final Precipitation PRECIPITATION = Precipitation.RAIN;
	static final Category CATEGORY = Category.FOREST;
	static final float DEPTH = 0.1F;
	static final float SCALE = 0.6F;
	static final float TEMPERATURE = 0.8F;
	static final float DOWNFALL = 0.8F;
	static final int WATER_COLOR = 0x3F76E4;
	static final int WATER_FOG_COLOR = 0x50533;
	static final String PARENT = null;

	public ForestIslandBiome() {
		super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPITATION).category(CATEGORY).depth(DEPTH).scale(SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
		this.addStructureFeature(Feature.MINESHAFT, new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL));
		this.addStructureFeature(Feature.STRONGHOLD, FeatureConfig.DEFAULT);
		DefaultBiomeFeatures.addLandCarvers(this);
		DefaultBiomeFeatures.addDefaultStructures(this);
		DefaultBiomeFeatures.addDefaultLakes(this);
		DefaultBiomeFeatures.addDungeons(this);
		DefaultBiomeFeatures.addForestFlowers(this);
		DefaultBiomeFeatures.addMineables(this);
		DefaultBiomeFeatures.addDefaultOres(this);
		DefaultBiomeFeatures.addForestTrees(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addForestGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addMoreSeagrass(this);
		DefaultBiomeFeatures.addLessKelp(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		TraverseDefaultBiomeFeatures.addAridHighlandsShrubs(this);
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.RABBIT, 3, 2, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.SHEEP, 6, 3, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.PIG, 5, 3, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.CHICKEN, 5, 3, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.COW, 4, 3, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.HORSE, 1, 1, 3));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.DONKEY, 1, 1, 1));
		this.addSpawn(EntityCategory.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 19, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.HUSK, 80, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new Biome.SpawnEntry(EntityType.WOLF, 5, 4, 4));
	}

}
