package net.mcreator.fabulousfletching.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelarrow_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("fabulousfletching", "modelarrow_model"), "main");
	public final ModelPart bb_main;

	public Modelarrow_model(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = bb_main.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 5).addBox(-2.5F, -5.0F, 7.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, -16).addBox(0.2F, -5.0F, -8.0F, 0.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -19.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));
		PartDefinition cube_r2 = bb_main.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -16).addBox(2.3F, -2.5F, -8.0F, 0.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.5F, -19.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int rgb) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, rgb);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
