package com.rocker1337.dab.init.items;

import com.rocker1337.dab.Reference;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class MLGCanCanDisk extends ItemRecord
{
    protected MLGCanCanDisk(String name, SoundEvent soundIn)
    {
        super(name, soundIn);
        setUnlocalizedName(SetItemNames.DABItems.CANCANRECORD.getUnlocalizedName());
        setRegistryName(SetItemNames.DABItems.CANCANRECORD.getRegistryName());
    }

    @Override
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation("entity.player.burp");
    }
}
