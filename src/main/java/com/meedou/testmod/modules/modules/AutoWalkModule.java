package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoWalkModule extends Module {
    public AutoWalkModule(){
        super("Auto Walk", "P", Category.MOVEMENT);
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), true);
        }
    }
    @Override
    public void onDisable(){
        super.onDisable();
        KeyBinding.setKeyBindState(mc.gameSettings.keyBindForward.getKeyCode(), false);
    }
    @Override
    public void onEnable(){
        super.onEnable();
    }
}
