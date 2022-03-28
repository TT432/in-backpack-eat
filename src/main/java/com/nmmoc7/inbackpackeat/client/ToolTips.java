package com.nmmoc7.inbackpackeat.client;

import com.nmmoc7.inbackpackeat.utils.Utils;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ToolTips {
    @SubscribeEvent
    public static void tooltips(ItemTooltipEvent event) {
        ItemStack item = event.getItemStack();

        if (Utils.isFood(item)) {
            event.getToolTip().add("[" + KeyBindings.EAT.getDisplayName() + "] " + I18n.translateToLocal("tooltip.food.eat").trim());
        }
    }
}
