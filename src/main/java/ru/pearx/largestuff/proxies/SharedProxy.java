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
		BlockPos spawnCoords = DimensionManager.getWorld(0).func_175694_M();
		World world = DimensionManager.getWorld(Main.DimID);
		if (p.field_71093_bK != Main.DimID)
		{
			p.func_184204_a(Main.DimID);
			for (int i = (int)p.field_70165_t - 5; i < p.field_70165_t + 5; i++)
			{
			    for (int j = (int)p.field_70163_u - 5; j < p.field_70165_t + 5; j++)
			    { 
			        for (int k = (int)p.field_70161_v - 5; k < p.field_70165_t + 5; k++)
			        { 
			               if (world.func_180495_p(new BlockPos(i, j, k)).func_177230_c() == Blocks.field_150343_Z || world.func_180495_p(new BlockPos(i, j, k)).func_177230_c() == Blocks.field_150427_aO)
			               {
			                       world.func_175698_g(new BlockPos(i, j, k));
			               }
			        }
			    }
			}
		}
		if(world.func_180495_p(spawnCoords).func_177230_c().func_176212_b(world, spawnCoords, EnumFacing.UP))
		{
			if(p instanceof EntityLivingBase)
				p.func_70634_a(spawnCoords.func_177958_n() + 0.50000, world.func_175645_m(spawnCoords).func_177956_o(), spawnCoords.func_177952_p() + 0.50000);
			else
				p.func_70107_b(spawnCoords.func_177958_n() + 0.50000, world.func_175645_m(spawnCoords).func_177956_o(), spawnCoords.func_177952_p() + 0.50000);
		}
		else
		{
			if(p instanceof EntityLivingBase)
				p.func_70634_a(spawnCoords.func_177958_n() + 0.50000, spawnCoords.func_177956_o(), spawnCoords.func_177952_p() + 0.50000);
			else
				p.func_70107_b(spawnCoords.func_177958_n() + 0.50000, spawnCoords.func_177956_o(), spawnCoords.func_177952_p() + 0.50000);
		}
		if(p instanceof EntityPlayer)
		{
			world.func_184133_a((EntityPlayer) p, spawnCoords, SoundEvents.field_187571_bR, SoundCategory.AMBIENT, 1, 1);
		}
	}
	
	public static void Teleport(Entity p, int dim, double x, double y, double z, SoundEvent sound, SoundCategory cat)
	{
		World world = DimensionManager.getWorld(dim);
		if (p.field_71093_bK != dim)
		{
			p.func_184204_a(dim);
			for (int i = (int)p.field_70165_t - 5; i < p.field_70165_t + 5; i++)
			{
				for (int j = (int)p.field_70163_u - 5; j < p.field_70165_t + 5; j++)
				{
					for (int k = (int)p.field_70161_v - 5; k < p.field_70165_t + 5; k++)
					{
						if (world.func_180495_p(new BlockPos(i, j, k)).func_177230_c() == Blocks.field_150343_Z || world.func_180495_p(new BlockPos(i, j, k)).func_177230_c() == Blocks.field_150427_aO)
						{
							world.func_175698_g(new BlockPos(i, j, k));
						}
					}
				}
			}
		}
		if(p instanceof EntityLivingBase)
		{
			p.func_70634_a(x, y, z);
			p.field_70143_R = 0;
		}
		else
			p.func_70107_b(x, y, z);
		if(p instanceof EntityPlayer)
		{
			world.func_184148_a((EntityPlayer) p, x, y, z, sound, cat, 1, 1);
		}
	}
}
