package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BreezeArrowExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = EntityType.WIND_CHARGE.spawn(_level, BlockPos.containing(x - immediatesourceentity.getDeltaMovement().x(), y - immediatesourceentity.getDeltaMovement().y(), z - immediatesourceentity.getDeltaMovement().z()),
					MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setDeltaMovement((immediatesourceentity.getDeltaMovement().x()), (immediatesourceentity.getDeltaMovement().y()), (immediatesourceentity.getDeltaMovement().z()));
			}
		}
	}
}
