package net.novarayx.toanotherdimension.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.novarayx.toanotherdimension.ToAnotherDimension;

public class ModModelLayers {
    public static final ModelLayerLocation CROCO_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,"croco_layer"), "main");
    public static final ModelLayerLocation DRAWOOL_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,"drawool_layer"), "main");
}
