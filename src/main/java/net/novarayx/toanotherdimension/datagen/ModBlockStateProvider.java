package net.novarayx.toanotherdimension.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ToAnotherDimension.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NOVARITE_BLOCK);
        blockWithItem(ModBlocks.NOVARITE_BLOCK_DIRT);
        blockWithItem(ModBlocks.NOVARITE_STONE_BLOCK);
        blockWithItem(ModBlocks.NOVARITE_BRICK_BLOCK);
        blockWithItem(ModBlocks.NOVARITE_ORE_BLOCK);


        stairsBlock((StairBlock) ModBlocks.NOVARITE_BRICK_STAIRS.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.NOVARITE_BRICK_SLAB.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.NOVARITE_BRICK_BUTTON.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.NOVARITE_BRICK_FENCE.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.NOVARITE_BRICK_FENCE_GATE.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.NOVARITE_BRICK_WALL.get(),
                blockTexture(ModBlocks.NOVARITE_BRICK_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.NOVARITE_BRICK_DOOR.get(),
                modLoc("block/novarite_brick_door_bottom"),
                modLoc("block/novarite_brick_door_top"),
                "cutout");

        logBlock(((RotatedPillarBlock) ModBlocks.NOVARITE_LOG_BLOCK.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.NOVARITE_WOOD_BLOCK.get()), blockTexture(ModBlocks.NOVARITE_LOG_BLOCK.get()), blockTexture(ModBlocks.NOVARITE_LOG_BLOCK.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get()), blockTexture(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get()),
                ResourceLocation.fromNamespaceAndPath(
                        ToAnotherDimension.MOD_ID,
                        "block/stripped_pine_log_top"
                ));
        axisBlock(((RotatedPillarBlock) ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK.get()), blockTexture(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get()),
                blockTexture(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get()));

        blockItem(ModBlocks.NOVARITE_LOG_BLOCK);
        blockItem(ModBlocks.NOVARITE_WOOD_BLOCK);
        blockItem(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK);
        blockItem(ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK);

        blockWithItem(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK);

        leavesBlock(ModBlocks.NOVARITE_LEAF_BLOCK);

        saplingBlock(ModBlocks.NOVARITE_TREE_SAPLING);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.fromNamespaceAndPath("minecraft", "block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ToAnotherDimension.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
