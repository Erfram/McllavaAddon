package llama.mcllava;


import llama.mcllava.packets.camera.*;
import llama.mcllava.packets.client.*;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import static llama.mcllava.KeyBindings.keybindingCallBacks;

public class LlavaMethods {
    public static final Map<UUID, Consumer<String>> clipboardCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<Number>> perspectiveCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<double[]>> mousePositionCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<String>> systemTimeCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<Boolean>> getSettingCameraCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<CameraShakeScriptVector>> cameraShakeScriptVectorCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<CameraRotationsScriptVector>> cameraRotationsScripVectorCallBacks = new HashMap<>();
    public static final Map<UUID, Consumer<Boolean>> getEnableRenderArmCallBacks = new HashMap<>();

    public static void getSystemTime(EntityPlayerMP player, Consumer<String> callBack){
        systemTimeCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new CGetSystemTimePacket(), player);
    }

    public static void openLink(EntityPlayerMP player, String URL) {
        Mcllava.NETWORK.sendTo(new COpenLinkPacket(URL), player);
    }

    public static void setPerspective(EntityPlayerMP player, int number) {
        Mcllava.NETWORK.sendTo(new CSetPerspectivePacket(number), player);
    }

    public static void getPerspective(EntityPlayerMP player, Consumer<Number> callBack) {
        perspectiveCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new CGetPerspectivePacket(), player);
    }

    public static void setClipboard(EntityPlayerMP player, String message) {
        Mcllava.NETWORK.sendTo(new CSetClipboardPacket(message), player);
    }

    public static void getClipboard(EntityPlayerMP player, Consumer<String> callBack) {
        clipboardCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new CGetClipboardPacket(), player);
    }

    public static void setMousePosition(EntityPlayerMP player, int x, int y) {
        Mcllava.NETWORK.sendTo(new CSetMousePositionPacket(x, y), player);
    }

    public static void getMousePosition(EntityPlayerMP player, Consumer<double[]> callBack) {
        mousePositionCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new CGetMousePositionPacket(), player);
    }

    public static void getSetting(EntityPlayerMP player, String key, Consumer<String> callBack){
        keybindingCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new CGetSettingPacket(key), player);
    }

    public static void setSetting(EntityPlayerMP player, String key, Object value){
        Mcllava.NETWORK.sendTo(new CSetSettingPacket(key, value), player);
    }

    public static void enableSettingCamera(EntityPlayerMP player, boolean flag){
        Mcllava.NETWORK.sendTo(new ClientEnableSettingCameraPacket(flag), player);
    }

    public static void getEnableSettingCamera(EntityPlayerMP player, Consumer<Boolean> callBack){
        getSettingCameraCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetEnableSettingCameraPacket(), player);
    }

    public static void setCameraShake(EntityPlayerMP player, float x, float y, float z, float angle, float rotation, float scale, float minus, float plus){
        Mcllava.NETWORK.sendTo(new ClientSetCameraShakePacket(x, y, z, angle, rotation, scale, minus, plus), player);
    }

    public static void getCameraShake(EntityPlayerMP player, Consumer<CameraShakeScriptVector> callback){
        cameraShakeScriptVectorCallBacks.put(player.getUniqueID(), callback);

        Mcllava.NETWORK.sendTo(new ClientGetCameraShakePacket(), player);
    }

    public static void setCameraRotation(EntityPlayerMP player, float x, float y, float z, float angle, float rotation, float scale){
        Mcllava.NETWORK.sendTo(new ClientSetCameraRotationsPacket(x, y, z, angle, rotation, scale), player);
    }

    public static void getCameraRotations(EntityPlayerMP player, Consumer<CameraRotationsScriptVector> callback){
        cameraRotationsScripVectorCallBacks.put(player.getUniqueID(), callback);

        Mcllava.NETWORK.sendTo(new ClientGetCameraRotationsPacket(), player);
    }

    public static void enableRenderArm(EntityPlayerMP player, boolean flag){
        Mcllava.NETWORK.sendTo(new CEnableRenderArmPacket(flag), player);
    }

    public static void getEenableRenderArm(EntityPlayerMP player, Consumer<Boolean> callback){
        getEnableRenderArmCallBacks.put(player.getUniqueID(), callback);

        Mcllava.NETWORK.sendTo(new CGetEnableRenderArmPacket(), player);
    }

    public static void setCanceledRenderMHud(EntityPlayerMP player, boolean flag){
        Mcllava.NETWORK.sendTo(new CSetCanceledRenderMHud(), player);
    }
}
