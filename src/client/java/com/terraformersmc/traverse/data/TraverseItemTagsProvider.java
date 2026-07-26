package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.item.TraverseItemIds;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
	protected TraverseItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, FabricTagsProvider.BlockTagsProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Vanilla item tags
		 */
		tag(ItemTags.BOATS)
				.add(TraverseItemIds.FIR_BOAT);

		tag(ItemTags.CHEST_BOATS)
				.add(TraverseItemIds.FIR_CHEST_BOAT);

		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

		copy(BlockTags.LEAVES, ItemTags.LEAVES);

		copy(BlockItemTags.LOGS_THAT_BURN.block(), ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockItemTags.SAPLINGS.block(), ItemTags.SAPLINGS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.STONE_BUTTONS, BlockItemTags.STONE_BUTTONS.item());

		copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);

		copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);

		copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);

		copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);

		copy(BlockTags.WOODEN_SHELVES, ItemTags.WOODEN_SHELVES);

		copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);

		copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

		copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);


		/*
		 * Conventional item tags
		 */
		copy(TraverseBlockTags.PLANKS_THAT_BURN, TraverseItemTags.PLANKS_THAT_BURN);

		copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);

		copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);


		/*
		 * Local item tags
		 */
		copy(TraverseBlockTags.FIR_LOGS, TraverseItemTags.FIR_LOGS);
	}

	@Override
	public String getName() {
		return "Traverse Item Tags";
	}
}
