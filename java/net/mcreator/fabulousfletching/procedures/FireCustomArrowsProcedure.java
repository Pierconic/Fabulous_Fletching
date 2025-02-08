package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;
import net.mcreator.fabulousfletching.init.FabulousfletchingModEntities;
import net.mcreator.fabulousfletching.entity.VolatileJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.VolatileForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SpectralForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SlimedForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.SeekingForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.PrismaticForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.JeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.GoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.ForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.FlintArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.BreezeArrowProjectileEntity;

public class FireCustomArrowsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, ItemStack itemstack) {
		if (direction == null)
			return;
		if (FabulousfletchingModItems.FLINT_ARROW.get() == itemstack.getItem()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 0.8, false);
				}
			}
			if (direction == Direction.DOWN) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
					_entityToSpawn.shoot(0, (-1), 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.UP) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
					_entityToSpawn.shoot(0, 1, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.NORTH) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
					_entityToSpawn.shoot(0, 0, (-1), 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.SOUTH) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
					_entityToSpawn.shoot(0, 0, 1, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.WEST) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
					_entityToSpawn.shoot((-1), 0, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.EAST) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new FlintArrowProjectileEntity(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
					_entityToSpawn.shoot(1, 0, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (FabulousfletchingModItems.BREEZE_ARROW.get() == itemstack.getItem()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 0.8);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 0.8, false);
				}
			}
			if (direction == Direction.DOWN) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
					_entityToSpawn.shoot(0, (-1), 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.UP) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
					_entityToSpawn.shoot(0, 1, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.NORTH) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
					_entityToSpawn.shoot(0, 0, (-1), 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.SOUTH) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
					_entityToSpawn.shoot(0, 0, 1, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.WEST) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
					_entityToSpawn.shoot((-1), 0, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			} else if (direction == Direction.EAST) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = new Object() {
						public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
							AbstractArrow entityToSpawn = new BreezeArrowProjectileEntity(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), level) {
								@Override
								public byte getPierceLevel() {
									return piercing;
								}

								@Override
								protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
									if (knockback > 0) {
										double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
										Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
										if (vec3.lengthSqr() > 0.0) {
											livingEntity.push(vec3.x, 0.1, vec3.z);
										}
									}
								}
							};
							entityToSpawn.setBaseDamage(damage);
							entityToSpawn.setSilent(true);
							entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
							return entityToSpawn;
						}
					}.getArrow(projectileLevel, 2, 1, (byte) 0);
					_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
					_entityToSpawn.shoot(1, 0, 0, 1, 3);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:iron_arrows")))) {
			if (FabulousfletchingModItems.VOLATILE_IRON_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileIronArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.PRISMATIC_IRON_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticIronArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SLIMED_IRON_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedIronArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SEEKING_IRON_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingIronArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:golden_arrows")))) {
			if (FabulousfletchingModItems.GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.5);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.5, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new GoldenArrowProjectileEntity(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.VOLATILE_GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileGoldenArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.PRISMATIC_GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticGoldenArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SPECTRAL_GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SLIMED_GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedGoldenArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SEEKING_GOLDEN_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingGoldenArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 1, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 2);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:jeweled_arrows")))) {
			if (FabulousfletchingModItems.JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new JeweledArrowProjectileEntity(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.VOLATILE_JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileJeweledArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.PRISMATIC_JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticJeweledArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SPECTRAL_JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralJeweledArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SLIMED_JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedJeweledArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SEEKING_JEWELED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingJeweledArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 4, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("forge:forged_arrows")))) {
			if (FabulousfletchingModItems.FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new ForgedArrowProjectileEntity(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.VOLATILE_FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new VolatileForgedArrowProjectileEntity(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.PRISMATIC_FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new PrismaticForgedArrowProjectileEntity(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SPECTRAL_FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SpectralForgedArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SLIMED_FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SlimedForgedArrowProjectileEntity(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else if (FabulousfletchingModItems.SEEKING_FORGED_ARROW.get() == itemstack.getItem()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.dispenser.launch")), SoundSource.NEUTRAL, 1, (float) 1.2, false);
					}
				}
				if (direction == Direction.DOWN) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y - 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, (-1), 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.UP) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 1.3), (z + 0.5));
						_entityToSpawn.shoot(0, 1, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.NORTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z - 1.3));
						_entityToSpawn.shoot(0, 0, (-1), 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.SOUTH) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 0.5), (y + 0.5), (z + 1.3));
						_entityToSpawn.shoot(0, 0, 1, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.WEST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x - 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot((-1), 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				} else if (direction == Direction.EAST) {
					if (world instanceof ServerLevel projectileLevel) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new SeekingForgedArrowProjectileEntity(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), level) {
									@Override
									public byte getPierceLevel() {
										return piercing;
									}

									@Override
									protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
										if (knockback > 0) {
											double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
											Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
											if (vec3.lengthSqr() > 0.0) {
												livingEntity.push(vec3.x, 0.1, vec3.z);
											}
										}
									}
								};
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setSilent(true);
								entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 7, 1, (byte) 0);
						_entityToSpawn.setPos((x + 1.3), (y + 0.5), (z + 0.5));
						_entityToSpawn.shoot(1, 0, 0, 1, 1);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
