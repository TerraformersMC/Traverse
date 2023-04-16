package com.terraformersmc.traverse;

import com.terraformersmc.traverse.biomegen.TraverseBiolithGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class TraverseWorldgen implements ModInitializer {

	@Override
	public void onInitialize() {
		if (FabricLoader.getInstance().isModLoaded("biolith")) {
			Traverse.LOGGER.info("Enabling Traverse's Biolith worldgen module.");

			//Traverse.callbackWhenInitialized(TraverseSurfaceBuilders::init);
			Traverse.callbackWhenInitialized(new TraverseBiolithGeneration());
		} else {
			Traverse.LOGGER.warn("Traverse world generation disabled; Biolith is not present.");
		}
	}
}
