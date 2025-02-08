package net.mcreator.fabulousfletching.procedures;

import net.neoforged.neoforge.event.entity.player.ItemEntityPickupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.Collections;

@EventBusSubscriber
public class GiveSlimedRecipesProcedure {
	@SubscribeEvent
	public static void onPickup(ItemEntityPickupEvent.Pre event) {
		execute(event, event.getPlayer(), event.getItemEntity().getItem());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == Items.SLIME_BALL && entity instanceof Player) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("fabulousfletching:slimed_iron_arrow_craft")));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("fabulousfletching:slimed_golden_arrow_craft")));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("fabulousfletching:slimed_jeweled_arrow_craft")));
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("fabulousfletching:slimed_forged_arrow_craft")));
		}
	}
}
