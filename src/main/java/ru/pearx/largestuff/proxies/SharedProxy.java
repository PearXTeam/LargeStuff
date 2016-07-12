package ru.pearx.largestuff.proxies;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import ru.pearx.largestuff.LSTeleporter;
import ru.pearx.largestuff.Main;

public class SharedProxy 
{
	public static void TeleportToSpawn(Entity p)
	{
		World w = DimensionManager.getWorld(Main.DimID);
		BlockPos spawnCoords = w.getSpawnPoint();
		if(w.getBlockState(spawnCoords).getBlock() != Blocks.AIR)
		{
			spawnCoords = w.getTopSolidOrLiquidBlock(spawnCoords);
		}
		Teleport(p, Main.DimID, spawnCoords.getX(), spawnCoords.getY(), spawnCoords.getZ(), SoundEvents.BLOCK_GRASS_BREAK);
	}
	
	public static void Teleport(Entity p, int dim, double x, double y, double z, SoundEvent sound)
	{
		World world = DimensionManager.getWorld(dim);
		if (p.dimension != dim)
		{
			EntityPlayerMP emp = (EntityPlayerMP) p;
			emp.getServer().getPlayerList().transferPlayerToDimension(emp, dim, new LSTeleporter(emp.getServerWorld()));
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
			p.playSound(sound, 1f, 1f);
		}
	}
}
