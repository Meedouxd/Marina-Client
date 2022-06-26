package com.meedou.testmod.modules.modules;

import com.meedou.testmod.gui.ClickGUI;
import com.meedou.testmod.modules.Module;

public class ClickGUIModule extends Module {
    public ClickGUIModule(){
        super("ClickGUI", "G", Category.RENDER);
    }
    @Override
    public void onEnable(){
        super.onEnable();
        System.out.println("GUI THING BLAHHHH");
        mc.displayGuiScreen(new ClickGUI());
        this.disable();
    }
    @Override
    public void onDisable(){
        super.onDisable();
    }
}
