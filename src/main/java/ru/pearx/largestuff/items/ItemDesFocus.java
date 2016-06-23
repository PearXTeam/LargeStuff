package ru.pearx.largestuff.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ru.pearx.largestuff.Main;

import java.util.List;

public class ItemDesFocus extends ItemCoordStore
{
	public ItemDesFocus()
	{
		func_77637_a(Main.TabLargeStuff);
		func_77625_d(1);
		func_77655_b("desFocus");
        setRegistryName(Main.ModID, "desFocus");
	}

	@Override
	public void func_77624_a(ItemStack stack, EntityPlayer p, List l, boolean b)
	{
		l.add(I18n.func_135052_a("item.desFocus.lore1", new Object[0]));
		super.func_77624_a(stack, p, l, b);
	}
}
