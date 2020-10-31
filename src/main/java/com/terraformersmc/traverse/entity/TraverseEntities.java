package com.terraformersmc.traverse.entity;

import com.terraformersmc.terraform.boat.TerraformBoat;
import com.terraformersmc.terraform.boat.TerraformBoatEntity;
import com.terraformersmc.terraform.boat.TerraformBoatItem;
import com.terraformersmc.traverse.Traverse;
import com.terraformersmc.traverse.block.TraverseBlocks;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class TraverseEntities {
	public static EntityType<TerraformBoatEntity> FIR_BOAT;

	public static void register() {
		FIR_BOAT = registerBoat("fir", TraverseBlocks.FIR_PLANKS, BoatEntity.Type.OAK, () -> FIR_BOAT);
	}

	private static EntityType<TerraformBoatEntity> registerBoat(String name, ItemConvertible planks, BoatEntity.Type vanilla, Supplier<EntityType<TerraformBoatEntity>> boatSupplier) {
		Identifier id = new Identifier(Traverse.MOD_ID, name + "_boat");
		Identifier skin = new Identifier(Traverse.MOD_ID, "textures/entity/boat/" + name + ".png");
		Item item = Registry.register(Registry.ITEM, id, new TerraformBoatItem(boatSupplier, new Item.Settings().maxCount(1).group(ItemGroup.TRANSPORTATION)));
		TerraformBoat boat = new TerraformBoat(item.asItem(), planks.asItem(), skin, vanilla);

		EntityType<TerraformBoatEntity> type = FabricEntityTypeBuilder.<TerraformBoatEntity>create(
				SpawnGroup.MISC, (entity, world) -> new TerraformBoatEntity(entity, world, boat))
				.dimensions(EntityDimensions.fixed(1.375F, 0.5625F))
				.build();

		return Registry.register(Registry.ENTITY_TYPE, id, type);
	}
}
