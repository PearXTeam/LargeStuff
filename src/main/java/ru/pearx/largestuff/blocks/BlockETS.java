package ru.pearx.largestuff.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
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
import ru.pearx.largestuff.te.EnderTeleportingStationEntity;

public class BlockETS extends ModelBlockBase
{
	public BlockETS(Material mat)
	{
		super(mat);
		setUnlocalizedName("ets");
		setRegistryName(Main.ModID, "ets");
        setHardness(1.0f);
        setResistance(3.0f);
	}

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return new AxisAlignedBB(0F, 0F, 0F, 1F, 0.2F, 1F);
    }

	@Override
	public TileEntity createNewTileEntity(World w, int i) {
		return new EnderTeleportingStationEntity();
	}

	@Override
	public void breakBlock(World w, BlockPos pos, IBlockState state)
	{
		TileEntity te = w.getTileEntity(pos);
		if(te instanceof EnderTeleportingStationEntity)
		{
			EnderTeleportingStationEntity ets = (EnderTeleportingStationEntity)te;
			if(ets.isSetuped())
			{
				ItemStack stack = new ItemStack(LSItems.DesFocus, 1);
				NBTTagCompound tag = new NBTTagCompound();
				tag.setDouble("posX", ets.posX);
				tag.setDouble("posY", ets.posY);
				tag.setDouble("posZ", ets.posZ);
				tag.setInteger("dim", ets.dim);
				stack.setTagCompound(tag);
				w.spawnEntity(new EntityItem(w, pos.getX(), pos.getY(), pos.getZ(), stack));
			}
		}
		super.breakBlock(w, pos, state);
	}

	@Override
	public void randomDisplayTick(IBlockState state, World w, BlockPos pos, Random rand)
	{
		super.randomDisplayTick(state, w, pos, rand);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.05D, pos.getY() + 1.8D, pos.getZ() + 0.05D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.05D, pos.getY() + 1.8D, pos.getZ() + 0.05D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.95D, pos.getY() + 1.8D, pos.getZ() + 0.95D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.95D, pos.getY() + 1.8D, pos.getZ() + 0.95D, 0, -1D, 0);

		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.95D, pos.getY() + 1.8D, pos.getZ() + 0.05D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.95D, pos.getY() + 1.8D, pos.getZ() + 0.05D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.05D, pos.getY() + 1.8D, pos.getZ() + 0.95D, 0, -1D, 0);
		w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.05D, pos.getY() + 1.8D, pos.getZ() + 0.95D, 0, -1D, 0);
		TileEntity te = w.getTileEntity(pos);
		if (te instanceof EnderTeleportingStationEntity)
		{
			EnderTeleportingStationEntity ets = (EnderTeleportingStationEntity) te;
			if (ets.isSetuped())
			{
				for (int i = 0; i < 50; i++) {
					w.spawnParticle(EnumParticleTypes.PORTAL, pos.getX() + 0.50000, pos.getY(), pos.getZ() + 0.50000, 0, rand.nextFloat(), 0);
				}
			}
		}
	}

	@Override
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
	{
		ItemStack held = p.getHeldItem(hand);
		TileEntity te = w.getTileEntity(pos);
		if(te instanceof EnderTeleportingStationEntity)
		{
			EnderTeleportingStationEntity ets = (EnderTeleportingStationEntity)te;
			if(p.isSneaking())
			{
				if(ets.isSetuped())
				{
					if(!w.isRemote)
						w.spawnEntity(new EntityItem(w, p.posX, p.posY, p.posZ, ets.GetDrop()));
					ets.Reset();
					return true;
				}
			}
			else
			{
				if(!held.isEmpty())
				{
					if(held.getItem() == LSItems.DesFocus)
					{
						NBTTagCompound tag = held.getTagCompound();
						if(tag != null)
						{
							if(tag.hasKey("posX") && tag.hasKey("posY") && tag.hasKey("posZ") && tag.hasKey("dim"))
							{
								if(!p.isCreative())
								{
									held.setCount(held.getCount()-1);
								}
								if(!ets.isSetuped())
								{
									ets.Setup(tag.getDouble("posX"), tag.getDouble("posY"), tag.getDouble("posZ"), tag.getInteger("dim"));
								}
								else
								{
									if(!w.isRemote)
										w.spawnEntity(new EntityItem(w, p.posX, p.posY, p.posZ, ets.GetDrop()));
									ets.Reset();
									ets.Setup(tag.getDouble("posX"), tag.getDouble("posY"), tag.getDouble("posZ"), tag.getInteger("dim"));
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
	public void onEntityCollidedWithBlock(World w, BlockPos p, IBlockState s, Entity e)
	{
		if(Main.UseCollisionEvent)
			EnderTeleportingStationEntity.Use(w, e, p);
	}
}
