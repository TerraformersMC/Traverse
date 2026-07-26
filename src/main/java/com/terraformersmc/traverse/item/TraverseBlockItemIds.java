package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

@SuppressWarnings("unused")
public class TraverseBlockItemIds {
	public static BlockItemId BROWN_AUTUMNAL_LEAVES = create("brown_autumnal_leaves");
	public static BlockItemId BROWN_AUTUMNAL_SAPLING = create("brown_autumnal_sapling");
	public static BlockItemId ORANGE_AUTUMNAL_LEAVES = create("orange_autumnal_leaves");
	public static BlockItemId ORANGE_AUTUMNAL_SAPLING = create("orange_autumnal_sapling");
	public static BlockItemId RED_AUTUMNAL_LEAVES = create("red_autumnal_leaves");
	public static BlockItemId RED_AUTUMNAL_SAPLING = create("red_autumnal_sapling");
	public static BlockItemId YELLOW_AUTUMNAL_LEAVES = create("yellow_autumnal_leaves");
	public static BlockItemId YELLOW_AUTUMNAL_SAPLING = create("yellow_autumnal_sapling");

	public static BlockItemId FIR_LEAVES = create("fir_leaves");
	public static BlockItemId FIR_SAPLING = create("fir_sapling");

	public static BlockItemId FIR_LOG = create("fir_log");
	public static BlockItemId FIR_WOOD = create("fir_wood");
	public static BlockItemId STRIPPED_FIR_LOG = create("stripped_fir_log");
	public static BlockItemId STRIPPED_FIR_WOOD = create("stripped_fir_wood");
	public static BlockItemId FIR_PLANKS = create("fir_planks");
	public static BlockItemId FIR_SLAB = create("fir_slab");
	public static BlockItemId FIR_PRESSURE_PLATE = create("fir_pressure_plate");
	public static BlockItemId FIR_FENCE = create("fir_fence");
	public static BlockItemId FIR_TRAPDOOR = create("fir_trapdoor");
	public static BlockItemId FIR_FENCE_GATE = create("fir_fence_gate");
	public static BlockItemId FIR_STAIRS = create("fir_stairs");
	public static BlockItemId FIR_BUTTON = create("fir_button");
	public static BlockItemId FIR_DOOR = create("fir_door");
	public static BlockItemId FIR_SHELF = create("fir_shelf");

	public static BlockItemId FIR_SIGN = create("fir_sign");
	public static BlockItemId FIR_HANGING_SIGN = create("fir_hanging_sign");


	public static BlockItemId create(final Identifier blockId, final Identifier itemId) {
		return BlockItemId.create(blockId, itemId);
	}

	public static BlockItemId create(final String blockName, final String itemName) {
		return BlockItemId.create(Identifier.fromNamespaceAndPath(Traverse.MOD_ID, blockName), Identifier.fromNamespaceAndPath(Traverse.MOD_ID, itemName));
	}

	public static BlockItemId create(final String name) {
		Identifier id = Identifier.fromNamespaceAndPath(Traverse.MOD_ID, name);
		return BlockItemId.create(id, id);
	}
}
