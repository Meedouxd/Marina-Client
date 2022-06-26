package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KillAuraModule extends Module {
    boolean enabled = false;
    int count = 0;
    public KillAuraModule(){
        super("Kill Aura", "R", Category.COMBAT);
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            if(playerUtil.findNearestPlayer() != null && mc.player.getDistanceSq(playerUtil.findNearestPlayer()) < 26.0f){
                if(count >= 40){
                    mc.playerController.attackEntity(mc.player, playerUtil.findNearestPlayer());
                    mc.player.swingArm(EnumHand.MAIN_HAND);
                    count = 0;
                }else{
                    count++;
                }
            }
        }
    }
    @Override
    public void onEnable(){
        super.onEnable();
    }
    @Override
    public void onDisable(){
        super.onDisable();
    }
}
