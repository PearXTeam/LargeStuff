package ru.pearx.largestuff;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import ru.pearx.largestuff.items.LSItems;
import ru.pearx.largestuff.proxies.CommonProxy;
import ru.pearx.largestuff.te.EnderTeleportingStationEntity;

import java.util.ArrayList;

@Mod(modid = Main.ModID, name = Main.ModName, version = Main.Version)
public class Main 
{
	public static final String ModID = "largestuff";
	public static final String ModName = "LargeStuff";
	public static final String Version = "2.1.0";

	public static boolean ShowOreDict;
	public static int DimID;
	public static boolean UseCollisionEvent;

	@SidedProxy(clientSide="ru.pearx.largestuff.proxies.ClientSide", serverSide="ru.pearx.largestuff.proxies.ServerSide")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void PreInit(FMLPreInitializationEvent e)
	{
		SetupMetadata(e.getModMetadata());
		
		Configuration conf = new Configuration(e.getSuggestedConfigurationFile());
		conf.load();
		DimID = conf.getInt("SpawnDimID", Configuration.CATEGORY_GENERAL, 0, -1, 256, "The ID of the spawn dimension (0 = Overworld, -1 = Nether, 1 = End");
		ShowOreDict = conf.getBoolean("ShowOreDictNames", Configuration.CATEGORY_GENERAL, true, "Show OreDict names for items? (F3 + H - Enable)");
		UseCollisionEvent = conf.getBoolean("UseCollisionEvent", Configuration.CATEGORY_GENERAL, false, "Use collision event for Ender Teleporting Station? True = SLIGHTLY faster, teleports only players and some mobs, False = SLIGHTLY lower, teleports all entities.");
		conf.save();

		GameRegistry.register(LSItems.PrimalTalisman);
		GameRegistry.register(LSItems.EnderTeleport);
		GameRegistry.register(LSItems.DesMetal);
		GameRegistry.register(LSItems.DesCase);
		GameRegistry.register(LSItems.DesRod);
		GameRegistry.register(LSItems.DesShard);
		GameRegistry.register(LSItems.DesPlate);
		GameRegistry.register(LSItems.DesDoubleRod);
		GameRegistry.register(LSItems.DesFocus);
		GameRegistry.registerTileEntity(EnderTeleportingStationEntity.class, "teEnderTeleportingStation");
		GameRegistry.register(LSItems.BlockEnderTeleportingStation);
		GameRegistry.register(LSItems.BlockDes);
		GameRegistry.register(LSItems.EndermanFlash);
		GameRegistry.register(LSItems.ItemBlockDes);
		GameRegistry.register(LSItems.ItemBlockEnderTeleportingStation);

		OreDictionary.registerOre("nuggetDes", LSItems.DesShard);
		OreDictionary.registerOre("stickDes", LSItems.DesRod);
		OreDictionary.registerOre("ingotDes", LSItems.DesMetal);
		OreDictionary.registerOre("plateDes", LSItems.DesPlate);
		OreDictionary.registerOre("blockDes", LSItems.BlockDes);
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent e)
	{
		proxy.RegItemRender();

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.PrimalTalisman), new Object[]
				{
					"#P#",
					"#F#",
					"S#S",
					'P', Blocks.YELLOW_FLOWER, 'F', "dirt", 'S', "stickWood"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.PrimalTalisman), new Object[]
				{
						"#P#",
						"#F#",
						"S#S",
						'P', Blocks.RED_FLOWER, 'F', "dirt", 'S', "stickWood"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.DesCase), new Object[]
				{
					"DDD",
					"D#D",
					"DDD",
					'D', "nuggetDes"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.EnderTeleport), new Object[]
				{
					"#P#",
					"#R#",
					"#CB",
					'P', Items.ENDER_PEARL, 'R', "stickDes", 'C', LSItems.DesCase, 'B', Blocks.STONE_BUTTON
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.DesPlate), new Object[]
				{
					"DDD",
					'D', "nuggetDes"
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesMetal), new Object[]
				{
						"gemDiamond", Blocks.OBSIDIAN, Items.ENDER_PEARL
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesShard, 9), new Object[]
				{
						"ingotDes"
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesRod), new Object[]
				{
						"nuggetDes", "stickWood"
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesDoubleRod), new Object[]
				{
						"stickDes", "stickDes"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.BlockEnderTeleportingStation), new Object[]
				{
					"S#S",
					"SPS",
					'S', LSItems.DesDoubleRod, 'P', "plateDes"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.BlockDes), new Object[]
				{
					"DDD",
					"DDD",
					"DDD",
					'D', "ingotDes"
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesMetal, 9), new Object[]
				{
						"blockDes"
				}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(LSItems.DesMetal), new Object[]
				{
					"DDD",
					"DDD",
					"DDD",
					'D', "nuggetDes"
				}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(LSItems.DesFocus), new Object[]
				{
						"nuggetDes", "nuggetDes", Items.ENDER_EYE
				}));
		proxy.RegisterRender();
		MinecraftForge.EVENT_BUS.register(new LSEvents());
	}
	
	private void SetupMetadata(ModMetadata mm)
	{
		mm.autogenerated = false;
		mm.version = Version;
		mm.name = ModName;
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("mrAppleXZ");
		mm.authorList = arrayList;
		mm.description = "LargeStuff - Minecraft mod, that adds a random stuff.";
		mm.modId = ModID;
	}
	
	public static CreativeTabs TabLargeStuff = new CreativeTabs("largestuff")
	{
		@Override
		public Item getTabIconItem()
		{
			return LSItems.EnderTeleport;
		}
	};

}