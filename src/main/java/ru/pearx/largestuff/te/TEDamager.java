package ru.pearx.largestuff.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;

/**
 * Created by mrAppleXZ on 21.06.2016.
 */
public class TEDamager extends TileEntity
{
    int damage = 0;

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        NBTTagCompound tag = compound;
        tag.setInteger("tookDamage", damage);
        return tag;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        damage = compound.getInteger("tookDamage");
    }
}
