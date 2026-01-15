package net.novarayx.toanotherdimension.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.LOGS_THAT_BURN;
import static net.minecraft.tags.BlockTags.PLANKS;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ToAnotherDimension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.NOVARITE_WOOD_HELMET.get(),
                        ModItems.NOVARITE_WOOD_CHESTPLATE.get(),
                        ModItems.NOVARITE_WOOD_LEGGINGS.get(),
                        ModItems.NOVARITE_WOOD_BOOTS.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.NOVARITE_LOG_BLOCK.get().asItem())
                .add(ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK.get().asItem())
                .add(ModBlocks.NOVARITE_WOOD_BLOCK.get().asItem())
                .add(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get().asItem());

        this.tag(ItemTags.MUSIC_DISCS)
                .add(ModItems.SPACE_NULLIFIER_MUSIC_DISC.get());

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.SPACE_NULLIFIER_MUSIC_DISC.get());

    }
}
