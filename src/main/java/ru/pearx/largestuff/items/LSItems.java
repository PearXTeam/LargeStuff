package ru.pearx.largestuff.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.te.EnderTeleportingStation;

public class LSItems 
{
	public static Item PrimalTalisman = new ItemPrimalTalisman();
	public static Item EnderTeleport = new ItemEnderTeleport();
	public static Item DesMetal = new Item().setUnlocalizedName("desMetal").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desMetal");
	public static Item DesShard = new Item().setUnlocalizedName("desShard").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desShard");
	public static Item DesCase = new Item().setUnlocalizedName("desCase").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desCase");
	public static Item DesRod = new Item().setUnlocalizedName("desRod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desRod");
	public static Item DesPlate = new Item().setUnlocalizedName("desPlate").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desPlate");
	public static Item DesDoubleRod = new Item().setUnlocalizedName("desDoubleRod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "desDoubleRod");
	public static Item EndermanFlash = new Item().setUnlocalizedName("endermanFlash").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "endermanFlash");
	public static Item DesFocus = new ItemDesFocus();
	
	public static Block BlockEnderTeleportingStation = new EnderTeleportingStation(Material.ROCK);
	public static Block BlockDes = new DesBlock(Material.ROCK);
	public static Item ItemBlockDes = new ItemBlock(BlockDes).setRegistryName(Main.ModID, "desBlock");
	public static Item ItemBlockEnderTeleportingStation = new ItemBlock(BlockEnderTeleportingStation).setRegistryName(Main.ModID, "enderTeleportingStation");
}