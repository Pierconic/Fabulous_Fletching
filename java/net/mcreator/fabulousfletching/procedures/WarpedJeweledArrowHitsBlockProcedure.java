package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;

public class WarpedJeweledArrowHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (Math.random() < 0.05 && !(world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("forge:arrow_soft")))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 6, 0.2, 0.2, 0.2, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		} else {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
			if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)
					&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(FabulousfletchingModItems.WARPED_JEWELED_ARROW.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, (float) 0.6,
								(float) (0.1 * Mth.nextInt(RandomSource.create(), 8, 13)));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, (float) 0.6, (float) (0.1 * Mth.nextInt(RandomSource.create(), 8, 13)), false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, (float) 0.6,
								(float) (0.1 * Mth.nextInt(RandomSource.create(), 8, 13)));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.PLAYERS, (float) 0.6,
								(float) (0.1 * Mth.nextInt(RandomSource.create(), 8, 13)), false);
					}
				}
			}
		}
	}
}
