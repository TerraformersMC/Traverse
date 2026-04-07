package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.boat.TraverseBoats;
import com.terraformersmc.traverse.tag.TraverseBlockTags;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseItemTagProvider extends FabricTagProvider.ItemTagProvider {
	protected TraverseItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagProvider blockTagProvider) {
		super(output, registriesFuture, blockTagProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		/*
		 * Vanilla item tags
		 */
		valueLookupBuilder(ItemTags.BOATS)
				.add(TraverseBoats.FIR_BOAT);

		valueLookupBuilder(ItemTags.CHEST_BOATS)
				.add(TraverseBoats.FIR_CHEST_BOAT);

		copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);

		copy(BlockTags.LEAVES, ItemTags.LEAVES);

		copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

		copy(BlockTags.PLANKS, ItemTags.PLANKS);

		copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);

		copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);

		copy(BlockTags.CEILING_HANGING_SIGNS, ItemTags.HANGING_SIGNS);

		copy(BlockTags.STONE_BUTTONS, ItemTags.STONE_BUTTONS);

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
