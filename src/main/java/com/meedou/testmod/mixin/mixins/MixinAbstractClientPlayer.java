package com.meedou.testmod.mixin.mixins;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.UUID;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {
    @Shadow
    @Nullable
    protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    public void preGetLocationCape(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(getPlayerInfo() != null){
            UUID uuid = getPlayerInfo().getGameProfile().getId();
            if(uuid.equals(UUID.fromString("0a9f266b-d1cf-4723-bf35-f94ab9935809"))){
                callbackInfoReturnable.setReturnValue(new ResourceLocation("textures/testmod/cape.png"));
            }
        }
    }

    @Inject(method = "getLocationSkin()Lnet/minecraft/util/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void preGetLocationSkin(CallbackInfoReturnable<ResourceLocation> callbackInfoReturnable) {
        if(getPlayerInfo() != null){
            UUID uuid = getPlayerInfo().getGameProfile().getId();
            if(!uuid.equals(UUID.fromString("0a9f266b-d1cf-4723-bf35-f94ab9935809"))){
                callbackInfoReturnable.setReturnValue(new ResourceLocation("textures/testmod/skin.png"));
            }
        }
    }
}
