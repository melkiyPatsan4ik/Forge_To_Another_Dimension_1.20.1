package net.novarayx.toanotherdimension.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.custom.ModFlammableRotatedPillarBlock;
import net.novarayx.toanotherdimension.block.custom.ModPortalBlock;
import net.novarayx.toanotherdimension.item.ModItems;
import net.novarayx.toanotherdimension.worldgen.tree.NovariteTreeGrower;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ToAnotherDimension.MOD_ID);

    public static final RegistryObject<Block> NOVARITE_BLOCK = registerBlock("novarite_block",
            ()-> new ModPortalBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.AMETHYST)){
                @Override
                public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                    pTooltip.add(Component.translatable("tooltip.toanotherdimension.portalblock"));
                    super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
                }
            });
    public static final RegistryObject<Block> NOVARITE_ORE_BLOCK = registerBlock("novarite_ore_block",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block> NOVARITE_STONE_BLOCK = registerBlock("novarite_stone_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final RegistryObject<Block> NOVARITE_BLOCK_DIRT = registerBlock("novarite_dirt_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)
                    .strength(1f)
                    .sound(SoundType.ROOTED_DIRT)));
    public static final RegistryObject<Block> NOVARITE_LEAF_BLOCK = registerBlock("novarite_leaf_block",
            ()-> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .strength(1f)
                    .noOcclusion()
                    .sound(SoundType.BIG_DRIPLEAF)));
    public static final RegistryObject<Block> NOVARITE_LOG_BLOCK = registerBlock("novarite_log_block",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2f)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NOVARITE_STRIPPED_LOG_BLOCK = registerBlock("novarite_stripped_log_block",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2f)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NOVARITE_STRIPPED_WOOD_BLOCK = registerBlock("novarite_stripped_wood_block",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2f)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NOVARITE_WOOD_BLOCK = registerBlock("novarite_wood_block",
            ()-> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2f)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> NOVARITE_WOOD_PlANK_BLOCK = registerBlock("novarite_wood_plank_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2f)
                    .sound(SoundType.WOOD)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> NOVARITE_TREE_SAPLING = registerBlock("novarite_tree_sapling",
            ()-> new SaplingBlock(new NovariteTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)
                    .sound(SoundType.CHERRY_SAPLING)));

    public static final RegistryObject<Block> NOVARITE_BRICK_BLOCK = registerBlock("novarite_brick_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> NOVARITE_BRICK_STAIRS = registerBlock("novarite_brick_stairs",
            ()-> new StairBlock(() -> ModBlocks.NOVARITE_BRICK_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> NOVARITE_BRICK_SLAB = registerBlock("novarite_brick_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)

                    .sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> NOVARITE_BRICK_BUTTON = registerBlock("novarite_brick_button",
            ()-> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS),
                    BlockSetType.STONE, 10, true));
    public static final RegistryObject<Block> NOVARITE_BRICK_PRESSURE_PLATE = registerBlock("novarite_brick_pressure_plate",
            ()-> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS),
                    BlockSetType.STONE));

    public static final RegistryObject<Block> NOVARITE_BRICK_FENCE = registerBlock("novarite_brick_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block> NOVARITE_BRICK_FENCE_GATE = registerBlock("novarite_brick_fence_gate",
            ()-> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS),
                    SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> NOVARITE_BRICK_WALL = registerBlock("novarite_brick_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS)
                    .sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block> NOVARITE_BRICK_DOOR = registerBlock("novarite_brick_door",
            ()-> new DoorBlock(BlockBehaviour.Properties.of()
                    .strength(3f)
                    .sound(SoundType.NETHER_BRICKS)
                    .noOcclusion(),
                    BlockSetType.OAK));

    private  static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
