package com.terraformersmc.traverse.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class TraverseItems {
	public static final Item FIR_BOAT = TerraformBoatItemHelper.registerBoatItem(new Identifier(Traverse.MOD_ID, "fir_boat"), TraverseItems.registerFirBoatType());

	private static Supplier<TerraformBoatType> registerFirBoatType() {
		var type = new TerraformBoatType.Builder().item(TraverseItems.FIR_BOAT).build();
		Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(Traverse.MOD_ID, "fir"), type);
		return () -> type;
	}

	public static void register() {
		// initialize class
	}
}
