package com.nmmoc7.inbackpackeat.client;

import com.nmmoc7.inbackpackeat.net.EatClient;
import com.nmmoc7.inbackpackeat.net.NetManager;
import com.nmmoc7.inbackpackeat.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class FindItem {
    static int coolDown = 0;
    static int amount;
    static boolean pressed;

    @SubscribeEvent
    public static void cTick(TickEvent.ClientTickEvent event) {
        foodProgram();
    }

    static boolean eating() {
        return GameSettings.isKeyDown(KeyBindings.EAT);
    }

    static int getSlotFormInv(Slot slot, InventoryPlayer inv) {
        for (int i = 0; i < inv.mainInventory.size(); i++) {
            if (inv.mainInventory.get(i) == slot.getStack()) {
                return i;
            }
        }

        return -1;
    }

    static void foodProgram() {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;

        coolDown = Math.max(coolDown - 1, 0);

        if (mc.currentScreen instanceof GuiContainer) {
            GuiContainer screen = (GuiContainer) mc.currentScreen;
            Slot slot = screen.getSlotUnderMouse();

            if (slot != null && slot.inventory.equals(player.inventory)) {
                ItemStack item = slot.getStack();
                InventoryPlayer inv = player.inventory;

                if (eating()) {
                    if ((coolDown == 0 || !pressed) && Utils.isFood(item)){
                        int i = getSlotFormInv(slot, inv);

                        if (i != -1) {
                            NetManager.INSTANCE.sendMessageToServer(new EatClient(i));

                            if (amount > 4) {
                                coolDown = 3;
                            } else {
                                coolDown = 20;
                            }

                            if (!pressed) {
                                pressed = true;
                            }

                            amount++;
                        }
                    }
                }
                else {
                    pressed = false;
                }
            }
        }

        if (coolDown == 0) {
            amount = 0;
        }
    }
}
