
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.fabulousfletching.entity.WarpedJeweledArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.WarpedIronArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.WarpedGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.WarpedForgedArrowProjectileEntity;
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
import net.mcreator.fabulousfletching.entity.CursedArrowProjectileEntity;
import net.mcreator.fabulousfletching.entity.BreezeArrowProjectileEntity;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class FabulousfletchingModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, FabulousfletchingMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<GoldenArrowProjectileEntity>> GOLDEN_ARROW_PROJECTILE = register("golden_arrow_projectile",
			EntityType.Builder.<GoldenArrowProjectileEntity>of(GoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<JeweledArrowProjectileEntity>> JEWELED_ARROW_PROJECTILE = register("jeweled_arrow_projectile",
			EntityType.Builder.<JeweledArrowProjectileEntity>of(JeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ForgedArrowProjectileEntity>> FORGED_ARROW_PROJECTILE = register("forged_arrow_projectile",
			EntityType.Builder.<ForgedArrowProjectileEntity>of(ForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<FlintArrowProjectileEntity>> FLINT_ARROW_PROJECTILE = register("flint_arrow_projectile",
			EntityType.Builder.<FlintArrowProjectileEntity>of(FlintArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<VolatileIronArrowProjectileEntity>> VOLATILE_IRON_ARROW_PROJECTILE = register("volatile_iron_arrow_projectile",
			EntityType.Builder.<VolatileIronArrowProjectileEntity>of(VolatileIronArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<VolatileGoldenArrowProjectileEntity>> VOLATILE_GOLDEN_ARROW_PROJECTILE = register("volatile_golden_arrow_projectile",
			EntityType.Builder.<VolatileGoldenArrowProjectileEntity>of(VolatileGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<VolatileJeweledArrowProjectileEntity>> VOLATILE_JEWELED_ARROW_PROJECTILE = register("volatile_jeweled_arrow_projectile",
			EntityType.Builder.<VolatileJeweledArrowProjectileEntity>of(VolatileJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<VolatileForgedArrowProjectileEntity>> VOLATILE_FORGED_ARROW_PROJECTILE = register("volatile_forged_arrow_projectile",
			EntityType.Builder.<VolatileForgedArrowProjectileEntity>of(VolatileForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrismaticIronArrowProjectileEntity>> PRISMATIC_IRON_ARROW_PROJECTILE = register("prismatic_iron_arrow_projectile",
			EntityType.Builder.<PrismaticIronArrowProjectileEntity>of(PrismaticIronArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrismaticGoldenArrowProjectileEntity>> PRISMATIC_GOLDEN_ARROW_PROJECTILE = register("prismatic_golden_arrow_projectile",
			EntityType.Builder.<PrismaticGoldenArrowProjectileEntity>of(PrismaticGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrismaticJeweledArrowProjectileEntity>> PRISMATIC_JEWELED_ARROW_PROJECTILE = register("prismatic_jeweled_arrow_projectile",
			EntityType.Builder.<PrismaticJeweledArrowProjectileEntity>of(PrismaticJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrismaticForgedArrowProjectileEntity>> PRISMATIC_FORGED_ARROW_PROJECTILE = register("prismatic_forged_arrow_projectile",
			EntityType.Builder.<PrismaticForgedArrowProjectileEntity>of(PrismaticForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpectralGoldenArrowProjectileEntity>> SPECTRAL_GOLDEN_ARROW_PROJECTILE = register("spectral_golden_arrow_projectile",
			EntityType.Builder.<SpectralGoldenArrowProjectileEntity>of(SpectralGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpectralJeweledArrowProjectileEntity>> SPECTRAL_JEWELED_ARROW_PROJECTILE = register("spectral_jeweled_arrow_projectile",
			EntityType.Builder.<SpectralJeweledArrowProjectileEntity>of(SpectralJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SpectralForgedArrowProjectileEntity>> SPECTRAL_FORGED_ARROW_PROJECTILE = register("spectral_forged_arrow_projectile",
			EntityType.Builder.<SpectralForgedArrowProjectileEntity>of(SpectralForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SlimedIronArrowProjectileEntity>> SLIMED_IRON_ARROW_PROJECTILE = register("slimed_iron_arrow_projectile",
			EntityType.Builder.<SlimedIronArrowProjectileEntity>of(SlimedIronArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SlimedGoldenArrowProjectileEntity>> SLIMED_GOLDEN_ARROW_PROJECTILE = register("slimed_golden_arrow_projectile",
			EntityType.Builder.<SlimedGoldenArrowProjectileEntity>of(SlimedGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SlimedJeweledArrowProjectileEntity>> SLIMED_JEWELED_ARROW_PROJECTILE = register("slimed_jeweled_arrow_projectile",
			EntityType.Builder.<SlimedJeweledArrowProjectileEntity>of(SlimedJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SlimedForgedArrowProjectileEntity>> SLIMED_FORGED_ARROW_PROJECTILE = register("slimed_forged_arrow_projectile",
			EntityType.Builder.<SlimedForgedArrowProjectileEntity>of(SlimedForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeekingIronArrowProjectileEntity>> SEEKING_IRON_ARROW_PROJECTILE = register("seeking_iron_arrow_projectile",
			EntityType.Builder.<SeekingIronArrowProjectileEntity>of(SeekingIronArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeekingGoldenArrowProjectileEntity>> SEEKING_GOLDEN_ARROW_PROJECTILE = register("seeking_golden_arrow_projectile",
			EntityType.Builder.<SeekingGoldenArrowProjectileEntity>of(SeekingGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeekingJeweledArrowProjectileEntity>> SEEKING_JEWELED_ARROW_PROJECTILE = register("seeking_jeweled_arrow_projectile",
			EntityType.Builder.<SeekingJeweledArrowProjectileEntity>of(SeekingJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<SeekingForgedArrowProjectileEntity>> SEEKING_FORGED_ARROW_PROJECTILE = register("seeking_forged_arrow_projectile",
			EntityType.Builder.<SeekingForgedArrowProjectileEntity>of(SeekingForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WarpedIronArrowProjectileEntity>> WARPED_IRON_ARROW_PROJECTILE = register("warped_iron_arrow_projectile",
			EntityType.Builder.<WarpedIronArrowProjectileEntity>of(WarpedIronArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WarpedGoldenArrowProjectileEntity>> WARPED_GOLDEN_ARROW_PROJECTILE = register("warped_golden_arrow_projectile",
			EntityType.Builder.<WarpedGoldenArrowProjectileEntity>of(WarpedGoldenArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WarpedJeweledArrowProjectileEntity>> WARPED_JEWELED_ARROW_PROJECTILE = register("warped_jeweled_arrow_projectile",
			EntityType.Builder.<WarpedJeweledArrowProjectileEntity>of(WarpedJeweledArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<WarpedForgedArrowProjectileEntity>> WARPED_FORGED_ARROW_PROJECTILE = register("warped_forged_arrow_projectile",
			EntityType.Builder.<WarpedForgedArrowProjectileEntity>of(WarpedForgedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<CursedArrowProjectileEntity>> CURSED_ARROW_PROJECTILE = register("cursed_arrow_projectile",
			EntityType.Builder.<CursedArrowProjectileEntity>of(CursedArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BreezeArrowProjectileEntity>> BREEZE_ARROW_PROJECTILE = register("breeze_arrow_projectile",
			EntityType.Builder.<BreezeArrowProjectileEntity>of(BreezeArrowProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}
