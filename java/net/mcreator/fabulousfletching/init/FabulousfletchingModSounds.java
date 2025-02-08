
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.fabulousfletching.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.fabulousfletching.FabulousfletchingMod;

public class FabulousfletchingModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, FabulousfletchingMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> DIAMOND_CLINK = REGISTRY.register("diamond_clink", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("fabulousfletching", "diamond_clink")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NETHERITE_CLINK = REGISTRY.register("netherite_clink", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("fabulousfletching", "netherite_clink")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FUSE = REGISTRY.register("fuse", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("fabulousfletching", "fuse")));
}
