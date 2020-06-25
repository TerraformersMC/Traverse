package com.terraformersmc.traverse.feature;

import com.terraformersmc.terraform.mixin.InvokerFoliagePlacerType;
import com.terraformersmc.terraform.placer.PlacerTypes;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

import java.util.HashMap;
import java.util.Map;

public class TraverseFeatures {

	private static final Map<Identifier, Feature<? extends FeatureConfig>> FEATURES = new HashMap<>();

	public static final FoliagePlacerType<NoneFoliagePlacer> NONE_FOLIAGE_PLACER = PlacerTypes.registerFoliagePlacer("traverse:none", NoneFoliagePlacer.CODEC);

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
