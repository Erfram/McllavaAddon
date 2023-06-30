package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CSetMousePositionPacket implements IMessage {

    // Набор полей данных пакета
    private int x;
    private int y;

    public CSetMousePositionPacket(){}

    public CSetMousePositionPacket(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readInt();
        y = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
    }

    public static class Handler implements IMessageHandler<CSetMousePositionPacket, IMessage> {
        @Override
        public IMessage onMessage(CSetMousePositionPacket packet, MessageContext ctx) {
            int x = packet.x;
            int y = packet.y;

            // Отправляем сообщение игроку
            if(ctx.side.isClient()) {
                ClientMethods.setMousePositionToClient(x, y);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}