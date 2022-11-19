package com.terraformersmc.traverse;

import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.config.TraverseConfigManager;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import com.terraformersmc.traverse.feature.placer.TraversePlacerTypes;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.item.TraverseItemGroups;
import com.terraformersmc.traverse.item.TraverseItems;
import com.terraformersmc.traverse.villager.TraverseVillagerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Traverse implements ModInitializer {
	public static final String MOD_ID = "traverse";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final TraverseConfigManager CONFIG_MANAGER = new TraverseConfigManager();

	private static Boolean initialized = false;
	private static final ArrayList<Runnable> runnables = new ArrayList<>(1);

	private static void register() {
		TraverseBlocks.register();
		TraverseItems.register();
		TraverseBoatTypes.register();
		TraverseConfiguredFeatures.register();
		TraversePlacedFeatures.register();
		TraverseBiomes.register();
		TraverseVillagerTypes.register();
		TraversePlacerTypes.register();
		TraverseItemGroups.register();
	}

	@Override
	public void onInitialize() {
		register();

		// This must be after TraverseBiomes.register()
		CONFIG_MANAGER.getBiomeConfig();

		if (!FabricLoader.getInstance().isModLoaded("traverse-worldgen")) {
			Traverse.LOGGER.info("No Traverse worldgen module present; Traverse biomes will not generate.");
		}

		// At this point Traverse is completely initialized.
		initialized = true;
		for (Runnable callback : runnables) {
			callback.run();
		}
	}

	public static void callbackWhenInitialized(Runnable callback) {
		if (initialized) {
			callback.run();
		} else {
			runnables.add(callback);
		}
	}

	public static TraverseConfigManager getConfigManager() {
		return CONFIG_MANAGER;
	}
}
