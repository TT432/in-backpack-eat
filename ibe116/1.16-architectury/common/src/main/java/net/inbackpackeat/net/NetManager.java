package net.inbackpackeat.net;

import me.shedaniel.architectury.networking.NetworkChannel;
import net.inbackpackeat.InBackpackEat;
import net.minecraft.resources.ResourceLocation;

/**
 * @author DustW
 */
public class NetManager {
    public static final NetManager INSTANCE = new NetManager();

    private final NetworkChannel channel = NetworkChannel.create(new ResourceLocation(InBackpackEat.MOD_ID, "net"));

    public NetManager() {
        channel.register(EatClient.class, EatClient::toBytes, EatClient::fromBytes, EatClient::handle);
    }

    // 向服务器发包（客户端到服务器）
    public void sendMessageToServer(IMessage msg) {
        channel.sendToServer(msg);
    }
}
