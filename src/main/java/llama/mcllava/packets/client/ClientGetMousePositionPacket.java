package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetMousePositionPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetMousePositionPacket implements IMessage {

    // Набор полей данных пакета

    public ClientGetMousePositionPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<ClientGetMousePositionPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetMousePositionPacket packet, MessageContext ctx) {
            double[] coordinates = ClientMethods.getMousePositionToClient();

            return new ServerGetMousePositionPacket(coordinates); // В ответ ничего не отправляем
        }
    }
}