package com.moonlit.core.cultivation;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;

public class CultivationCapability {
    private int qi;
    private int realmLevel;

    public void tick(Player player) {
        // TODO: Qi regen & breakthrough logic
    }

    public CompoundTag saveNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("Qi", qi);
        tag.putInt("RealmLevel", realmLevel);
        return tag;
    }

    public void loadNBT(CompoundTag tag) {
        qi = tag.getInt("Qi");
        realmLevel = tag.getInt("RealmLevel");
    }
}
