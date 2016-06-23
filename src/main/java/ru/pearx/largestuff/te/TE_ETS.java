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
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		this.Setup(tag.getDouble("posX"), tag.getDouble("posY"), tag.getDouble("posZ"), tag.getInteger("dim"));
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tag.setDouble("posX", this.posX);
		tag.setDouble("posY", this.posY);
		tag.setDouble("posZ", this.posZ);
		tag.setInteger("dim", this.dim);
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
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound nbtTag = new NBTTagCompound();
		writeToNBT(nbtTag);
		return new SPacketUpdateTileEntity(this.getPos(), 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
	{
		readFromNBT(packet.getNbtCompound());
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
		tag.setDouble("posX", this.posX);
		tag.setDouble("posY", this.posY);
		tag.setDouble("posZ", this.posZ);
		tag.setInteger("dim", this.dim);
		ItemStack stack = new ItemStack(LSItems.DesFocus, 1);
		stack.setTagCompound(tag);
		return stack;
	}

	public static void Use(World w, Entity e, BlockPos pos)
	{
		TileEntity te = w.getTileEntity(pos);
		if (te instanceof TE_ETS)
		{
			TE_ETS ets = (TE_ETS) te;
			if (ets.isSetuped())
			{
				Main.proxy.Teleport(w, e, ets.dim, ets.posX, ets.posY, ets.posZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.PLAYERS);
			}
		}
	}

	@Override
	public void update()
	{
		if (isSetuped())
		{
			World w = getWorld();
			BlockPos p = getPos();
			List<Entity> ent = w.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(p.getX(), p.getY(), p.getZ(), p.getX() + 1, p.getY() + 2, p.getZ() + 1));
			for (Entity e : ent)
			{
				if (!Main.UseCollisionEvent)
					Use(e.getEntityWorld(), e, e.getPosition());

			}
		}
	}
}
