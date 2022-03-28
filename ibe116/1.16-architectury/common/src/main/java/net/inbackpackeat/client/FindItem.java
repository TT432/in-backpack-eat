package net.inbackpackeat.client;

import com.mojang.blaze3d.platform.InputConstants;
import me.shedaniel.architectury.event.events.client.ClientTickEvent;
import net.inbackpackeat.net.EatClient;
import net.inbackpackeat.net.NetManager;
import net.inbackpackeat.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FindItem {
    int coolDown = 0;
    int amount;
    boolean pressed;

    public FindItem() {
        ClientTickEvent.CLIENT_PRE.register(this::foodProgram);
    }

    boolean eating() {
        return InputConstants.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), ModKeys.EAT.key.getValue());
    }

    int getSlotFormInv(Slot slot, Inventory inv) {
        for (int i = 0; i < inv.items.size(); i++) {
            if (inv.items.get(i) == slot.getItem()) {
                return i;
            }
        }

        return -1;
    }

    void foodProgram(Minecraft mc) {
        LocalPlayer player = mc.player;

        coolDown = Math.max(coolDown - 1, 0);

        if (mc.screen instanceof AbstractContainerScreen) {
            AbstractContainerScreen screen = (AbstractContainerScreen) mc.screen;
            Slot slot = screen.hoveredSlot;

            if (slot != null && slot.container.equals(player.inventory)) {
                ItemStack item = slot.getItem();
                Inventory inv = player.inventory;

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
