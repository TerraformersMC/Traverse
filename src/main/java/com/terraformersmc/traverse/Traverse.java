package com.terraformersmc.traverse;

import com.terraformersmc.terraform.config.BiomeConfigHandler;
import com.terraformersmc.traverse.biome.TraverseBiomes;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.entity.TraverseEntities;
import com.terraformersmc.traverse.feature.TraverseFeatures;
import com.terraformersmc.traverse.generation.TraverseGeneration;
import com.terraformersmc.traverse.surfacebuilder.TraverseSurfaceBuilders;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Traverse implements ModInitializer {

	public static final String MOD_ID = "traverse";
	public static final BiomeConfigHandler BIOME_CONFIG_HANDLER = new BiomeConfigHandler(MOD_ID);

	@Override
	public void onInitialize() {
		register();
	}

	public static void register() {
		TraverseBlocks.register();
		TraverseEntities.register();
		TraverseSurfaceBuilders.register();
		TraverseFeatures.register();
		TraverseBiomes.register();
		TraverseGeneration.register();

		FabricItemGroupBuilder.create(new Identifier(MOD_ID, "items")).icon(() -> TraverseBlocks.FIR_SAPLING.asItem().getStackForRender()).appendItems(stacks -> Registry.ITEM.forEach(item -> {
			if (Registry.ITEM.getId(item).getNamespace().equals(MOD_ID)) {
				item.appendStacks(item.getGroup(), (DefaultedList<ItemStack>) stacks);
			}
		})).build();
	}

}
