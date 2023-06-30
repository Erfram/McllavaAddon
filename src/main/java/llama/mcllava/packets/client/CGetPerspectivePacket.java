package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.SGetPerspectivePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CGetPerspectivePacket implements IMessage {

    // Набор полей данных пакета

    public CGetPerspectivePacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<CGetPerspectivePacket, IMessage> {
        @Override
        public IMessage onMessage(CGetPerspectivePacket packet, MessageContext ctx) {
            int number = ClientMethods.getPerspectiveToClient();

            return new SGetPerspectivePacket(number); // В ответ ничего не отправляем
        }
    }
}