package ru.pearx.largestuff.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import ru.pearx.largestuff.ItemRenderer;
import ru.pearx.largestuff.items.LSItems;
import ru.pearx.largestuff.te.EnderTeleportingStationEntity;
import ru.pearx.largestuff.te.EnderTeleportingStationRender;

public class ClientSide extends CommonProxy
{

	@Override
	public void TeleportToSpawn(World w, Entity p) 
	{
		if(!w.isRemote)
		{
			SharedProxy.TeleportToSpawn(p);
		}
	}

	@Override
	public void Teleport(World w, Entity p, int dim, double x, double y, double z, SoundEvent sound)
	{
		if(!w.isRemote)
		{
			SharedProxy.Teleport(p, dim, x, y, z, sound);
		}
	}
	
	@Override
	public void RegisterRender() 
	{
        ClientRegistry.bindTileEntitySpecialRenderer(EnderTeleportingStationEntity.class, new EnderTeleportingStationRender());
        super.RegisterRender();
	}

	@Override
	public void RegItemRender()
	{
		ItemRenderer.reg(LSItems.DesMetal);
		ItemRenderer.reg(LSItems.DesCase);
		ItemRenderer.reg(LSItems.DesFocus);
		ItemRenderer.reg(LSItems.DesPlate);
		ItemRenderer.reg(LSItems.DesRod);
		ItemRenderer.reg(LSItems.DesShard);
		ItemRenderer.reg(LSItems.DesDoubleRod);
		ItemRenderer.reg(LSItems.EnderTeleport);
		ItemRenderer.reg(LSItems.PrimalTalisman);
		ItemRenderer.reg(LSItems.ItemBlockDes);
		ItemRenderer.reg(LSItems.ItemBlockEnderTeleportingStation);
		ItemRenderer.reg(LSItems.EndermanFlash);
		ItemRenderer.reg(LSItems.DesHelmet);
		ItemRenderer.reg(LSItems.DesSuit);
		ItemRenderer.reg(LSItems.DesLeggings);
		ItemRenderer.reg(LSItems.DesBoots);
	}
}
