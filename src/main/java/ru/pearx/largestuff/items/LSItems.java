package ru.pearx.largestuff.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.armor.DesArmor;
import ru.pearx.largestuff.blocks.BlockETS;
import ru.pearx.largestuff.blocks.DesBlock;

public class LSItems 
{
	public static Item PrimalTalisman = new ItemPrimalTalisman();
	public static Item EnderTeleport = new ItemEnderTeleport();
	public static Item DesMetal = new Item().setUnlocalizedName("des_metal").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_metal");
	public static Item DesShard = new Item().setUnlocalizedName("des_shard").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_shard");
	public static Item DesCase = new Item().setUnlocalizedName("des_case").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_case");
	public static Item DesRod = new Item().setUnlocalizedName("des_rod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_rod");
	public static Item DesPlate = new Item().setUnlocalizedName("des_plate").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_plate");
	public static Item DesDoubleRod = new Item().setUnlocalizedName("des_double_rod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_double_rod");
	public static Item EndermanFlash = new Item().setUnlocalizedName("enderman_flash").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "enderman_flash");
	public static Item DesFocus = new ItemDesFocus();
	
	public static Block BlockEnderTeleportingStation = new BlockETS(Material.ROCK);
	public static Block BlockDes = new DesBlock();

	public static Item ItemBlockDes = new ItemBlock(BlockDes).setRegistryName(Main.ModID, "des_block");
	public static Item ItemBlockEnderTeleportingStation = new ItemBlock(BlockEnderTeleportingStation).setRegistryName(Main.ModID, "ets");

	public static Item DesHelmet = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.HEAD);
	public static Item DesSuit = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.CHEST);
	public static Item DesLeggings = new DesArmor(DesArmor.Des, 2, EntityEquipmentSlot.LEGS);
	public static Item DesBoots = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.FEET);
}