package ru.pearx.largestuff.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ServerSide extends CommonProxy
{
	@Override
	public void TeleportToSpawn(World w, Entity p) 
	{
		SharedProxy.TeleportToSpawn(p);
	}

	@Override
	public void Teleport(World w, Entity p, int dim, double x, double y, double z, SoundEvent sound)
	{
		SharedProxy.Teleport(p, dim, x, y, z, sound);
	}
}