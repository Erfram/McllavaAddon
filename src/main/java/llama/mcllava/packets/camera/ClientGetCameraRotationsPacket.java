package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetCameraRotationsPacket implements IMessage {
    public ClientGetCameraRotationsPacket(){}

    @Override
    public void fromBytes(ByteBuf buf) {}

    @Override
    public void toBytes(ByteBuf buf) {}

    public static class Handler implements IMessageHandler<ClientGetCameraRotationsPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetCameraRotationsPacket packet, MessageContext ctx) {
            float[] array = ClientMethods.getCameraRotationsToClient();

            return new ServerGetCameraRotationsPacket(array);
        }
    }
}
