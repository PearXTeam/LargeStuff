package ru.pearx.largestuff.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;

public class ItemPrimalTalisman extends Item
{
	public ItemPrimalTalisman()
	{
		setCreativeTab(Main.TabLargeStuff);
		setMaxStackSize(1);
		setUnlocalizedName("primalTalisman");
		setRegistryName(Main.ModID, "primalTalisman");
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean b) 
	{
		l.add(I18n.format("item.primalTalisman.lore1", new Object[0]));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World w, EntityPlayer p, EnumHand hand)
	{
		if(!w.isRemote)
		{
			Main.proxy.TeleportToSpawn(w, p);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
