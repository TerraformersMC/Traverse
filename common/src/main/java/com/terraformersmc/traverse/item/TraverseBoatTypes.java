package com.terraformersmc.traverse.item;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TraverseBoatTypes {
	public static TerraformBoatType fir;

	public static void register() {
		var item = TerraformBoatItemHelper.registerBoatItem(new Identifier(Traverse.MOD_ID, "fir_boat"), () -> fir, false);
		var chestItem = TerraformBoatItemHelper.registerBoatItem(new Identifier(Traverse.MOD_ID, "fir_chest_boat"), () -> fir, true);

		fir = new TerraformBoatType.Builder()
				.item(item)
				.chestItem(chestItem)
				.planks(TraverseBlocks.FIR_PLANKS.asItem())
				.build();
		Registry.register(TerraformBoatTypeRegistry.INSTANCE, new Identifier(Traverse.MOD_ID, "fir"), fir);
	}
}
