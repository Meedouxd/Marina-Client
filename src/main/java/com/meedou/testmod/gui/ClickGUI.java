package com.meedou.testmod.gui;

import com.meedou.testmod.modules.ModuleManager;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class ClickGUI extends GuiScreen{
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks){
        drawDefaultBackground();
        drawRect(150, 2, 220, 14, 0x8f0193);
        mc.fontRenderer.drawString("Combat", 152, 4, 0xffffffff);
        drawRect(250, 2, 322, 14, 0x8f0193);
        mc.fontRenderer.drawString("Movement", 252, 4, 0xffffffff);
        drawRect(350, 2, 432, 14, 0x8f0193);
        mc.fontRenderer.drawString("Render", 352, 4, 0xffffffff);
        drawRect(450, 2, 506, 14, 0x8f0193);
        mc.fontRenderer.drawString("Misc", 452, 4, 0xffffffff);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    @Override
    public boolean doesGuiPauseGame(){
        return false;
    }
    @Override
    public void initGui(){
        buttonList.add(new GuiButton(1, 10, 10, 25,14,"Hacks!"));
    }
    @Override
    public void actionPerformed(GuiButton button) throws IOException {

    }
}
