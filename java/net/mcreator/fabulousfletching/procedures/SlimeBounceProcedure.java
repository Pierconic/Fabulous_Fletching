package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class SlimeBounceProcedure {
	public static void execute(LevelAccessor world, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		double x_reflect = 0;
		double y_reflect = 0;
		double z_reflect = 0;
		double x_delta = 0;
		double y_delta = 0;
		double z_delta = 0;
		if (immediatesourceentity.getPersistentData().getDouble("bounces") > 0
				&& (world.getBlockState(BlockPos.containing(immediatesourceentity.getX() + immediatesourceentity.getDeltaMovement().x() * 1, immediatesourceentity.getY(), immediatesourceentity.getZ())).canOcclude()
						|| world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY() + immediatesourceentity.getDeltaMovement().y() * 1, immediatesourceentity.getZ())).canOcclude()
						|| world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ() + immediatesourceentity.getDeltaMovement().z() * 1)).canOcclude())) {
			x_reflect = 1;
			y_reflect = 1;
			z_reflect = 1;
			if (world.getBlockState(BlockPos.containing(immediatesourceentity.getX() + immediatesourceentity.getDeltaMovement().x() * 1, immediatesourceentity.getY(), immediatesourceentity.getZ())).canOcclude()
					&& !world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY() + immediatesourceentity.getDeltaMovement().y() * 1.2, immediatesourceentity.getZ())).canOcclude()) {
				{
					Entity _ent = immediatesourceentity;
					_ent.setYRot((float) (immediatesourceentity.getYRot() + 180));
					_ent.setXRot(immediatesourceentity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				x_reflect = -1;
			}
			if (world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ() + immediatesourceentity.getDeltaMovement().z() * 1)).canOcclude()
					&& !world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY() + immediatesourceentity.getDeltaMovement().y() * 1.2, immediatesourceentity.getZ())).canOcclude()) {
				{
					Entity _ent = immediatesourceentity;
					_ent.setYRot((float) (immediatesourceentity.getYRot() + 180));
					_ent.setXRot(immediatesourceentity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				z_reflect = -1;
			}
			if (world.getBlockState(BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY() + immediatesourceentity.getDeltaMovement().y() * 1, immediatesourceentity.getZ())).canOcclude() && x_reflect > 0 && z_reflect > 0) {
				{
					Entity _ent = immediatesourceentity;
					_ent.setYRot(immediatesourceentity.getYRot());
					_ent.setXRot((float) (immediatesourceentity.getXRot() + 180));
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
				y_reflect = -1;
			}
			immediatesourceentity.getPersistentData().putDouble("bounces", (immediatesourceentity.getPersistentData().getDouble("bounces") - 1));
			x_delta = immediatesourceentity.getDeltaMovement().x() * 0.8 * x_reflect;
			y_delta = immediatesourceentity.getDeltaMovement().y() * 0.8 * y_reflect;
			z_delta = immediatesourceentity.getDeltaMovement().z() * 0.8 * z_reflect;
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(immediatesourceentity.getX(), immediatesourceentity.getY(), immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.jump")),
							SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.slime.jump")), SoundSource.NEUTRAL, 1, 1,
							false);
				}
			}
			immediatesourceentity.setDeltaMovement(new Vec3(x_delta, y_delta, z_delta));
			{
				Entity _ent = immediatesourceentity;
				_ent.teleportTo((immediatesourceentity.getX() + x_delta * 1.15), (immediatesourceentity.getY() + y_delta * 1.15), (immediatesourceentity.getZ() + z_delta * 1.15));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((immediatesourceentity.getX() + x_delta * 1.15), (immediatesourceentity.getY() + y_delta * 1.15), (immediatesourceentity.getZ() + z_delta * 1.15), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
