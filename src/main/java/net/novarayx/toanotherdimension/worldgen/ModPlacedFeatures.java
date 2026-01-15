package net.novarayx.toanotherdimension.worldgen;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_NOVARITE_ORE_KEY = registerKey("novarite_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_NOVARITE_ORE_KEY = registerKey("nether_novarite_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NOVARITE_ORE_KEY = registerKey("end_novarite_ore_placed");

    public static final ResourceKey<PlacedFeature> NOVARITE_TREE_PLACED_KEY = registerKey("novarite_tree_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, OVERWORLD_NOVARITE_ORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NOVARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_NOVARITE_ORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_NOVARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NOVARITE_ORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_NOVARITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NOVARITE_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NOVARITE_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2),
                        ModBlocks.NOVARITE_TREE_SAPLING.get())
                );
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}