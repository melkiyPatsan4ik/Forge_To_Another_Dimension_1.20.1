package net.novarayx.toanotherdimension.item;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.novarayx.toanotherdimension.ToAnotherDimension;
import net.novarayx.toanotherdimension.item.custom.FuelItem;
import net.novarayx.toanotherdimension.item.custom.MetalDetectorItem;
import net.novarayx.toanotherdimension.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ToAnotherDimension.MOD_ID);

    public static final RegistryObject<Item> NOVARITE = ITEMS.register("novarite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_HEART = ITEMS.register("novarite_heart",
            () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NOVARITE_DETECTOR = ITEMS.register("novarite_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(200)));
    public static final RegistryObject<Item> NOVARITE_FRUIT = ITEMS.register("novarite_fruit",
            () -> new Item(new Item.Properties().food(ModFoods.NOVARITE_FRUIT)));
    public static final RegistryObject<Item> NOVARITE_VEGETABLE = ITEMS.register("novarite_vegetable",
            () -> new Item(new Item.Properties().food(ModFoods.NOVARITE_VEGETABLE)));

    public static final RegistryObject<Item> NOVARITE_WOOD_SWORD= ITEMS.register("novarite_wood_sword",
            () -> new SwordItem(ModToolTiers.NOVARITE_WOOD, 4,2,new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_PICKAXE = ITEMS.register("novarite_wood_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NOVARITE_WOOD,1, 1, new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_SHOVEL = ITEMS.register("novarite_wood_shovel",
            () -> new ShovelItem(ModToolTiers.NOVARITE_WOOD,1, 1, new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_HOE = ITEMS.register("novarite_wood_hoe",
            () -> new HoeItem(ModToolTiers.NOVARITE_WOOD,1, 1, new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_AXE = ITEMS.register("novarite_wood_axe",
            () -> new AxeItem(ModToolTiers.NOVARITE_WOOD,8, 1, new Item.Properties()));

    public static final RegistryObject<Item> NOVARITE_WOOD_HELMET = ITEMS.register("novarite_wood_helmet",
            () -> new ArmorItem(ModArmorMaterials.NOVARITE_WOOD,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_CHESTPLATE = ITEMS.register("novarite_wood_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NOVARITE_WOOD,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_LEGGINGS = ITEMS.register("novarite_wood_leggings",
            () -> new ArmorItem(ModArmorMaterials.NOVARITE_WOOD,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> NOVARITE_WOOD_BOOTS = ITEMS.register("novarite_wood_boots",
            () -> new ArmorItem(ModArmorMaterials.NOVARITE_WOOD,ArmorItem.Type.BOOTS,new Item.Properties()));

    public static final RegistryObject<Item> SPACE_NULLIFIER_MUSIC_DISC = ITEMS.register("space_nullifier_music_disc",
            () -> new RecordItem(6, ModSounds.SPACE_NULLIFIER, new Item.Properties().stacksTo(1), 2440));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
