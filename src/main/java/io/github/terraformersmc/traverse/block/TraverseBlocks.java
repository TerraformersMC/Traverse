package io.github.terraformersmc.traverse.block;

import io.github.terraformersmc.terraform.block.TerraformLeavesBlock;
import io.github.terraformersmc.terraform.block.TerraformSaplingBlock;
import io.github.terraformersmc.terraform.feature.TerraformOakTreeFeature;
import io.github.terraformersmc.terraform.util.TerraformSaplingGenerator;
import io.github.terraformersmc.traverse.Traverse;
import io.github.terraformersmc.traverse.feature.FirTreeFeature;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

    public static final Block FIR_LOG = add("fir_log", new LogBlock(MaterialColor.BROWN, FabricBlockSettings.copy(Blocks.DARK_OAK_LOG).build()), ItemGroup.DECORATIONS);
    public static final Block FIR_LEAVES = add("fir_leaves", new TerraformLeavesBlock(), ItemGroup.DECORATIONS);
    public static final Block FIR_SAPLING = add("fir_sapling", new TerraformSaplingBlock(new TerraformSaplingGenerator(() -> new FirTreeFeature(DefaultFeatureConfig::deserialize, true))), ItemGroup.DECORATIONS);

    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        return add(name, block, new BlockItem(block, new Item.Settings().itemGroup(tab)));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        add(name, block);
        if (item != null) {
            item.registerBlockItemMap(Item.BLOCK_ITEM_MAP, item);
            ITEMS.put(new Identifier(Traverse.MOD_ID, name), item);
        }
        return block;
    }

    private static <B extends Block> B add(String name, B block) {
        BLOCKS.put(new Identifier(Traverse.MOD_ID, name), block);
        return block;
    }

    public static void register() {
        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

}
