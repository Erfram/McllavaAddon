package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.SGetSystemTimePacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CGetSystemTimePacket implements IMessage {

    // Набор полей данных пакета

    public CGetSystemTimePacket(){}


    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<CGetSystemTimePacket, IMessage> {
        @Override
        public IMessage onMessage(CGetSystemTimePacket packet, MessageContext ctx) {
            String time = ClientMethods.getSystemTimeToClient();

            return new SGetSystemTimePacket(time); // В ответ ничего не отправляем
        }
    }
}