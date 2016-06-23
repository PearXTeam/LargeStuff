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
        super(Material.field_151575_d);
        func_149663_c("damager");
        func_149711_c(2F);
        func_149752_b(5F);
        func_149672_a(SoundType.field_185848_a);
        setRegistryName(Main.ModID, "damager");
    }

    @Override
    public boolean func_180639_a(World w, BlockPos pos, IBlockState s, EntityPlayer p, EnumHand hand, @Nullable ItemStack held, EnumFacing side, float hitX, float hitY, float hitZ)
    {

        return true;
    }

    @Override
    public TileEntity func_149915_a(World worldIn, int meta)
    {
        return new TEDamager();
    }
}
