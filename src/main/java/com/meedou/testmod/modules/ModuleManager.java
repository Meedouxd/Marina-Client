package com.meedou.testmod.modules;

import com.meedou.testmod.modules.modules.*;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager{
    public List<Module> Mods = new ArrayList<>();
    public List<String> EnabledMods = new ArrayList();
    public ModuleManager(){
        //Combat
        addModule(new KillAuraModule());
        addModule(new CrystalAuraModule());
        addModule(new AimbotModule());
        addModule(new AutoPvPModule());
        addModule(new AnchorModule());
        //Movement
        addModule(new AutoWalkModule());
        addModule(new SpeedModule());
        //Player

        //Render
        addModule(new ClickGUIModule());
        //Misc
        addModule(new FakePlayerModule());


    }
    public void addModule(Module module){
        Mods.add(module);
    }
    public Module getMod(Class modClass){
        for(Module allmods: Mods){
            if(allmods.getClass() == modClass){
                return allmods;
            }
        }
        return null;
    }
    public void toggleModFromName(String name){
        for(Module allmods : Mods){
            if(allmods.getName().equals(name)){
                allmods.toggle();
            }
        }
    }
}

