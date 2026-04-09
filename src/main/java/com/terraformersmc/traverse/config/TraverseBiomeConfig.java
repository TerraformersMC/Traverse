package com.terraformersmc.traverse.config;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.Map;
import java.util.stream.Collectors;

public class TraverseBiomeConfig {
	private final Map<String, Boolean> biomes;

	TraverseBiomeConfig() {
		// This is where to set biomes to default disabled if needed (replace "k -> true").
		biomes = TraverseBiomes.BIOMES.stream().collect(Collectors.toMap(k -> k.identifier().getPath(), k -> true));
	}

	public boolean isBiomeEnabled(String name) {
		return !biomes.containsKey(name) || biomes.get(name);
	}

	public boolean isBiomeEnabled(Identifier identifier) {
		return isBiomeEnabled(identifier.getPath());
	}

	public boolean isBiomeEnabled(ResourceKey<Biome> biomeKey) {
		return isBiomeEnabled(biomeKey.identifier());
	}
}
