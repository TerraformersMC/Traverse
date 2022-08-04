package com.terraformersmc.traverse.config;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import java.util.Map;
import java.util.stream.Collectors;

public class TraverseBiomeConfig {
	private final Map<String, Boolean> biomes = TraverseBiomes.BIOMES.keySet().stream().collect(Collectors.toMap(k -> k.getValue().getPath(), k -> true));

	public boolean isBiomeEnabled(String name) {
		return biomes.get(name);
	}

	public boolean isBiomeEnabled(Identifier identifier) {
		return isBiomeEnabled(identifier.getPath());
	}

	public boolean isBiomeEnabled(RegistryKey<Biome> biomeKey) {
		return isBiomeEnabled(biomeKey.getValue());
	}
}
