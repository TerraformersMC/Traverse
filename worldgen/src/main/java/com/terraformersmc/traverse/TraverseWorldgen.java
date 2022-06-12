package com.terraformersmc.traverse;

import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import net.fabricmc.api.ModInitializer;

public class TraverseWorldgen implements ModInitializer {
	private static void register() {
		TraverseSurfaceRules.register();
	}

	@Override
	public void onInitialize() {
		register();
	}
}
