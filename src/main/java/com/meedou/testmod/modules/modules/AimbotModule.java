package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AimbotModule extends Module {
    public AimbotModule(){
        super("Aimbot", "B",Category.COMBAT);
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
            if(playerUtil.findNearestPlayer() != null){
                Entity e = playerUtil.findNearestPlayer();
                double deltaX = e.posX - mc.player.posX;
                double deltaY = e.posY - mc.player.posY;
                double deltaZ = e.posZ - mc.player.posZ;
                double dist = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
                mc.player.rotationPitch = (float) -(Math.atan2(deltaY, dist) * 180.0D / Math.PI);
                mc.player.rotationYaw = (float) (Math.atan2(deltaZ, deltaX) * 180.0D / Math.PI) - 90.0F;
            }
        }
    }
}