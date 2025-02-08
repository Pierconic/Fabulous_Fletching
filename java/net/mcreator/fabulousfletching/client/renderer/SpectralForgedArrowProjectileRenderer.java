package net.mcreator.fabulousfletching.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.fabulousfletching.entity.SpectralForgedArrowProjectileEntity;
import net.mcreator.fabulousfletching.client.model.Modelbomb_arrow_model;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SpectralForgedArrowProjectileRenderer extends EntityRenderer<SpectralForgedArrowProjectileEntity> {
	private static final ResourceLocation texture = ResourceLocation.parse("fabulousfletching:textures/entities/spectral_forged_arrow.png");
	private final Modelbomb_arrow_model model;

	public SpectralForgedArrowProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelbomb_arrow_model(context.bakeLayer(Modelbomb_arrow_model.LAYER_LOCATION));
	}

	@Override
	public void render(SpectralForgedArrowProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(SpectralForgedArrowProjectileEntity entity) {
		return texture;
	}
}
