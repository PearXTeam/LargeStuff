package ru.pearx.largestuff.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import ru.pearx.largestuff.Main;

public class SharedProxy 
{
	public static void TeleportToSpawn(Entity p)
	{
		BlockPos spawnCoords = DimensionManager.getWorld(0).getSpawnPoint();
		World world = DimensionManager.getWorld(Main.DimID);
		if (p.dimension != Main.DimID)
		{
			p.changeDimension(Main.DimID);
			for (int i = (int)p.posX - 5; i < p.posX + 5; i++)
			{
			    for (int j = (int)p.posY - 5; j < p.posX + 5; j++)
			    { 
			        for (int k = (int)p.posZ - 5; k < p.posX + 5; k++)
			        { 
			               if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.OBSIDIAN || world.getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.PORTAL)
			               {
			                       world.setBlockToAir(new BlockPos(i, j, k));
			               }
			        }
			    }
			}
		}
		if(world.getBlockState(spawnCoords).getBlock().isBlockSolid(world, spawnCoords, EnumFacing.UP))
		{
			if(p instanceof EntityLivingBase)
				p.setPositionAndUpdate(spawnCoords.getX() + 0.50000, world.getHeight(spawnCoords).getY(), spawnCoords.getZ() + 0.50000);
			else
				p.setPosition(spawnCoords.getX() + 0.50000, world.getHeight(spawnCoords).getY(), spawnCoords.getZ() + 0.50000);
		}
		else
		{
			if(p instanceof EntityLivingBase)
				p.setPositionAndUpdate(spawnCoords.getX() + 0.50000, spawnCoords.getY(), spawnCoords.getZ() + 0.50000);
			else
				p.setPosition(spawnCoords.getX() + 0.50000, spawnCoords.getY(), spawnCoords.getZ() + 0.50000);
		}
		if(p instanceof EntityPlayer)
		{
			world.playSound((EntityPlayer) p, spawnCoords, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.AMBIENT, 1, 1);
		}
	}
	
	public static void Teleport(Entity p, int dim, double x, double y, double z, SoundEvent sound, SoundCategory cat)
	{
		World world = DimensionManager.getWorld(dim);
		if (p.dimension != dim)
		{
			p.changeDimension(dim);
			for (int i = (int)p.posX - 5; i < p.posX + 5; i++)
			{
				for (int j = (int)p.posY - 5; j < p.posX + 5; j++)
				{
					for (int k = (int)p.posZ - 5; k < p.posX + 5; k++)
					{
						if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.OBSIDIAN || world.getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.PORTAL)
						{
							world.setBlockToAir(new BlockPos(i, j, k));
						}
					}
				}
			}
		}
		if(p instanceof EntityLivingBase)
		{
			p.setPositionAndUpdate(x, y, z);
			p.fallDistance = 0;
		}
		else
			p.setPosition(x, y, z);
		if(p instanceof EntityPlayer)
		{
			world.playSound((EntityPlayer) p, x, y, z, sound, cat, 1, 1);
		}
	}
}
