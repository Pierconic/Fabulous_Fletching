
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.fabulousfletching.FabulousfletchingMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class FabulousfletchingModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FabulousfletchingMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(FabulousfletchingModItems.GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.FLINT_ARROW.get());
			tabData.accept(FabulousfletchingModItems.VOLATILE_IRON_ARROW.get());
			tabData.accept(FabulousfletchingModItems.VOLATILE_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.VOLATILE_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.VOLATILE_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.PRISMATIC_IRON_ARROW.get());
			tabData.accept(FabulousfletchingModItems.PRISMATIC_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.PRISMATIC_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.PRISMATIC_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SPECTRAL_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SPECTRAL_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SPECTRAL_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SLIMED_IRON_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SLIMED_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SLIMED_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SLIMED_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SEEKING_IRON_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SEEKING_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SEEKING_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.SEEKING_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.WARPED_IRON_ARROW.get());
			tabData.accept(FabulousfletchingModItems.WARPED_GOLDEN_ARROW.get());
			tabData.accept(FabulousfletchingModItems.WARPED_JEWELED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.WARPED_FORGED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.CURSED_ARROW.get());
			tabData.accept(FabulousfletchingModItems.BREEZE_ARROW.get());
		}
	}
}
