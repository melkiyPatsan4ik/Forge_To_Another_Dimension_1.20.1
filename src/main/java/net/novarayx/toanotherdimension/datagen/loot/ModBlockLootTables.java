package net.novarayx.toanotherdimension.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NOVARITE_ORE_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_STONE_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_LOG_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_BLOCK_DIRT.get());
        this.dropSelf(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_WOOD_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK.get());
        this.dropSelf(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get());
        this.add(ModBlocks.NOVARITE_LEAF_BLOCK.get(), block ->
                createLeavesDrops(block, ModBlocks.NOVARITE_TREE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.NOVARITE_ORE_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NOVARITE_ORE_BLOCK.get(), ModItems.NOVARITE.get()));

        this.dropSelf(ModBlocks.NOVARITE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_BUTTON.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_FENCE.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.NOVARITE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.NOVARITE_TREE_SAPLING.get());

        this.add(ModBlocks.NOVARITE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NOVARITE_BRICK_SLAB.get()));
        this.add(ModBlocks.NOVARITE_BRICK_DOOR.get(),
                block -> createDoorTable(ModBlocks.NOVARITE_BRICK_DOOR.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
