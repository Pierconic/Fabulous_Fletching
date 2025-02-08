package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Comparator;

public class DefaultCourseCorrectionProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double xvector = 0;
		double yvector = 0;
		double zvector = 0;
		double horizontaltheta = 0;
		double verticaltheta = 0;
		if (!entity.getPersistentData().getBoolean("hit")) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FIREWORK, (immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()), 1, 0.1, 0.1, 0.1, 0);
		}
		if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).isEmpty()
				&& !(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)) == entity)) {
			horizontaltheta = Math.atan(Math.abs(immediatesourceentity.getX()
					- ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getX()) / Math.abs(immediatesourceentity.getZ() - ((Entity) world
							.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getZ()));
			verticaltheta = Math.atan(Math.abs(immediatesourceentity.getY()
					- ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getY()) / Math.abs(immediatesourceentity.getZ() - ((Entity) world
							.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getZ()));
			xvector = Math.sin(horizontaltheta);
			yvector = Math.sin(verticaltheta);
			zvector = Math.cos(horizontaltheta);
			if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getX() < immediatesourceentity.getX()) {
				xvector = xvector * (-1);
			}
			if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getZ() < immediatesourceentity.getZ()) {
				zvector = zvector * (-1);
			}
			if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ())), 7, 7, 7), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf((immediatesourceentity.getX()), (immediatesourceentity.getY()), (immediatesourceentity.getZ()))).findFirst().orElse(null)).getY() < immediatesourceentity.getY()) {
				yvector = yvector * (-1);
			}
			immediatesourceentity
					.setDeltaMovement(new Vec3(((immediatesourceentity.getDeltaMovement().x() + xvector) / 2), ((immediatesourceentity.getDeltaMovement().y() + yvector) / 2), ((immediatesourceentity.getDeltaMovement().z() + zvector) / 2)));
		}
	}
}
