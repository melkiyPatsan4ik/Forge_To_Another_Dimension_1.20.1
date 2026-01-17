package net.novarayx.toanotherdimension.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier NOVARITE_WOOD = TierSortingRegistry.registerTier(
            new ForgeTier(5,1500,10f,4f,25,
                    ModTags.Blocks.NEEDS_NOVARITE_TOOL, () -> Ingredient.of(ModItems.NOVARITE.get())),
            ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, "novarite_wood_plank_block"), List.of(Tiers.NETHERITE),
            List.of());
}
