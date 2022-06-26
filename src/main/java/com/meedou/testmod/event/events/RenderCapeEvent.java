package com.meedou.testmod.event.events;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RenderCapeEvent extends Event {
    private ResourceLocation location = null;
    public AbstractClientPlayer Player;
    public RenderCapeEvent(AbstractClientPlayer abstractClientPlayer) {
        Player = abstractClientPlayer;
    }
    public void SetResourceLocation(ResourceLocation locationToGet)
    {
        location = locationToGet;
    }

    public ResourceLocation GetResourceLocation()
    {
        return location;
    }
}
