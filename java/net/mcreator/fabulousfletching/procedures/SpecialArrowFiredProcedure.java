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

import net.mcreator.fabulousfletching.entity.CursedArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpecialArrowFiredProcedure {
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
		if (entity instanceof CursedArrowProjectileEntity) {
			FabulousfletchingMod.queueServerWork(1, () -> {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"/data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:cursed_arrow_projectile] {item: {count:1, id:\"fabulousfletching:cursed_arrow\"}}");
					}
				}
			});
		}
	}
}
