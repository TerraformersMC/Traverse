package com.terraformersmc.traverse.feature;

import com.terraformersmc.terraform.feature.FallenLogFeature;
import com.terraformersmc.terraform.feature.FallenLogFeatureConfig;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.*;

import java.util.HashMap;
import java.util.Map;

public class TraverseFeatures {

	private static final Map<Identifier, Feature<? extends FeatureConfig>> FEATURES = new HashMap<>();

	public static final FirTreeFeature FIR_TREE = add("fir_tree", new FirTreeFeature(BranchedTreeFeatureConfig::deserialize2, false));
	public static final FallenLogFeature FALLEN_OAK_TREE = add("fallen_tree", new FallenLogFeature(FallenLogFeatureConfig::deserialize));

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
