package ru.pearx.largestuff.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by mrAppleXZ on 07.05.2016.
 */
public class ItemCoordStore extends Item
{
    @Override
    public ActionResult<ItemStack> onItemRightClick(World w, EntityPlayer p, EnumHand hand)
    {
        ItemStack stack = p.getHeldItem(hand);
        NBTTagCompound tag;
        if(!w.isRemote)
        {
            if (p.isSneaking())
            {
                tag = new NBTTagCompound();
                tag.setDouble("posX", p.posX);
                tag.setDouble("posY", p.posY);
                tag.setDouble("posZ", p.posZ);
                tag.setInteger("dim", p.dimension);
                stack.setTagCompound(tag);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean b)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag != null)
        {
            if(tag.hasKey("dim") && tag.hasKey("posX") && tag.hasKey("posY") && tag.hasKey("posZ"))
            {
                l.add("__________");
                l.add("Dim: " + tag.getInteger("dim") + ". XYZ: " + (int)tag.getDouble("posX") + ", " + (int)tag.getDouble("posY") + ", "+ (int)tag.getDouble("posZ") + ".");
            }
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound();
        if(tag != null)
        {
            if(tag.hasKey("dim") && tag.hasKey("posX") && tag.hasKey("posY") && tag.hasKey("posZ"))
                return true;
        }
        return false;
    }
}
