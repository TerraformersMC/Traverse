package com.terraformersmc.traverse.item;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import com.terraformersmc.traverse.boat.TraverseBoats;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class TraverseItemGroups {
	private static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, "items"));

	private static final HashMap<ResourceKey<CreativeModeTab>, HashMap<ItemLike, ItemGroupEntries>> ITEM_GROUP_ENTRY_MAPS;

	static {
		ITEM_GROUP_ENTRY_MAPS = new HashMap<>(8);

		/*
		 * These items are the last Vanilla item of a "similar" type to items we add to Vanilla groups.
		 * Each is used to build a collection of items which will be inserted below the Vanilla item.
		 */
		final Item BUILDING_WOOD_ITEMS = Items.PALE_OAK_BUTTON;
		final Item FUNCTIONAL_SHELF = Items.PALE_OAK_SHELF;
		final Item FUNCTIONAL_SIGN = Items.PALE_OAK_HANGING_SIGN;
		final Item NATURAL_LEAVES = Items.FLOWERING_AZALEA_LEAVES;
		final Item NATURAL_SAPLING = Items.PALE_OAK_SAPLING;
		final Item NATURAL_LOG = Items.PALE_OAK_LOG;
		final Item TOOLS_BOAT = Items.PALE_OAK_CHEST_BOAT;


		/*
		 * For each Vanilla item group, add the same kinds of items Vanilla adds.
		 * Since Minecraft 1.19.3, items are often in multiple item groups...
		 */

		// BUILDING BLOCKS

		// Wood items
		addGroupEntry(TraverseBlocks.FIR_LOG, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_WOOD, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.STRIPPED_FIR_LOG, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.STRIPPED_FIR_WOOD, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_PLANKS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_STAIRS, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_SLAB, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_FENCE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_FENCE_GATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_DOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_TRAPDOOR, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_PRESSURE_PLATE, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);
		addGroupEntry(TraverseBlocks.FIR_BUTTON, CreativeModeTabs.BUILDING_BLOCKS, BUILDING_WOOD_ITEMS);


		// NATURAL

		// Wood Items
		addGroupEntry(TraverseBlocks.FIR_LOG, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LOG);

		// Saplings
		addGroupEntry(TraverseBlocks.BROWN_AUTUMNAL_SAPLING, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.ORANGE_AUTUMNAL_SAPLING, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.RED_AUTUMNAL_SAPLING, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.YELLOW_AUTUMNAL_SAPLING, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SAPLING);
		addGroupEntry(TraverseBlocks.FIR_SAPLING, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_SAPLING);

		// Leaves
		addGroupEntry(TraverseBlocks.BROWN_AUTUMNAL_LEAVES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.ORANGE_AUTUMNAL_LEAVES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.RED_AUTUMNAL_LEAVES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.YELLOW_AUTUMNAL_LEAVES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LEAVES);
		addGroupEntry(TraverseBlocks.FIR_LEAVES, CreativeModeTabs.NATURAL_BLOCKS, NATURAL_LEAVES);


		// FUNCTIONAL

		// Wood Items
		addGroupEntry(TraverseBlocks.FIR_SHELF, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_SHELF);
		addGroupEntry(TraverseBlocks.FIR_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_SIGN);
		addGroupEntry(TraverseBlocks.FIR_HANGING_SIGN, CreativeModeTabs.FUNCTIONAL_BLOCKS, FUNCTIONAL_SIGN);


		// REDSTONE


		// HOTBAR


		// SEARCH


		// TOOLS

		// Boats
		addGroupEntry(TraverseBoats.FIR_BOAT, CreativeModeTabs.TOOLS_AND_UTILITIES, TOOLS_BOAT);
		addGroupEntry(TraverseBoats.FIR_CHEST_BOAT, CreativeModeTabs.TOOLS_AND_UTILITIES, TOOLS_BOAT);


		// COMBAT


		// CONSUMABLES


		// CRAFTING


		// SPAWN EGGS


		// INVENTORY


		/*
		 * Add the items configured above to the Vanilla item groups.
		 */
		for (ResourceKey<CreativeModeTab> group : ITEM_GROUP_ENTRY_MAPS.keySet()) {
			ItemGroupEvents.modifyEntriesEvent(group).register((content) -> {
				FeatureFlagSet featureSet = content.getEnabledFeatures();
				HashMap<ItemLike, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.get(group);

				for (ItemLike relative : entryMap.keySet()) {
					ItemGroupEntries entries = entryMap.get(relative);

					// FAPI does not give us a way to add at a feature-flag-disabled location.
					// So, below we have to adjust for any items which may be disabled.
					if (relative == null) {
						// Target the end of the Item Group
						content.acceptAll(entries.getCollection());
					} else {
						//Traverse.LOGGER.warn("About to add to Vanilla Item Group '{}' after Item '{}': '{}'", group.getValue(), relative, entries.getCollection().stream().map(ItemStack::getItem).collect(Collectors.toList()));
						content.addAfter(relative, entries.getCollection());
					}
				}
			});
		}


		/*
		 * Also add all the items to Traverse's own item group.
		 */
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, FabricItemGroup.builder()
				.title(Component.literal("Traverse"))
				.icon(() -> TraverseBlocks.FIR_SAPLING.asItem().getDefaultInstance())
				.displayItems((context, entries) -> {
					ITEM_GROUP_ENTRY_MAPS.values().stream()
							.map(HashMap::values).flatMap(Collection::stream)
							.map(ItemGroupEntries::getCollection).flatMap(Collection::stream)
							.collect(Collectors.groupingByConcurrent(ItemStack::getItem)).keySet().stream()
							.sorted(Comparator.comparing((item) -> item.getName().getString())).forEach(entries::accept);
				}).build()
		);
	}

	public static void addGroupEntry(ItemLike item, ResourceKey<CreativeModeTab> group) {
		// Appends the item to the bottom of the group.
		addGroupEntry(item, group, null);
	}

	public static void addGroupEntry(ItemLike item, ResourceKey<CreativeModeTab> group, @Nullable ItemLike relative) {
		HashMap<ItemLike, ItemGroupEntries> entryMap = ITEM_GROUP_ENTRY_MAPS.computeIfAbsent(group, (key) -> new HashMap<>(32));
		ItemGroupEntries entries = entryMap.computeIfAbsent(relative, ItemGroupEntries::empty);
		entries.addItem(item);
	}

	public static void register() { }
}
