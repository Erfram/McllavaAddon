package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientSetSettingPacket implements IMessage {

    // Набор полей данных пакета
    private String key;
    private Object value;

    public ClientSetSettingPacket(){}

    public ClientSetSettingPacket(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        key = ByteBufUtils.readUTF8String(buf);
        value = mchorse.mclib.utils.ByteBufUtils.readObject(buf);
    };

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, key);
        mchorse.mclib.utils.ByteBufUtils.writeObject(buf, value);
    }

    public static class Handler implements IMessageHandler<ClientSetSettingPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientSetSettingPacket packet, MessageContext ctx) {
            String key = packet.key;
            Object value = packet.value;

            // Отправляем сообщение игроку
            if(ctx.side.isClient()) {
                ClientMethods.setSettingToClient(key, value);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}