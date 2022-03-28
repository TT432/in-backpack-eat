package net.inbackpackeat;

import me.shedaniel.architectury.registry.KeyBindings;
import me.shedaniel.architectury.utils.Env;
import me.shedaniel.architectury.utils.EnvExecutor;
import net.inbackpackeat.client.FindItem;
import net.inbackpackeat.client.ModKeys;
import net.inbackpackeat.client.ToolTips;
import net.inbackpackeat.net.NetManager;

/***
 * @author DustW
 */
public class InBackpackEat {
    public static final String MOD_ID = "in-backpack-eat";

    public static NetManager net;

    public static void init() {
        net = NetManager.INSTANCE;

        EnvExecutor.runInEnv(Env.CLIENT, () -> () -> {
            KeyBindings.registerKeyBinding(ModKeys.EAT);
            new FindItem();
            new ToolTips();
        });
    }
}