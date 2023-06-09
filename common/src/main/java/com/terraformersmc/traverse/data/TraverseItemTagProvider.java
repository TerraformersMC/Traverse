package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class TraverseItemTagProvider extends FabricTagProvider.ItemTagProvider {
	protected TraverseItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, BlockTagProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	public void configure(RegistryWrapper.WrapperLookup registries) {
		getOrCreateTagBuilder(ItemTags.BOATS)
			.add(TraverseBoatTypes.FIR_BOAT);

		getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
			.add(TraverseBoatTypes.FIR_CHEST_BOAT);

		copy(BlockTags.LEAVES, ItemTags.LEAVES);

		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


		copy(TraverseBlockTags.FIR_LOGS, TraverseItemTags.FIR_LOGS);

		copy(TraverseBlockTags.PLANKS_THAT_BURN, TraverseItemTags.PLANKS_THAT_BURN);

		copy(TraverseBlockTags.STRIPPED_LOGS, TraverseItemTags.STRIPPED_LOGS);

		copy(TraverseBlockTags.STRIPPED_WOOD, TraverseItemTags.STRIPPED_WOOD);
	}
}
