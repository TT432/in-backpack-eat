package net.inbackpackeat;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class InBackpackEatExpectPlatform {
    @ExpectPlatform
    public static Path getConfigDirectory() {
        throw new AssertionError();
    }
}
