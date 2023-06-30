package llama.mcllava.packets.client;

import io.netty.buffer.ByteBuf;
import llama.mcllava.ClientMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CSetCanceledRenderMHud implements IMessage{

    private boolean flag;

    public CSetCanceledRenderMHud(){}

    public CSetCanceledRenderMHud(boolean flag) {
        this.flag = flag;
    }

        @Override
        public void fromBytes(ByteBuf buf) {
            flag = buf.readBoolean();
        }

        @Override
        public void toBytes(ByteBuf buf) {
            buf.writeBoolean(flag);
        }
        public static class Handler implements IMessageHandler<CSetCanceledRenderMHud, IMessage> {
            @Override
            public IMessage onMessage(CSetCanceledRenderMHud packet, MessageContext ctx) {
                boolean flag = packet.flag;

                if(ctx.side.isClient()) {
                    ClientMethods.setCanceledRenderMHudToClient(flag);
                }else{}
                return null; // В ответ ничего не отправляем
            }
        }
}
