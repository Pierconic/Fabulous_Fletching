package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class VolatileGoldenArrowBlockExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		FabulousfletchingMod.queueServerWork(20, () -> {
			if (entity.isAlive()) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (y + 0.5), z, 1, Level.ExplosionInteraction.BLOCK);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 20, 0.2, 0.2, 0.2, 0.2);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/kill @e[type=fabulousfletching:volatile_golden_arrow_projectile,sort=nearest,limit=1]");
			}
		});
	}
}
