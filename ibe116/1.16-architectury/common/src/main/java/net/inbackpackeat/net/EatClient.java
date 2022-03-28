package net.inbackpackeat.net;

import io.netty.buffer.ByteBuf;
import me.shedaniel.architectury.networking.NetworkManager;
import net.inbackpackeat.utils.Utils;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

/***
 * @author DustW
 */
public class EatClient implements IMessage {
    int slot;

    public EatClient(int slot) {
        this.slot = slot;
    }

    public static EatClient fromBytes(ByteBuf buf) {
        int slot = buf.readInt();
        return new EatClient(slot);
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(slot);
    }

    public static void handle(EatClient t, Supplier<NetworkManager.PacketContext> ctx) {
        Player player = ctx.get().getPlayer();
        Inventory inv = player.inventory;
        ItemStack item = inv.getItem(t.slot);

        if (Utils.isFood(item)) {
            item.finishUsingItem(player.level, player);
        }
    }
}
