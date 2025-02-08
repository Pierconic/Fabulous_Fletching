package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class VolatileJeweledArrowHitsEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(entity == sourceentity)) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 1, Level.ExplosionInteraction.BLOCK);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, (y + 1), z, 1, Level.ExplosionInteraction.BLOCK);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 15, 0.2, 0.2, 0.2, 0.2);
		}
	}
}
