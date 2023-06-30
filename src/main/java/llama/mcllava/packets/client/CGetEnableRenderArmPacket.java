package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.SGetEnableRenderArmPacket;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CGetEnableRenderArmPacket implements IMessage{
    public CGetEnableRenderArmPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class Handler implements IMessageHandler<CGetEnableRenderArmPacket, IMessage> {
        @Override
        public IMessage onMessage(CGetEnableRenderArmPacket packet, MessageContext ctx) {
            boolean flag = ClientMethods.getEnableRenderArmToClient();

            return new SGetEnableRenderArmPacket(flag); // В ответ ничего не отправляем
        }
    }
}
