package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerGetPerspectivePacket implements IMessage {

    // Набор полей данных пакета
    private int number;

    public ServerGetPerspectivePacket(){}

    public ServerGetPerspectivePacket(int number){
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

    public static class Handler implements IMessageHandler<ServerGetPerspectivePacket, IMessage> {
        @Override
        public IMessage onMessage(ServerGetPerspectivePacket packet, MessageContext ctx) {
            int number = packet.number;

            LlavaMethods.perspectiveCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(number);
            LlavaMethods.perspectiveCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}