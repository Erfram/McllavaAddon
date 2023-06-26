package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import llama.mcllava.packets.server.ServerGetSettingPacket;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientGetSettingPacket implements IMessage {

    // Набор полей данных пакета
    private String option;

    public ClientGetSettingPacket(){}

    public ClientGetSettingPacket(String options){
        this.option = options;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        option = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, option);
    }

    public static class Handler implements IMessageHandler<ClientGetSettingPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientGetSettingPacket packet, MessageContext ctx) {
            String option = ClientMethods.getSettingToClient(packet.option);

            return new ServerGetSettingPacket(option); // В ответ ничего не отправляем
        }
    }
}