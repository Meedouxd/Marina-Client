package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AnchorModule extends Module {
    public AnchorModule(){
        super("Anchor", "L",Category.COMBAT);
    }
    @Override
    public void onEnable(){
        super.onEnable();
    }
    @Override
    public void onDisable(){
        super.onDisable();
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            for(int i = 0; i < 5; i++){
                if(playerUtil.isEntitySurrounded(mc.player, i)){
                    mc.player.motionX = 0;
                    mc.player.motionZ = 0;
                }
            }
        }
    }
}
