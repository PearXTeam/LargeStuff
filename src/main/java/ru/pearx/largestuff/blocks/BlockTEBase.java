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
        func_149647_a(Main.TabLargeStuff);
        func_149672_a(SoundType.field_185851_d);
    }

    @Override
    public TileEntity func_149915_a(World worldIn, int meta)
    {
        return null;
    }

    @Override
    public void func_180663_b(World w, BlockPos pos, IBlockState state)
    {
        w.func_175713_t(pos);
        super.func_180663_b(w, pos, state);
    }
}
