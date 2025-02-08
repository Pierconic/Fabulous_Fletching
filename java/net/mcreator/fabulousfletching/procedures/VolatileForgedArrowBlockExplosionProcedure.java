package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class VolatileForgedArrowBlockExplosionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		FabulousfletchingMod.queueServerWork(10, () -> {
			if (immediatesourceentity.isAlive()) {
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, (y + 0.5), z, (float) 2.5, Level.ExplosionInteraction.BLOCK);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 15, 0.2, 0.2, 0.2, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 0.2, 0.2, 0.2, 0.05);
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0)) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.NETHERITE_SCRAP));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"kill @e[type=fabulousfletching:volatile_forged_arrow_projectile,sort=nearest,limit=1]");
			}
		});
	}
}
