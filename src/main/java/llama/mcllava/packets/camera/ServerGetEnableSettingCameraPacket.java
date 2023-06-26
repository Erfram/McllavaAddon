package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.LlavaMethods;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerGetEnableSettingCameraPacket implements IMessage{
    private boolean flag;
    public ServerGetEnableSettingCameraPacket(){
    }

    public ServerGetEnableSettingCameraPacket(boolean flag){
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

    public static class Handler implements IMessageHandler<ServerGetEnableSettingCameraPacket, IMessage> {
        @Override
        public IMessage onMessage(ServerGetEnableSettingCameraPacket packet, MessageContext ctx) {
            boolean flag = packet.flag;

            LlavaMethods.getSettingCameraCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(flag);
            LlavaMethods.getSettingCameraCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}
