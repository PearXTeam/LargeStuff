package ru.pearx.largestuff.items;

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
    public ActionResult<ItemStack> func_77659_a(ItemStack stack, World w, EntityPlayer p, EnumHand hand)
    {
        NBTTagCompound tag;
        if(!w.field_72995_K)
        {
            if (p.func_70093_af())
            {
                tag = new NBTTagCompound();
                tag.func_74780_a("posX", p.field_70165_t);
                tag.func_74780_a("posY", p.field_70163_u);
                tag.func_74780_a("posZ", p.field_70161_v);
                tag.func_74768_a("dim", p.field_71093_bK);
                stack.func_77982_d(tag);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

    @Override
    public void func_77624_a(ItemStack stack, EntityPlayer p, List l, boolean b)
    {
        NBTTagCompound tag = stack.func_77978_p();
        if(tag != null)
        {
            if(tag.func_74764_b("dim") && tag.func_74764_b("posX") && tag.func_74764_b("posY") && tag.func_74764_b("posZ"))
            {
                l.add("__________");
                l.add("Dim: " + tag.func_74762_e("dim") + ". XYZ: " + (int)tag.func_74769_h("posX") + ", " + (int)tag.func_74769_h("posY") + ", "+ (int)tag.func_74769_h("posZ") + ".");
            }
        }
    }

    @Override
    public boolean func_77636_d(ItemStack stack)
    {
        NBTTagCompound tag = stack.func_77978_p();
        if(tag != null)
        {
            if(tag.func_74764_b("dim") && tag.func_74764_b("posX") && tag.func_74764_b("posY") && tag.func_74764_b("posZ"))
                return true;
        }
        return false;
    }
}
