package llama.mcllava;

import llama.mcllava.packets.camera.*;
import llama.mcllava.packets.client.*;
import llama.mcllava.packets.server.*;
import mchorse.mappet.api.scripts.code.entities.ScriptPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        Mcllava.NETWORK.registerMessage(new ClientSetPerspectivePacket.Handler(), ClientSetPerspectivePacket.class, 0, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetMousePositionPacket.Handler(), ClientSetMousePositionPacket.class, 1, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetClipboardPacket.Handler(), ClientSetClipboardPacket.class, 2, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetSettingPacket.Handler(), ClientSetSettingPacket.class, 3, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientOpenLinkPacket.Handler(), ClientOpenLinkPacket.class, 4, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetCameraShakePacket.Handler(), ClientSetCameraShakePacket.class, 5, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientEnableSettingCameraPacket.Handler(), ClientEnableSettingCameraPacket.class, 6, Side.CLIENT);

        Mcllava.NETWORK.registerMessage(new ClientGetClipboardPacket.Handler(), ClientGetClipboardPacket.class, 7, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetClipboardPacket.Handler(), ServerGetClipboardPacket.class, 8, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetPerspectivePacket.Handler(), ClientGetPerspectivePacket.class, 9, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetPerspectivePacket.Handler(), ServerGetPerspectivePacket.class, 10, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetMousePositionPacket.Handler(), ClientGetMousePositionPacket.class, 11, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetMousePositionPacket.Handler(), ServerGetMousePositionPacket.class, 12, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetSettingPacket.Handler(), ClientGetSettingPacket.class, 13, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetSettingPacket.Handler(), ServerGetSettingPacket.class, 14, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetSystemTimePacket.Handler(), ClientGetSystemTimePacket.class, 15, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetSystemTimePacket.Handler(), ServerGetSystemTimePacket.class, 16, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientSendShakeInfoPacket.Handler(), ClientSendShakeInfoPacket.class, 17, Side.CLIENT);

        Mcllava.NETWORK.registerMessage(new ClientGetEnableSettingCameraPacket.Handler(), ClientGetEnableSettingCameraPacket.class, 18, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetEnableSettingCameraPacket.Handler(), ServerGetEnableSettingCameraPacket.class, 19, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetCameraShakePacket.Handler(), ClientGetCameraShakePacket.class, 20, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetCameraShakePacket.Handler(), ServerGetCameraShakePacket.class, 21, Side.SERVER);
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public static EntityPlayerMP getPlayer(Object clazz){
        ScriptPlayer instance = ((ScriptPlayer) clazz);

        return instance.getMinecraftPlayer();
    }
        public static CriticalHitEvent getCriticalEvent(Object clazz){
        CriticalHitEvent instance = ((CriticalHitEvent) clazz);

        return instance;
    }
}