package com.terraformersmc.traverse.biome;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.List;

public class TraverseBiomes {
	public static final ResourceKey<Biome> AUTUMNAL_WOODS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "autumnal_woods"));
	public static final ResourceKey<Biome> CONIFEROUS_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "coniferous_forest"));
	public static final ResourceKey<Biome> DESERT_SHRUBLAND = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "desert_shrubland"));
	public static final ResourceKey<Biome> FLATLANDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "flatlands"));
	public static final ResourceKey<Biome> LUSH_SWAMP = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "lush_swamp"));
	public static final ResourceKey<Biome> SNOWY_CONIFEROUS_FOREST = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "snowy_coniferous_forest"));
	public static final ResourceKey<Biome> WOODLANDS = ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "woodlands"));

	public static final List<ResourceKey<Biome>> BIOMES = List.of(
			AUTUMNAL_WOODS,
			CONIFEROUS_FOREST,
			DESERT_SHRUBLAND,
			FLATLANDS,
			LUSH_SWAMP,
			SNOWY_CONIFEROUS_FOREST,
			WOODLANDS
	);

	public static void bootstrap(BootstrapContext<Biome> context) {
		context.register(AUTUMNAL_WOODS, AutumnalWoodsBiomes.create(context));
		context.register(CONIFEROUS_FOREST, ConiferousForestBiomes.create(context, false));
		context.register(DESERT_SHRUBLAND, DesertShrublandBiomes.create(context));
		context.register(FLATLANDS, FlatlandsBiomes.create(context));
		context.register(LUSH_SWAMP, LushSwampBiomes.create(context));
		context.register(SNOWY_CONIFEROUS_FOREST, ConiferousForestBiomes.create(context, true));
		context.register(WOODLANDS, WoodlandsBiomes.create(context));
	}

	static void addBasicFeatures(BiomeGenerationSettings.Builder generationSettings) {
		BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
		BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
		BiomeDefaultFeatures.addDefaultSprings(generationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
	}

	public static net.minecraft.world.level.biome.MobSpawnSettings.Builder createDefaultSpawnSettings() {
		net.minecraft.world.level.biome.MobSpawnSettings.Builder spawnSettings = new net.minecraft.world.level.biome.MobSpawnSettings.Builder();
		addDefaultCreatureSpawnEntries(spawnSettings);
		addDefaultCaveSpawnEntries(spawnSettings);
		addDefaultMonsterSpawnEntries(spawnSettings);
		return spawnSettings;
	}

	public static void addDefaultCreatureSpawnEntries(net.minecraft.world.level.biome.MobSpawnSettings.Builder builder) {
		builder.addSpawn(MobCategory.CREATURE, 12, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 4, 4));
		builder.addSpawn(MobCategory.CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.PIG, 4, 4));
		builder.addSpawn(MobCategory.CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 4, 4));
		builder.addSpawn(MobCategory.CREATURE,  8, new MobSpawnSettings.SpawnerData(EntityType.COW, 4, 4));
	}

	public static void addDefaultCaveSpawnEntries(net.minecraft.world.level.biome.MobSpawnSettings.Builder builder) {
		builder.addSpawn(MobCategory.AMBIENT, 10, new MobSpawnSettings.SpawnerData(EntityType.BAT, 8, 8));
		builder.addSpawn(MobCategory.UNDERGROUND_WATER_CREATURE, 10, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 4, 6));
	}

	public static void addDefaultMonsterSpawnEntries(net.minecraft.world.level.biome.MobSpawnSettings.Builder builder) {
		builder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 4, 4));
		builder.addSpawn(MobCategory.MONSTER,  95, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 4, 4));
		builder.addSpawn(MobCategory.MONSTER,   5, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE_VILLAGER, 1, 1));
		builder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 4, 4));
		builder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 4, 4));
		builder.addSpawn(MobCategory.MONSTER, 100, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 4, 4));
		builder.addSpawn(MobCategory.MONSTER,  10, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 4));
		builder.addSpawn(MobCategory.MONSTER,   5, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 1, 1));
	}

	public static net.minecraft.world.level.biome.BiomeSpecialEffects.Builder createDefaultBiomeEffects() {
		return new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()
			.waterColor(0x3F76E4);
	}

	public static EnvironmentAttributeMap.Builder createDefaultEnvironmentAttributes() {
		return EnvironmentAttributeMap.builder()
			.set(EnvironmentAttributes.WATER_FOG_COLOR, 0x50533)
			.set(EnvironmentAttributes.SKY_COLOR, getSkyColor(0.2F))
			.set(EnvironmentAttributes.FOG_COLOR, 0xC0D8FF);
	}

	private static int getSkyColor(float temperature) {
		float f = temperature / 3.0F;
		f = Mth.clamp(f, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}
}
