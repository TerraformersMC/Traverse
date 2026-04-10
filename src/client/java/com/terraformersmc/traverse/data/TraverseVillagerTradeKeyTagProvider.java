package com.terraformersmc.traverse.data;

import com.terraformersmc.traverse.villager.TraverseVillagerTrades;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.KeyTagProvider;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class TraverseVillagerTradeKeyTagProvider extends KeyTagProvider<VillagerTrade> {
	protected TraverseVillagerTradeKeyTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, Registries.VILLAGER_TRADE, lookupProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider registries) {
		this.tag(VillagerTradeTags.WANDERING_TRADER_COMMON)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_FIR_LOG)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_FIR_SAPLING)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_BROWN_AUTUMNAL_SAPLING)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_ORANGE_AUTUMNAL_SAPLING)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_RED_AUTUMNAL_SAPLING)
			.add(TraverseVillagerTrades.WANDERING_TRADER_EMERALD_YELLOW_AUTUMNAL_SAPLING);
	}

	@Override
	public String getName() {
		return "Traverse Villager Trade Tags";
	}
}
