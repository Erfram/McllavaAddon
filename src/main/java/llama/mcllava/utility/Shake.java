package llama.mcllava.utility;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Shake {
    public static boolean isActive = false;
    public static float x = 0;
    public static float y = 0;
    public static float z = 1;
    public static float angle = 0.5F;
    public static float rotation = 5;
    public static float scale = 0; // Если приблизить - | Если отдалить то +
    public static float minus = 0.1F;
    public static float plus = 0.1F;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void render(EntityViewRenderEvent.CameraSetup e) {
        if(isActive){
            tickRender();

            float ticks = animationProgress;
            float s = 1 - (scale * ticks) / 10;

            GlStateManager.rotate((ticks - angle) * rotation, x, y, z);
            GlStateManager.scale(1, 1, s);
        }
    }

    public static boolean isReversed = false;
    public static float animationProgress = 0F;

    public static void tickRender(){
        if (isReversed) {
            animationProgress = Math.max(animationProgress - minus, 0);

            if(animationProgress == 0){
                isReversed = false;
            }
        } else {
            animationProgress = Math.min(animationProgress + plus, 1);

            if(animationProgress == 1){
                isReversed = true;
            }
        }
    }

    public static ShakeBuilder builder(){
        return new ShakeBuilder();
    }
}