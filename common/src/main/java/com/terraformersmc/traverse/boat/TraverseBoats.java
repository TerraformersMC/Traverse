package com.terraformersmc.traverse.boat;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class TraverseBoats {
	public static final Identifier FIR = Identifier.of(Traverse.MOD_ID, "fir");
	public static final Item FIR_BOAT = TerraformBoatItemHelper.registerBoatItem(FIR, false);
	public static final Item FIR_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(FIR, true);

	public static void register() {
	}
}
