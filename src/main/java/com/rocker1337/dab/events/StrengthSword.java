package com.rocker1337.dab.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class StrengthSword
{

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void holdDiamondSwordEvent(LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer entity = (EntityPlayer) event.getEntity();
            ItemStack heldItem = entity.getHeldItemMainhand();
            if (heldItem != null && heldItem.getItem() == Items.DIAMOND_SWORD)
            {
                entity.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("strength"), 25, 1));
            }
        }
    }
}
