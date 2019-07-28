package com.terraformersmc.traverse.block;

import com.terraformersmc.terraform.block.*;
import com.terraformersmc.terraform.feature.TerraformOakTreeFeature;
import com.terraformersmc.terraform.util.RecipeUtil;
import com.terraformersmc.terraform.util.TerraformSaplingGenerator;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.feature.FirTreeFeature;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

import java.util.HashMap;
import java.util.Map;

public class TraverseBlocks {

	private static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();
	private static final Map<Identifier, Block> BLOCKS = new HashMap<>();

	public static final Block RED_AUTUMNAL_LEAVES = add("red_autumnal_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block RED_AUTUMNAL_SAPLING = add("red_autumnal_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, true, Blocks.DARK_OAK_LOG.getDefaultState(), RED_AUTUMNAL_LEAVES.getDefaultState()))), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_LEAVES = add("brown_autumnal_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block BROWN_AUTUMNAL_SAPLING = add("brown_autumnal_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, true, 5, Blocks.OAK_LOG.getDefaultState(), BROWN_AUTUMNAL_LEAVES.getDefaultState()))), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_LEAVES = add("orange_autumnal_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block ORANGE_AUTUMNAL_SAPLING = add("orange_autumnal_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, true, Blocks.OAK_LOG.getDefaultState(), ORANGE_AUTUMNAL_LEAVES.getDefaultState()))), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_LEAVES = add("yellow_autumnal_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block YELLOW_AUTUMNAL_SAPLING = add("yellow_autumnal_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, true, 6, Blocks.BIRCH_LOG.getDefaultState(), YELLOW_AUTUMNAL_LEAVES.getDefaultState()))), ItemGroup.DECORATIONS);

	public static final Block FIR_PLANKS = add("fir_planks", new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_SAPLING = add("fir_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new FirTreeFeature(DefaultFeatureConfig::deserialize, true))), ItemGroup.DECORATIONS);
	public static final Block STRIPPED_FIR_LOG = add("stripped_fir_log", new LogBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.OAK_LOG).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block STRIPPED_FIR_WOOD = add("stripped_fir_wood", new LogBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.OAK_LOG).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LOG = add("fir_log", new StrippableLogBlock(() -> STRIPPED_FIR_LOG, MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.DARK_OAK_LOG).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_WOOD = add("fir_wood", new StrippableLogBlock(() -> STRIPPED_FIR_WOOD, MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.DARK_OAK_LOG).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_LEAVES = add("fir_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
	public static final Block FIR_SLAB = add("fir_slab", new SlabBlock(FabricBlockSettings.copy(Blocks.OAK_SLAB).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_PRESSURE_PLATE = add("fir_pressure_plate", new TerraformPressurePlateBlock(FabricBlockSettings.copy(Blocks.OAK_PRESSURE_PLATE).build()), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE = add("fir_fence", new FenceBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).build()), ItemGroup.DECORATIONS);
	public static final Block FIR_TRAPDOOR = add("fir_trapdoor", new TerraformTrapdoorBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).build()), ItemGroup.REDSTONE);
	public static final Block FIR_FENCE_GATE = add("fir_fence_gate", new FenceGateBlock(FabricBlockSettings.copy(Blocks.OAK_FENCE).build()), ItemGroup.REDSTONE);
	public static final Block FIR_STAIRS = add("fir_stairs", new TerraformStairsBlock(FIR_PLANKS, FabricBlockSettings.copy(Blocks.OAK_STAIRS).build()), ItemGroup.BUILDING_BLOCKS);
	public static final Block FIR_BUTTON = add("fir_button", new TerraformButtonBlock(FabricBlockSettings.copy(Blocks.OAK_BUTTON).build()), ItemGroup.REDSTONE);
	public static final Block FIR_DOOR = add("fir_door", new TerraformDoorBlock(FabricBlockSettings.copy(Blocks.OAK_DOOR).build()), ItemGroup.REDSTONE);
	private static final Identifier FIR_SIGN_TEXTURE = new Identifier(Traverse.MOD_ID, "textures/entity/signs/fir.png");
	public static final Block FIR_SIGN = add("fir_sign", new TerraformSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_SIGN).build()));
	public static final Block FIR_WALL_SIGN = add("fir_wall_sign", new TerraformWallSignBlock(FIR_SIGN_TEXTURE, FabricBlockSettings.copy(Blocks.OAK_WALL_SIGN).build()));
	public static final Item FIR_SIGN_ITEM = add("fir_sign", new SignItem(new Item.Settings().maxCount(16).group(ItemGroup.DECORATIONS), FIR_SIGN, FIR_WALL_SIGN));

	private static <B extends Block> B add(String name, B block, ItemGroup tab) {
		return add(name, block, new BlockItem(block, new Item.Settings().group(tab)));
	}

	private static <B extends Block> B add(String name, B block, BlockItem item) {
		add(name, block);
		if (item != null) {
			item.appendBlocks(Item.BLOCK_ITEMS, item);
			ITEMS.put(new Identifier(Traverse.MOD_ID, name), item);
			RecipeUtil.registerCompostableBlock(block);
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

}
