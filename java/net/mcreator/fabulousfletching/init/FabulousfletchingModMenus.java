
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.fabulousfletching.world.inventory.FletchingGuiMenu;
import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class FabulousfletchingModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, FabulousfletchingMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<FletchingGuiMenu>> FLETCHING_GUI = REGISTRY.register("fletching_gui", () -> IMenuTypeExtension.create(FletchingGuiMenu::new));
}
