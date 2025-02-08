package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fabulousfletching.network.FabulousfletchingModVariables;

public class RecipePage1DisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookPage == 0 && entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookOpen) {
			return true;
		}
		return false;
	}
}
