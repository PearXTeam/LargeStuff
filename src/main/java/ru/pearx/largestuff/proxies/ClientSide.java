package ru.pearx.largestuff.proxies;

import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import ru.pearx.largestuff.ItemRenderer;
import ru.pearx.largestuff.items.LSItems;
import ru.pearx.largestuff.te.ETSRender;
import ru.pearx.largestuff.te.TE_ETS;

public class ClientSide extends CommonProxy
{

	@Override
	public void TeleportToSpawn(World w, Entity p) 
	{
		if(!w.field_72995_K)
		{
			SharedProxy.TeleportToSpawn(p);
		}
		super.TeleportToSpawn(w, p);
	}

	@Override
	public void Teleport(World w, Entity p, int dim, double x, double y, double z, SoundEvent sound, SoundCategory cat)
	{
		if(!w.field_72995_K)
		{
			SharedProxy.Teleport(p, dim, x, y, z, sound, cat);
		}
		super.Teleport(w, p, dim, x, y, z, sound, cat);
	}
	
	@Override
	public void RegisterRender() 
	{
        ClientRegistry.bindTileEntitySpecialRenderer(TE_ETS.class, new ETSRender());
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
		ItemRenderer.reg(LSItems.ItemBlockDamager);
		ItemRenderer.reg(LSItems.ItemBlockETS);
		ItemRenderer.reg(LSItems.EndermanFlash);
		ItemRenderer.reg(LSItems.DesHelmet);
		ItemRenderer.reg(LSItems.DesSuit);
		ItemRenderer.reg(LSItems.DesLeggings);
		ItemRenderer.reg(LSItems.DesBoots);
	}
}
