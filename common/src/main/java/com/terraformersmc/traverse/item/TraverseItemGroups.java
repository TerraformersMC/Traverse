package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TraverseItemGroups {
	private static final ItemGroup ITEM_GROUP;
	private static final HashMap<ItemGroup, HashMap<ItemConvertible, ItemGroupEntries>> ITEM_GROUP_ENTRY_MAPS;

	static {
		ITEM_GROUP_ENTRY_MAPS = new HashMap<>(8);

		/*
		 * These items are the last Vanilla item of a "similar" type to items we add to Vanilla groups.
		 * Each is used to build a collection of items which will be inserted below the Vanilla item.
		 */
		final Item BUILDING_BLOCKS_WOOD_ITEMS = Items.MANGROVE_TRAPDOOR;
		final Item FUNCTIONAL_SIGN = Items.MANGROVE_SIGN;  // TODO: s.b. MANGROVE_HANGING_SIGN but that breaks
		final Item NATURAL_LEAVES = Items.FLOWERING_AZALEA_LEAVES;
		final Item NATURAL_SAPLING = Items.MANGROVE_PROPAGULE;
		final Item NATURAL_LOG = Items.MANGROVE_LOG;
		final Item TOOLS_BOAT = Items.MANGROVE_CHEST_BOAT;


		/*
		 * For each Vanilla item group, add the same kinds of items Vanilla adds.
		 * Since Minecraft 1.19.3, items are often in multiple item groups...
		 */

		// BUILDING BLOCKS

		// Wood items
		addGroupEntry(TraverseBlocks.FIR_LOG, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_WOOD, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.STRIPPED_FIR_LOG, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.STRIPPED_FIR_WOOD, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_PLANKS, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_STAIRS, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_SLAB, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_FENCE, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_FENCE_GATE, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_DOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_TRAPDOOR, ItemGroups.BUILDING_BLOCKS, BUILDING_BLOCKS_WOOD_ITEMS);


		// NATURAL

		// Wood Items
		addGroupEntry(TraverseBlocks.FIR_LOG, ItemGroups.NATURAL, NATURAL_LOG);

		// Saplings
		addGroupEntry(TraverseBlocks.BROWN_AUTUMNAL_SAPLING, ItemGroups.NATURAL, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, ItemGroups.NATURAL, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.RED_AUTUMNAL_SAPLING, ItemGroups.NATURAL, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, ItemGroups.NATURAL, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.FIR_SAPLING, ItemGroups.NATURAL, NATURAL_SAPLING);

		// Leaves
		addGroupEntry(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, ItemGroups.NATURAL, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, ItemGroups.NATURAL, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.RED_AUTUMNAL_LEAVES, ItemGroups.NATURAL, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, ItemGroups.NATURAL, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.FIR_LEAVES, ItemGroups.NATURAL, NATURAL_LEAVES);


		// FUNCTIONAL

		// Wood Items
		addGroupEntry(TraverseBlocks.FIR_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_SIGN);
		addGroupEntry(TraverseBlocks.FIR_HANGING_SIGN, ItemGroups.FUNCTIONAL, FUNCTIONAL_SIGN);


		// REDSTONE


		// HOTBAR


		// SEARCH


		// TOOLS

		// Boats
		addGroupEntry(TraverseBoatTypes.fir.getItem(), ItemGroups.TOOLS, TOOLS_BOAT);
		addGroupEntry(TraverseBoatTypes.fir.getChestItem(), ItemGroups.TOOLS, TOOLS_BOAT);


		// COMBAT


		// CONSUMABLES


		// CRAFTING


		// SPAWN EGGS


		// INVENTORY


		/*
		 * Add the items configured above to the Vanilla item groups.
		 */
		for (ItemGroup group : ITEM_GROUP_ENTRY_MAPS.keySet()) {
			ItemGroupEvents.modifyEntriesEvent(group).register((content) -> {
				HashMap<ItemConvertible, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.get(group);

				for (ItemConvertible relative : entryMap.keySet()) {
					ItemGroupEntries entries = entryMap.get(relative);

					if (relative == null) {
						// Target the end of the Item Group
						content.addAll(entries.getCollection());
					} else {
						content.addAfter(relative, entries.getCollection());
					}
				}
			});
		}


		/*
		 * Also add all the items to Traverse's own item group.
		 */
		ITEM_GROUP = FabricItemGroup.builder(new Identifier(Traverse.MOD_ID, "items"))
				.displayName(Text.literal("Traverse Items"))
				.icon(() -> TraverseBlocks.FIR_SAPLING.asItem().getDefaultStack())
				.entries((enabledFeatures, entries, operatorEnabled) -> {
					ITEM_GROUP_ENTRY_MAPS.values().stream()
							.map(HashMap::values).flatMap(Collection::stream)
							.map(ItemGroupEntries::getCollection).flatMap(Collection::stream)
							.collect(Collectors.groupingByConcurrent(ItemStack::getItem)).keySet().stream()
							.sorted(Comparator.comparing((item) -> item.getName().getString())).forEach(entries::add);
				}).build();
	}

	public static void addGroupEntry(ItemConvertible item, ItemGroup group) {
		// Appends the item to the bottom of the group.
		addGroupEntry(item, group, null);
	}

	public static void addGroupEntry(ItemConvertible item, ItemGroup group, @Nullable ItemConvertible relative) {
		HashMap<ItemConvertible, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.computeIfAbsent(group, (key) -> new HashMap<>(32));
		ItemGroupEntries entries = entryMap.computeIfAbsent(relative, ItemGroupEntries::empty);
		entries.addItem(item);
	}

	public static void register() { }
}
