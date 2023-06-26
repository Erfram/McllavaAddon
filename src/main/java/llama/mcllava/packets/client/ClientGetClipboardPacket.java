package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetClipboardPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetClipboardPacket implements IMessage {

    // Набор полей данных пакета

    public ClientGetClipboardPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<ClientGetClipboardPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetClipboardPacket packet, MessageContext ctx) {
            String message = ClientMethods.getClipboardToClient();

            return new ServerGetClipboardPacket(message); // В ответ ничего не отправляем
        }
    }
}