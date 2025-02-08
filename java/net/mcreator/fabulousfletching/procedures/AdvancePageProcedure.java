package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.fabulousfletching.network.FabulousfletchingModVariables;

public class AdvancePageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookPage < 1) {
			{
				FabulousfletchingModVariables.PlayerVariables _vars = entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES);
				_vars.FletchingBookPage = entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookPage + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
