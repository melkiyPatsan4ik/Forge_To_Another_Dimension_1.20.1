package net.novarayx.toanotherdimension.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.entity.custom.CrocoEntity;

public class CrocoRenderer extends MobRenderer<CrocoEntity, CrocoModel<CrocoEntity>> {
    public CrocoRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrocoModel<>(pContext.bakeLayer(ModModelLayers.CROCO_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrocoEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,"textures/entity/croco.png");
    }

    @Override
    public void render(CrocoEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        if(pEntity.isBaby()){
            pPoseStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
