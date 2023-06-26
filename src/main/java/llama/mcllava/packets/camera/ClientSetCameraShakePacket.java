package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.utility.Shake;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientSetCameraShakePacket implements IMessage {

    // Набор полей данных пакета
    private float x;
    private float y;
    private float z;
    private float angle;
    private float rotation;
    private float scale;
    private float minus;
    private float plus;

    public ClientSetCameraShakePacket(){}
    public ClientSetCameraShakePacket(float x, float y, float z, float angle, float rotation, float scale, float minus, float plus){
        this.x = x;
        this.y = y;
        this.z = z;
        this.angle = angle;
        this.rotation = rotation;
        this.scale = scale;
        this.minus = minus;
        this.plus = plus;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readFloat();
        this.y = buf.readFloat();
        this.z = buf.readFloat();
        this.angle = buf.readFloat();
        this.rotation = buf.readFloat();
        this.scale = buf.readFloat();
        this.minus = buf.readFloat();
        this.plus = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(x);
        buf.writeFloat(y);
        buf.writeFloat(z);
        buf.writeFloat(angle);
        buf.writeFloat(rotation);
        buf.writeFloat(scale);
        buf.writeFloat(minus);
        buf.writeFloat(plus);
    }

    public static class Handler implements IMessageHandler<ClientSetCameraShakePacket, IMessage> {
        @Override
        public IMessage onMessage(ClientSetCameraShakePacket packet, MessageContext ctx) {
            Shake.x = packet.x;
            Shake.y = packet.y;
            Shake.z = packet.z;
            Shake.rotation = packet.rotation;
            Shake.scale = packet.scale;
            Shake.minus = packet.minus;
            Shake.plus = packet.plus;

            return null;
        }
    }
}
