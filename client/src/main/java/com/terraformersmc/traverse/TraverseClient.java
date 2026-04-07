package com.terraformersmc.traverse;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEntityRenderers();
		registerRenderLayers();
	}

	private static void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayers(TraverseBoats.FIR);
	}

	private static void registerRenderLayers() {
		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, TraverseBlocks.FIR_SAPLING, TraverseBlocks.FIR_DOOR, TraverseBlocks.FIR_TRAPDOOR);
		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);
		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING);
	}
}
