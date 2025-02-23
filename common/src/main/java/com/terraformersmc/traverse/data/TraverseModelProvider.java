package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlockFamilies;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;

public class TraverseModelProvider extends FabricModelProvider {
	public TraverseModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator) {
		// Autumnals
		generator.registerSingleton(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.registerSingleton(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.registerSingleton(TraverseBlocks.RED_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.registerSingleton(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, TexturedModel.LEAVES);

		generator.registerFlowerPotPlantAndItem(TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerFlowerPotPlantAndItem(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);

		// Fir
		generator.registerCubeAllModelTexturePool(TraverseBlockFamilies.FIR.getBaseBlock()).family(TraverseBlockFamilies.FIR);
		generator.registerLog(TraverseBlocks.FIR_LOG).log(TraverseBlocks.FIR_LOG).wood(TraverseBlocks.FIR_WOOD);
		generator.registerLog(TraverseBlocks.STRIPPED_FIR_LOG).log(TraverseBlocks.STRIPPED_FIR_LOG).wood(TraverseBlocks.STRIPPED_FIR_WOOD);
		generator.registerHangingSign(TraverseBlockFamilies.FIR.getBaseBlock(), TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.FIR_WALL_HANGING_SIGN);
		generator.registerFlowerPotPlantAndItem(TraverseBlocks.FIR_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
		generator.registerSingleton(TraverseBlocks.FIR_LEAVES, TexturedModel.LEAVES);

		this.registerBlockItemModel(generator, TraverseBlocks.BROWN_AUTUMNAL_LEAVES);
		this.registerBlockItemModel(generator, TraverseBlocks.ORANGE_AUTUMNAL_LEAVES);
		this.registerBlockItemModel(generator, TraverseBlocks.RED_AUTUMNAL_LEAVES);
		this.registerBlockItemModel(generator, TraverseBlocks.YELLOW_AUTUMNAL_LEAVES);

		this.registerBlockItemModel(generator, TraverseBlocks.FIR_LEAVES);

		// Item models missed by vanilla code
		this.registerBlockItemModel(generator, TraverseBlocks.FIR_FENCE_GATE);
		this.registerBlockItemModel(generator, TraverseBlocks.FIR_PLANKS);
		this.registerBlockItemModel(generator, TraverseBlocks.FIR_PRESSURE_PLATE);
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
		// Fir
		generator.register(TraverseBoats.FIR_BOAT, Models.GENERATED);
		generator.register(TraverseBoats.FIR_CHEST_BOAT, Models.GENERATED);
	}

	/*
	 * Shorthand for registering just the item model of a block item which uses its block's model.
	 */
	private void registerBlockItemModel(BlockStateModelGenerator generator, Block block) {
		generator.registerParentedItemModel(block, ModelIds.getBlockModelId(block));
	}

	@Override
	public String getName() {
		return "Traverse Models";
	}
}
