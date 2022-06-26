package com.meedou.testmod;

import com.meedou.testmod.event.ForgeEventProcessor;
import com.meedou.testmod.modules.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = TestMod.MODID, name = TestMod.NAME, version = TestMod.VERSION)
public class TestMod
{
    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "1.0";
    public final Minecraft mc = Minecraft.getMinecraft();
    public static ModuleManager moduleManager;

    @Mod.Instance
    public static TestMod testmod;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ForgeEventProcessor());
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        moduleManager = new ModuleManager();
    }
}
