package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.fabulousfletching.entity.JeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.ForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.WarpedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.WarpedForgedArrowProjectileEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ArrowSFXProcedure {
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
		if (entity instanceof JeweledArrowProjectileEntity || entity instanceof VolatileJeweledArrowProjectileEntity || entity instanceof PrismaticJeweledArrowProjectileEntity || entity instanceof SpectralJeweledArrowProjectileEntity
       || entity instanceof SlimedJeweledArrowProjectileEntity || entity instanceof SeekingJeweledArrowProjectileEntity || entity instanceof WarpedJeweledArrowProjectileEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:diamond_clink")), SoundSource.NEUTRAL, 1, (float) (Mth.nextInt(RandomSource.create(), 8, 13) * 0.1));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:diamond_clink")), SoundSource.NEUTRAL, 1, (float) (Mth.nextInt(RandomSource.create(), 8, 13) * 0.1), false);
				}
			}
		}
		       if (entity instanceof ForgedArrowProjectileEntity || entity instanceof VolatileForgedArrowProjectileEntity || entity instanceof PrismaticForgedArrowProjectileEntity || entity instanceof SpectralForgedArrowProjectileEntity
       ||entity instanceof SlimedForgedArrowProjectileEntity || entity instanceof SeekingForgedArrowProjectileEntity || entity instanceof WarpedForgedArrowProjectileEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:netherite_clink")), SoundSource.NEUTRAL, (float) 0.6,
							(float) (Mth.nextInt(RandomSource.create(), 8, 13) * 0.1));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:netherite_clink")), SoundSource.NEUTRAL, (float) 0.6, (float) (Mth.nextInt(RandomSource.create(), 8, 13) * 0.1), false);
				}
			}
		}
		       if (entity instanceof VolatileForgedArrowProjectileEntity || entity instanceof VolatileJeweledArrowProjectileEntity || entity instanceof VolatileGoldenArrowProjectileEntity || entity instanceof VolatileIronArrowProjectileEntity) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:fuse")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("fabulousfletching:fuse")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
