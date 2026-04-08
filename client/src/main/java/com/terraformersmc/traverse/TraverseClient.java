package com.terraformersmc.traverse;

import com.terraformersmc.terraform.boat.api.TerraformBoatClientHelper;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.api.ClientModInitializer;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEntityRenderers();
	}

	private static void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayers(TraverseBoats.FIR);
	}
}
