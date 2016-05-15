package ru.pearx.largestuff.items;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import ru.pearx.largestuff.Main;

public class DesBlock extends Block
{

	protected DesBlock(Material mat)
	{
		super(mat);
		setCreativeTab(Main.TabLargeStuff);
		setUnlocalizedName("desBlock");
		setHardness(150.0F);
		setResistance(6000.0F);
		setHarvestLevel("pickaxe", 3);
        setStepSound(SoundType.METAL);
		setRegistryName(Main.ModID, "desBlock");
	}

}
