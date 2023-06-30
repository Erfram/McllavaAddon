package llama.mcllava;

import llama.mcllava.packets.camera.*;
import llama.mcllava.packets.client.*;
import llama.mcllava.packets.server.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        Mcllava.NETWORK.registerMessage(new CSetPerspectivePacket.Handler(), CSetPerspectivePacket.class, 0, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new CSetMousePositionPacket.Handler(), CSetMousePositionPacket.class, 1, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new CSetClipboardPacket.Handler(), CSetClipboardPacket.class, 2, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new CSetSettingPacket.Handler(), CSetSettingPacket.class, 3, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new COpenLinkPacket.Handler(), COpenLinkPacket.class, 4, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetCameraShakePacket.Handler(), ClientSetCameraShakePacket.class, 5, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientEnableSettingCameraPacket.Handler(), ClientEnableSettingCameraPacket.class, 6, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSetCameraRotationsPacket.Handler(), ClientSetCameraRotationsPacket.class, 7, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ClientSendShakeInfoPacket.Handler(), ClientSendShakeInfoPacket.class, 8, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new CEnableRenderArmPacket.Handler(), CEnableRenderArmPacket.class, 9, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new CSetCanceledRenderMHud.Handler(), CSetCanceledRenderMHud.class, 10, Side.CLIENT);

        Mcllava.NETWORK.registerMessage(new CGetClipboardPacket.Handler(), CGetClipboardPacket.class, 11, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetClipboardPacket.Handler(), SGetClipboardPacket.class, 12, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new CGetPerspectivePacket.Handler(), CGetPerspectivePacket.class, 13, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetPerspectivePacket.Handler(), SGetPerspectivePacket.class, 14, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new CGetMousePositionPacket.Handler(), CGetMousePositionPacket.class, 15, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetMousePositionPacket.Handler(), SGetMousePositionPacket.class, 16, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new CGetSettingPacket.Handler(), CGetSettingPacket.class, 17, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetSettingPacket.Handler(), SGetSettingPacket.class, 18, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new CGetSystemTimePacket.Handler(), CGetSystemTimePacket.class, 19, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetSystemTimePacket.Handler(), SGetSystemTimePacket.class, 20, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetEnableSettingCameraPacket.Handler(), ClientGetEnableSettingCameraPacket.class, 21, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetEnableSettingCameraPacket.Handler(), ServerGetEnableSettingCameraPacket.class, 22, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetCameraShakePacket.Handler(), ClientGetCameraShakePacket.class, 23, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetCameraShakePacket.Handler(), ServerGetCameraShakePacket.class, 24, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new ClientGetCameraRotationsPacket.Handler(), ClientGetCameraRotationsPacket.class, 25, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new ServerGetCameraRotationsPacket.Handler(), ServerGetCameraRotationsPacket.class, 26, Side.SERVER);

        Mcllava.NETWORK.registerMessage(new CGetEnableRenderArmPacket.Handler(), CGetEnableRenderArmPacket.class, 27, Side.CLIENT);
        Mcllava.NETWORK.registerMessage(new SGetEnableRenderArmPacket.Handler(), SGetEnableRenderArmPacket.class, 28, Side.SERVER);
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}