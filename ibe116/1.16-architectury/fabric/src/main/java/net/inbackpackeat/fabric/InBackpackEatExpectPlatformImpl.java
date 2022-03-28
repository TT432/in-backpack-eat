package net.inbackpackeat.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.inbackpackeat.InBackpackEatExpectPlatform;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.Slot;

import java.lang.reflect.Field;
import java.nio.file.Path;

public class InBackpackEatExpectPlatformImpl {
    /**
     * This is our actual method to {@link InBackpackEatExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    static Field hoveredSlot;

    public static Slot getPointingSlot(AbstractContainerScreen screen) {
        try {
            return (Slot) (hoveredSlot == null ? (hoveredSlot = screen.getClass().getField("hoveredSlot")) : hoveredSlot).get(screen);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
