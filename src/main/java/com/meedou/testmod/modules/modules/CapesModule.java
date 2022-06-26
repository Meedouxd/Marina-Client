package com.meedou.testmod.modules.modules;

import com.meedou.testmod.event.events.RenderCapeEvent;
import com.meedou.testmod.modules.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapesModule extends Module {
    public CapesModule(){
        super("Capes", "Z",Category.MISC);
    }
    @SubscribeEvent
    public void onRenderCape(RenderCapeEvent event){
    }
}