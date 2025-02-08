package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class CursedArrowDrainProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _entity)
			_entity.setHealth((float) Math.min((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1), 1));
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 1));
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SCULK_SOUL, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.2, 0.2, 0.2, 0.1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SCULK_SOUL, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 20, 0.2, 0.2, 0.2, 0.1);
	}
}
