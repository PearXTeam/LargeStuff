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
		func_77637_a(Main.TabLargeStuff);
		func_77625_d(1);
		func_77655_b("primalTalisman");
		setRegistryName(Main.ModID, "primalTalisman");
	}

	@Override
	public void func_77624_a(ItemStack stack, EntityPlayer p, List l, boolean b) 
	{
		l.add(I18n.func_135052_a("item.primalTalisman.lore1", new Object[0]));
	}

	@Override
	public ActionResult<ItemStack> func_77659_a(ItemStack stack, World w, EntityPlayer p, EnumHand hand)
	{
		if(!w.field_72995_K)
		{
			Main.proxy.TeleportToSpawn(w, p);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
