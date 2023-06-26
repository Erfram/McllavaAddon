package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetPerspectivePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetPerspectivePacket implements IMessage {

    // Набор полей данных пакета

    public ClientGetPerspectivePacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<ClientGetPerspectivePacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetPerspectivePacket packet, MessageContext ctx) {
            int number = ClientMethods.getPerspectiveToClient();

            return new ServerGetPerspectivePacket(number); // В ответ ничего не отправляем
        }
    }
}