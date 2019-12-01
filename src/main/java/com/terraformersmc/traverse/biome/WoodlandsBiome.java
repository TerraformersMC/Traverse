package com.terraformersmc.traverse.biome;

import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class WoodlandsBiome extends Biome {

	static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG);
	static final Precipitation PRECIPITATION = Precipitation.RAIN;
	static final Category CATEGORY = Category.FOREST;
	static final float DEPTH = 0.15F;
	static final float SCALE = 0.05F;
	static final float TEMPERATURE = 0.8F;
	static final float DOWNFALL = 0.4F;
	static final int WATER_COLOR = 0x3F76E4;
	static final int WATER_FOG_COLOR = 0x50533;
	static final int GRASS_COLOR = 0x99A955;
	static final int FOLIAGE_COLOR = 0x849E4A;
	static final String PARENT = null;

	public WoodlandsBiome() {
		super(new Settings().surfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPITATION).category(CATEGORY).depth(DEPTH).scale(SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).parent(PARENT));
		this.addStructureFeature(Feature.VILLAGE.configure(new VillageFeatureConfig("village/plains/town_centers", 6)));
		this.addStructureFeature(Feature.MINESHAFT.configure(new MineshaftFeatureConfig(0.004D, MineshaftFeature.Type.NORMAL)));
		this.addStructureFeature(Feature.PILLAGER_OUTPOST.configure(FeatureConfig.DEFAULT));
		this.addStructureFeature(Feature.STRONGHOLD.configure(FeatureConfig.DEFAULT));
		DefaultBiomeFeatures.addLandCarvers(this);
		DefaultBiomeFeatures.addDefaultStructures(this);
		DefaultBiomeFeatures.addDefaultLakes(this);
		DefaultBiomeFeatures.addDungeons(this);
		DefaultBiomeFeatures.addForestFlowers(this);
		DefaultBiomeFeatures.addMineables(this);
		DefaultBiomeFeatures.addDefaultOres(this);
		DefaultBiomeFeatures.addDefaultDisks(this);
		DefaultBiomeFeatures.addDefaultFlowers(this);
		DefaultBiomeFeatures.addForestGrass(this);
		DefaultBiomeFeatures.addDefaultMushrooms(this);
		DefaultBiomeFeatures.addDefaultVegetation(this);
		DefaultBiomeFeatures.addSprings(this);
		DefaultBiomeFeatures.addFrozenTopLayer(this);
		TraverseDefaultBiomeFeatures.addWoodlandsTrees(this, 7);
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.SHEEP, 12, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.PIG, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.COW, 8, 4, 4));
		this.addSpawn(EntityCategory.CREATURE, new SpawnEntry(EntityType.WOLF, 5, 4, 4));
		this.addSpawn(EntityCategory.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE, 95, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
		this.addSpawn(EntityCategory.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
	}

	@Override
	public int getGrassColorAt(double x, double z) {
		return GRASS_COLOR;
	}

	@Override
	public int getFoliageColorAt() {
		return FOLIAGE_COLOR;
	}

}
