package net.novarayx.toanotherdimension.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.tags.BlockTags.*;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ToAnotherDimension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES).add(ModBlocks.NOVARITE_ORE_BLOCK.get()).addTag(Tags.Blocks.ORES);

        this.tag(MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NOVARITE_BRICK_BLOCK.get(),
                        ModBlocks.NOVARITE_BLOCK.get(),
                        ModBlocks.NOVARITE_ORE_BLOCK.get()
                );

        this.tag(NEEDS_IRON_TOOL)
            .add(ModBlocks.NOVARITE_ORE_BLOCK.get());

        this.tag(NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.NOVARITE_LOG_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_NOVARITE_TOOL)
                .add(ModBlocks.NOVARITE_BRICK_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.NOVARITE_BRICK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.NOVARITE_BRICK_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.NOVARITE_BRICK_WALL.get());

        this.tag(LOGS_THAT_BURN)
                .add(ModBlocks.NOVARITE_LOG_BLOCK.get())
                .add(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get())
                .add(ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK.get())
                .add(ModBlocks.NOVARITE_WOOD_BLOCK.get())
                .add(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get());


        this.tag(DIRT)
                .add(ModBlocks.NOVARITE_BLOCK_DIRT.get());
        }

}
