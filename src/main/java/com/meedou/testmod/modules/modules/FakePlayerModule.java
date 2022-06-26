package com.meedou.testmod.modules.modules;

import com.meedou.testmod.modules.Module;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import java.util.UUID;

public class FakePlayerModule extends Module {
    boolean enabled = false;
    private EntityOtherPlayerMP fakePlayer;
    public FakePlayerModule(){
        super("Fake Player", "J", Category.MISC);
    }
    @Override
    public void onEnable(){
        super.onEnable();
        fakePlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("d8cf0222-b0cd-4333-85ec-08666dd9a7db"), "Other Women"));
        fakePlayer.copyLocationAndAnglesFrom(mc.player);
        fakePlayer.rotationYawHead = mc.player.rotationYawHead;
        fakePlayer.inventory.copyInventory(mc.player.inventory);
        mc.world.addEntityToWorld(-100, fakePlayer);
    }
    @Override
    public void onDisable(){
        super.onDisable();
        mc.world.removeEntity(fakePlayer);
    }
}