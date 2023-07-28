package com.terraformersmc.traverse.init;

import com.terraformersmc.terraform.tree.merchant.TerraformSaplingTradeHelper;
import com.terraformersmc.traverse.item.TraverseItems;

public class TraverseTrades {
	public static void register() {
		TerraformSaplingTradeHelper.registerWanderingTraderSaplingTrades(
				TraverseItems.BROWN_AUTUMNAL_SAPLING,
				TraverseItems.ORANGE_AUTUMNAL_SAPLING,
				TraverseItems.RED_AUTUMNAL_SAPLING,
				TraverseItems.YELLOW_AUTUMNAL_SAPLING,
				TraverseItems.FIR_SAPLING
		);
	}
}
