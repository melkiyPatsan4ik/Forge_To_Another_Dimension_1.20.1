package net.novarayx.toanotherdimension.entity.client;
// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.novarayx.toanotherdimension.entity.animations.CrocoAnimationDefinition;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;

public class CrocoModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart croco;
	private final ModelPart Body;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public CrocoModel(ModelPart root) {
		this.croco = root.getChild("croco");
		this.Body = this.croco.getChild("Body");
		this.RightLeg = this.croco.getChild("RightLeg");
		this.LeftLeg = this.croco.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition croco = partdefinition.addOrReplaceChild("croco", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = croco.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.0F, -0.9828F, 4.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition eye_r1 = Body.addOrReplaceChild("eye_r1", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -4.6F, -1.1828F, -3.1416F, 0.0F, 0.7418F));

		PartDefinition eye_r2 = Body.addOrReplaceChild("eye_r2", CubeListBuilder.create().texOffs(12, 0).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -4.6F, -1.1828F, 3.1416F, 0.0F, -2.3998F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 3).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.6F, -0.8828F, 0.7854F, 0.0F, -3.1416F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 2).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.025F, -4.6F, -0.2828F, -0.2443F, 0.0F, -3.1416F));

		PartDefinition cube_r3 = Body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(1, 2).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.9F, -1.1828F, 0.0F, 0.0F, -3.1416F));

		PartDefinition cube_r4 = Body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(1, 0).addBox(-1.0F, -1.0F, -0.7071F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.7F, 1.4172F, -0.7816F, 0.1233F, 1.571F));

		PartDefinition cube_r5 = Body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -0.7071F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -3.5F, 1.2172F, -0.7854F, 0.0F, 1.5708F));

		PartDefinition cube_r6 = Body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.0F, -0.7071F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -4.6F, 0.5172F, -0.7816F, -0.1233F, 1.5706F));

		PartDefinition cube_r7 = Body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 0.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.3F, -0.1828F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body_r1 = Body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(4, 7).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -4.5F, 0.5172F, -0.0873F, 0.0873F, 0.7941F));

		PartDefinition body_r2 = Body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(4, 7).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -5.0F, 0.0172F, 0.0873F, -0.0873F, 0.7941F));

		PartDefinition RightLeg = croco.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 7).addBox(-3.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition LeftLeg = croco.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 7).addBox(1.0F, -0.2547F, -0.5939F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

		this.animateWalk(CrocoAnimationDefinition.walk, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((CrocoEntity)entity).idleAnimationState, CrocoAnimationDefinition.idle , ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.Body.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.Body.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		croco.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return croco;
	}
}