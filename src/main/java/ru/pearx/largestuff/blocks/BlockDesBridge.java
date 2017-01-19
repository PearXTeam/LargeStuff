package ru.pearx.largestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.items.LSItems;

/**
 * Created by me on 15.01.17.
 */
public class BlockDesBridge extends Block
{
    public static final PropertyDirection FACING = PropertyDirection.create( "facing", EnumFacing.Plane.HORIZONTAL );

    public BlockDesBridge()
    {
        super(Material.ROCK);
        setRegistryName("des_bridge");
        setCreativeTab(Main.TabLargeStuff);
        setUnlocalizedName("des_bridge");
        setHardness(75F);
        setResistance(3000F);
        setSoundType(SoundType.METAL);
    }

    @Override
    public void neighborChanged(IBlockState state, World w, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (w.isBlockPowered(pos))
        {
            Vec3i vec = state.getValue(FACING).getDirectionVec();
            for (int i = 1; i <= Main.DesBridgeLength; i++)
            {
                int x = i * vec.getX();
                int z = i * vec.getZ();
                BlockPos npos = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
                if (w.isAirBlock(npos))
                {
                    w.setBlockState(npos, LSItems.BlockHLight.getDefaultState());
                } else
                    break;
            }
        } else
        {
            disable(state, w, pos);
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).ordinal();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FACING, EnumFacing.VALUES[meta]);
    }

    @Override
    public IBlockState getStateForPlacement(World w, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void breakBlock(World w, BlockPos pos, IBlockState state)
    {
        disable(state, w, pos);
        super.breakBlock(w, pos, state);
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

    public void disable(IBlockState state, World w, BlockPos pos)
    {
        Vec3i vec = state.getValue(FACING).getDirectionVec();
        for (int i = 1; i <= Main.DesBridgeLength; i++)
        {
            int x = i * vec.getX();
            int z = i * vec.getZ();
            BlockPos npos = new BlockPos(pos.getX() + x, pos.getY(), pos.getZ() + z);
            if (w.getBlockState(npos).getBlock() instanceof BlockHLight)
            {
                w.setBlockToAir(npos);
            }
        }
    }
}
