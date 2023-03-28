package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.wood.block.PillarLogHelper;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.sapling.TraverseSaplingGenerator;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.item.TraverseItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;

public class TraverseBlocks {
	private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

	public static final Block RED_AUTUMNAL_LEAVES = withItem("red_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block RED_AUTUMNAL_SAPLING = withItem("red_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.RED_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));
	public static final Block BROWN_AUTUMNAL_LEAVES = withItem("brown_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block BROWN_AUTUMNAL_SAPLING = withItem("brown_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));
	public static final Block ORANGE_AUTUMNAL_LEAVES = withItem("orange_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block ORANGE_AUTUMNAL_SAPLING = withItem("orange_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));
	public static final Block YELLOW_AUTUMNAL_LEAVES = withItem("yellow_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block YELLOW_AUTUMNAL_SAPLING = withItem("yellow_autumnal_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));

	public static final Block FIR_LEAVES = withItem("fir_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)));
	public static final Block FIR_SAPLING = withItem("fir_sapling", new SaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.FIR_TREE), SaplingBlock.Settings.copy(Blocks.OAK_SAPLING)));
	public static final Block FIR_LOG = withItem("fir_log", PillarLogHelper.of(MapColor.OAK_TAN, MapColor.BROWN));
	public static final Block FIR_WOOD = withItem("fir_wood", PillarLogHelper.of(MapColor.BROWN));
	public static final Block STRIPPED_FIR_LOG = withItem("stripped_fir_log", PillarLogHelper.of(MapColor.OAK_TAN));
	public static final Block STRIPPED_FIR_WOOD = withItem("stripped_fir_wood", PillarLogHelper.of(MapColor.OAK_TAN));
	public static final Block FIR_PLANKS = withItem("fir_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));
	public static final Block FIR_SLAB = withItem("fir_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));
	public static final Block FIR_PRESSURE_PLATE = withItem("fir_pressure_plate", new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE), BlockSetType.OAK));
	public static final Block FIR_FENCE = withItem("fir_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));
	public static final Block FIR_TRAPDOOR = withItem("fir_trapdoor", new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR), BlockSetType.OAK));
	public static final Block FIR_FENCE_GATE = withItem("fir_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE), WoodType.OAK));
	public static final Block FIR_STAIRS = withItem("fir_stairs", new StairsBlock(FIR_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)));
	public static final Block FIR_BUTTON = withItem("fir_button", new ButtonBlock(AbstractBlock.Settings.copy(Blocks.OAK_BUTTON), BlockSetType.OAK,30, true));
	public static final Block FIR_DOOR = withItem("fir_door", new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR), BlockSetType.OAK));
	private static final Identifier FIR_SIGN_TEXTURE = Identifier.of(Traverse.MOD_ID, "entity/signs/fir");
	public static final TerraformSignBlock FIR_SIGN = add("fir_sign", new TerraformSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
	public static final TerraformWallSignBlock FIR_WALL_SIGN = add("fir_wall_sign", new TerraformWallSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
	public static final SignItem FIR_SIGN_ITEM = TraverseItems.add("fir_sign", new SignItem(new Item.Settings().maxCount(16), TraverseBlocks.FIR_SIGN, TraverseBlocks.FIR_WALL_SIGN));
	private static final Identifier FIR_HANGING_SIGN_TEXTURE = Identifier.of(Traverse.MOD_ID, "entity/signs/hanging/fir");
	private static final Identifier FIR_HANGING_SIGN_GUI_TEXTURE = new Identifier(Traverse.MOD_ID, "textures/gui/hanging_signs/fir");
	public static final TerraformHangingSignBlock FIR_HANGING_SIGN = add("fir_hanging_sign", new TerraformHangingSignBlock(FIR_HANGING_SIGN_TEXTURE, FIR_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20)));
	public static final TerraformWallHangingSignBlock FIR_WALL_HANGING_SIGN = add("fir_wall_hanging_sign", new TerraformWallHangingSignBlock(FIR_HANGING_SIGN_TEXTURE, FIR_HANGING_SIGN_GUI_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN).requires(FeatureFlags.UPDATE_1_20)));
	public static final HangingSignItem FIR_HANGING_SIGN_ITEM = TraverseItems.add("fir_hanging_sign", new HangingSignItem(TraverseBlocks.FIR_HANGING_SIGN, TraverseBlocks.FIR_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));
	public static final Block POTTED_RED_AUTUMNAL_SAPLING = add("potted_red_autumnal_sapling", new FlowerPotBlock(RED_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_BROWN_AUTUMNAL_SAPLING = add("potted_brown_autumnal_sapling", new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_ORANGE_AUTUMNAL_SAPLING = add("potted_orange_autumnal_sapling", new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_YELLOW_AUTUMNAL_SAPLING = add("potted_yellow_autumnal_sapling", new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_FIR_SAPLING = add("potted_fir_sapling", new FlowerPotBlock(FIR_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

	private static <B extends Block> B withItem(String name, B block) {
		return add(name, block, new BlockItem(block, new Item.Settings()));
	}

	private static <B extends Block> B add(String name, B block, BlockItem item) {
		add(name, block);
		if (item != null) {
			TraverseItems.add(name, item);
		}
		return block;
	}

	private static <B extends Block> B add(String name, B block) {
		BLOCKS.put(Identifier.of(Traverse.MOD_ID, name), block);
		return block;
	}

	public static void register() {
		for (Identifier id : BLOCKS.keySet()) {
			Registry.register(Registries.BLOCK, id, BLOCKS.get(id));
		}

		addCompostables();
		addFlammables();
		addFuels();
		addStrippables();
	}

	private static void addCompostables() {
		CompostingChanceRegistry compostingRegistry = CompostingChanceRegistry.INSTANCE;
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

	private static void addFuels() {
		FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;

		fuelRegistry.add(FIR_FENCE, 300);
		fuelRegistry.add(FIR_FENCE_GATE, 300);
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
