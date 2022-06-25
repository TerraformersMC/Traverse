package com.terraformersmc.traverse.biome;

import com.google.common.collect.ImmutableMap;
import com.terraformersmc.terraform.biomeremapper.api.BiomeRemapperApi;
import com.terraformersmc.terraform.biomeremapper.api.DataVersions;
import com.terraformersmc.traverse.Traverse;

public class TraverseBiomeRemappings implements BiomeRemapperApi {
	public void init() {
		register(Traverse.MOD_ID, DataVersions.V_1_18_2, ImmutableMap.<String, String>builder()
				.put("traverse:arid_highlands", "minecraft:windswept_savanna")
				.put("traverse:autumnal_wooded_hills", "traverse:autumnal_woods")
				.put("traverse:cliffs", "minecraft:stony_peaks")
				.put("traverse:coniferous_wooded_hills", "traverse:coniferous_forest")
				.put("traverse:high_coniferous_forest", "traverse:coniferous_forest")
				.put("traverse:meadow", "traverse:flatlands")
				.put("traverse:mini_jungle", "minecraft:jungle")
				.put("traverse:plains_plateau", "minecraft:plains")
				.put("traverse:rocky_edge", "minecraft:plains")
				.put("traverse:rolling_hills", "minecraft:windswept_forest")
				.put("traverse:snowy_cliffs", "minecraft:jagged_peaks")
				.put("traverse:snowy_coniferous_wooded_hills", "traverse:snowy_coniferous_forest")
				.put("traverse:snowy_high_coniferous_forest", "traverse:snowy_coniferous_forest")
				.put("traverse:wooded_island", "minecraft:forest")
				.put("traverse:wooded_plateau", "minecraft:forest")
				.build());
	}
}
