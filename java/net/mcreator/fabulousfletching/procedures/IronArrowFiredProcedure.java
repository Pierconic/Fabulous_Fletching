package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fabulousfletching.entity.WarpedIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class IronArrowFiredProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double x_inaccuracy = 0;
		double y_inaccuracy = 0;
		double z_inaccuracy = 0;
		if ((entity instanceof Arrow || entity instanceof SpectralArrow) && !world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty() || entity instanceof SlimedIronArrowProjectileEntity
				|| entity instanceof VolatileIronArrowProjectileEntity || entity instanceof PrismaticIronArrowProjectileEntity || entity instanceof SeekingIronArrowProjectileEntity || entity instanceof WarpedIronArrowProjectileEntity) {
			x_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			y_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			z_inaccuracy = Mth.nextInt(RandomSource.create(), -5, 5) * 0.01;
			if (entity instanceof PrismaticIronArrowProjectileEntity) {
				FabulousfletchingMod.queueServerWork(1, () -> {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:prismatic_iron_arrow_projectile] {item: {count:1, id:\"fabulousfletching:prismatic_iron_arrow\"}}");
						}
					}
				});
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 0.8 + x_inaccuracy), (entity.getDeltaMovement().y() * 0.8 + y_inaccuracy), (entity.getDeltaMovement().z() * 0.8 + z_inaccuracy)));
		}
	}
}
