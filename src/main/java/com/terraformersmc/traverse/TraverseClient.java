package com.terraformersmc.traverse;

import com.terraformersmc.traverse.entity.TraverseEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.BoatEntityRenderer;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(TraverseEntities.FIR_BOAT, (dispatcher, context) -> new BoatEntityRenderer(dispatcher));
	}
}
