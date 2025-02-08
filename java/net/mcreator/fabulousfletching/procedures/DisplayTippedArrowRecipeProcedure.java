package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.fabulousfletching.network.FabulousfletchingModVariables;

public class DisplayTippedArrowRecipeProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.FEATHER)) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.STICK)) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.GLASS_BOTTLE)) : false) && entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookOpen
				&& 1 == entity.getData(FabulousfletchingModVariables.PLAYER_VARIABLES).FletchingBookPage) {
			return true;
		}
		return false;
	}
}
