package com.meedou.testmod.modules.modules;

import com.meedou.testmod.TestMod;
import com.meedou.testmod.modules.Module;
import com.meedou.testmod.modules.ModuleManager;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
public class AutoPvPModule extends Module {
    private KillAuraModule killAura;
    private AimbotModule aimbot;
    private AutoWalkModule autowalk;
    private SpeedModule speed;
    int oldCount = 0;
    public AutoPvPModule(){
        super("AutoPvP", "N", Category.COMBAT);
    }
    @Override
    public void onEnable(){
        super.onEnable();
        //There is better way to do this I just forgot honestly. fix in future i guess...
        if(killAura == null){
            killAura = (KillAuraModule) TestMod.moduleManager.getMod(KillAuraModule.class);
        }
        if(aimbot == null){
            aimbot = (AimbotModule) TestMod.moduleManager.getMod(AimbotModule.class);
        }
        if(autowalk == null){
            autowalk = (AutoWalkModule) TestMod.moduleManager.getMod(AutoWalkModule.class);
        }
        if(speed == null){
            speed = (SpeedModule) TestMod.moduleManager.getMod(SpeedModule.class);
        }
        autowalk.enable();
        aimbot.enable();
        speed.enable();
    }
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        if(mc.player != null){
            if(mc.player.getHealth() <=  4.5){
                if(playerUtil.findItemInHotBar(Items.GOLDEN_APPLE) != -1 )mc.player.inventory.currentItem = playerUtil.findItemInHotBar(Items.GOLDEN_APPLE);
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
            }
            else if(mc.player.getHealth() >= 5.0){
                KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), false);
                if(playerUtil.findItemInHotBar(Items.DIAMOND_SWORD) != -1 )mc.player.inventory.currentItem = playerUtil.findItemInHotBar(Items.DIAMOND_SWORD);
            }
            if(playerUtil.findNearestPlayer() != null) {
                Entity target = playerUtil.findNearestPlayer();
                if(playerUtil.isEntityTrapped(mc.player) && !playerUtil.isOnSameBlock(mc.player, target)){
                    if(playerUtil.findItemInHotBar(Items.CHORUS_FRUIT) != -1){
                        mc.player.inventory.currentItem = playerUtil.findItemInHotBar(Items.CHORUS_FRUIT);
                        KeyBinding.setKeyBindState(mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                    }

                }
                if(playerUtil.isOnSameBlock(mc.player, target)){
                    killAura.enable();
                    autowalk.disable();
                    aimbot.disable();
                    speed.disable();
                }else{
                    autowalk.enable();
                    aimbot.enable();
                    speed.enable();
                }
            }
        }
    }
    @Override
    public void onDisable(){
        super.onDisable();
        aimbot.disable();
        autowalk.disable();
        speed.disable();
        killAura.disable();
    }
}
