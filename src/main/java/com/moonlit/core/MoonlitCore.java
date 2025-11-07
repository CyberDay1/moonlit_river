package com.moonlit.core;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoonlitCore.MODID)
public class MoonlitCore {
    public static final String MODID = "moonlit_core";

    public MoonlitCore() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        // Client-only init (UI overlays, rendering)
    }
}
