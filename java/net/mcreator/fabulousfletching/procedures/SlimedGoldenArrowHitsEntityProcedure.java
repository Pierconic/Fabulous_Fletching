package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;

public class SlimedGoldenArrowHitsEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!(entity == sourceentity) || immediatesourceentity.getPersistentData().getDouble("bounces") < 2) {
			if (Math.random() < 0.4) {
				if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)
						&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)) {
					if (Math.random() < 0.7) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(FabulousfletchingModItems.SLIMED_GOLDEN_ARROW.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(FabulousfletchingModItems.GOLDEN_ARROW.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + immediatesourceentity.getDeltaMovement().x() * 0.4), (Math.abs(immediatesourceentity.getDeltaMovement().y() * 0.3) + 0.15),
					(entity.getDeltaMovement().z() + immediatesourceentity.getDeltaMovement().z() * 0.4)));
		}
	}
}
