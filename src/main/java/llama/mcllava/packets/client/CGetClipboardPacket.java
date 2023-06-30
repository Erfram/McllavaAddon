package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.SGetClipboardPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CGetClipboardPacket implements IMessage {

    // Набор полей данных пакета

    public CGetClipboardPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<CGetClipboardPacket, IMessage> {
        @Override
        public IMessage onMessage(CGetClipboardPacket packet, MessageContext ctx) {
            String message = ClientMethods.getClipboardToClient();

            return new SGetClipboardPacket(message); // В ответ ничего не отправляем
        }
    }
}