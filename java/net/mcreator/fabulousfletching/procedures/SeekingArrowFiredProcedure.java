package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import net.mcreator.fabulousfletching.entity.SeekingIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingForgedArrowProjectileEntity;

@EventBusSubscriber
public class SeekingArrowFiredProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof SeekingIronArrowProjectileEntity||entity instanceof SeekingGoldenArrowProjectileEntity||entity instanceof SeekingJeweledArrowProjectileEntity||entity instanceof SeekingForgedArrowProjectileEntity) {
			entity.getPersistentData().putBoolean("hit", false);
		}
	}
}
