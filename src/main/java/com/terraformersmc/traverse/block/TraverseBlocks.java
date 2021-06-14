package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.leaves.ComposterRecipes;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import com.terraformersmc.terraform.tree.block.TerraformSaplingBlock;
import com.terraformersmc.terraform.wood.block.StrippableLogBlock;
import com.terraformersmc.terraform.wood.block.TerraformButtonBlock;
import com.terraformersmc.terraform.wood.block.TerraformDoorBlock;
import com.terraformersmc.terraform.wood.block.TerraformPressurePlateBlock;
import com.terraformersmc.terraform.wood.block.TerraformStairsBlock;
import com.terraformersmc.terraform.wood.block.TerraformTrapdoorBlock;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.sapling.TraverseSaplingGenerator;
import com.terraformersmc.traverse.feature.TraverseConfiguredFeatures;
import com.terraformersmc.traverse.feature.TraverseFeatureConfigs;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;

public class TraverseBlocks {

	private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
	private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

	public static final Block RED_AUTUMNAL_LEAVES = add("red_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block RED_AUTUMNAL_SAPLING = add("red_autumnal_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.RED_AUTUMNAL_TREE)), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_LEAVES = add("brown_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_SAPLING = add("brown_autumnal_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.BROWN_AUTUMNAL_TREE)), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_LEAVES = add("orange_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_SAPLING = add("orange_autumnal_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.ORANGE_AUTUMNAL_TREE)), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_LEAVES = add("yellow_autumnal_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_SAPLING = add("yellow_autumnal_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.YELLOW_AUTUMNAL_TREE)), ItemGroup.DECORATIONS);

	public static final Block FIR_PLANKS = add("fir_planks", new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_SAPLING = add("fir_sapling", new TerraformSaplingBlock(new TraverseSaplingGenerator(() -> TraverseConfiguredFeatures.FIR_TREE)), ItemGroup.DECORATIONS);
	public static final Block STRIPPED_FIR_LOG = add("stripped_fir_log", createLog(MapColor.BROWN, MapColor.OAK_TAN), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_FIR_WOOD = add("stripped_fir_wood", createLog(MapColor.OAK_TAN, MapColor.OAK_TAN), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LOG = add("fir_log", new StrippableLogBlock(() -> STRIPPED_FIR_LOG, MapColor.BROWN, FabricBlockSettings.copyOf(Blocks.DARK_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_WOOD = add("fir_wood", new StrippableLogBlock(() -> STRIPPED_FIR_WOOD, MapColor.BROWN, FabricBlockSettings.copyOf(Blocks.DARK_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LEAVES = add("fir_leaves", new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).allowsSpawning(TraverseBlocks::canSpawnOnLeaves).suffocates(TraverseBlocks::never).blockVision(TraverseBlocks::never)), ItemGroup.DECORATIONS);
	public static final Block FIR_SLAB = add("fir_slab", new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_PRESSURE_PLATE = add("fir_pressure_plate", new TerraformPressurePlateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE = add("fir_fence", new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
	public static final Block FIR_TRAPDOOR = add("fir_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE_GATE = add("fir_fence_gate", new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
	public static final Block FIR_STAIRS = add("fir_stairs", new TerraformStairsBlock(FIR_PLANKS, FabricBlockSettings.copyOf(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_BUTTON = add("fir_button", new TerraformButtonBlock(FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
	public static final Block FIR_DOOR = add("fir_door", new TerraformDoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
	private static final Identifier FIR_SIGN_TEXTURE = new Identifier(Traverse.MOD_ID, "entity/sign/fir");
	public static final TerraformSignBlock FIR_SIGN = add("fir_sign", new TerraformSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
	public static final Block FIR_WALL_SIGN = add("fir_wall_sign", new TerraformWallSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
	public static final Item FIR_SIGN_ITEM = add("fir_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), FIR_SIGN, FIR_WALL_SIGN));

	public static final Block POTTED_RED_AUTUMNAL_SAPLING = add("potted_red_autumnal_sapling", new FlowerPotBlock(RED_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_BROWN_AUTUMNAL_SAPLING = add("potted_brown_autumnal_sapling", new FlowerPotBlock(BROWN_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_ORANGE_AUTUMNAL_SAPLING = add("potted_orange_autumnal_sapling", new FlowerPotBlock(ORANGE_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_YELLOW_AUTUMNAL_SAPLING = add("potted_yellow_autumnal_sapling", new FlowerPotBlock(YELLOW_AUTUMNAL_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));
	public static final Block POTTED_FIR_SAPLING = add("potted_fir_sapling", new FlowerPotBlock(FIR_SAPLING, FabricBlockSettings.copyOf(Blocks.POTTED_OAK_SAPLING)));

	private static <B extends Block> B add(String name, B block, ItemGroup tab) {
		return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
	}

	private static <B extends Block> B add(String name, B block, BlockItem item) {
		add(name, block);
		if (item != null) {
			item.appendBlocks(Item.BLOCK_ITEMS, item);
			ITEMS.put(new Identifier(Traverse.MOD_ID, name), item);
			ComposterRecipes.registerCompostableBlock(block);
		}
		return block;
	}

	private static <B extends Block> B add(String name, B block) {
		BLOCKS.put(new Identifier(Traverse.MOD_ID, name), block);
		return block;
	}

	private static <I extends BlockItem> I add(String name, I item) {
		item.appendBlocks(Item.BLOCK_ITEMS, item);
		ITEMS.put(new Identifier(Traverse.MOD_ID, name), item);
		return item;
	}

	public static void register() {
		for (Identifier id : ITEMS.keySet()) {
			Registry.register(Registry.ITEM, id, ITEMS.get(id));
		}
		for (Identifier id : BLOCKS.keySet()) {
			Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
		}
		addFuels();
		addFlammables();
	}

	private static void addFuels() {
		FuelRegistry fuelRegistry = FuelRegistry.INSTANCE;
		fuelRegistry.add(FIR_FENCE, 300);
		fuelRegistry.add(FIR_FENCE_GATE, 300);
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


	// Todo: fix when Fabric API supports `of(Material material, Function<BlockState, MapColor> mapColor)`
	private static PillarBlock createLog(MapColor topColor, MapColor sideColor) {
		return new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0F).sounds(BlockSoundGroup.WOOD));
	}

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}
	public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
		return type == EntityType.OCELOT || type == EntityType.PARROT;
	}

}
