package net.novarayx.toanotherdimension.worldgen.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.novarayx.toanotherdimension.worldgen.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class NovariteTreeGrower extends AbstractTreeGrower {
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.NOVARITE_TREE_KEY;
    }
}
