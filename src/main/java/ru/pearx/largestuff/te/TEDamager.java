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
    public NBTTagCompound func_189515_b(NBTTagCompound compound)
    {
        NBTTagCompound tag = compound;
        tag.func_74768_a("tookDamage", damage);
        return tag;
    }

    @Override
    public void func_145839_a(NBTTagCompound compound)
    {
        damage = compound.func_74762_e("tookDamage");
    }
}
