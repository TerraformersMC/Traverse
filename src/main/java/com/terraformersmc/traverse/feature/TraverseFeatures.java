package com.terraformersmc.traverse.feature;

import com.terraformersmc.terraform.feature.FallenLogFeature;
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

	public static final OakTreeFeature RED_AUTUMNAL_TREE = add("red_autumnal_tree", new OakTreeFeature(BranchedTreeFeatureConfig::deserialize2));
	public static final OakTreeFeature BROWN_AUTUMNAL_TREE = add("brown_autumnal_tree", new OakTreeFeature(BranchedTreeFeatureConfig::deserialize2));
	public static final OakTreeFeature ORANGE_AUTUMNAL_TREE = add("orange_autumnal_tree", new OakTreeFeature(BranchedTreeFeatureConfig::deserialize2));
	public static final OakTreeFeature YELLOW_AUTUMNAL_TREE = add("yellow_autumnal_tree", new OakTreeFeature(BranchedTreeFeatureConfig::deserialize2));
//	public static final MeadowFlowerFeature LUSH_FLOWER = add("lush_flower", new MeadowFlowerFeature(DefaultFeatureConfig::deserialize));
	public static final OakTreeFeature MINI_JUNGLE_TREE = add("mini_jungle_tree", new OakTreeFeature(BranchedTreeFeatureConfig::deserialize2));
	public static final JungleGroundBushFeature OAK_SHRUB = add("oak_shrub", new JungleGroundBushFeature(TreeFeatureConfig::deserialize));
	public static final FirTreeFeature FIR_TREE = add("fir_tree", new FirTreeFeature(BranchedTreeFeatureConfig::deserialize2, false));
	public static final TerraformSwampTreeFeature TALL_SWAMP_TREE = add("tall_swamp_tree", new TerraformSwampTreeFeature(TreeFeatureConfig::deserialize, false, 7));
	public static final FallenLogFeature FALLEN_OAK_TREE = add("fallen_oak_tree", new FallenLogFeature(TreeFeatureConfig::deserialize, false, Blocks.OAK_LOG.getDefaultState(), 3, 2));

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
