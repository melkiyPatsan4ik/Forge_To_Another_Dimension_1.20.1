package net.novarayx.toanotherdimension.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ToAnotherDimension.MOD_ID);

    public static final RegistryObject<CreativeModeTab> NOVARITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("novarite_items_tab",
                    ()-> CreativeModeTab.builder()
                            .icon(()-> new ItemStack(ModItems.NOVARITE.get()))
                            .title(Component.translatable("creativetab.toanotherdimension.novarite_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.NOVARITE.get());
                                output.accept(ModItems.NOVARITE_DETECTOR.get());
                                output.accept(ModItems.NOVARITE_FRUIT.get());
                                output.accept(ModItems.NOVARITE_VEGETABLE.get());
                                output.accept(ModItems.NOVARITE_HEART.get());

                                output.accept(ModItems.NOVARITE_WOOD_AXE.get());
                                output.accept(ModItems.NOVARITE_WOOD_PICKAXE.get());
                                output.accept(ModItems.NOVARITE_WOOD_SWORD.get());
                                output.accept(ModItems.NOVARITE_WOOD_SHOVEL.get());
                                output.accept(ModItems.NOVARITE_WOOD_HOE.get());

                                output.accept(ModItems.NOVARITE_WOOD_HELMET.get());
                                output.accept(ModItems.NOVARITE_WOOD_CHESTPLATE.get());
                                output.accept(ModItems.NOVARITE_WOOD_LEGGINGS.get());
                                output.accept(ModItems.NOVARITE_WOOD_BOOTS.get());

                                output.accept(ModBlocks.NOVARITE_TREE_SAPLING.get().asItem());
                                output.accept(ModItems.SPACE_NULLIFIER_MUSIC_DISC.get());
                            })

                            .build());
    public static final RegistryObject<CreativeModeTab> NOVARITE_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("novarite_blocks_tab",
                    ()-> CreativeModeTab.builder()
                            .icon(()-> new ItemStack(ModBlocks.NOVARITE_BLOCK.get()))
                            .withTabsBefore(NOVARITE_ITEMS_TAB.getId())
                            .title(Component.translatable("creativetab.toanotherdimension.novarite_blocks"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.NOVARITE_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_BLOCK_DIRT.get());
                                output.accept(ModBlocks.NOVARITE_ORE_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_LEAF_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_LOG_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_STRIPPED_LOG_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_WOOD_PlANK_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_STRIPPED_WOOD_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_WOOD_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_BLOCK.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_STAIRS.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_DOOR.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_STAIRS.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_SLAB.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_BUTTON.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_FENCE.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_FENCE_GATE.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE.get());
                                output.accept(ModBlocks.NOVARITE_BRICK_WALL.get());
                            })

                            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
