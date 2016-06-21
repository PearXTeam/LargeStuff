package ru.pearx.largestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import ru.pearx.largestuff.Main;

public class DesBlock extends Block
{

	public DesBlock()
	{
		super(Material.ROCK);
		setCreativeTab(Main.TabLargeStuff);
		setUnlocalizedName("desBlock");
		setHardness(150.0F);
		setResistance(6000.0F);
		setHarvestLevel("pickaxe", 3);
        setSoundType(SoundType.METAL);
		setRegistryName(Main.ModID, "desBlock");
	}

}
