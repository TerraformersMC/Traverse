package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseBlockLootTableProvider extends FabricBlockLootTableProvider {
	protected TraverseBlockLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		//noinspection unused
		HolderLookup.RegistryLookup<Enchantment> enchantmentRegistry = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

		// simple blocks
		dropSelf(TraverseBlocks.BROWN_AUTUMNAL_SAPLING);
		dropSelf(TraverseBlocks.FIR_BUTTON);
		dropSelf(TraverseBlocks.FIR_FENCE);
		dropSelf(TraverseBlocks.FIR_FENCE_GATE);
		dropSelf(TraverseBlocks.FIR_LOG);
		dropSelf(TraverseBlocks.FIR_PLANKS);
		dropSelf(TraverseBlocks.FIR_PRESSURE_PLATE);
		dropSelf(TraverseBlocks.FIR_SAPLING);
		dropSelf(TraverseBlocks.FIR_HANGING_SIGN);
		dropSelf(TraverseBlocks.FIR_SHELF);
		dropSelf(TraverseBlocks.FIR_SIGN);
		dropSelf(TraverseBlocks.FIR_STAIRS);
		dropSelf(TraverseBlocks.FIR_TRAPDOOR);
		dropSelf(TraverseBlocks.FIR_WALL_HANGING_SIGN);
		dropSelf(TraverseBlocks.FIR_WALL_SIGN);
		dropSelf(TraverseBlocks.FIR_WOOD);
		dropSelf(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING);
		dropSelf(TraverseBlocks.RED_AUTUMNAL_SAPLING);
		dropSelf(TraverseBlocks.STRIPPED_FIR_LOG);
		dropSelf(TraverseBlocks.STRIPPED_FIR_WOOD);
		dropSelf(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING);

		// less simple blocks
		add(TraverseBlocks.FIR_DOOR, this::createDoorTable);
		add(TraverseBlocks.FIR_SLAB, this::createSlabItemTable);

		// potted things
		dropPottedContents(TraverseBlocks.POTTED_BROWN_AUTUMNAL_SAPLING);
		dropPottedContents(TraverseBlocks.POTTED_FIR_SAPLING);
		dropPottedContents(TraverseBlocks.POTTED_ORANGE_AUTUMNAL_SAPLING);
		dropPottedContents(TraverseBlocks.POTTED_RED_AUTUMNAL_SAPLING);
		dropPottedContents(TraverseBlocks.POTTED_YELLOW_AUTUMNAL_SAPLING);

		// tree leaves
		add(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, createLeavesDrops(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, TraverseBlocks.BROWN_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		add(TraverseBlocks.FIR_LEAVES, createLeavesDrops(TraverseBlocks.FIR_LEAVES, TraverseBlocks.FIR_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		add(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, createLeavesDrops(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		add(TraverseBlocks.RED_AUTUMNAL_LEAVES, createLeavesDrops(TraverseBlocks.RED_AUTUMNAL_LEAVES, TraverseBlocks.RED_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
		add(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, createLeavesDrops(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, 0.05f, 0.0625f, 0.083333336f, 0.1f));
	}

	@Override
	public String getName() {
		return "Traverse Block Loot Tables";
	}
}
