
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.fabulousfletching.client.renderer.WarpedJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.WarpedIronArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.WarpedGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.WarpedForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.VolatileJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.VolatileIronArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.VolatileGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.VolatileForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SpectralJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SpectralGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SpectralForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SlimedJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SlimedIronArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SlimedGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SlimedForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SeekingJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SeekingIronArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SeekingGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.SeekingForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.PrismaticJeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.PrismaticIronArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.PrismaticGoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.PrismaticForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.JeweledArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.GoldenArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.ForgedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.FlintArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.CursedArrowProjectileRenderer;
import net.mcreator.fabulousfletching.client.renderer.BreezeArrowProjectileRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FabulousfletchingModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FabulousfletchingModEntities.GOLDEN_ARROW_PROJECTILE.get(), GoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.JEWELED_ARROW_PROJECTILE.get(), JeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.FORGED_ARROW_PROJECTILE.get(), ForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.FLINT_ARROW_PROJECTILE.get(), FlintArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.VOLATILE_IRON_ARROW_PROJECTILE.get(), VolatileIronArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.VOLATILE_GOLDEN_ARROW_PROJECTILE.get(), VolatileGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.VOLATILE_JEWELED_ARROW_PROJECTILE.get(), VolatileJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.VOLATILE_FORGED_ARROW_PROJECTILE.get(), VolatileForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.PRISMATIC_IRON_ARROW_PROJECTILE.get(), PrismaticIronArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.PRISMATIC_GOLDEN_ARROW_PROJECTILE.get(), PrismaticGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.PRISMATIC_JEWELED_ARROW_PROJECTILE.get(), PrismaticJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.PRISMATIC_FORGED_ARROW_PROJECTILE.get(), PrismaticForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), SpectralGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SPECTRAL_JEWELED_ARROW_PROJECTILE.get(), SpectralJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SPECTRAL_FORGED_ARROW_PROJECTILE.get(), SpectralForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SLIMED_IRON_ARROW_PROJECTILE.get(), SlimedIronArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SLIMED_GOLDEN_ARROW_PROJECTILE.get(), SlimedGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SLIMED_JEWELED_ARROW_PROJECTILE.get(), SlimedJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SLIMED_FORGED_ARROW_PROJECTILE.get(), SlimedForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SEEKING_IRON_ARROW_PROJECTILE.get(), SeekingIronArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SEEKING_GOLDEN_ARROW_PROJECTILE.get(), SeekingGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SEEKING_JEWELED_ARROW_PROJECTILE.get(), SeekingJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.SEEKING_FORGED_ARROW_PROJECTILE.get(), SeekingForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.WARPED_IRON_ARROW_PROJECTILE.get(), WarpedIronArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.WARPED_GOLDEN_ARROW_PROJECTILE.get(), WarpedGoldenArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.WARPED_JEWELED_ARROW_PROJECTILE.get(), WarpedJeweledArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.WARPED_FORGED_ARROW_PROJECTILE.get(), WarpedForgedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.CURSED_ARROW_PROJECTILE.get(), CursedArrowProjectileRenderer::new);
		event.registerEntityRenderer(FabulousfletchingModEntities.BREEZE_ARROW_PROJECTILE.get(), BreezeArrowProjectileRenderer::new);
	}
}
