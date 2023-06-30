package llama.mcllava.packets.server;

import io.netty.buffer.ByteBuf;
import llama.mcllava.KeyBindings;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SGetSettingPacket implements IMessage {

    // Набор полей данных пакета
    private String option;

    public SGetSettingPacket(){}

    public SGetSettingPacket(String option){
        this.option = option;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        option = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, option);
    }

    public static class Handler implements IMessageHandler<SGetSettingPacket, IMessage> {
        @Override
        public IMessage onMessage(SGetSettingPacket packet, MessageContext ctx) {
            String option = packet.option;

            KeyBindings.keybindingCallBacks.get( ctx.getServerHandler().player.getUniqueID() ).accept(option);
            KeyBindings.keybindingCallBacks.remove( ctx.getServerHandler().player.getUniqueID() );

            return null;
        }
    }
}