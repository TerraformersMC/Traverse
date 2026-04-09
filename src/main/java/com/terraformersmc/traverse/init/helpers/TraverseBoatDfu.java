package com.terraformersmc.traverse.init.helpers;

import com.terraformersmc.terraform.boat.api.data.TerraformBoatDfuApi;

import java.util.Collection;
import java.util.Set;

public class TraverseBoatDfu implements TerraformBoatDfuApi {
	@Override
	public Collection<String> getDfuBoatIds() {
		return Set.of("traverse:fir_boat", "traverse:fir_chest_boat");
	}
}
