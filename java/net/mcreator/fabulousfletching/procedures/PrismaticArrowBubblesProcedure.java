package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class PrismaticArrowBubblesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (immediatesourceentity.isInWaterOrBubble()) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.BUBBLE, x, y, z, Mth.nextInt(RandomSource.create(), 1, 3), 0.2, 0.2, 0.2, 0.1);
			immediatesourceentity.setNoGravity(true);
		} else {
			immediatesourceentity.setNoGravity(false);
		}
	}
}
