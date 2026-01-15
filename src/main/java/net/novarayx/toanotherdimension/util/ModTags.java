package net.novarayx.toanotherdimension.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.novarayx.toanotherdimension.ToAnotherDimension;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES
                = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_NOVARITE_TOOL
                = tag("needs_novarite_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, name));
        }
    }
    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, name));
        }
    }
}
