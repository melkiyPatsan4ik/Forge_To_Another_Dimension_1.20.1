package net.novarayx.toanotherdimension.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes(){
        Regions.register(new ModOverworldRegion(ResourceLocation
                .fromNamespaceAndPath(ToAnotherDimension.MOD_ID,"overworld"),5));
    }
}
