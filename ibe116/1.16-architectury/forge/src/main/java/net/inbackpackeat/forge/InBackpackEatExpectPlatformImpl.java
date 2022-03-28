package net.inbackpackeat.forge;

import net.inbackpackeat.InBackpackEatExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class InBackpackEatExpectPlatformImpl {
    /**
     * This is our actual method to {@link InBackpackEatExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
