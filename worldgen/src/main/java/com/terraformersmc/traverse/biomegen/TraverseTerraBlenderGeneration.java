package com.terraformersmc.traverse.biomegen;

import com.mojang.datafixers.util.Pair;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.*;

import java.util.function.Consumer;

import static com.terraformersmc.traverse.biome.TraverseBiomes.*;

public class TraverseTerraBlenderGeneration extends Region implements Runnable, TerraBlenderApi {

	public TraverseTerraBlenderGeneration() {
		super(new Identifier(Traverse.MOD_ID, "overworld"), RegionType.OVERWORLD, 5);
	}

	@Override
	public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
		this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
			builder.replaceBiome(BiomeKeys.FOREST, AUTUMNAL_WOODS);
			builder.replaceBiome(BiomeKeys.TAIGA, CONIFEROUS_FOREST);
			builder.replaceBiome(BiomeKeys.DESERT, DESERT_SHRUBLAND);
			builder.replaceBiome(BiomeKeys.PLAINS, FLATLANDS);
			builder.replaceBiome(BiomeKeys.SWAMP, LUSH_SWAMP);
			builder.replaceBiome(BiomeKeys.SNOWY_TAIGA, SNOWY_CONIFEROUS_FOREST);
			builder.replaceBiome(BiomeKeys.BIRCH_FOREST, WOODLANDS);
		});
	}

	@Override
	public void onTerraBlenderInitialized() {
		// We can't do registration stuff until both Traverse and TerraBlender are ready.
		// The run() method below will be called when Traverse is done initializing.
		Traverse.callbackWhenInitialized(this);
	}

	// Initialize TerraBlender as our biome placement provider.
	@Override
	public void run() {
		// Register the Traverse surface rules; this must happen before we call addSurfaceRules().
		TraverseSurfaceRules.register();

		// Add the Traverse Overworld surface rules via TerraBlender.
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Traverse.MOD_ID, TraverseSurfaceRules.createRules());

		// Add the biomes to Overworld generation via TerraBlender.
		Regions.register(this);
	}
}
