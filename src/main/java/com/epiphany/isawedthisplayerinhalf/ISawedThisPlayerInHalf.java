package com.epiphany.isawedthisplayerinhalf;

import com.epiphany.isawedthisplayerinhalf.networking.Networker;
import com.epiphany.isawedthisplayerinhalf.rendering.PlayerRendererWrapper;
import com.epiphany.isawedthisplayerinhalf.rendering.RenderingOffsetter;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// TODO Check out why bytecode manipulators are not working in release builds.
// TODO Add config options to change offset.

// TODO Try and change rendering calculations so Minecraft will render the offset position, even if the original is not in view.

// TODO Add option to turn graphics off.

@Mod("swdthsplyrnhlf")
public class ISawedThisPlayerInHalf {
    public static final String MOD_ID = "swdthsplyrnhlf";

    public ISawedThisPlayerInHalf() {
        FMLJavaModLoadingContext.get().getModEventBus().register(ISawedThisPlayerInHalf.class);
        MinecraftForge.EVENT_BUS.register(Offsetter.class);
        Networker.registerPackets();
    }

    @SubscribeEvent
    public static void doClientStuff(final FMLClientSetupEvent fmlClientSetupEvent) {
        RenderingOffsetter.doClientStuff();
        PlayerRendererWrapper.doClientStuff();

        MinecraftForge.EVENT_BUS.register(RenderingOffsetter.class);
    }

    @SubscribeEvent
    public static void onServerStarting(FMLServerStartingEvent fmlServerStartingEvent) {

    }


    /*@SubscribeEvent
    public static void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    @SubscribeEvent
    public static void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }



    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        }
    }*/
}
