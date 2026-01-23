package net.novarayx.toanotherdimension.entity.client;// Made with Blockbench 5.0.7
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
import net.novarayx.toanotherdimension.entity.animations.DrawoolAnimationDefinition;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;
import net.novarayx.toanotherdimension.entity.custom.DrawoolEntity;

public class DrawoolModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart Entity;
    private final ModelPart Body;
    private final ModelPart tail;
    private final ModelPart wool;
    private final ModelPart Leg;
    private final ModelPart Leg2;
    private final ModelPart Leg3;
    private final ModelPart Leg4;
    private final ModelPart Head;

    public DrawoolModel(ModelPart root) {
        this.Entity = root.getChild("Entity");
        this.Body = this.Entity.getChild("Body");
        this.tail = this.Body.getChild("tail");
        this.wool = this.tail.getChild("wool");
        this.Leg = this.Entity.getChild("Leg");
        this.Leg2 = this.Entity.getChild("Leg2");
        this.Leg3 = this.Entity.getChild("Leg3");
        this.Leg4 = this.Entity.getChild("Leg4");
        this.Head = this.Entity.getChild("Head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Entity = partdefinition.addOrReplaceChild("Entity", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition Body = Entity.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        PartDefinition spine_r1 = Body.addOrReplaceChild("spine_r1", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -2.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition spine_r2 = Body.addOrReplaceChild("spine_r2", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, 1.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition tail = Body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -4.0F));

        PartDefinition spine_r3 = tail.addOrReplaceChild("spine_r3", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -2.0F, -1.4835F, 0.0F, 0.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(4, 2).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.7418F, 0.0F, 0.0F));

        PartDefinition wool = tail.addOrReplaceChild("wool", CubeListBuilder.create().texOffs(16, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -5.0F, -0.6786F, -0.7268F, 0.4754F));

        PartDefinition Leg = Entity.addOrReplaceChild("Leg", CubeListBuilder.create().texOffs(20, 13).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, 3.0F));

        PartDefinition Leg2 = Entity.addOrReplaceChild("Leg2", CubeListBuilder.create().texOffs(20, 13).addBox(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 3.0F));

        PartDefinition Leg3 = Entity.addOrReplaceChild("Leg3", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, -4.0F));

        PartDefinition Leg4 = Entity.addOrReplaceChild("Leg4", CubeListBuilder.create().texOffs(8, 22).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, -4.0F));

        PartDefinition Head = Entity.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-3.0F, -4.0F, -1.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(17, 0).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 5.0F));

        PartDefinition horn_r1 = Head.addOrReplaceChild("horn_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 1.0F, -0.2481F, 0.0844F, 0.3211F));

        PartDefinition horn_r2 = Head.addOrReplaceChild("horn_r2", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.0F, 1.0F, -0.0413F, 0.0142F, 0.3313F));

        PartDefinition horn_r3 = Head.addOrReplaceChild("horn_r3", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -4.0F, 0.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -6.0F, 1.0F, -0.0407F, -0.0156F, -0.3662F));

        PartDefinition horn_r4 = Head.addOrReplaceChild("horn_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, 1.0F, -0.2451F, -0.0929F, -0.3551F));

        PartDefinition spine_r4 = Head.addOrReplaceChild("spine_r4", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.7F, -0.1F, -0.5236F, 0.0F, 0.0F));

        PartDefinition spine_r5 = Head.addOrReplaceChild("spine_r5", CubeListBuilder.create().texOffs(1, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.7F, -1.1F, -2.5307F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.applyHeadRotation(netHeadYaw,headPitch,ageInTicks);

        this.animateWalk(DrawoolAnimationDefinition.move, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(((DrawoolEntity)entity).idleAnimationState, DrawoolAnimationDefinition.idle , ageInTicks, 1f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.Head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.Head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Entity.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return Entity;
    }
}