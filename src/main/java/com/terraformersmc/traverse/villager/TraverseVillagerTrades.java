package com.terraformersmc.traverse.villager;

import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.item.TraverseItems;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Optional;

public class TraverseVillagerTrades {
	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_FIR_LOG = resourceKey("wandering_trader/emerald_fir_log");

	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_FIR_SAPLING = resourceKey("wandering_trader/emerald_fir_sapling");
	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_BROWN_AUTUMNAL_SAPLING = resourceKey("wandering_trader/emerald_brown_autumnal_sapling");
	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_ORANGE_AUTUMNAL_SAPLING = resourceKey("wandering_trader/emerald_orange_autumnal_sapling");
	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_RED_AUTUMNAL_SAPLING = resourceKey("wandering_trader/emerald_red_autumnal_sapling");
	public static final ResourceKey<VillagerTrade> WANDERING_TRADER_EMERALD_YELLOW_AUTUMNAL_SAPLING = resourceKey("wandering_trader/emerald_yellow_autumnal_sapling");

	public static void bootstrap(BootstrapContext<VillagerTrade> context) {
		HolderGetter<Item> items = context.lookup(Registries.ITEM);

		for (Pair<ResourceKey<VillagerTrade>, Item> pair : List.of(
			Pair.of(WANDERING_TRADER_EMERALD_FIR_LOG, TraverseItems.FIR_LOG.asItem())
		)) {
			context.register(pair.getLeft(), new VillagerTrade(
				new TradeCost(Items.EMERALD, 1),
				new ItemStackTemplate(pair.getRight(), 8),
				4,
				1,
				0.05F,
				Optional.empty(),
				List.of()
			));
		}

		for (Pair<ResourceKey<VillagerTrade>, Item> entry : List.of(
			Pair.of(WANDERING_TRADER_EMERALD_FIR_SAPLING, TraverseItems.FIR_SAPLING.asItem()),
			Pair.of(WANDERING_TRADER_EMERALD_BROWN_AUTUMNAL_SAPLING, TraverseItems.BROWN_AUTUMNAL_SAPLING.asItem()),
			Pair.of(WANDERING_TRADER_EMERALD_ORANGE_AUTUMNAL_SAPLING, TraverseItems.ORANGE_AUTUMNAL_SAPLING.asItem()),
			Pair.of(WANDERING_TRADER_EMERALD_RED_AUTUMNAL_SAPLING, TraverseItems.RED_AUTUMNAL_SAPLING.asItem()),
			Pair.of(WANDERING_TRADER_EMERALD_YELLOW_AUTUMNAL_SAPLING, TraverseItems.YELLOW_AUTUMNAL_SAPLING.asItem())
		)) {
			context.register(entry.getLeft(), new VillagerTrade(
				new TradeCost(Items.EMERALD, 5),
				new ItemStackTemplate(entry.getRight()),
				8,
				1,
				0.05F,
				Optional.empty(),
				List.of()
			));
		}
	}

	public static ResourceKey<VillagerTrade> resourceKey(final String path) {
		return ResourceKey.create(Registries.VILLAGER_TRADE, Identifier.fromNamespaceAndPath(Traverse.MOD_ID, path));
	}
}
