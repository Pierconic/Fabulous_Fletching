
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.fabulousfletching.item.WarpedJeweledArrowItem;
import net.mcreator.fabulousfletching.item.WarpedIronArrowItem;
import net.mcreator.fabulousfletching.item.WarpedGoldenArrowItem;
import net.mcreator.fabulousfletching.item.WarpedForgedArrowItem;
import net.mcreator.fabulousfletching.item.VolatileJeweledArrowItem;
import net.mcreator.fabulousfletching.item.VolatileIronArrowItem;
import net.mcreator.fabulousfletching.item.VolatileGoldenArrowItem;
import net.mcreator.fabulousfletching.item.VolatileForgedArrowItem;
import net.mcreator.fabulousfletching.item.SpectralJeweledArrowItem;
import net.mcreator.fabulousfletching.item.SpectralGoldenArrowItem;
import net.mcreator.fabulousfletching.item.SpectralForgedArrowItem;
import net.mcreator.fabulousfletching.item.SlimedJeweledArrowItem;
import net.mcreator.fabulousfletching.item.SlimedIronArrowItem;
import net.mcreator.fabulousfletching.item.SlimedGoldenArrowItem;
import net.mcreator.fabulousfletching.item.SlimedForgedArrowItem;
import net.mcreator.fabulousfletching.item.SeekingJeweledArrowItem;
import net.mcreator.fabulousfletching.item.SeekingIronArrowItem;
import net.mcreator.fabulousfletching.item.SeekingGoldenArrowItem;
import net.mcreator.fabulousfletching.item.SeekingForgedArrowItem;
import net.mcreator.fabulousfletching.item.PrismaticJeweledArrowItem;
import net.mcreator.fabulousfletching.item.PrismaticIronArrowItem;
import net.mcreator.fabulousfletching.item.PrismaticGoldenArrowItem;
import net.mcreator.fabulousfletching.item.PrismaticForgedArrowItem;
import net.mcreator.fabulousfletching.item.JeweledArrowItem;
import net.mcreator.fabulousfletching.item.GoldenArrowItem;
import net.mcreator.fabulousfletching.item.ForgedArrowItem;
import net.mcreator.fabulousfletching.item.FlintArrowItem;
import net.mcreator.fabulousfletching.item.CursedArrowItem;
import net.mcreator.fabulousfletching.item.BreezeArrowItem;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class FabulousfletchingModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(FabulousfletchingMod.MODID);
	public static final DeferredItem<Item> GOLDEN_ARROW = REGISTRY.register("golden_arrow", GoldenArrowItem::new);
	public static final DeferredItem<Item> JEWELED_ARROW = REGISTRY.register("jeweled_arrow", JeweledArrowItem::new);
	public static final DeferredItem<Item> FORGED_ARROW = REGISTRY.register("forged_arrow", ForgedArrowItem::new);
	public static final DeferredItem<Item> FLINT_ARROW = REGISTRY.register("flint_arrow", FlintArrowItem::new);
	public static final DeferredItem<Item> VOLATILE_IRON_ARROW = REGISTRY.register("volatile_iron_arrow", VolatileIronArrowItem::new);
	public static final DeferredItem<Item> VOLATILE_GOLDEN_ARROW = REGISTRY.register("volatile_golden_arrow", VolatileGoldenArrowItem::new);
	public static final DeferredItem<Item> VOLATILE_JEWELED_ARROW = REGISTRY.register("volatile_jeweled_arrow", VolatileJeweledArrowItem::new);
	public static final DeferredItem<Item> VOLATILE_FORGED_ARROW = REGISTRY.register("volatile_forged_arrow", VolatileForgedArrowItem::new);
	public static final DeferredItem<Item> PRISMATIC_IRON_ARROW = REGISTRY.register("prismatic_iron_arrow", PrismaticIronArrowItem::new);
	public static final DeferredItem<Item> PRISMATIC_GOLDEN_ARROW = REGISTRY.register("prismatic_golden_arrow", PrismaticGoldenArrowItem::new);
	public static final DeferredItem<Item> PRISMATIC_JEWELED_ARROW = REGISTRY.register("prismatic_jeweled_arrow", PrismaticJeweledArrowItem::new);
	public static final DeferredItem<Item> PRISMATIC_FORGED_ARROW = REGISTRY.register("prismatic_forged_arrow", PrismaticForgedArrowItem::new);
	public static final DeferredItem<Item> SPECTRAL_GOLDEN_ARROW = REGISTRY.register("spectral_golden_arrow", SpectralGoldenArrowItem::new);
	public static final DeferredItem<Item> SPECTRAL_JEWELED_ARROW = REGISTRY.register("spectral_jeweled_arrow", SpectralJeweledArrowItem::new);
	public static final DeferredItem<Item> SPECTRAL_FORGED_ARROW = REGISTRY.register("spectral_forged_arrow", SpectralForgedArrowItem::new);
	public static final DeferredItem<Item> SLIMED_IRON_ARROW = REGISTRY.register("slimed_iron_arrow", SlimedIronArrowItem::new);
	public static final DeferredItem<Item> SLIMED_GOLDEN_ARROW = REGISTRY.register("slimed_golden_arrow", SlimedGoldenArrowItem::new);
	public static final DeferredItem<Item> SLIMED_JEWELED_ARROW = REGISTRY.register("slimed_jeweled_arrow", SlimedJeweledArrowItem::new);
	public static final DeferredItem<Item> SLIMED_FORGED_ARROW = REGISTRY.register("slimed_forged_arrow", SlimedForgedArrowItem::new);
	public static final DeferredItem<Item> SEEKING_IRON_ARROW = REGISTRY.register("seeking_iron_arrow", SeekingIronArrowItem::new);
	public static final DeferredItem<Item> SEEKING_GOLDEN_ARROW = REGISTRY.register("seeking_golden_arrow", SeekingGoldenArrowItem::new);
	public static final DeferredItem<Item> SEEKING_JEWELED_ARROW = REGISTRY.register("seeking_jeweled_arrow", SeekingJeweledArrowItem::new);
	public static final DeferredItem<Item> SEEKING_FORGED_ARROW = REGISTRY.register("seeking_forged_arrow", SeekingForgedArrowItem::new);
	public static final DeferredItem<Item> WARPED_IRON_ARROW = REGISTRY.register("warped_iron_arrow", WarpedIronArrowItem::new);
	public static final DeferredItem<Item> WARPED_GOLDEN_ARROW = REGISTRY.register("warped_golden_arrow", WarpedGoldenArrowItem::new);
	public static final DeferredItem<Item> WARPED_JEWELED_ARROW = REGISTRY.register("warped_jeweled_arrow", WarpedJeweledArrowItem::new);
	public static final DeferredItem<Item> WARPED_FORGED_ARROW = REGISTRY.register("warped_forged_arrow", WarpedForgedArrowItem::new);
	public static final DeferredItem<Item> CURSED_ARROW = REGISTRY.register("cursed_arrow", CursedArrowItem::new);
	public static final DeferredItem<Item> BREEZE_ARROW = REGISTRY.register("breeze_arrow", BreezeArrowItem::new);
	// Start of user code block custom items
	// End of user code block custom items
}
