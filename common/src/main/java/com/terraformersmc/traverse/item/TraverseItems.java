package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.item.*;

public class TraverseItems {
	public static BlockItem RED_AUTUMNAL_LEAVES;
	public static BlockItem RED_AUTUMNAL_SAPLING;
	public static BlockItem BROWN_AUTUMNAL_LEAVES;
	public static BlockItem BROWN_AUTUMNAL_SAPLING;
	public static BlockItem ORANGE_AUTUMNAL_LEAVES;
	public static BlockItem ORANGE_AUTUMNAL_SAPLING;
	public static BlockItem YELLOW_AUTUMNAL_LEAVES;
	public static BlockItem YELLOW_AUTUMNAL_SAPLING;

	public static BlockItem FIR_LEAVES;
	public static BlockItem FIR_SAPLING;

	public static BlockItem FIR_LOG;
	public static BlockItem FIR_WOOD;
	public static BlockItem STRIPPED_FIR_LOG;
	public static BlockItem STRIPPED_FIR_WOOD;
	public static BlockItem FIR_PLANKS;
	public static BlockItem FIR_SLAB;
	public static BlockItem FIR_PRESSURE_PLATE;
	public static BlockItem FIR_FENCE;
	public static BlockItem FIR_TRAPDOOR;
	public static BlockItem FIR_FENCE_GATE;
	public static BlockItem FIR_STAIRS;
	public static BlockItem FIR_BUTTON;
	public static BlockItem FIR_DOOR;
	public static BlockItem FIR_SHELF;

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
		FIR_SHELF = TraverseRegistry.registerBlockItem("fir_shelf", TraverseBlocks.FIR_SHELF);

		FIR_SIGN = TraverseRegistry.register("fir_sign", settings -> new SignItem(TraverseBlocks.FIR_SIGN, TraverseBlocks.FIR_WALL_SIGN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());
		FIR_HANGING_SIGN = TraverseRegistry.register("fir_hanging_sign", settings -> new HangingSignItem(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.FIR_WALL_HANGING_SIGN, settings), new Item.Properties().stacksTo(16).useBlockDescriptionPrefix());

		addCompostables();
		addFuels();
	}

	private static void addCompostables() {
		CompostableRegistry compostingRegistry = CompostableRegistry.INSTANCE;
		float LEAVES_CHANCE = compostingRegistry.get(Items.OAK_LEAVES);
		float SAPLING_CHANCE = compostingRegistry.get(Items.OAK_SAPLING);

		compostingRegistry.add(FIR_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(FIR_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(BROWN_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(BROWN_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(ORANGE_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(ORANGE_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(RED_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(RED_AUTUMNAL_SAPLING, SAPLING_CHANCE);
		compostingRegistry.add(YELLOW_AUTUMNAL_LEAVES, LEAVES_CHANCE);
		compostingRegistry.add(YELLOW_AUTUMNAL_SAPLING, SAPLING_CHANCE);
	}

	private static void addFuels() {
		FuelValueEvents.BUILD.register((builder, context) -> {
			builder.add(FIR_FENCE, 300);
			builder.add(FIR_FENCE_GATE, 300);
		});
	}
}
