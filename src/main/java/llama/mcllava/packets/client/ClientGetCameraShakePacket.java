package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetCameraShakePacket;
import llama.mcllava.packets.server.ServerGetClipboardPacket;
import llama.mcllava.packets.server.ServerGetSettingPacket;
import llama.mcllava.utility.Shake;
import mchorse.mappet.api.scripts.user.data.ScriptVector;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetCameraShakePacket implements IMessage {
    public ClientGetCameraShakePacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {}

    @Override
    public void toBytes(ByteBuf buf) {}

    public static class Handler implements IMessageHandler<ClientGetCameraShakePacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetCameraShakePacket packet, MessageContext ctx) {
            float x = Shake.x;
            float y = Shake.y;
            float z = Shake.z;
            float angle = Shake.angle;
            float rotation = Shake.rotation;
            float scale = Shake.scale;
            float minus = Shake.minus;
            float plus = Shake.plus;

            float[] values = {x, y, z, angle, rotation, scale, minus, plus};

            return new ServerGetCameraShakePacket(values);
        }
    }
}
