package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SGetPerspectivePacket implements IMessage {

    // Набор полей данных пакета
    private int number;

    public SGetPerspectivePacket(){}

    public SGetPerspectivePacket(int number){
        this.number = number;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        number = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(number);
    }

    public static class Handler implements IMessageHandler<SGetPerspectivePacket, IMessage> {
        @Override
        public IMessage onMessage(SGetPerspectivePacket packet, MessageContext ctx) {
            int number = packet.number;

            LlavaMethods.perspectiveCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(number);
            LlavaMethods.perspectiveCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}