package ru.pearx.largestuff.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.items.LSItems;
import ru.pearx.largestuff.te.TE_ETS;

public class BlockETS extends ModelBlockBase
{
	public BlockETS(Material mat)
	{
		super(mat);
		func_149663_c("ets");
		setRegistryName(Main.ModID, "ets");
        func_149711_c(1.0f);
        func_149752_b(3.0f);
	}

    @Override
    public AxisAlignedBB func_185496_a(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.2F, 1F);
    }

	@Override
	public TileEntity func_149915_a(World w, int i) {
		return new TE_ETS();
	}

	@Override
	public void func_180663_b(World w, BlockPos pos, IBlockState state)
	{
		TileEntity te = w.func_175625_s(pos);
		if(te instanceof TE_ETS)
		{
			TE_ETS ets = (TE_ETS)te;
			if(ets.isSetuped())
			{
				ItemStack stack = new ItemStack(LSItems.DesFocus, 1);
				NBTTagCompound tag = new NBTTagCompound();
				tag.func_74780_a("posX", ets.posX);
				tag.func_74780_a("posY", ets.posY);
				tag.func_74780_a("posZ", ets.posZ);
				tag.func_74768_a("dim", ets.dim);
				stack.func_77982_d(tag);
				w.func_72838_d(new EntityItem(w, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), stack));
			}
		}
		super.func_180663_b(w, pos, state);
	}

	@Override
	public void func_180655_c(IBlockState state, World w, BlockPos pos, Random rand)
	{
		super.func_180655_c(state, w, pos, rand);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.05D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.05D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.05D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.05D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.95D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.95D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.95D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.95D, 0, -1D, 0);

		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.95D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.05D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.95D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.05D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.05D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.95D, 0, -1D, 0);
		w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.05D, pos.func_177956_o() + 1.8D, pos.func_177952_p() + 0.95D, 0, -1D, 0);
		TileEntity te = w.func_175625_s(pos);
		if (te instanceof TE_ETS)
		{
			TE_ETS ets = (TE_ETS) te;
			if (ets.isSetuped())
			{
				for (int i = 0; i < 50; i++) {
					w.func_175688_a(EnumParticleTypes.PORTAL, pos.func_177958_n() + 0.50000, pos.func_177956_o(), pos.func_177952_p() + 0.50000, 0, rand.nextFloat(), 0);
				}
			}
		}
	}

	@Override
	public boolean func_180639_a(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, ItemStack held, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		TileEntity te = w.func_175625_s(pos);
		if(te instanceof TE_ETS)
		{
			TE_ETS ets = (TE_ETS)te;
			if(p.func_70093_af())
			{
				if(ets.isSetuped())
				{
					if(!w.field_72995_K)
						w.func_72838_d(new EntityItem(w, p.field_70165_t, p.field_70163_u, p.field_70161_v, ets.GetDrop()));
					ets.Reset();
					return true;
				}
			}
			else
			{
				if(held != null)
				{
					if(held.func_77973_b() == LSItems.DesFocus)
					{
						NBTTagCompound tag = held.func_77978_p();
						if(tag != null)
						{
							if(tag.func_74764_b("posX") && tag.func_74764_b("posY") && tag.func_74764_b("posZ") && tag.func_74764_b("dim"))
							{
								if(!p.func_184812_l_())
								{
									--held.field_77994_a;
								}
								if(!ets.isSetuped())
								{
									ets.Setup(tag.func_74769_h("posX"), tag.func_74769_h("posY"), tag.func_74769_h("posZ"), tag.func_74762_e("dim"));
								}
								else
								{
									if(!w.field_72995_K)
										w.func_72838_d(new EntityItem(w, p.field_70165_t, p.field_70163_u, p.field_70161_v, ets.GetDrop()));
									ets.Reset();
									ets.Setup(tag.func_74769_h("posX"), tag.func_74769_h("posY"), tag.func_74769_h("posZ"), tag.func_74762_e("dim"));
								}
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public void func_180634_a(World w, BlockPos p, IBlockState s, Entity e)
	{
		if(Main.UseCollisionEvent)
			TE_ETS.Use(w, e, p);
	}
}
