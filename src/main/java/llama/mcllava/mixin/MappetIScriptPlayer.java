package llama.mcllava.mixin;

import llama.mcllava.CommonProxy;
import llama.mcllava.ExtendedScriptVector;
import llama.mcllava.Mcllava;
import llama.mcllava.packets.camera.ClientEnableSettingCameraPacket;
import llama.mcllava.packets.camera.ClientGetCameraShakePacket;
import llama.mcllava.packets.camera.ClientGetEnableSettingCameraPacket;
import llama.mcllava.packets.camera.ClientSetCameraShakePacket;
import llama.mcllava.packets.client.*;
import mchorse.mappet.api.scripts.code.entities.ScriptPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

import static llama.mcllava.KeyBindings.keybindingCallBacks;
import static llama.mcllava.LlavaMethods.*;

@Mixin(ScriptPlayer.class)
public class MappetIScriptPlayer {
    public void getSystemTime(Consumer<String> callBack){
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        systemTimeCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetSystemTimePacket(), player);
    }

    public void openLink(String URL) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        Mcllava.NETWORK.sendTo(new ClientOpenLinkPacket(URL), player);
    }

    public void setPerspective(int number) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        Mcllava.NETWORK.sendTo(new ClientSetPerspectivePacket(number), player);
    }

    public void getPerspective(Consumer<Number> callBack) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        perspectiveCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetPerspectivePacket(), player);
    }

    public void setClipboard(String message) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        Mcllava.NETWORK.sendTo(new ClientSetClipboardPacket(message), player);
    }

    public void getClipboard(Consumer<String> callBack) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        clipboardCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetClipboardPacket(), player);
    }

    public void setMousePosition(int x, int y) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        Mcllava.NETWORK.sendTo(new ClientSetMousePositionPacket(x, y), player);
    }

    public void getMousePosition(Consumer<double[]> callBack) {
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        mousePositionCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetMousePositionPacket(), player);
    }

    public void getSetting(String key, Consumer<String> callBack){
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        keybindingCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetSettingPacket(key), player);
    }

    public void setSetting(String key, Object value){
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        Mcllava.NETWORK.sendTo(new ClientSetSettingPacket(key, value), player);
    }

    public void setCameraPosition(int x, int y, int z){

    }

    public void enableSettingCamera(boolean flag){
        EntityPlayerMP player = CommonProxy.getPlayer(this);

        Mcllava.NETWORK.sendTo(new ClientEnableSettingCameraPacket(flag), player);
    }

    public void getEnableSettingCamera(Consumer<Boolean> callBack){
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        getSettingCameraCallBacks.put(player.getUniqueID(), callBack);

        Mcllava.NETWORK.sendTo(new ClientGetEnableSettingCameraPacket(), player);
    }

    public void setCameraShake(float x, float y, float z, float angle, float rotation, float scale, float minus, float plus){
        EntityPlayerMP player = CommonProxy.getPlayer(this);

        Mcllava.NETWORK.sendTo(new ClientSetCameraShakePacket(x, y, z, angle, rotation, scale, minus, plus), player);
    }

    public void getCameraShake(Consumer<ExtendedScriptVector> callback){
        EntityPlayerMP player = CommonProxy.getPlayer(this);
        extendedScriptVectorCallBacks.put(player.getUniqueID(), callback);

        Mcllava.NETWORK.sendTo(new ClientGetCameraShakePacket(), player);
    }
}