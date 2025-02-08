package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class SlimeTrailProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.ITEM_SLIME, x, y, z, Mth.nextInt(RandomSource.create(), 0, 1), 0.1, 0.1, 0.1, 0.1);
		}
	}
}
