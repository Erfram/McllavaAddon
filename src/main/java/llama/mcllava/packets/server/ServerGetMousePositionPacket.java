package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerGetMousePositionPacket implements IMessage {

    // Набор полей данных пакета
    private double[] coordinates;
    public ServerGetMousePositionPacket(){
        coordinates = new double[2];
    }

    public ServerGetMousePositionPacket(double[] coordinates){
        this.coordinates = coordinates;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        coordinates[0] = buf.readDouble();
        coordinates[1] = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(coordinates[0]);
        buf.writeDouble(coordinates[1]);
    }

    public static class Handler implements IMessageHandler<ServerGetMousePositionPacket, IMessage> {
        @Override
        public IMessage onMessage(ServerGetMousePositionPacket packet, MessageContext ctx) {
            double[] coordinates = packet.coordinates;

            LlavaMethods.mousePositionCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(coordinates);
            LlavaMethods.mousePositionCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}