package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.SGetMousePositionPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CGetMousePositionPacket implements IMessage {

    // Набор полей данных пакета

    public CGetMousePositionPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<CGetMousePositionPacket, IMessage> {
        @Override
        public IMessage onMessage(CGetMousePositionPacket packet, MessageContext ctx) {
            double[] coordinates = ClientMethods.getMousePositionToClient();

            return new SGetMousePositionPacket(coordinates); // В ответ ничего не отправляем
        }
    }
}