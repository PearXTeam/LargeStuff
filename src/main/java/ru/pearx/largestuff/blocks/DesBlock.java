package ru.pearx.largestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import ru.pearx.largestuff.Main;

public class DesBlock extends Block
{

	public DesBlock()
	{
		super(Material.field_151576_e);
		func_149647_a(Main.TabLargeStuff);
		func_149663_c("desBlock");
		func_149711_c(150.0F);
		func_149752_b(6000.0F);
		setHarvestLevel("pickaxe", 3);
        func_149672_a(SoundType.field_185852_e);
		setRegistryName(Main.ModID, "desBlock");
	}

}
