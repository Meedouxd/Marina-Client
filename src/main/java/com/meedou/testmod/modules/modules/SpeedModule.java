package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SpeedModule extends Module {
    boolean enabled = false;
    public SpeedModule(){
        super("Speed" , "V", Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            if(Math.abs(mc.player.motionX) > 0 || Math.abs(mc.player.motionZ) > 0){
                mc.player.setSprinting(true);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), true);
            }else{
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
            }
        }
    }
    public void onDisable(){
        super.onDisable();
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindJump.getKeyCode(), false);
    }
}
