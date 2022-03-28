package com.nmmoc7.inbackpackeat.proxy;

import com.nmmoc7.inbackpackeat.client.KeyBindings;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Client extends Common {
    @Override
    public void init() {
        super.init();

        KeyBindings.EAT.setKeyConflictContext(KeyConflictContext.GUI);
        ClientRegistry.registerKeyBinding(KeyBindings.EAT);
    }
}
