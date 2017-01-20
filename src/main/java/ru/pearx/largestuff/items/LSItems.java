package ru.pearx.largestuff.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.armor.DesArmor;
import ru.pearx.largestuff.blocks.BlockDesBridge;
import ru.pearx.largestuff.blocks.BlockETS;
import ru.pearx.largestuff.blocks.BlockHLight;
import ru.pearx.largestuff.blocks.DesBlock;

public class LSItems 
{
	public static Item PrimalTalisman = new ItemPrimalTalisman();
	public static Item EnderTeleport = new ItemEnderTeleport();
	public static Item DesMetal = new Item().setUnlocalizedName("des_metal").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_metal");
	public static Item DesShard = new Item().setUnlocalizedName("des_shard").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_shard");
	public static Item DesCase = new Item().setUnlocalizedName("des_case").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_case");
	public static Item DesLargeCase = new Item().setUnlocalizedName("des_large_case").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_large_case");
	public static Item DesRod = new Item().setUnlocalizedName("des_rod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_rod");
	public static Item DesPlate = new Item().setUnlocalizedName("des_plate").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_plate");
	public static Item DesDoubleRod = new Item().setUnlocalizedName("des_double_rod").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_double_rod");
	public static Item EndermanFlash = new Item().setUnlocalizedName("enderman_flash").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "enderman_flash");
	public static Item DesFocus = new ItemDesFocus();
	public static Item DesRedstoneController = new Item().setUnlocalizedName("des_redstone_controller").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "des_redstone_controller");
	public static Item LightiumCrystal = new Item().setUnlocalizedName("lightium_crystal").setCreativeTab(Main.TabLargeStuff).setRegistryName(Main.ModID, "lightium_crystal");
	public static Item SolidLightGenerator = new Item().setUnlocalizedName("solid_light_generator").setCreativeTab(Main.TabLargeStuff).setRegistryName("solid_light_generator");
	
	public static Block BlockEnderTeleportingStation = new BlockETS(Material.ROCK);
	public static Block BlockDes = new DesBlock();
	public static Block BlockDesBridge = new BlockDesBridge();
	public static Block BlockHLight = new BlockHLight();

	public static Item ItemBlockDes = new ItemBlock(BlockDes).setRegistryName(Main.ModID, "des_block");
	public static Item ItemBlockEnderTeleportingStation = new ItemBlock(BlockEnderTeleportingStation).setRegistryName(Main.ModID, "ets");
	public static Item ItemBlockDesBridge = new ItemBlock(BlockDesBridge).setRegistryName(Main.ModID, "des_bridge");

	public static Item DesHelmet = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.HEAD);
	public static Item DesSuit = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.CHEST);
	public static Item DesLeggings = new DesArmor(DesArmor.Des, 2, EntityEquipmentSlot.LEGS);
	public static Item DesBoots = new DesArmor(DesArmor.Des, 1, EntityEquipmentSlot.FEET);
}