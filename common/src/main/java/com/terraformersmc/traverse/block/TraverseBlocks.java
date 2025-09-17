package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.leaves.api.block.ColoredParticleLeavesBlock;
import com.terraformersmc.terraform.wood.api.block.PillarLogHelper;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.Optional;

public class TraverseBlocks {
	public static Block RED_AUTUMNAL_LEAVES;
	public static Block RED_AUTUMNAL_SAPLING;
	public static Block BROWN_AUTUMNAL_LEAVES;
	public static Block BROWN_AUTUMNAL_SAPLING;
	public static Block ORANGE_AUTUMNAL_LEAVES;
	public static Block ORANGE_AUTUMNAL_SAPLING;
	public static Block YELLOW_AUTUMNAL_LEAVES;
	public static Block YELLOW_AUTUMNAL_SAPLING;

	public static Block FIR_LEAVES;
	public static Block FIR_SAPLING;

	public static Block FIR_LOG;
	public static Block FIR_WOOD;
	public static Block STRIPPED_FIR_LOG;
	public static Block STRIPPED_FIR_WOOD;
	public static Block FIR_PLANKS;
	public static Block FIR_SLAB;
	public static Block FIR_PRESSURE_PLATE;
	public static Block FIR_FENCE;
	public static Block FIR_TRAPDOOR;
	public static Block FIR_FENCE_GATE;
	public static Block FIR_STAIRS;
	public static Block FIR_BUTTON;
	public static Block FIR_DOOR;
	public static Block FIR_SHELF;

	public static SignBlock FIR_SIGN;
	public static WallSignBlock FIR_WALL_SIGN;
	public static HangingSignBlock FIR_HANGING_SIGN;
	public static WallHangingSignBlock FIR_WALL_HANGING_SIGN;

	public static Block POTTED_RED_AUTUMNAL_SAPLING;
	public static Block POTTED_BROWN_AUTUMNAL_SAPLING;
	public static Block POTTED_ORANGE_AUTUMNAL_SAPLING;
	public static Block POTTED_YELLOW_AUTUMNAL_SAPLING;
	public static Block POTTED_FIR_SAPLING;

	public static void register() {
		BROWN_AUTUMNAL_LEAVES = TraverseRegistry.register("brown_autumnal_leaves", settings -> new ColoredParticleLeavesBlock(0.02f, 0x422611, settings), AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_BROWN).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never));
		BROWN_AUTUMNAL_SAPLING = TraverseRegistry.register("brown_autumnal_sapling", settings -> new SaplingBlock(new SaplingGenerator("brown_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE), Optional.empty()), settings), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_BROWN));
		ORANGE_AUTUMNAL_LEAVES = TraverseRegistry.register("orange_autumnal_leaves", settings -> new ColoredParticleLeavesBlock(0.02f, 0xDE791D, settings), AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_ORANGE).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never));
		ORANGE_AUTUMNAL_SAPLING = TraverseRegistry.register("orange_autumnal_sapling", settings -> new SaplingBlock(new SaplingGenerator("orange_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE), Optional.empty()), settings), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_ORANGE));
		RED_AUTUMNAL_LEAVES = TraverseRegistry.register("red_autumnal_leaves", settings -> new ColoredParticleLeavesBlock(0.02f, 0x7E2417, settings), AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never));
		RED_AUTUMNAL_SAPLING = TraverseRegistry.register("red_autumnal_sapling", settings -> new SaplingBlock(new SaplingGenerator("red_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.RED_AUTUMNAL_TREE), Optional.empty()), settings), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_RED));
		YELLOW_AUTUMNAL_LEAVES = TraverseRegistry.register("yellow_autumnal_leaves", settings -> new ColoredParticleLeavesBlock(0.02f, 0xD6B524, settings), AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_YELLOW).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never));
		YELLOW_AUTUMNAL_SAPLING = TraverseRegistry.register("yellow_autumnal_sapling", settings -> new SaplingBlock(new SaplingGenerator("yellow_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE), Optional.empty()), settings), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_YELLOW));

		FIR_LEAVES = TraverseRegistry.register("fir_leaves", settings -> new ColoredParticleLeavesBlock(0.01f, 0x184017, settings), AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never));
		FIR_SAPLING = TraverseRegistry.register("fir_sapling", settings -> new SaplingBlock(new SaplingGenerator("fir", Optional.empty(), Optional.of(TraverseConfiguredFeatures.FIR_TREE), Optional.empty()), settings), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING));

		FIR_LOG = TraverseRegistry.register("fir_log", PillarBlock::new, PillarLogHelper.createSettings(MapColor.OAK_TAN, MapColor.BROWN));
		FIR_WOOD = TraverseRegistry.register("fir_wood", PillarBlock::new, PillarLogHelper.createSettings(MapColor.BROWN));
		STRIPPED_FIR_LOG = TraverseRegistry.register("stripped_fir_log", PillarBlock::new, PillarLogHelper.createSettings(MapColor.OAK_TAN));
		STRIPPED_FIR_WOOD = TraverseRegistry.register("stripped_fir_wood", PillarBlock::new, PillarLogHelper.createSettings(MapColor.OAK_TAN));
		FIR_PLANKS = TraverseRegistry.register("fir_planks", Block::new, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS));
		FIR_SLAB = TraverseRegistry.register("fir_slab", SlabBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_SLAB));
		FIR_PRESSURE_PLATE = TraverseRegistry.register("fir_pressure_plate", settings -> new PressurePlateBlock(TraverseBlockSetTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
		FIR_FENCE = TraverseRegistry.register("fir_fence", FenceBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_FENCE));
		FIR_TRAPDOOR = TraverseRegistry.register("fir_trapdoor", settings -> new TrapdoorBlock(TraverseBlockSetTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_TRAPDOOR));
		FIR_FENCE_GATE = TraverseRegistry.register("fir_fence_gate", settings -> new FenceGateBlock(TraverseWoodTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE));
		FIR_STAIRS = TraverseRegistry.register("fir_stairs", settings -> new StairsBlock(FIR_PLANKS.getDefaultState(), settings), AbstractBlock.Settings.copy(Blocks.OAK_STAIRS));
		FIR_BUTTON = TraverseRegistry.register("fir_button", settings -> new ButtonBlock(TraverseBlockSetTypes.FIR, 30, settings), AbstractBlock.Settings.copy(Blocks.OAK_BUTTON));
		FIR_DOOR = TraverseRegistry.register("fir_door", settings -> new DoorBlock(TraverseBlockSetTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_DOOR));
		FIR_SHELF = TraverseRegistry.register("fir_shelf", ShelfBlock::new, AbstractBlock.Settings.copy(Blocks.OAK_SHELF));
		FIR_SIGN = TraverseRegistry.registerSignBlock("fir_sign", settings -> new SignBlock(TraverseWoodTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_SIGN));
		FIR_WALL_SIGN = TraverseRegistry.registerSignBlock("fir_wall_sign", settings -> new WallSignBlock(TraverseWoodTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_SIGN).lootTable(FIR_SIGN.getLootTableKey()));
		FIR_HANGING_SIGN = TraverseRegistry.registerSignBlock("fir_hanging_sign", settings -> new HangingSignBlock(TraverseWoodTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN));
		FIR_WALL_HANGING_SIGN = TraverseRegistry.registerSignBlock("fir_wall_hanging_sign", settings -> new WallHangingSignBlock(TraverseWoodTypes.FIR, settings), AbstractBlock.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).lootTable(FIR_HANGING_SIGN.getLootTableKey()));

		POTTED_RED_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_red_autumnal_sapling", settings -> new FlowerPotBlock(RED_AUTUMNAL_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING));
		POTTED_BROWN_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_brown_autumnal_sapling", settings -> new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING));
		POTTED_ORANGE_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_orange_autumnal_sapling", settings -> new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING));
		POTTED_YELLOW_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_yellow_autumnal_sapling", settings -> new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING));
		POTTED_FIR_SAPLING = TraverseRegistry.register("potted_fir_sapling", settings -> new FlowerPotBlock(FIR_SAPLING, settings), AbstractBlock.Settings.copy(Blocks.POTTED_OAK_SAPLING));

		addFlammables();
		addStrippables();
	}

	private static void addFlammables() {
		FlammableBlockRegistry flammableRegistry = FlammableBlockRegistry.getDefaultInstance();

		flammableRegistry.add(FIR_PLANKS, 5, 20);
		flammableRegistry.add(FIR_SLAB, 5, 20);
		flammableRegistry.add(FIR_FENCE_GATE, 5, 20);
		flammableRegistry.add(FIR_FENCE, 5, 20);
		flammableRegistry.add(FIR_STAIRS, 5, 20);
		flammableRegistry.add(FIR_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_FIR_LOG, 5, 5);
		flammableRegistry.add(STRIPPED_FIR_WOOD, 5, 5);
		flammableRegistry.add(FIR_WOOD, 5, 5);
		flammableRegistry.add(FIR_SHELF, 30, 20);
		flammableRegistry.add(FIR_LEAVES, 30, 60);
		flammableRegistry.add(RED_AUTUMNAL_LEAVES, 30, 60);
		flammableRegistry.add(BROWN_AUTUMNAL_LEAVES, 30, 60);
		flammableRegistry.add(ORANGE_AUTUMNAL_LEAVES, 30, 60);
		flammableRegistry.add(YELLOW_AUTUMNAL_LEAVES, 30, 60);
	}

	private static void addStrippables() {
		StrippableBlockRegistry.register(FIR_LOG, STRIPPED_FIR_LOG);
		StrippableBlockRegistry.register(FIR_WOOD, STRIPPED_FIR_WOOD);
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}

	public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}
}
