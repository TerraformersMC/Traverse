package com.terraformersmc.traverse;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class TraverseClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		registerEntityRenderers();
		registerRenderLayers();
	}

	private static void registerEntityRenderers() {
		TerraformBoatClientHelper.registerModelLayers(new Identifier(Traverse.MOD_ID, "fir"), false);
	}

	private static void registerRenderLayers() {
		RenderLayer cutout = RenderLayer.getCutout();
		BlockRenderLayerMap.INSTANCE.putBlocks(cutout, TraverseBlocks.FIR_SAPLING, TraverseBlocks.FIR_DOOR, TraverseBlocks.FIR_TRAPDOOR);
		BlockRenderLayerMap.INSTANCE.putBlocks(cutout, TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);
		BlockRenderLayerMap.INSTANCE.putBlocks(cutout, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING);
	}
}
