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
		setUnlocalizedName("primal_talisman");
		setRegistryName(Main.ModID, "primal_talisman");
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean b) 
	{
		l.add(I18n.format("item.primal_talisman.lore1", new Object[0]));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World w, EntityPlayer p, EnumHand hand)
	{
		ItemStack stack = p.getHeldItem(hand);
		if(!w.isRemote)
		{
			Main.proxy.TeleportToSpawn(w, p);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
