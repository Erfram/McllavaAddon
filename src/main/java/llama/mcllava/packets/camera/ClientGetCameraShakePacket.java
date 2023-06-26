package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
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
            float[] array = ClientMethods.getCameraShakeToClient();

            return new ServerGetCameraShakePacket(array);
        }
    }
}
