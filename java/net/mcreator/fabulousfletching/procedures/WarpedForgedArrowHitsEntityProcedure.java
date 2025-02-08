package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;

public class WarpedForgedArrowHitsEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double origin_x = 0;
		double origin_y = 0;
		double origin_z = 0;
		if (!(sourceentity == entity)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (entity.getX()), (entity.getY()), (entity.getZ()), 12, 0.2, 0.2, 0.2, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.PORTAL, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 12, 0.2, 0.2, 0.2, 0.1);
			origin_x = sourceentity.getX();
			origin_y = sourceentity.getY();
			origin_z = sourceentity.getZ();
			{
				Entity _ent = sourceentity;
				_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 5));
			{
				Entity _ent = entity;
				_ent.teleportTo(origin_x, origin_y, origin_z);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(origin_x, origin_y, origin_z, _ent.getYRot(), _ent.getXRot());
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, (float) 0.6, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, (float) 0.6,
							1);
				} else {
					_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
				}
			}
			if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)
					&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(FabulousfletchingModItems.WARPED_FORGED_ARROW.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
