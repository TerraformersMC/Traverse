package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlockFamilies;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class TraverseModelProvider extends FabricModelProvider {
	public TraverseModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generator) {
		// Autumnals
		generator.createTrivialBlock(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.createTrivialBlock(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.createTrivialBlock(TraverseBlocks.RED_AUTUMNAL_LEAVES, TexturedModel.LEAVES);
		generator.createTrivialBlock(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, TexturedModel.LEAVES);

		generator.createPlantWithDefaultItem(TraverseBlocks.BROWN_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generator.createPlantWithDefaultItem(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generator.createPlantWithDefaultItem(TraverseBlocks.RED_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generator.createPlantWithDefaultItem(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);

		// Fir
		generator.family(TraverseBlockFamilies.FIR.getBaseBlock()).generateFor(TraverseBlockFamilies.FIR);
		generator.createShelf(TraverseBlocks.FIR_SHELF, TraverseBlocks.STRIPPED_FIR_LOG);
		generator.woodProvider(TraverseBlocks.FIR_LOG).logWithHorizontal(TraverseBlocks.FIR_LOG).wood(TraverseBlocks.FIR_WOOD);
		generator.woodProvider(TraverseBlocks.STRIPPED_FIR_LOG).logWithHorizontal(TraverseBlocks.STRIPPED_FIR_LOG).wood(TraverseBlocks.STRIPPED_FIR_WOOD);
		generator.createPlantWithDefaultItem(TraverseBlocks.FIR_SAPLING, TraverseBlocks.POTTED_FIR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
		generator.createTrivialBlock(TraverseBlocks.FIR_LEAVES, TexturedModel.LEAVES);

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
	public void generateItemModels(ItemModelGenerators generator) {
		// Fir
		generator.generateFlatItem(TraverseBoats.FIR_BOAT, ModelTemplates.FLAT_ITEM);
		generator.generateFlatItem(TraverseBoats.FIR_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
	}

	/*
	 * Shorthand for registering just the item model of a block item which uses its block's model.
	 */
	private void registerBlockItemModel(BlockModelGenerators generator, Block block) {
		generator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block));
	}

	@Override
	public String getName() {
		return "Traverse Models";
	}
}
