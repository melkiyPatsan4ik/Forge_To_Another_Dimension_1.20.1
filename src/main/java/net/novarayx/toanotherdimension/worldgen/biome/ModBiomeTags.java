package net.novarayx.toanotherdimension.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.novarayx.toanotherdimension.ToAnotherDimension;

// NOT BEING USED FOR ANYTHING RIGHT NOW
public class ModBiomeTags {
    public static final TagKey<Biome> NOVARITE_BIOME_TAG =
            TagKey.create(Registries.BIOME,
                    ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, "has_novarite_trees"));
}
