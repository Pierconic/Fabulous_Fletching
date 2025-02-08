package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fabulousfletching.entity.WarpedForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.ForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ForgedArrowFiredProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double x_inaccuracy = 0;
		double y_inaccuracy = 0;
		double z_inaccuracy = 0;
		if (entity instanceof ForgedArrowProjectileEntity || entity instanceof PrismaticForgedArrowProjectileEntity || entity instanceof SeekingForgedArrowProjectileEntity || entity instanceof SlimedForgedArrowProjectileEntity
				|| entity instanceof SpectralForgedArrowProjectileEntity || entity instanceof VolatileForgedArrowProjectileEntity || entity instanceof WarpedForgedArrowProjectileEntity) {
			x_inaccuracy = Mth.nextInt(RandomSource.create(), -3, 3) * 0.01;
			y_inaccuracy = Mth.nextInt(RandomSource.create(), -3, 3) * 0.01;
			z_inaccuracy = Mth.nextInt(RandomSource.create(), -3, 3) * 0.01;
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.7 + x_inaccuracy), (entity.getDeltaMovement().y() * 0.7 + y_inaccuracy), (entity.getDeltaMovement().z() * 0.7 + z_inaccuracy)));
			FabulousfletchingMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:spectral_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:seeking_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:slimed_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:prismatic_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:prismatic_forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:volatile_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:warped_forged_arrow_projectile] {item: {count:1, id:\"fabulousfletching:forged_arrow\"}}");
					}
				}
			});
		}
	}
}
