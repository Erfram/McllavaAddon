package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetSystemTimePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetSystemTimePacket implements IMessage {

    // Набор полей данных пакета

    public ClientGetSystemTimePacket(){}


    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<ClientGetSystemTimePacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetSystemTimePacket packet, MessageContext ctx) {
            String time = ClientMethods.getSystemTimeToClient();

            return new ServerGetSystemTimePacket(time); // В ответ ничего не отправляем
        }
    }
}