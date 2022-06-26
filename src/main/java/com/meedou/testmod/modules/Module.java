package com.meedou.testmod.modules;

import com.meedou.testmod.TestMod;
import com.meedou.testmod.util.PlayerUtil;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Module {
     public String name;
     public String key;
     public enum Category{COMBAT("Combat"), MOVEMENT("Movement"), PLAYER("Player"), RENDER("Render"), MISC("Misc");
     private final String name;
         Category(String name) {
             this.name = name;
         }
         public String getName(){
             return name;
         }
     }
     public Category category;
     public boolean enabled = false;
     protected final Minecraft mc = Minecraft.getMinecraft();
     public final PlayerUtil playerUtil = new PlayerUtil();
    public Module(String name, String key, Category category){
        this.name = name;
        this.key = key;
        this.category = category;
    }
    public Module(){
    }
    public void onEnable(){
        TestMod.moduleManager.EnabledMods.add(this.getName());
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println(getName() + " has been enabled");
    }
    public void onDisable(){
        TestMod.moduleManager.EnabledMods.remove(this.getName());
        MinecraftForge.EVENT_BUS.unregister(this);
        System.out.println(getName() + " has been disabled");
    }
    public void enable(){
        if(!enabled){
            enabled = true;
            onEnable();
        }
    }
    public void disable(){
        if(enabled){
            enabled = false;
            onDisable();
        }
    }
    public String getName(){
        return name;
    }
    public String getKey(){
        return key;
    }
    public Category getCategory(){
        return category;
    }
    public void toggle(){
        if(enabled){
            enabled = false;
            onDisable();
        }else{
            enabled = true;
            onEnable();
        }
    }
}

