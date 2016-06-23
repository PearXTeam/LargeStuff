package ru.pearx.largestuff.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;

/**
 * Created by mrAppleXZ on 13.06.2016.
 */
public class ModelBlockBase extends BlockTEBase
{
    public ModelBlockBase(Material matIn)
    {
        super(matIn);
    }

    @Override
    public boolean func_149686_d(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType func_149645_b(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean func_149662_c(IBlockState state)
    {
        return false;
    }
}
