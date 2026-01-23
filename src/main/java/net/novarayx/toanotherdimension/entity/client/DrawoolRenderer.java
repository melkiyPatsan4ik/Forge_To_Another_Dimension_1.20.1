package net.novarayx.toanotherdimension.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;
import net.novarayx.toanotherdimension.entity.custom.DrawoolEntity;

public class DrawoolRenderer extends MobRenderer<DrawoolEntity, DrawoolModel<DrawoolEntity>> {
    public DrawoolRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DrawoolModel<>(pContext.bakeLayer(ModModelLayers.DRAWOOL_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DrawoolEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,"textures/entity/drawool.png");
    }

    @Override
    public void render(DrawoolEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
