package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.particles.ParticleTypes;

public class CurseParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if ((Math.abs(immediatesourceentity.getDeltaMovement().x()) > 1 || Math.abs(immediatesourceentity.getDeltaMovement().y()) > 1 || Math.abs(immediatesourceentity.getDeltaMovement().z()) > 1) && !immediatesourceentity.isInWall()) {
			world.addParticle(ParticleTypes.SONIC_BOOM, x, y, z, 0, 0, 0);
		}
	}
}
