package ru.pearx.largestuff.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;

/**
 * Created by mrAppleXZ on 21.06.2016.
 */
public class BlockTEBase extends BlockContainer
{
    public BlockTEBase(Material materialIn)
    {
        super(materialIn);
        setCreativeTab(Main.TabLargeStuff);
        setSoundType(SoundType.STONE);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return null;
    }

    @Override
    public void breakBlock(World w, BlockPos pos, IBlockState state)
    {
        w.removeTileEntity(pos);
        super.breakBlock(w, pos, state);
    }
}
