
package net.mcreator.fabulousfletching.item;

import javax.annotation.Nullable;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.projectile.Projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;

import net.mcreator.fabulousfletching.entity.SpectralGoldenArrowProjectileEntity;
import net.mcreator.fabulousfletching.init.FabulousfletchingModEntities;
import net.mcreator.fabulousfletching.init.FabulousfletchingModItems;


public class SpectralGoldenArrowItem extends ArrowItem {
	public SpectralGoldenArrowItem() {
		super(new Item.Properties().stacksTo(64));
	}
	
	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack weapon){
		return new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), shooter, world, stack.copyWithCount(1));
	}

	@Override 
	public Projectile asProjectile(Level world, Position pos, ItemStack stack, Direction direction) {
		SpectralGoldenArrowProjectileEntity goldenarrow = new SpectralGoldenArrowProjectileEntity(FabulousfletchingModEntities.SPECTRAL_GOLDEN_ARROW_PROJECTILE.get(), pos.x(), pos.y(), pos.z(), world, stack.copyWithCount(1));
		goldenarrow.pickup = AbstractArrow.Pickup.ALLOWED;
		return goldenarrow;
	}
}
	//@Override
    //public AbstractArrow createArrow(Level p_43237_, ItemStack p_43238_, LivingEntity p_43239_, @Nullable ItemStack p_345773_) {
    //    return new SpectralArrow(p_43237_, p_43239_, p_43238_.copyWithCount(1), p_345773_);
    //}


    //@Override
    //public Projectile asProjectile(Level p_338332_, Position p_338313_, ItemStack p_338304_, Direction p_338842_) {
    //    SpectralArrow spectralarrow = new SpectralArrow(p_338332_, p_338313_.x(), p_338313_.y(), p_338313_.z(), p_338304_.copyWithCount(1), null);
    //    spectralarrow.pickup = AbstractArrow.Pickup.ALLOWED;
    //    return spectralarrow;
    //}

    // /data merge entity @e[sort=nearest,limit=1,type=fabulousfletching:golden_arrow_projectile] {item: {count:1, id: "fabulousfletching:golden_arrow"}}