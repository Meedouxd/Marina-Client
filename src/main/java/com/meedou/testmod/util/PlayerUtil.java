package com.meedou.testmod.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockObsidian;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;

public class PlayerUtil {
    public final Minecraft mc = Minecraft.getMinecraft();
    //NOT WORKING
    public Entity findNearestPlayer(){
        Entity entityToReturn = null;
        double biggerDist = Double.MAX_VALUE;
        for (Entity e : mc.world.loadedEntityList) {
            if (e instanceof EntityOtherPlayerMP) {
                double deltaX = e.posX - mc.player.posX;
                double deltaZ = e.posZ - mc.player.posZ;
                double dist = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
                if(dist < biggerDist){
                    entityToReturn = e;
                    biggerDist = dist;
                }
            }
        }
        return entityToReturn;
    }

    public int findItemInHotBar(Item itemToFind){
            for(int i = 0; i < 9; i++){
                final ItemStack stack = mc.player.inventory.getStackInSlot(i);
                if (stack != ItemStack.EMPTY && stack.getItem() == itemToFind){
                    return i;
                }
            }
        return -1;
    }
    //Fix this in the future, please. Its terrible
    public int findBlockInHotBar(String blockName){
        if(blockName.equals("Obsidian")){
            for(int i = 0; i < 9; i++){
                final ItemStack stack = mc.player.inventory.getStackInSlot(i);
                if (stack != ItemStack.EMPTY && stack.getItem() instanceof ItemBlock){
                    final Block block = ((ItemBlock) stack.getItem()).getBlock();
                    if (block instanceof BlockObsidian){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    public boolean isEntitySurrounded(Entity e, int yOffset){
        String[] blocks = {mc.world.getBlockState(new BlockPos(e).down(yOffset).north()).getBlock().toString(),
                mc.world.getBlockState(new BlockPos(e).down(yOffset).south()).getBlock().toString(),
                mc.world.getBlockState(new BlockPos(e).down(yOffset).east()).getBlock().toString(),
                mc.world.getBlockState(new BlockPos(e).down(yOffset).west()).getBlock().toString()};
        for(String blockType : blocks){
            if(!blockType.equals("Block{minecraft:bedrock}") && !blockType.equals("Block{minecraft:obsidian}")){
                return false;
            }
        }
        return true;
    }
    public boolean isOnSameBlock(Entity one, Entity two){
        int xPos1 = (int) Math.floor(one.posX);
        int xPos2 = (int) Math.floor(two.posX);
        int yPos1 = (int) Math.floor(one.posY);
        int yPos2 = (int) Math.floor(two.posY);
        int zPos1 = (int) Math.floor(one.posZ);
        int zPos2 = (int) Math.floor(two.posZ);
        return xPos1 == xPos2 && yPos1 == yPos2 && zPos1 == zPos2;
    }
    public boolean isEntityTrapped(Entity e){
        if(isEntitySurrounded(e,0) && mc.world.getBlockState(new BlockPos(e).up(2)).getBlock().toString().equals("Block{minecraft:bedrock}") || mc.world.getBlockState(new BlockPos(e).up(2))
                .getBlock().toString().equals("Block{minecraft:obsidian}")){
            return true;
        }
        return false;
    }
}
