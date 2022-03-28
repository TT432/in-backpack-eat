package net.inbackpackeat.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import net.inbackpackeat.InBackpackEat;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InBackpackEat.MOD_ID)
public class InBackpackEatModForge {
    public InBackpackEatModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(InBackpackEat.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        InBackpackEat.init();
    }
}
