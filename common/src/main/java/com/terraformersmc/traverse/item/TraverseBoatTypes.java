package com.terraformersmc.traverse.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.traverse.Traverse;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TraverseBoatTypes {
	public static TerraformBoatType fir;

	public static void register() {
		var item = TerraformBoatItemHelper.registerBoatItem(new Identifier(Traverse.MOD_ID, "fir_boat"), () -> fir);

		fir = new TerraformBoatType.Builder().item(item).build();
		Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(Traverse.MOD_ID, "fir"), fir);
	}
}
