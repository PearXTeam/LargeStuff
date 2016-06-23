package ru.pearx.largestuff.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;

public class ItemEnderTeleport extends ItemCoordStore
{
    public ItemEnderTeleport()
	{
		func_77637_a(Main.TabLargeStuff);
		func_77625_d(1);
		func_77655_b("enderTeleport");
		setRegistryName(Main.ModID, "enderTeleport");
	}

	@Override
	public ActionResult<ItemStack> func_77659_a(ItemStack stack, World w, EntityPlayer p, EnumHand hand)
	{
		super.func_77659_a(stack, w, p, hand);
		if(!w.field_72995_K)
		{
			if(!p.func_70093_af())
			{
				NBTTagCompound tag = stack.func_77978_p();
				if (tag != null)
				{
					if(tag.func_74764_b("dim") && tag.func_74764_b("posX") && tag.func_74764_b("posY") && tag.func_74764_b("posZ"))
						Main.proxy.Teleport(w, p, tag.func_74762_e("dim"), tag.func_74762_e("posX"), tag.func_74762_e("posY"), tag.func_74762_e("posZ"), SoundEvents.field_187534_aX, SoundCategory.PLAYERS);
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	@Override
	public void func_77624_a(ItemStack stack, EntityPlayer p, List l, boolean b) 
	{
		l.add(I18n.func_135052_a("item.enderTeleport.lore1", new Object[0]));
		l.add(I18n.func_135052_a("item.enderTeleport.lore2", new Object[0]));
		l.add(I18n.func_135052_a("item.enderTeleport.lore3", new Object[0]));
	}
}
