package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.PillarLogHelper;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.init.helpers.TraverseRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
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

	public static TerraformSignBlock FIR_SIGN;
	public static TerraformWallSignBlock FIR_WALL_SIGN;
	public static TerraformHangingSignBlock FIR_HANGING_SIGN;
	public static TerraformWallHangingSignBlock FIR_WALL_HANGING_SIGN;

	public static Block POTTED_RED_AUTUMNAL_SAPLING;
	public static Block POTTED_BROWN_AUTUMNAL_SAPLING;
	public static Block POTTED_ORANGE_AUTUMNAL_SAPLING;
	public static Block POTTED_YELLOW_AUTUMNAL_SAPLING;
	public static Block POTTED_FIR_SAPLING;

	public static void register() {
		RED_AUTUMNAL_LEAVES = TraverseRegistry.register("red_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_RED).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
		RED_AUTUMNAL_SAPLING = TraverseRegistry.register("red_autumnal_sapling", new SaplingBlock(new SaplingGenerator("red_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.RED_AUTUMNAL_TREE), Optional.empty()), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_RED)));
		BROWN_AUTUMNAL_LEAVES = TraverseRegistry.register("brown_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_BROWN).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
		BROWN_AUTUMNAL_SAPLING = TraverseRegistry.register("brown_autumnal_sapling", new SaplingBlock(new SaplingGenerator("brown_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE), Optional.empty()), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_BROWN)));
		ORANGE_AUTUMNAL_LEAVES = TraverseRegistry.register("orange_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_ORANGE).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
		ORANGE_AUTUMNAL_SAPLING = TraverseRegistry.register("orange_autumnal_sapling", new SaplingBlock(new SaplingGenerator("orange_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE), Optional.empty()), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_ORANGE)));
		YELLOW_AUTUMNAL_LEAVES = TraverseRegistry.register("yellow_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).mapColor(MapColor.TERRACOTTA_YELLOW).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
		YELLOW_AUTUMNAL_SAPLING = TraverseRegistry.register("yellow_autumnal_sapling", new SaplingBlock(new SaplingGenerator("yellow_autumnal", Optional.empty(), Optional.of(TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE), Optional.empty()), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING).mapColor(MapColor.TERRACOTTA_YELLOW)));

		FIR_LEAVES = TraverseRegistry.register("fir_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
		FIR_SAPLING = TraverseRegistry.register("fir_sapling", new SaplingBlock(new SaplingGenerator("fir", Optional.empty(), Optional.of(TraverseConfiguredFeatures.FIR_TREE), Optional.empty()), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));

		FIR_LOG = TraverseRegistry.register("fir_log", PillarLogHelper.of(MapColor.OAK_TAN, MapColor.BROWN));
		FIR_WOOD = TraverseRegistry.register("fir_wood", PillarLogHelper.of(MapColor.BROWN));
		STRIPPED_FIR_LOG = TraverseRegistry.register("stripped_fir_log", PillarLogHelper.of(MapColor.OAK_TAN));
		STRIPPED_FIR_WOOD = TraverseRegistry.register("stripped_fir_wood", PillarLogHelper.of(MapColor.OAK_TAN));
		FIR_PLANKS = TraverseRegistry.register("fir_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
		FIR_SLAB = TraverseRegistry.register("fir_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
		FIR_PRESSURE_PLATE = TraverseRegistry.register("fir_pressure_plate", new PressurePlateBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));
		FIR_FENCE = TraverseRegistry.register("fir_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
		FIR_TRAPDOOR = TraverseRegistry.register("fir_trapdoor", new TrapdoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)));
		FIR_FENCE_GATE = TraverseRegistry.register("fir_fence_gate", new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));
		FIR_STAIRS = TraverseRegistry.register("fir_stairs", new StairsBlock(FIR_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
		FIR_BUTTON = TraverseRegistry.register("fir_button", new ButtonBlock(BlockSetType.OAK, 30, AbstractBlock.Settings.copy(Blocks.OAK_BUTTON)));
		FIR_DOOR = TraverseRegistry.register("fir_door", new DoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR)));

		final Identifier FIR_SIGN_TEXTURE = Identifier.of(Traverse.MOD_ID, "entity/signs/fir");
		FIR_SIGN = TraverseRegistry.register("fir_sign", new TerraformSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
		FIR_WALL_SIGN = TraverseRegistry.register("fir_wall_sign", new TerraformWallSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN).dropsLike(FIR_SIGN)));
		final Identifier FIR_HANGING_SIGN_TEXTURE = Identifier.of(Traverse.MOD_ID, "entity/signs/hanging/fir");
		final Identifier FIR_HANGING_SIGN_GUI_TEXTURE = Identifier.of(Traverse.MOD_ID, "textures/gui/hanging_signs/fir");
		FIR_HANGING_SIGN = TraverseRegistry.register("fir_hanging_sign", new TerraformHangingSignBlock(FIR_HANGING_SIGN_TEXTURE, FIR_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
		FIR_WALL_HANGING_SIGN = TraverseRegistry.register("fir_wall_hanging_sign", new TerraformWallHangingSignBlock(FIR_HANGING_SIGN_TEXTURE, FIR_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).dropsLike(FIR_HANGING_SIGN)));

		POTTED_RED_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_red_autumnal_sapling", new FlowerPotBlock(RED_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
		POTTED_BROWN_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_brown_autumnal_sapling", new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
		POTTED_ORANGE_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_orange_autumnal_sapling", new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
		POTTED_YELLOW_AUTUMNAL_SAPLING = TraverseRegistry.register("potted_yellow_autumnal_sapling", new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
		POTTED_FIR_SAPLING = TraverseRegistry.register("potted_fir_sapling", new FlowerPotBlock(FIR_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

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
