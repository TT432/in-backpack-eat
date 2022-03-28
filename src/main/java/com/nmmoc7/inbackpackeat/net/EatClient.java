package com.nmmoc7.inbackpackeat.net;

import com.nmmoc7.inbackpackeat.utils.Utils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class EatClient implements IMessage {
    int slot;

    public EatClient() {
    }

    public EatClient(int slot) {
        this.slot = slot;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        slot = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(slot);
    }

    public static class Handler implements IMessageHandler<EatClient, IMessage> {
        @Override
        public IMessage onMessage(EatClient message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            InventoryPlayer inv = player.inventory;
            ItemStack item = inv.getStackInSlot(message.slot);

            if (Utils.isFood(item)) {
                item.onItemUseFinish(player.world, player);
            }

            return null;
        }
    }
}
