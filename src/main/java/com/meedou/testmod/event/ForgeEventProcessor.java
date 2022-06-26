package com.meedou.testmod.event;

import com.meedou.testmod.TestMod;
import com.meedou.testmod.modules.Module;
import com.meedou.testmod.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.awt.*;
import java.util.Collections;

public class ForgeEventProcessor {
    Minecraft mc = Minecraft.getMinecraft();
    ScaledResolution sr = new ScaledResolution(mc);
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event){
        Display.setTitle("Majora beta");
    }
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        ScaledResolution sr = new ScaledResolution(mc);
        int y = 0;
        int hexColor;
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            mc.fontRenderer.drawString("Majora beta",0,0,Color.MAGENTA.getRGB());
            for(String enabledMods : TestMod.moduleManager.EnabledMods){
                int[] rainbow = getRainbow(5, 0.1F * (y/10));
                hexColor = RGBtoHex(rainbow[0], rainbow[1], rainbow[2]);
                mc.fontRenderer.drawStringWithShadow(enabledMods, sr.getScaledWidth() - mc.fontRenderer.getStringWidth(enabledMods) -4,y,  hexColor);
                y+=10;
            }
        }
    }
    //thanks to Gate Client because lord knows I didnt want to do this.
    public static int[] getRainbow(int cycle, float offset) {
        int r = 0, g = 0, b = 0;
        long timeInCycle = (System.currentTimeMillis() - Math.round(offset * 1000)) % (cycle * 1000);
        float portionOfCycle = (float) 6 * timeInCycle / (cycle * 1000);
        float timeInPortion = portionOfCycle - (float) Math.floor(portionOfCycle);
        int timeInPortionRGB = Math.round(255 * timeInPortion);

        if (portionOfCycle < 1) {
            r = 255;
            g = timeInPortionRGB;
        } else if (portionOfCycle < 2) {
            r = 255 - timeInPortionRGB;
            g = 255;
        } else if (portionOfCycle < 3) {
            g = 255;
            b = timeInPortionRGB;
        } else if (portionOfCycle < 4) {
            g = 255 - timeInPortionRGB;
            b = 255;
        } else if (portionOfCycle < 5) {
            r = timeInPortionRGB;
            b = 255;
        } else if (portionOfCycle < 6) {
            r = 255;
            b = 255 - timeInPortionRGB;
        }
        return new int[] {r, g, b};
    }
    public static int RGBtoHex(int red, int green, int blue) {
        return (red << 16) | (green << 8) | (blue);
    }//end of skidding LOL
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event){
        if(Keyboard.getEventKeyState()){
            String keyTyped = Keyboard.getKeyName(Keyboard.getEventKey());
            for(Module mod : TestMod.moduleManager.Mods){
                if(keyTyped.equals(mod.getKey())){
                    mod.toggle();
                }
            }
        }
    }
}
