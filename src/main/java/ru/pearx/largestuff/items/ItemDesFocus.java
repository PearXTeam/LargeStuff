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
		setCreativeTab(Main.TabLargeStuff);
		setMaxStackSize(1);
		setUnlocalizedName("des_focus");
        setRegistryName(Main.ModID, "des_focus");
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean b)
	{
		l.add(I18n.format("item.des_focus.lore1", new Object[0]));
		super.addInformation(stack, p, l, b);
	}
}
