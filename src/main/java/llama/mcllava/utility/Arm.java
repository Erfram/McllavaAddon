package llama.mcllava.utility;

import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Arm {
    public static boolean isActive = false;

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void render(RenderHandEvent event){
        if(isActive){
            event.setCanceled(true);
        }else{
            event.setCanceled(false);
        }
    }
}
