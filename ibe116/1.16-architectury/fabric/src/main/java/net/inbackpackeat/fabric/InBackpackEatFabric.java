package net.inbackpackeat.fabric;

import net.inbackpackeat.InBackpackEat;
import net.fabricmc.api.ModInitializer;

public class InBackpackEatFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        InBackpackEat.init();
    }
}
