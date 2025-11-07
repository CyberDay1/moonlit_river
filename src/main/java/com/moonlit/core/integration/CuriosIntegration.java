package com.moonlit.core.integration;

import top.theillusivec4.curios.api.event.RegisterCurioSlotsEvent;
import top.theillusivec4.curios.api.type.slot.SlotTypePreset;

public class CuriosIntegration {
    public static void registerSlots(RegisterCurioSlotsEvent event) {
        event.registerSlot(SlotTypePreset.RING.getIdentifier());
        event.registerSlot(SlotTypePreset.CHARM.getIdentifier());
    }
}
