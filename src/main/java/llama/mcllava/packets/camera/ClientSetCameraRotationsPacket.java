package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientSetCameraRotationsPacket implements IMessage {

    // Набор полей данных пакета
    private float x;
    private float y;
    private float z;
    private float angle;
    private float rotation;
    private float scale;

    public ClientSetCameraRotationsPacket(){}
    public ClientSetCameraRotationsPacket(float x, float y, float z, float angle, float rotation, float scale){
        this.x = x;
        this.y = y;
        this.z = z;
        this.angle = angle;
        this.rotation = rotation;
        this.scale = scale;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readFloat();
        this.y = buf.readFloat();
        this.z = buf.readFloat();
        this.angle = buf.readFloat();
        this.rotation = buf.readFloat();
        this.scale = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);
        buf.writeFloat(angle);
        buf.writeFloat(rotation);
        buf.writeFloat(scale);
    }

    public static class Handler implements IMessageHandler<ClientSetCameraRotationsPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientSetCameraRotationsPacket packet, MessageContext ctx) {
            if(ctx.side.isClient()) {
                ClientMethods.setCameraRotationsToClient(packet.x, packet.y, packet.z, packet.angle, packet.rotation, packet.scale);
            }else{}

            return null;
        }
    }
}
