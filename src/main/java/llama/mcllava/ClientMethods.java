package llama.mcllava;

import llama.mcllava.utility.Shake;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@SideOnly(Side.CLIENT)
public class ClientMethods {
    public static void openLinkToClient(String URL) {
        GuiScreen gui = Minecraft.getMinecraft().currentScreen;

        Minecraft.getMinecraft().displayGuiScreen(new GuiConfirmOpenLink(gui, URL, 31102009, false));
    }

    public static void setClipboardToClient(String message) {
        GuiScreen.setClipboardString(message);
    }

    public static String getClipboardToClient() {
        return GuiScreen.getClipboardString();
    }

    public static void setMousePositionToClient(int x, int y) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(x, y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static double[] getMousePositionToClient() {
        double x = MouseInfo.getPointerInfo().getLocation().getX();
        double y = MouseInfo.getPointerInfo().getLocation().getY();

        double[] coordinates = new double[]{x, y};

        return coordinates;
    }

    public static String getSystemTimeToClient(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void setPerspectiveToClient(int number) {
        Minecraft mc = Minecraft.getMinecraft();

        mc.gameSettings.thirdPersonView = number;
    }

    public static int getPerspectiveToClient() {
        return Minecraft.getMinecraft().gameSettings.thirdPersonView;
    }

    public static void setSettingToClient(String key, Object value){
        try{
            String[] keys = {"keyBindAdvancements", "keyBindAttack", "keyBindBack", "keyBindChat", "keyBindCommand", "keyBindDrop", "keyBindForward", "keyBindFullscreen", "keyBindInventory", "keyBindJump", "keyBindLeft", "keyBindLoadToolbar", "keyBindPickBlock", "keyBindPlayerList", "keyBindRight", "keyBindSaveToolbar", "keyBindScreenshot", "keyBindsHotbar", "keyBindSmoothCamera", "keyBindSneak", "keyBindSpectatorOutlines", "keyBindSprint", "keyBindSwapHands", "keyBindTogglePerspective", "keyBindUseItem", "thirdPersonView", "advancedItemTooltips", "ambientOcclusion", "anaglyph", "attackIndicator", "autoJump", "chatColours", "chatHeightUnfocused", "chatLinks", "chatLinksPromp", "chatOpacity", "chatScale", "chatVisibility", "chatWidth", "clouds", "debugCamEnable", "difficulty", "enableVsync", "enableWeakAttacks", "entityShadows", "fancyGraphics", "fboEnable", "forceUnicodeFont", "fovSetting", "fullScreen", "gammaSetting", "guiScale", "heldItemTooltips", "hideGUI", "hideServerAddress", "incompatibleResourcePacks", "invertMouse", "language", "lastServer", "limitFramerate", "mainHand", "mipmapLevels", "mouseSensitivity", "narrator", "overrideHeight", "overrideWidth", "particleSetting", "pauseOnLostFocus", "realmsNotifications", "reducedDebugInfo", "renderDistanceChunks", "resourcePacks", "saturation", "showDebugInfo", "showDebugProfilerChart", "showLagometer", "showSubtitles", "smoothCamera", "snooperEnabled", "touchscreen", "tutorialStep", "useNativeTransport", "useVbo", "viewBobbing"};
            String[] fields = {"field_194146_ao", "field_74312_F", "field_74368_y", "field_74310_D", "field_74323_J", "field_74316_C", "field_74351_w", "field_152395_am", "field_151445_Q", "field_74314_A", "field_74370_x", "field_193630_aq", "field_74322_I", "field_74321_H", "field_74366_z", "field_193629_ap", "field_151447_Z", "field_151456_ac", "field_151458_ab", "field_74311_E", "field_178883_an", "field_151444_V", "field_186718_X", "field_151457_aa", "field_74313_G", "field_74320_O", "field_82882_x", "field_74348_k", "field_74337_g", "field_186716_M", "field_189989_R", "field_74344_o", "field_96693_G", "field_74359_p", "field_74358_q", "field_74357_r", "field_96691_E", "field_74343_n", "field_96692_F", "field_74345_l", "field_74325_U", "field_74318_M", "field_74352_v", "field_189422_N", "field_181151_V", "field_74347_j", "field_151448_g", "field_151455_aw", "field_74334_X", "field_74353_u", "field_74333_Y", "field_74335_Z", "field_92117_D", "field_74319_N", "field_80005_w", "field_183018_l", "field_74338_d", "field_74363_ab", "field_74332_R", "field_74350_i", "field_186715_A", "field_151442_I", "field_74341_c", "field_192571_R", "field_92119_C", "field_92118_B", "field_74362_aa", "field_82881_y", "field_183509_X", "field_178879_v", "field_151451_c", "field_151453_l", "field_151452_as", "field_74330_P", "field_74329_Q", "field_181657_aC", "field_186717_N", "field_74326_T", "field_74355_t", "field_85185_A", "field_193631_S", "field_181150_U", "field_178881_t", "field_74336_f"};

            for(int i = 0; i < fields.length; i++){
                if(key == keys[i]){
                    key = fields[i];
                }
            }
            Field field = Minecraft.getMinecraft().gameSettings.getClass().getDeclaredField(key);
            field.set(Minecraft.getMinecraft().gameSettings, value);
        }catch(java.lang.NoSuchFieldException | java.lang.IllegalAccessException e){
            e.printStackTrace();
        }
    }

    public static String getSettingToClient(String key){
        try {
            return Minecraft.getMinecraft().gameSettings.getKeyBinding(GameSettings.Options.valueOf(key.toUpperCase()));
            // by Dyamo умный малчик
        }catch(Exception e) {
            return "";
        }
    }

    public static boolean getEnableSettingCameraToClient(){
        return Shake.isActive;
    }

    public static float[] getCameraShakeToClient(){
        float x = Shake.x;
        float y = Shake.y;
        float z = Shake.z;
        float angle = Shake.angle;
        float rotation = Shake.rotation;
        float scale = Shake.scale;
        float minus = Shake.minus;
        float plus = Shake.plus;

        float[] values = {x, y, z, angle, rotation, scale, minus, plus};
        return values;
    }

    public static void setCameraShakeToCliet(float x, float y, float z, float angle, float rotation, float scale, float minus, float plus){
        Shake.x = x;
        Shake.y = y;
        Shake.z = z;
        Shake.angle = angle;
        Shake.rotation = rotation;
        Shake.scale = scale;
        Shake.minus = minus;
        Shake.plus = plus;
    }

//    public static Object parse(final Object text, final Object reviver) {
//        final String str = JSType.toString(text);
//        final Global global = Context.getGlobal();
//        final boolean dualFields = ((ScriptObject) global).useDualFields();
//        final JSONParser parser = new JSONParser(str, global, dualFields);
//        final Object value;
//
//        value = parser.parse();
//
//        try{
//            Method applyR = JSONFunctions.class.getDeclaredMethod("applyReviver", Global.class, Object.class, Object.class);
//            applyR.setAccessible(true);
//
//            return applyR(global, value, reviver);
//        }catch(NoSuchMethodException e){
//            e.printStackTrace();
//        }
//    }
}