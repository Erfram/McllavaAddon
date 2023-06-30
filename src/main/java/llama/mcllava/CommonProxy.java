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
        Mcllava.NETWORK.registerMessage(new ClientSetCameraRotationsPacket.Handler(), ClientSetCameraRotationsPacket.class, 7, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSendShakeInfoPacket.Handler(), ClientSendShakeInfoPacket.class, 8, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientEnableRenderArmPacket.Handler(), ClientEnableRenderArmPacket.class, 9, Side.CLIENT);

        Mcllava.NETWORK.registerMessage(new ClientGetClipboardPacket.Handler(), ClientGetClipboardPacket.class, 10, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetClipboardPacket.Handler(), ServerGetClipboardPacket.class, 11, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetPerspectivePacket.Handler(), ClientGetPerspectivePacket.class, 12, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetPerspectivePacket.Handler(), ServerGetPerspectivePacket.class, 13, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetMousePositionPacket.Handler(), ClientGetMousePositionPacket.class, 14, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetMousePositionPacket.Handler(), ServerGetMousePositionPacket.class, 15, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetSettingPacket.Handler(), ClientGetSettingPacket.class, 16, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetSettingPacket.Handler(), ServerGetSettingPacket.class, 17, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetSystemTimePacket.Handler(), ClientGetSystemTimePacket.class, 18, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetSystemTimePacket.Handler(), ServerGetSystemTimePacket.class, 19, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetEnableSettingCameraPacket.Handler(), ClientGetEnableSettingCameraPacket.class, 20, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetEnableSettingCameraPacket.Handler(), ServerGetEnableSettingCameraPacket.class, 21, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetCameraShakePacket.Handler(), ClientGetCameraShakePacket.class, 22, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetCameraShakePacket.Handler(), ServerGetCameraShakePacket.class, 23, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetCameraRotationsPacket.Handler(), ClientGetCameraRotationsPacket.class, 24, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetCameraRotationsPacket.Handler(), ServerGetCameraRotationsPacket.class, 25, Side.SERVER);
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}