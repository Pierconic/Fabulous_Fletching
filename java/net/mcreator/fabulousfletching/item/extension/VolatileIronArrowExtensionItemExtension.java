
package net.mcreator.fabulousfletching.item.extension;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.Direction;

import net.mcreator.fabulousfletching.procedures.FireCustomArrowsProcedure;
import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class VolatileIronArrowExtensionItemExtension {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> DispenserBlock.registerBehavior(FabulousfletchingModItems.VOLATILE_IRON_ARROW.get(), new OptionalDispenseItemBehavior() {
			public ItemStack execute(BlockSource blockSource, ItemStack stack) {
				ItemStack itemstack = stack.copy();
				Level world = blockSource.level();
				Direction direction = blockSource.state().getValue(DispenserBlock.FACING);
				int x = blockSource.pos().getX();
				int y = blockSource.pos().getY();
				int z = blockSource.pos().getZ();
				boolean success = this.isSuccess();
				FireCustomArrowsProcedure.execute(world, x, y, z, direction, itemstack);
				itemstack.shrink(1);
				return itemstack;
			}
		}));
	}
}
