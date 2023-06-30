package llama.mcllava.utility;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderMHud {
    public static String[] elements = {};
    public static boolean isActive = false;

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent event)
    {
        for(int i = 0; i < elements.length; i++){
            RenderGameOverlayEvent.ElementType element =  RenderGameOverlayEvent.ElementType.valueOf(elements[i].toUpperCase());

            if(event.getType() == element){
                event.setCanceled(isActive);
            }
        }
    }
}