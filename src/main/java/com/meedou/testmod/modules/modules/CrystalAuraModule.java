package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CrystalAuraModule extends Module {
    public CrystalAuraModule(){
        super("Crystal Aura", "C", Category.COMBAT);
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            for (Entity e : mc.world.loadedEntityList) {
                if (e instanceof EntityEnderCrystal) {
                    mc.playerController.attackEntity(mc.player, e);
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
