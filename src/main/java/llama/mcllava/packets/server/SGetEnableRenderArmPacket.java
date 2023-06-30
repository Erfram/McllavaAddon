package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SGetEnableRenderArmPacket implements IMessage{
    private boolean flag;

    public SGetEnableRenderArmPacket(){}

    public SGetEnableRenderArmPacket(boolean flag){
        this.flag = flag;
    }
    @Override public void fromBytes(ByteBuf buf) {
        flag = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeBoolean(flag);
    }

    public static class Handler implements IMessageHandler<SGetEnableRenderArmPacket, IMessage> {
        @Override
        public IMessage onMessage(SGetEnableRenderArmPacket packet, MessageContext ctx) {
            boolean flag = packet.flag;

            LlavaMethods.getEnableRenderArmCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(flag);
            LlavaMethods.getEnableRenderArmCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}
