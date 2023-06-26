package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetEnableSettingCameraPacket implements IMessage {

    // Набор полей данных пакета
    private String option;

    public ClientGetEnableSettingCameraPacket(){}


    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<ClientGetEnableSettingCameraPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetEnableSettingCameraPacket packet, MessageContext ctx) {
            boolean isActive = ClientMethods.getEnableSettingCameraToClient();

            return new ServerGetEnableSettingCameraPacket(isActive); // В ответ ничего не отправляем
        }
    }
}
