package net.novarayx.toanotherdimension;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.novarayx.toanotherdimension.block.ModBlocks;
import net.novarayx.toanotherdimension.entity.ModEntities;
import net.novarayx.toanotherdimension.entity.client.CrocoRenderer;
import net.novarayx.toanotherdimension.item.ModCreativeTabs;
import net.novarayx.toanotherdimension.item.ModItems;
import net.novarayx.toanotherdimension.loot.ModLootModifiers;
import net.novarayx.toanotherdimension.sound.ModSounds;
import net.novarayx.toanotherdimension.worldgen.biome.ModTerrablender;
import net.novarayx.toanotherdimension.worldgen.biome.surface.ModSurfaceRules;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ToAnotherDimension.MOD_ID)
public class ToAnotherDimension
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "toanotherdimension";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public ToAnotherDimension(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModSounds.register(modEventBus);

        ModEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModTerrablender.registerBiomes();

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeRules());

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.NOVARITE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.NOVARITE_BLOCK);
            event.accept(ModBlocks.NOVARITE_BLOCK_DIRT);
            event.accept(ModBlocks.NOVARITE_STONE_BLOCK);
            event.accept(ModBlocks.NOVARITE_ORE_BLOCK);
            event.accept(ModBlocks.NOVARITE_LEAF_BLOCK);
            event.accept(ModBlocks.NOVARITE_LOG_BLOCK);
            event.accept(ModBlocks.NOVARITE_BRICK_BLOCK);

            event.accept(ModBlocks.NOVARITE_BRICK_DOOR);
            event.accept(ModBlocks.NOVARITE_BRICK_STAIRS);
            event.accept(ModBlocks.NOVARITE_BRICK_SLAB);
            event.accept(ModBlocks.NOVARITE_BRICK_BUTTON);
            event.accept(ModBlocks.NOVARITE_BRICK_FENCE);
            event.accept(ModBlocks.NOVARITE_BRICK_FENCE_GATE);
            event.accept(ModBlocks.NOVARITE_BRICK_PRESSURE_PLATE);
            event.accept(ModBlocks.NOVARITE_BRICK_WALL);
            event.accept(ModBlocks.NOVARITE_TREE_SAPLING.get().asItem());
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.CROCO.get(), CrocoRenderer::new);
        }
    }
}
