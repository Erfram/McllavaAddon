package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.utility.Shake;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientEnableSettingCameraPacket implements IMessage {

    // Набор полей данных пакета
    private boolean flag;

    public ClientEnableSettingCameraPacket(){}

    public ClientEnableSettingCameraPacket(boolean flag) {
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

    public static class Handler implements IMessageHandler<ClientEnableSettingCameraPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientEnableSettingCameraPacket packet, MessageContext ctx) {
            if(ctx.side.isClient()) {
                Shake.isActive = packet.flag;
            }else{}
            return null; // В ответ ничего не отправляем
        }
    }
}