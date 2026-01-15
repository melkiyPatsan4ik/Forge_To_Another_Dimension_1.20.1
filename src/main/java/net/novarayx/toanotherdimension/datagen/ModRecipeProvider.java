package net.novarayx.toanotherdimension.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BLOCK.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.NOVARITE.get())
                .unlockedBy(getHasName(ModItems.NOVARITE.get()), has(ModItems.NOVARITE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NOVARITE.get(), 9)
                .requires(ModBlocks.NOVARITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BLOCK.get()), has(ModBlocks.NOVARITE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get(), 4)
                .requires(ModBlocks.NOVARITE_LOG_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
    }
}
