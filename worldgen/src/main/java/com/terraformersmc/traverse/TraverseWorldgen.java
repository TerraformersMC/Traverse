package com.terraformersmc.traverse;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class TraverseWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded("terrablender")) {
			Traverse.LOGGER.info("Enabling Traverse's TerraBlender worldgen module.");
		} else {
			Traverse.LOGGER.warn("Traverse world generation disabled; TerraBlender is not present.");
		}
	}
}
