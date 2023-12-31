package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CSetClipboardPacket implements IMessage {

    // Набор полей данных пакета
    private String message;

    public CSetClipboardPacket(){}

    public CSetClipboardPacket(String message) {
        this.message = message;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        message = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, message);
    }

    public static class Handler implements IMessageHandler<CSetClipboardPacket, IMessage> {
        @Override
        public IMessage onMessage(CSetClipboardPacket packet, MessageContext ctx) {
            String message = packet.message;

            // Отправляем сообщение игроку
            if(ctx.side.isClient()) {
                ClientMethods.setClipboardToClient(message);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}