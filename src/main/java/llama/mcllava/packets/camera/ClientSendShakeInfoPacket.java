package llama.mcllava.packets.camera;

import io.netty.buffer.ByteBuf;
import llama.mcllava.utility.Shake;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientSendShakeInfoPacket implements IMessage {

    // Набор полей данных пакета
    private NBTTagCompound tag;

    public ClientSendShakeInfoPacket(){}
    public ClientSendShakeInfoPacket(NBTTagCompound tag){
        this.tag = tag;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.tag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, tag);
    }

    public static class Handler implements IMessageHandler<ClientSendShakeInfoPacket, IMessage> {
        @Override
        public IMessage onMessage(ClientSendShakeInfoPacket packet, MessageContext ctx) {
            NBTTagCompound tag = packet.tag;

            if(tag.hasKey("active")){
                Shake.isActive = tag.getBoolean("active");
            }
            if(tag.hasKey("x")){
                Shake.x = tag.getFloat("x");
            }
            if(tag.hasKey("y")){
                Shake.y = tag.getFloat("y");
            }
            if(tag.hasKey("z")){
                Shake.z = tag.getFloat("z");
            }
            if(tag.hasKey("rotation")){
                Shake.rotation = tag.getFloat("rotation");
            }
            if(tag.hasKey("scale")){
                Shake.scale = tag.getFloat("scale");
            }
            if(tag.hasKey("minus")){
                Shake.minus = tag.getFloat("minus");
            }
            if(tag.hasKey("plus")){
                Shake.plus = tag.getFloat("plus");
            }
            if(tag.hasKey("animationProgress")){
                Shake.animationProgress = tag.getFloat("animationProgress");
            }

            return null;
        }
    }
}