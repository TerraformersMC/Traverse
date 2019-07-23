package com.terraformersmc.traverse.feature;

import com.terraformersmc.terraform.feature.TerraformOakTreeFeature;
import com.terraformersmc.terraform.feature.TerraformSwampTreeFeature;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

import java.util.HashMap;
import java.util.Map;

public class TraverseFeatures {

	private static final Map<Identifier, Feature<? extends FeatureConfig>> FEATURES = new HashMap<>();

	public static final TerraformOakTreeFeature RED_AUTUMNAL_TREE = add("red_autumnal_tree", new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, false, Blocks.DARK_OAK_LOG.getDefaultState(), TraverseBlocks.RED_AUTUMNAL_LEAVES.getDefaultState()));
	public static final TerraformOakTreeFeature BROWN_AUTUMNAL_TREE = add("brown_autumnal_tree", new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), TraverseBlocks.BROWN_AUTUMNAL_LEAVES.getDefaultState()));
	public static final TerraformOakTreeFeature ORANGE_AUTUMNAL_TREE = add("orange_autumnal_tree", new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), TraverseBlocks.ORANGE_AUTUMNAL_LEAVES.getDefaultState()));
	public static final TerraformOakTreeFeature YELLOW_AUTUMNAL_TREE = add("yellow_autumnal_tree", new TerraformOakTreeFeature(DefaultFeatureConfig::deserialize, false, Blocks.BIRCH_LOG.getDefaultState(), TraverseBlocks.YELLOW_AUTUMNAL_LEAVES.getDefaultState()));
	public static final MeadowFlowerFeature LUSH_FLOWER = add("lush_flower", new MeadowFlowerFeature(DefaultFeatureConfig::deserialize));
	public static final OakTreeFeature MINI_JUNGLE_TREE = add("mini_jungle_tree", new OakTreeFeature(DefaultFeatureConfig::deserialize, false, 4, Blocks.JUNGLE_LOG.getDefaultState(), Blocks.JUNGLE_LEAVES.getDefaultState(), true));
	public static final JungleGroundBushFeature OAK_SHRUB = add("oak_shrub", new JungleGroundBushFeature(DefaultFeatureConfig::deserialize, Blocks.OAK_LOG.getDefaultState(), Blocks.OAK_LEAVES.getDefaultState()));
	public static final FirTreeFeature FIR_TREE = add("fir_tree", new FirTreeFeature(DefaultFeatureConfig::deserialize, false));
	public static final TerraformSwampTreeFeature TALL_SWAMP_TREE = add("tall_swamp_tree", new TerraformSwampTreeFeature(DefaultFeatureConfig::deserialize, false, 7));

	public static <F extends Feature<? extends FeatureConfig>> F add(String name, F feature) {
		FEATURES.put(new Identifier(Traverse.MOD_ID, name), feature);
		return feature;
	}

	public static void register() {
		for (Identifier id : FEATURES.keySet()) {
			Registry.register(Registry.FEATURE, id, FEATURES.get(id));
		}
	}

}
