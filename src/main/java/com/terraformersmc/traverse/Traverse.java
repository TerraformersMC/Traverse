package com.terraformersmc.traverse;

import com.terraformersmc.terraform.config.BiomeConfigHandler;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.feature.TraversePlacedFeatures;
import com.terraformersmc.traverse.feature.placer.TraversePlacerTypes;
import com.terraformersmc.traverse.generation.TraverseGeneration;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.surfacerules.TraverseSurfaceRules;
import com.terraformersmc.traverse.villager.TraverseVillagerTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class Traverse implements ModInitializer, TerraBlenderApi {

	public static final String MOD_ID = "traverse";
	public static final BiomeConfigHandler BIOME_CONFIG_HANDLER = new BiomeConfigHandler(MOD_ID);

	private static void register() {
		TraverseBlocks.register();
		TraverseBoatTypes.register();
		TraverseSurfaceRules.register();
		TraversePlacedFeatures.init();
		TraverseBiomes.register();
		TraverseGeneration.register();
		TraverseVillagerTypes.register();
		TraversePlacerTypes.register();

		FabricItemGroupBuilder.create(new Identifier(MOD_ID, "items")).icon(() -> TraverseBlocks.FIR_SAPLING.asItem().getDefaultStack()).appendItems(stacks -> Registry.ITEM.forEach(item -> {
			if (Registry.ITEM.getId(item).getNamespace().equals(MOD_ID)) {
				item.appendStacks(item.getGroup(), (DefaultedList<ItemStack>) stacks);
			}
		})).build();
	}

	@Override
	public void onInitialize() {
		register();
	}

	@Override
	public void onTerraBlenderInitialized() {
		Regions.register(new TraverseGeneration(new Identifier(MOD_ID, "overworld"), 5));
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, TraverseSurfaceRules.createRules());
	}
}
