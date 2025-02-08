package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fabulousfletching.entity.WarpedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.JeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class JeweledArrowFiredProcedure {
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
		if (entity instanceof JeweledArrowProjectileEntity || entity instanceof PrismaticJeweledArrowProjectileEntity || entity instanceof SeekingJeweledArrowProjectileEntity || entity instanceof SlimedJeweledArrowProjectileEntity
				|| entity instanceof SpectralJeweledArrowProjectileEntity || entity instanceof VolatileJeweledArrowProjectileEntity || entity instanceof WarpedJeweledArrowProjectileEntity) {
			FabulousfletchingMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:spectral_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:seeking_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:slimed_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:prismatic_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:prismatic_jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:volatile_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:warped_jeweled_arrow_projectile] {item: {count:1, id:\"fabulousfletching:jeweled_arrow\"}}");
					}
				}
			});
		}
	}
}
