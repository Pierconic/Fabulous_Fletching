package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fabulousfletching.network.FabulousfletchingModVariables;

public class ToggleRecipeBookProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookOpen) {
			{
				FabulousfletchingModVariables.PlayerVariables _vars = entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES);
				_vars.FletchingBookOpen = false;
				_vars.syncPlayerVariables(entity);
			}
		} else {
			{
				FabulousfletchingModVariables.PlayerVariables _vars = entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES);
				_vars.FletchingBookOpen = true;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
