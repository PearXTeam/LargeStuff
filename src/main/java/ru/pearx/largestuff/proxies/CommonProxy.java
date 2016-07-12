package ru.pearx.largestuff.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class CommonProxy 
{
	public void TeleportToSpawn(World w, Entity p){}
	public void Teleport(World w, Entity p, int dim, double x, double y, double z, SoundEvent sound){}
	public void RegisterRender(){}
	public void RegItemRender() {}
}
