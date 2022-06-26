package com.meedou.testmod.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import net.minecraft.client.Minecraft;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public abstract class MixinNetworkManager {

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void sendPacket(Packet<?> packetIn, CallbackInfo callbackInfo) {
        if(packetIn instanceof CPacketChatMessage){
            String message = ((CPacketChatMessage) packetIn).getMessage();
            if(message.length() < 256 && !message.startsWith("/") && !message.endsWith("\u1D00")){
                callbackInfo.cancel();
                Minecraft.getMinecraft().player.sendChatMessage(message +"\u25e6 \u1D0D\u1D00\u0280\u026A\u0274\u1D00");
            }
        }

    }

    @Inject(method = "channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet<?> p_channelRead0_2_, CallbackInfo callbackInfo) {

    }
}
