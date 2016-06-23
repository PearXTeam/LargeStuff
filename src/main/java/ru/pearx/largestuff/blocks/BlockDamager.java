package ru.pearx.largestuff.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.te.TEDamager;

import javax.annotation.Nullable;

/**
 * Created by mrAppleXZ on 21.06.2016.
 */
public class BlockDamager extends BlockTEBase
{
    public BlockDamager()
    {
        super(Material.WOOD);
        setUnlocalizedName("damager");
        setHardness(2F);
        setResistance(5F);
        setSoundType(SoundType.WOOD);
        setRegistryName(Main.ModID, "damager");
    }

    @Override
    public boolean onBlockActivated(World w, BlockPos pos, IBlockState s, EntityPlayer p, EnumHand hand, @Nullable ItemStack held, EnumFacing side, float hitX, float hitY, float hitZ)
    {

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TEDamager();
    }
}
