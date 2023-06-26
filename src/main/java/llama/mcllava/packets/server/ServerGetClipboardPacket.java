package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerGetClipboardPacket implements IMessage {

    // Набор полей данных пакета
    private String message;

    public ServerGetClipboardPacket(){}

    public ServerGetClipboardPacket(String message){
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

    public static class Handler implements IMessageHandler<ServerGetClipboardPacket, IMessage> {
        @Override
        public IMessage onMessage(ServerGetClipboardPacket packet, MessageContext ctx) {
            String message = packet.message;

            LlavaMethods.clipboardCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(message);
            LlavaMethods.clipboardCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}