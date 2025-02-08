package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class TriggerFletchingRecipesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (FletchingRecipesProcedure.execute(entity).getItem() == Blocks.AIR.asItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get(4)).set(ItemStack.EMPTY);
				_player.containerMenu.broadcastChanges();
			}
		} else {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = FletchingRecipesProcedure.execute(entity).copy();
				_setstack.setCount(FletchingRecipesProcedure.execute(entity).getCount());
				((Slot) _slots.get(4)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
