package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class SlimedIronArrowHitsEntityProcedure {
	public static void execute(Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!(entity == sourceentity) || immediatesourceentity.getPersistentData().getDouble("bounces") < 1) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + immediatesourceentity.getDeltaMovement().x() * 0.4), (Math.abs(immediatesourceentity.getDeltaMovement().y() * 0.3) + 0.15),
					(entity.getDeltaMovement().z() + immediatesourceentity.getDeltaMovement().z() * 0.4)));
		}
	}
}
