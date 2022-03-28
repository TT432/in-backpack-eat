package com.nmmoc7.inbackpackeat.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class Utils {
    public static boolean isFood(ItemStack item) {
        return !item.isEmpty() && (item.getItem() instanceof ItemFood
                || item.getItem() == Items.MILK_BUCKET
                || item.getItem() == Items.POTIONITEM);
    }
}
