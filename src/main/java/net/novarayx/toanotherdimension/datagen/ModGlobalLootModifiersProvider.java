package net.novarayx.toanotherdimension.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.item.ModItems;
import net.novarayx.toanotherdimension.loot.AddItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ToAnotherDimension.MOD_ID);
    }

    @Override
    protected void start() {
        add("novarite_fruit_from_leaf", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.NOVARITE_LEAF_BLOCK.get()).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.NOVARITE_FRUIT.get()));
        add("novarite_heart_from_croco", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID, "entity/croco")).build()},ModItems.NOVARITE_HEART.get()));
        add("novarite_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.fromNamespaceAndPath("minecraft", "chests/jungle_temple")).build()},ModItems.NOVARITE_DETECTOR.get()));
    }
}
