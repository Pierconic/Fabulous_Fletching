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

import net.mcreator.fabulousfletching.entity.WarpedGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.GoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GoldArrowFiredProcedure {
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
		if (entity instanceof GoldenArrowProjectileEntity || entity instanceof PrismaticGoldenArrowProjectileEntity || entity instanceof SeekingGoldenArrowProjectileEntity || entity instanceof SlimedGoldenArrowProjectileEntity
				|| entity instanceof SpectralGoldenArrowProjectileEntity || entity instanceof VolatileGoldenArrowProjectileEntity || entity instanceof WarpedGoldenArrowProjectileEntity) {
			x_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			y_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			z_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.2 + x_inaccuracy), (entity.getDeltaMovement().y() * 1.2 + y_inaccuracy), (entity.getDeltaMovement().z() * 1.2 + z_inaccuracy)));
			FabulousfletchingMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:spectral_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:seeking_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:slimed_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:prismatic_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:prismatic_golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:volatile_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:warped_golden_arrow_projectile] {item: {count:1, id:\"fabulousfletching:golden_arrow\"}}");
					}
				}
			});
		}
	}
}
