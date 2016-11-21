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
		setCreativeTab(Main.TabLargeStuff);
		setMaxStackSize(1);
		setUnlocalizedName("ender_teleport");
		setRegistryName(Main.ModID, "ender_teleport");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World w, EntityPlayer p, EnumHand hand)
	{
		super.onItemRightClick(w, p, hand);
		ItemStack stack = p.getHeldItem(hand);
		if(!w.isRemote)
		{
			if(!p.isSneaking())
			{
				NBTTagCompound tag = stack.getTagCompound();
				if (tag != null)
				{
					if(tag.hasKey("dim") && tag.hasKey("posX") && tag.hasKey("posY") && tag.hasKey("posZ"))
						Main.proxy.Teleport(w, p, tag.getInteger("dim"), tag.getInteger("posX"), tag.getInteger("posY"), tag.getInteger("posZ"), SoundEvents.ENTITY_ENDERMEN_TELEPORT);
				}
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean b) 
	{
		l.add(I18n.format("item.ender_teleport.lore1", new Object[0]));
		l.add(I18n.format("item.ender_teleport.lore2", new Object[0]));
		l.add(I18n.format("item.ender_teleport.lore3", new Object[0]));
	}
}
