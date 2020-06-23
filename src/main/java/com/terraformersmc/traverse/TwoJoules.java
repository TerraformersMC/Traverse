package com.terraformersmc.traverse;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Tickable;

public class TwoJoules implements Tickable, ToolMaterial {
	@Override
	public int getDurability() {
		return 0;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 0;
	}

	@Override
	public float getAttackDamage() {
		return 0;
	}

	@Override
	public int getMiningLevel() {
		return 0;
	}

	@Override
	public int getEnchantability() {
		return 0;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return null;
	}

	@Override
	public void tick() {

	}
}
