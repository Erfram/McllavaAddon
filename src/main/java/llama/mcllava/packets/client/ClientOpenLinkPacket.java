package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientOpenLinkPacket implements IMessage {

    // Набор полей данных пакета
    private String url;

    public ClientOpenLinkPacket(){}

    public ClientOpenLinkPacket(String key) {
        this.url = key;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        url = ByteBufUtils.readUTF8String(buf);
    };

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, url);
    }

    public static class Handler implements IMessageHandler<ClientOpenLinkPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientOpenLinkPacket packet, MessageContext ctx) {
            String url = packet.url;

            // Отправляем сообщение игроку
            if(ctx.side.isClient()) {
                ClientMethods.openLinkToClient(url);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}