package ru.pearx.largestuff.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.armor.DesArmor;
import ru.pearx.largestuff.blocks.BlockDamager;
import ru.pearx.largestuff.blocks.BlockETS;
import ru.pearx.largestuff.blocks.DesBlock;

public class LSItems 
{
	public static Item PrimalTalisman = new ItemPrimalTalisman();
	public static Item EnderTeleport = new ItemEnderTeleport();
	public static Item DesMetal = new Item().func_77655_b("desMetal").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desMetal");
	public static Item DesShard = new Item().func_77655_b("desShard").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desShard");
	public static Item DesCase = new Item().func_77655_b("desCase").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desCase");
	public static Item DesRod = new Item().func_77655_b("desRod").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desRod");
	public static Item DesPlate = new Item().func_77655_b("desPlate").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desPlate");
	public static Item DesDoubleRod = new Item().func_77655_b("desDoubleRod").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "desDoubleRod");
	public static Item EndermanFlash = new Item().func_77655_b("endermanFlash").func_77637_a(Main.TabLargeStuff).setRegistryName(Main.ModID, "endermanFlash");
	public static Item DesFocus = new ItemDesFocus();
	
	public static Block BlockETS = new BlockETS(Material.field_151576_e);
	//public static Block BlockMagicalAlloyer = new BlockMagicalAlloyer();
	public static Block BlockDes = new DesBlock();
	public static Block BlockDamager = new BlockDamager();

	public static Item ItemBlockDes = new ItemBlock(BlockDes).setRegistryName(Main.ModID, "desBlock");
	public static Item ItemBlockETS = new ItemBlock(BlockETS).setRegistryName(Main.ModID, "ets");
	//public static Item ItemBlockMagicalAlloyer = new ItemBlock(BlockMagicalAlloyer);
	public static Item ItemBlockDamager = new ItemBlock(BlockDamager).setRegistryName(Main.ModID, "damager");

	public static Item DesHelmet = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.HEAD);
	public static Item DesSuit = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.CHEST);
	public static Item DesLeggings = new DesArmor(DesArmor.Des, 2, EntityEquipmentSlot.LEGS);
	public static Item DesBoots = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.FEET);
}
