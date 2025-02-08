package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.entity.Entity;

public class BreezeArrowFlightProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity.isInWaterRainOrBubble()) {
			immediatesourceentity.setNoGravity(false);
		} else {
			immediatesourceentity.setNoGravity(true);
		}
	}
}
