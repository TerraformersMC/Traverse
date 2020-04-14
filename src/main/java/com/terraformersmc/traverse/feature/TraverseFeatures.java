package com.terraformersmc.traverse.feature;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import com.terraformersmc.terraform.feature.FallenLogFeature;
import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;
import com.terraformersmc.traverse.Traverse;

public class TraverseFeatures {

	private static final Map<Identifier, Feature<? extends FeatureConfig>> FEATURES = new HashMap<>();

	public static final FallenLogFeature FALLEN_OAK_TREE = add("fallen_tree", new FallenLogFeature(FallenLogFeatureConfig::deserialize));

	private static <F extends Feature<? extends FeatureConfig>> F add(String name, F feature) {
		FEATURES.put(new Identifier(Traverse.MOD_ID, name), feature);
		return feature;
	}

	public static void register() {
		for (Identifier id : FEATURES.keySet()) {
			Registry.register(Registry.FEATURE, id, FEATURES.get(id));
		}
	}

}
