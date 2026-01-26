package net.novarayx.toanotherdimension.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_BLOCK.get(), 4)
                .pattern("NN")
                .pattern("NN")
                .define('N', ModBlocks.NOVARITE_STONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_STONE_BLOCK.get()), has(ModBlocks.NOVARITE_STONE_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_STAIRS.get())
                .pattern("  N")
                .pattern(" NN")
                .pattern("NNN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_SLAB.get(), 6)
                .pattern("NNN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE.get(), 6)
                .pattern("NN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_DOOR.get())
                .pattern("NN")
                .pattern("NN")
                .pattern("NN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_WALL.get())
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_FENCE.get())
                .pattern("NSN")
                .pattern("NSN")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_FENCE_GATE.get())
                .pattern("SNS")
                .pattern("SNS")
                .define('N', ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.NOVARITE_BRICK_BUTTON.get(), 1)
                .requires(ModBlocks.NOVARITE_BRICK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_BRICK_BLOCK.get()), has(ModBlocks.NOVARITE_BRICK_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get(), 4)
                .requires(ModBlocks.NOVARITE_LOG_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_PICKAXE.get())
                .pattern("WWW")
                .pattern(" S ")
                .pattern(" S ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_AXE.get())
                .pattern("WW ")
                .pattern("WS ")
                .pattern(" S ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_SWORD.get())
                .pattern(" W ")
                .pattern(" W ")
                .pattern(" S ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_SHOVEL.get())
                .pattern(" W ")
                .pattern(" S ")
                .pattern(" S ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_HOE.get())
                .pattern("WW ")
                .pattern(" S ")
                .pattern(" S ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_HELMET.get())
                .pattern("WWW")
                .pattern("W W")
                .pattern("   ")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_CHESTPLATE.get())
                .pattern("W W")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_LEGGINGS.get())
                .pattern("WWW")
                .pattern("W W")
                .pattern("W W")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.NOVARITE_WOOD_BOOTS.get())
                .pattern("   ")
                .pattern("W W")
                .pattern("W W")
                .define('W', ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NOVARITE_LOG_BLOCK.get()), has(ModBlocks.NOVARITE_LOG_BLOCK.get()))
                .save(pWriter);
    }
}
