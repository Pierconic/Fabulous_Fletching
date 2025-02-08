package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.fabulousfletching.entity.SlimedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedForgedArrowProjectileEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SlimedArrowFiredProcedure {
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
		if (entity instanceof SlimedIronArrowProjectileEntity) {
			entity.getPersistentData().putDouble("bounces", 1);
		} else if (entity instanceof SlimedGoldenArrowProjectileEntity) {
			entity.getPersistentData().putDouble("bounces", 2);
		} else if (entity instanceof SlimedJeweledArrowProjectileEntity) {
			entity.getPersistentData().putDouble("bounces", 4);
		} else if (entity instanceof SlimedForgedArrowProjectileEntity) {
			entity.getPersistentData().putDouble("bounces", 8);
		}
	}
}
