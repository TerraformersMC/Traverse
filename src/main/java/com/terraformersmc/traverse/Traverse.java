package com.terraformersmc.traverse;

import com.terraformersmc.traverse.biomegen.TraverseBiolithGeneration;
import com.terraformersmc.traverse.block.TraverseBlockEntityTypes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import com.terraformersmc.traverse.config.TraverseConfigManager;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import com.terraformersmc.traverse.feature.placer.TraversePlacerTypes;
import com.terraformersmc.traverse.item.TraverseCreativeModeTabs;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.villager.TraverseVillagerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Traverse implements ModInitializer {
	public static final String MOD_ID = "traverse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final TraverseConfigManager CONFIG_MANAGER = new TraverseConfigManager();

	@Override
	public void onInitialize() {
		TraverseBlocks.register();
		TraverseItems.register();
		TraverseBlockEntityTypes.register();
		TraverseBoats.register();
		TraversePlacerTypes.register();
		TraverseFeatures.register();
		TraverseVillagerTypes.register();
		TraverseCreativeModeTabs.register();

		if (FabricLoader.getInstance().isModLoaded("biolith")) {
			Traverse.LOGGER.info("Enabling Traverse's Biolith worldgen module.");
			//TraverseSurfaceBuilders.register();
			TraverseBiolithGeneration.register();
		} else {
			Traverse.LOGGER.warn("Traverse world generation disabled; Biolith is not present.");
		}
	}

	public static TraverseConfigManager getConfigManager() {
		return CONFIG_MANAGER;
	}
}
