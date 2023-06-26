package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientSetPerspectivePacket implements IMessage {

    // Набор полей данных пакета
    private int number;

    public ClientSetPerspectivePacket(){}

    /**
     * @param number Число, которое будет выводиться на серверной стороне.
     */
    public ClientSetPerspectivePacket(int number) {
        this.number = number;
    }

    /**
     * Читает данные пакета из ByteBuf при получении.
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        number = buf.readInt();
    }

    /**
     * Записывает данные пакета в ByteBuf перед отправкой.
     */
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(number);
    }

    public static class Handler implements IMessageHandler<ClientSetPerspectivePacket, IMessage> {

        //Данный метод вызывается для обработки входящих данных из пакета.

        @Override
        public IMessage onMessage(ClientSetPerspectivePacket packet, MessageContext ctx) {
            if(ctx.side.isClient()) {
                ClientMethods.setPerspectiveToClient(packet.number);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}