package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CursedArrowHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity && !(sourceentity == entity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 240, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 240, 2, false, false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.attack_impact")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.attack_impact")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.attack_impact")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.warden.attack_impact")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) Math.max((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1), 1));
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) Math.max((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - 45, 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_SOUL, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.2, 0.2, 0.2, 0.1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SCULK_SOUL, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), 20, 0.2, 0.2, 0.2, 0.1);
		}
	}
}
