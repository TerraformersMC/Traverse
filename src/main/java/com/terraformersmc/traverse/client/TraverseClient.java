package com.terraformersmc.traverse.client;

import com.terraformersmc.terraform.registry.SpriteIdentifierRegistry;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.entity.TraverseEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEntityRenderers();
		registerRenderLayers();
		registerTextures();
	}

	public static void registerEntityRenderers() {
		EntityRendererRegistry.INSTANCE.register(TraverseEntities.FIR_BOAT, (dispatcher, context) -> new BoatEntityRenderer(dispatcher));
	}

	public static void registerRenderLayers() {
		RenderLayer cutout = RenderLayer.getCutout();
		BlockRenderLayerMap.INSTANCE.putBlocks(cutout, TraverseBlocks.FIR_SAPLING, TraverseBlocks.FIR_DOOR, TraverseBlocks.FIR_TRAPDOOR);
	}

	public static void registerTextures() {
		Identifier texture = TraverseBlocks.FIR_SIGN.getTexture();
		SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, texture));
	}
}
