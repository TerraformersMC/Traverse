package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.item.TraverseBoatTypes;
import com.terraformersmc.traverse.tag.TraverseItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tag.ItemTags;

public class TraverseItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public TraverseItemTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		this.getOrCreateTagBuilder(ItemTags.BOATS)
			.add(TraverseBoatTypes.fir.getItem());

		this.getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
			.add(TraverseBoatTypes.fir.getChestItem());

		this.getOrCreateTagBuilder(ItemTags.LEAVES)
			.add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES.asItem())
			.add(TraverseBlocks.RED_AUTUMNAL_LEAVES.asItem())
			.add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES.asItem())
			.add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES.asItem())
			.add(TraverseBlocks.FIR_LEAVES.asItem());

		this.getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
			.addTag(TraverseItemTags.FIR_LOGS);

		this.getOrCreateTagBuilder(ItemTags.PLANKS)
			.add(TraverseBlocks.FIR_PLANKS.asItem());

		this.getOrCreateTagBuilder(ItemTags.SAPLINGS)
			.add(TraverseBlocks.BROWN_AUTUMNAL_SAPLING.asItem())
			.add(TraverseBlocks.RED_AUTUMNAL_SAPLING.asItem())
			.add(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING.asItem())
			.add(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING.asItem())
			.add(TraverseBlocks.FIR_SAPLING.asItem());

		this.getOrCreateTagBuilder(ItemTags.SIGNS)
			.add(TraverseBlocks.FIR_SIGN.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS)
			.add(TraverseBlocks.FIR_BUTTON.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_DOORS)
			.add(TraverseBlocks.FIR_DOOR.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_FENCES)
			.add(TraverseBlocks.FIR_FENCE.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
			.add(TraverseBlocks.FIR_PRESSURE_PLATE.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
			.add(TraverseBlocks.FIR_SLAB.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
			.add(TraverseBlocks.FIR_STAIRS.asItem());

		this.getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS)
			.add(TraverseBlocks.FIR_TRAPDOOR.asItem());


		this.getOrCreateTagBuilder(TraverseItemTags.FIR_LOGS)
			.add(TraverseBlocks.FIR_LOG.asItem())
			.add(TraverseBlocks.FIR_WOOD.asItem())
			.add(TraverseBlocks.STRIPPED_FIR_LOG.asItem())
			.add(TraverseBlocks.STRIPPED_FIR_WOOD.asItem());

		this.getOrCreateTagBuilder(TraverseItemTags.PLANKS_THAT_BURN)
			.add(TraverseBlocks.FIR_PLANKS.asItem());

		this.getOrCreateTagBuilder(TraverseItemTags.STRIPPED_LOGS)
			.add(TraverseBlocks.STRIPPED_FIR_LOG.asItem());

		this.getOrCreateTagBuilder(TraverseItemTags.STRIPPED_WOOD)
			.add(TraverseBlocks.STRIPPED_FIR_WOOD.asItem());
	}
}
