package net.mcreator.fabulousfletching.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class SeekingIronArrowHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.REDSTONE_LAMP) {
			world.setBlock(BlockPos.containing(x, y, z), Blocks.REDSTONE_LAMP.defaultBlockState(), 3);
		}
		immediatesourceentity.getPersistentData().putBoolean("hit", true);
	}
}
