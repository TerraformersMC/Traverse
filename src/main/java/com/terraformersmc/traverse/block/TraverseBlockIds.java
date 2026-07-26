package com.terraformersmc.traverse.block;

import com.terraformersmc.traverse.Traverse;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.*;

@SuppressWarnings("unused")
public class TraverseBlockIds {
	public static ResourceKey<Block> BROWN_AUTUMNAL_LEAVES = create("brown_autumnal_leaves");
	public static ResourceKey<Block> BROWN_AUTUMNAL_SAPLING = create("brown_autumnal_sapling");
	public static ResourceKey<Block> ORANGE_AUTUMNAL_LEAVES = create("orange_autumnal_leaves");
	public static ResourceKey<Block> ORANGE_AUTUMNAL_SAPLING = create("orange_autumnal_sapling");
	public static ResourceKey<Block> RED_AUTUMNAL_LEAVES = create("red_autumnal_leaves");
	public static ResourceKey<Block> RED_AUTUMNAL_SAPLING = create("red_autumnal_sapling");
	public static ResourceKey<Block> YELLOW_AUTUMNAL_LEAVES = create("yellow_autumnal_leaves");
	public static ResourceKey<Block> YELLOW_AUTUMNAL_SAPLING = create("yellow_autumnal_sapling");

	public static ResourceKey<Block> FIR_LEAVES = create("fir_leaves");
	public static ResourceKey<Block> FIR_SAPLING = create("fir_sapling");

	public static ResourceKey<Block> FIR_LOG = create("fir_log");
	public static ResourceKey<Block> FIR_WOOD = create("fir_wood");
	public static ResourceKey<Block> STRIPPED_FIR_LOG = create("stripped_fir_log");
	public static ResourceKey<Block> STRIPPED_FIR_WOOD = create("stripped_fir_wood");
	public static ResourceKey<Block> FIR_PLANKS = create("fir_planks");
	public static ResourceKey<Block> FIR_SLAB = create("fir_slab");
	public static ResourceKey<Block> FIR_PRESSURE_PLATE = create("fir_pressure_plate");
	public static ResourceKey<Block> FIR_FENCE = create("fir_fence");
	public static ResourceKey<Block> FIR_TRAPDOOR = create("fir_trapdoor");
	public static ResourceKey<Block> FIR_FENCE_GATE = create("fir_fence_gate");
	public static ResourceKey<Block> FIR_STAIRS = create("fir_stairs");
	public static ResourceKey<Block> FIR_BUTTON = create("fir_button");
	public static ResourceKey<Block> FIR_DOOR = create("fir_door");
	public static ResourceKey<Block> FIR_SHELF = create("fir_shelf");

	public static ResourceKey<Block> FIR_SIGN = create("fir_sign");
	public static ResourceKey<Block> FIR_WALL_SIGN = create("fir_wall_sign");
	public static ResourceKey<Block> FIR_HANGING_SIGN = create("fir_hanging_sign");
	public static ResourceKey<Block> FIR_WALL_HANGING_SIGN = create("fir_wall_hanging_sign");

	public static ResourceKey<Block> POTTED_BROWN_AUTUMNAL_SAPLING = create("potted_brown_autumnal_sapling");
	public static ResourceKey<Block> POTTED_ORANGE_AUTUMNAL_SAPLING = create("potted_orange_autumnal_sapling");
	public static ResourceKey<Block> POTTED_RED_AUTUMNAL_SAPLING = create("potted_red_autumnal_sapling");
	public static ResourceKey<Block> POTTED_YELLOW_AUTUMNAL_SAPLING = create("potted_yellow_autumnal_sapling");

	public static ResourceKey<Block> POTTED_FIR_SAPLING = create("potted_fir_sapling");


	private static ResourceKey<Block> create(final String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, name));
	}
}
