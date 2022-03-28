package net.inbackpackeat.utils;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/***
 * @author DustW
 */
public class Utils {
    public static boolean isFood(ItemStack item) {
        return !item.isEmpty() && (item.getItem().getFoodProperties() != null
                || item.getItem() == Items.MILK_BUCKET
                || item.getItem() == Items.POTION);
    }
}
