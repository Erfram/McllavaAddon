package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SGetSystemTimePacket implements IMessage {

    // Набор полей данных пакета
    private String time;

    public SGetSystemTimePacket(){}

    public SGetSystemTimePacket(String time){
        this.time = time;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        time = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, time);
    }

    public static class Handler implements IMessageHandler<SGetSystemTimePacket, IMessage> {
        @Override
        public IMessage onMessage(SGetSystemTimePacket packet, MessageContext ctx) {
            String time = packet.time;

            LlavaMethods.systemTimeCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(time);
            LlavaMethods.systemTimeCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}