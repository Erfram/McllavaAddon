package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientEnableRenderArmPacket implements IMessage{
    private boolean flag;
    public ClientEnableRenderArmPacket(){}

    public ClientEnableRenderArmPacket(boolean flag) {
        this.flag = flag;
    }

    /**
     * Читает данные пакета из ByteBuf при получении.
     */
    @Override
    public void fromBytes(ByteBuf buf) {
        flag = buf.readBoolean();
    }

    /**
    * Записывает данные пакета в ByteBuf перед отправкой.
    */
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(flag);
    }

    public static class Handler implements IMessageHandler<ClientEnableRenderArmPacket, IMessage> {

        //Данный метод вызывается для обработки входящих данных из пакета.
        @Override
        public IMessage onMessage(ClientEnableRenderArmPacket packet, MessageContext ctx) {
            boolean flag = packet.flag;

            if(ctx.side.isClient()) {
                ClientMethods.enableRenderArmToClient(flag);
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}
