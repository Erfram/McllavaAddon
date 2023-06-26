package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.CameraRotationsScriptVector;
import llama.mcllava.CameraShakeScriptVector;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerGetCameraRotationsPacket implements IMessage{
    private float[] values;

    public ServerGetCameraRotationsPacket(){
        values = new float[6];
    }

    public ServerGetCameraRotationsPacket(float[] values){
        this.values = values;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        values[0] = buf.readFloat();
        values[1] = buf.readFloat();
        values[2] = buf.readFloat();
        values[3] = buf.readFloat();
        values[4] = buf.readFloat();
        values[5] = buf.readFloat();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeFloat(values[0]);
        buf.writeFloat(values[1]);
        buf.writeFloat(values[2]);
        buf.writeFloat(values[3]);
        buf.writeFloat(values[4]);
        buf.writeFloat(values[5]);
    }

    public static class Handler implements IMessageHandler<ServerGetCameraRotationsPacket, IMessage> {
        @Override
        public IMessage onMessage(ServerGetCameraRotationsPacket packet, MessageContext ctx) {
            float x = packet.values[0];
            float y = packet.values[1];
            float z = packet.values[2];
            float angle = packet.values[3];
            float rotation = packet.values[4];
            float scale = packet.values[5];

            CameraRotationsScriptVector camera = new CameraRotationsScriptVector(x, y, z, angle, rotation, scale);

            LlavaMethods.cameraRotationsScripVectorCallBacks.get(ctx.getServerHandler().player.getUniqueID()).accept(camera);
            LlavaMethods.cameraRotationsScripVectorCallBacks.remove(ctx.getServerHandler().player.getUniqueID());

            return null;
        }
    }
}
