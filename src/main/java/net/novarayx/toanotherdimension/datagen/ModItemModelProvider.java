package net.novarayx.toanotherdimension.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ToAnotherDimension.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NOVARITE);
        simpleItem(ModItems.NOVARITE_DETECTOR);
        simpleItem(ModItems.NOVARITE_FRUIT);
        simpleItem(ModItems.NOVARITE_VEGETABLE);
        simpleItem(ModItems.SPACE_NULLIFIER_MUSIC_DISC);

        simpleBlockItem(ModBlocks.NOVARITE_BRICK_DOOR);

        fenceItem(ModBlocks.NOVARITE_BRICK_FENCE, ModBlocks.NOVARITE_BRICK_BLOCK);
        buttonItem(ModBlocks.NOVARITE_BRICK_BUTTON, ModBlocks.NOVARITE_BRICK_BLOCK);
        wallItem(ModBlocks.NOVARITE_BRICK_WALL, ModBlocks.NOVARITE_BRICK_BLOCK);

        evenSimplerBlockItem(ModBlocks.NOVARITE_BRICK_STAIRS);
        evenSimplerBlockItem(ModBlocks.NOVARITE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.NOVARITE_BRICK_FENCE_GATE);

        handheldItem(ModItems.NOVARITE_WOOD_SWORD);
        handheldItem(ModItems.NOVARITE_WOOD_AXE);
        handheldItem(ModItems.NOVARITE_WOOD_PICKAXE);
        handheldItem(ModItems.NOVARITE_WOOD_SHOVEL);
        handheldItem(ModItems.NOVARITE_WOOD_HOE);

        trimmedArmorItem(ModItems.NOVARITE_WOOD_HELMET);
        trimmedArmorItem(ModItems.NOVARITE_WOOD_CHESTPLATE);
        trimmedArmorItem(ModItems.NOVARITE_WOOD_LEGGINGS);
        trimmedArmorItem(ModItems.NOVARITE_WOOD_BOOTS);

        saplingItem(ModBlocks.NOVARITE_TREE_SAPLING);

        withExistingParent(ModItems.CROCO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.DRAWOOL_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ToAnotherDimension.MOD_ID;

        if (itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + itemRegistryObject.getId().getPath();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";

                // ✅ Non-deprecated ResourceLocation creation
                ResourceLocation armorItemResLoc =
                        ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);

                ResourceLocation trimResLoc =
                        ResourceLocation.fromNamespaceAndPath("minecraft", trimPath);

                ResourceLocation trimNameResLoc =
                        ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                // Let ExistingFileHelper know this texture exists
                existingFileHelper.trackGenerated(
                        trimResLoc,
                        PackType.CLIENT_RESOURCES,
                        ".png",
                        "textures"
                );

                // Trimmed armor model
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Base armor model with trim override
                this.withExistingParent(
                                itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated")
                        )
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue)
                        .end()
                        .texture(
                                "layer0",
                                ResourceLocation.fromNamespaceAndPath(
                                        MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()
                                )
                        );
            });
        }
    }




    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(
                item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated")
        ).texture(
                "layer0",
                ResourceLocation.fromNamespaceAndPath(
                        ToAnotherDimension.MOD_ID,
                        "item/" + item.getId().getPath()
                )
        );
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(
                item.getId().getPath(),
                modLoc("block/" + item.getId().getPath())
        );
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",
                        ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(ToAnotherDimension.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(
                                ToAnotherDimension.MOD_ID,
                                "item/" + item.getId().getPath()
                        ));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(ToAnotherDimension.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/handheld"))
                .texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(
                                ToAnotherDimension.MOD_ID,
                                "item/" + item.getId().getPath()
                        ));
    }

}
