package ru.pearx.largestuff.te;

import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.pearx.largestuff.Main;
import ru.pearx.largestuff.items.LSItems;

import javax.annotation.Nullable;
import java.util.List;

public class TE_ETS extends TileEntity implements ITickable
{
	public double posX;
	public double posY = -9999999;
	public double posZ;
	public int dim;

	@Override
	public void func_145839_a(NBTTagCompound tag)
	{
		super.func_145839_a(tag);
		this.Setup(tag.func_74769_h("posX"), tag.func_74769_h("posY"), tag.func_74769_h("posZ"), tag.func_74762_e("dim"));
	}

	@Override
	public NBTTagCompound func_189515_b(NBTTagCompound tag)
	{
		super.func_189515_b(tag);
		tag.func_74780_a("posX", this.posX);
		tag.func_74780_a("posY", this.posY);
		tag.func_74780_a("posZ", this.posZ);
		tag.func_74768_a("dim", this.dim);
		return tag;
	}

	public boolean isSetuped()
	{
		return posY != -9999999;
	}

	public void Setup(double x, double y, double z, int dim)
	{
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.dim = dim;
	}

	@Nullable
	@Override
	public SPacketUpdateTileEntity func_189518_D_()
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		func_189515_b(nbtTag);
		return new SPacketUpdateTileEntity(this.func_174877_v(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
	{
		func_145839_a(packet.func_148857_g());
	}

	public void Reset()
	{
		this.posX = 0;
		this.posY = -9999999;
		this.posZ = 0;
		this.dim = 0;
	}

	public ItemStack GetDrop()
	{
		NBTTagCompound tag = new NBTTagCompound();
		tag.func_74780_a("posX", this.posX);
		tag.func_74780_a("posY", this.posY);
		tag.func_74780_a("posZ", this.posZ);
		tag.func_74768_a("dim", this.dim);
		ItemStack stack = new ItemStack(LSItems.DesFocus, 1);
		stack.func_77982_d(tag);
		return stack;
	}

	public static void Use(World w, Entity e, BlockPos pos)
	{
		TileEntity te = w.func_175625_s(pos);
		if (te instanceof TE_ETS)
		{
			TE_ETS ets = (TE_ETS) te;
			if (ets.isSetuped())
			{
				Main.proxy.Teleport(w, e, ets.dim, ets.posX, ets.posY, ets.posZ, SoundEvents.field_187534_aX, SoundCategory.PLAYERS);
			}
		}
	}

	@Override
	public void func_73660_a()
	{
		if (isSetuped())
		{
			World w = func_145831_w();
			BlockPos p = func_174877_v();
			List<Entity> ent = w.func_72872_a(Entity.class, new AxisAlignedBB(p.func_177958_n(), p.func_177956_o(), p.func_177952_p(), p.func_177958_n() + 1, p.func_177956_o() + 2, p.func_177952_p() + 1));
			for (Entity e : ent)
			{
				if (!Main.UseCollisionEvent)
					Use(e.func_130014_f_(), e, e.func_180425_c());

			}
		}
	}
}
