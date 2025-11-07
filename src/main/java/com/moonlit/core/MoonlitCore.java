package com.moonlit.core;

import com.moonlit.core.integration.CuriosIntegration;
import com.moonlit.core.network.NetworkHandler;
import com.moonlit.core.ui.OverlayHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.DistExecutor;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.client.event.RegisterGuiOverlaysEvent;

@Mod(MoonlitCore.MODID)
public class MoonlitCore {
    public static final String MODID = "moonlit_core";

    public MoonlitCore() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(MoonlitCore::onCommonSetup);
        modBus.addListener(CuriosIntegration::registerSlots);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> MoonlitCoreClient::new);
    }

    private static void onCommonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(NetworkHandler::register);
    }

    private static void onClientSetup(final FMLClientSetupEvent event) {
        // Client-only init (UI overlays, rendering)
    }

    private static void registerGuiOverlays(final RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("qi_bar", OverlayHandler.QI_BAR);
    }

    private static final class MoonlitCoreClient implements DistExecutor.SafeRunnable {
        @Override
        public void run() {
            var modBus = FMLJavaModLoadingContext.get().getModEventBus();
            modBus.addListener(MoonlitCore::onClientSetup);
            modBus.addListener(MoonlitCore::registerGuiOverlays);
        }
    }
}
