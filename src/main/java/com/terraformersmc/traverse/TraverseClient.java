package com.terraformersmc.traverse;

import com.terraformersmc.terraform.registry.SpriteIdentifierRegistry;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.entity.TraverseEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(TraverseEntities.FIR_BOAT, (dispatcher, context) -> new BoatEntityRenderer(dispatcher));

		Identifier texture = TraverseBlocks.FIR_SIGN.getTexture();
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
	}
}
