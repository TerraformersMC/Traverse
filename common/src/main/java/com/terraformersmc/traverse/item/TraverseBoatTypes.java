package com.terraformersmc.traverse.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class TraverseBoatTypes {
	public static Item FIR_BOAT;
	public static Item FIR_CHEST_BOAT;

	public static void register() {
		final Identifier FIR_BOAT_ID = Identifier.of(Traverse.MOD_ID, "fir_boat");
		final Identifier FIR_CHEST_BOAT_ID = Identifier.of(Traverse.MOD_ID, "fir_chest_boat");
		final RegistryKey<TerraformBoatType> FIR_BOAT_KEY = TerraformBoatTypeRegistry.createKey(Identifier.of(Traverse.MOD_ID, "fir"));

		FIR_BOAT = TerraformBoatItemHelper.registerBoatItem(FIR_BOAT_ID, FIR_BOAT_KEY, false);
		FIR_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(FIR_CHEST_BOAT_ID, FIR_BOAT_KEY, true);

		TerraformBoatType FIR = new TerraformBoatType.Builder()
				.item(FIR_BOAT)
				.chestItem(FIR_CHEST_BOAT)
				.planks(TraverseBlocks.FIR_PLANKS.asItem())
				.build();

		Registry.register(TerraformBoatTypeRegistry.INSTANCE, FIR_BOAT_KEY, FIR);
	}
}
