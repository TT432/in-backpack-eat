package com.nmmoc7.inbackpackeat;

import com.nmmoc7.inbackpackeat.proxy.Common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = InBackpackEat.MOD_ID,
        name = InBackpackEat.MOD_NAME,
        version = InBackpackEat.VERSION
)
public class InBackpackEat {

    public static final String MOD_ID = "in-backpack-eat";
    public static final String MOD_NAME = "In Backpack Eat";
    public static final String VERSION = "1.12.2-1-1";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static InBackpackEat INSTANCE;

    @SidedProxy(clientSide = "com.nmmoc7.inbackpackeat.proxy.Client", serverSide = "com.nmmoc7.inbackpackeat.proxy.Common")
    public static Common proxy;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
}
