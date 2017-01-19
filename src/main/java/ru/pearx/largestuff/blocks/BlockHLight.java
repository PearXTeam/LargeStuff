package ru.pearx.largestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import ru.pearx.largestuff.Main;

/**
 * Created by me on 18.01.17.
 */
public class BlockHLight extends Block
{
    public BlockHLight()
    {
        super(Material.GROUND);
        setRegistryName(Main.ModID, "h_light");
        setBlockUnbreakable();
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0, 0.8f, 0, 1f, 1f, 1f);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullyOpaque(IBlockState state)
    {
        return true;
    }

    @Override
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
}
