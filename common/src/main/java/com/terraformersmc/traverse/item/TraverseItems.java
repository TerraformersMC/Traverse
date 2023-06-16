package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;

public class TraverseItems {
	public static Item RED_AUTUMNAL_LEAVES;
	public static Item RED_AUTUMNAL_SAPLING;
	public static Item BROWN_AUTUMNAL_LEAVES;
	public static Item BROWN_AUTUMNAL_SAPLING;
	public static Item ORANGE_AUTUMNAL_LEAVES;
	public static Item ORANGE_AUTUMNAL_SAPLING;
	public static Item YELLOW_AUTUMNAL_LEAVES;
	public static Item YELLOW_AUTUMNAL_SAPLING;

	public static Item FIR_LEAVES;
	public static Item FIR_SAPLING;

	public static Item FIR_LOG;
	public static Item FIR_WOOD;
	public static Item STRIPPED_FIR_LOG;
	public static Item STRIPPED_FIR_WOOD;
	public static Item FIR_PLANKS;
	public static Item FIR_SLAB;
	public static Item FIR_PRESSURE_PLATE;
	public static Item FIR_FENCE;
	public static Item FIR_TRAPDOOR;
	public static Item FIR_FENCE_GATE;
	public static Item FIR_STAIRS;
	public static Item FIR_BUTTON;
	public static Item FIR_DOOR;

	public static SignItem FIR_SIGN;
	public static HangingSignItem FIR_HANGING_SIGN;

	public static void register() {
		RED_AUTUMNAL_LEAVES = TraverseRegistry.registerBlockItem("red_autumnal_leaves", TraverseBlocks.RED_AUTUMNAL_LEAVES);
		RED_AUTUMNAL_SAPLING = TraverseRegistry.registerBlockItem("red_autumnal_sapling", TraverseBlocks.RED_AUTUMNAL_SAPLING);
		BROWN_AUTUMNAL_LEAVES = TraverseRegistry.registerBlockItem("brown_autumnal_leaves", TraverseBlocks.BROWN_AUTUMNAL_LEAVES);
		BROWN_AUTUMNAL_SAPLING = TraverseRegistry.registerBlockItem("brown_autumnal_sapling", TraverseBlocks.BROWN_AUTUMNAL_SAPLING);
		ORANGE_AUTUMNAL_LEAVES = TraverseRegistry.registerBlockItem("orange_autumnal_leaves", TraverseBlocks.ORANGE_AUTUMNAL_LEAVES);
		ORANGE_AUTUMNAL_SAPLING = TraverseRegistry.registerBlockItem("orange_autumnal_sapling", TraverseBlocks.ORANGE_AUTUMNAL_SAPLING);
		YELLOW_AUTUMNAL_LEAVES = TraverseRegistry.registerBlockItem("yellow_autumnal_leaves", TraverseBlocks.YELLOW_AUTUMNAL_LEAVES);
		YELLOW_AUTUMNAL_SAPLING = TraverseRegistry.registerBlockItem("yellow_autumnal_sapling", TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);

		FIR_LEAVES = TraverseRegistry.registerBlockItem("fir_leaves", TraverseBlocks.FIR_LEAVES);
		FIR_SAPLING = TraverseRegistry.registerBlockItem("fir_sapling", TraverseBlocks.FIR_SAPLING);

		FIR_LOG = TraverseRegistry.registerBlockItem("fir_log", TraverseBlocks.FIR_LOG);
		FIR_WOOD = TraverseRegistry.registerBlockItem("fir_wood", TraverseBlocks.FIR_WOOD);
		STRIPPED_FIR_LOG = TraverseRegistry.registerBlockItem("stripped_fir_log", TraverseBlocks.STRIPPED_FIR_LOG);
		STRIPPED_FIR_WOOD = TraverseRegistry.registerBlockItem("stripped_fir_wood", TraverseBlocks.STRIPPED_FIR_WOOD);
		FIR_PLANKS = TraverseRegistry.registerBlockItem("fir_planks", TraverseBlocks.FIR_PLANKS);
		FIR_SLAB = TraverseRegistry.registerBlockItem("fir_slab", TraverseBlocks.FIR_SLAB);
		FIR_PRESSURE_PLATE = TraverseRegistry.registerBlockItem("fir_pressure_plate", TraverseBlocks.FIR_PRESSURE_PLATE);
		FIR_FENCE = TraverseRegistry.registerBlockItem("fir_fence", TraverseBlocks.FIR_FENCE);
		FIR_TRAPDOOR = TraverseRegistry.registerBlockItem("fir_trapdoor", TraverseBlocks.FIR_TRAPDOOR);
		FIR_FENCE_GATE = TraverseRegistry.registerBlockItem("fir_fence_gate", TraverseBlocks.FIR_FENCE_GATE);
		FIR_STAIRS = TraverseRegistry.registerBlockItem("fir_stairs", TraverseBlocks.FIR_STAIRS);
		FIR_BUTTON = TraverseRegistry.registerBlockItem("fir_button", TraverseBlocks.FIR_BUTTON);
		FIR_DOOR = TraverseRegistry.registerBlockItem("fir_door", TraverseBlocks.FIR_DOOR);

		FIR_SIGN = TraverseRegistry.register("fir_sign", new SignItem(new Item.Settings().maxCount(16), TraverseBlocks.FIR_SIGN, TraverseBlocks.FIR_WALL_SIGN));
		FIR_HANGING_SIGN = TraverseRegistry.register("fir_hanging_sign", new HangingSignItem(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.FIR_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
	}
}
