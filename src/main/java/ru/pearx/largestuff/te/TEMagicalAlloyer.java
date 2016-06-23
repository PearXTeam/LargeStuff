//package ru.pearx.largestuff.te;
//
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.InventoryPlayer;
//import net.minecraft.inventory.Container;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.inventory.ISidedInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
//import net.minecraft.tileentity.TileEntityLockable;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.ITickable;
//import net.minecraft.util.StringUtils;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.text.ITextComponent;
//import net.minecraft.util.text.TextComponentString;
//import net.minecraft.world.World;
//import ru.pearx.largestuff.Main;
//import ru.pearx.largestuff.recipes.MagicalAlloyerIn;
//import ru.pearx.largestuff.recipes.MagicalAlloyerRecipes;
//
//import javax.annotation.Nullable;
//
///**
// * Created by mrAppleXZ on 13.06.2016.
// */
//public class TEMagicalAlloyer extends TileEntityLockable implements ISidedInventory, ITickable
//{
//    public ItemStack[] slots = new ItemStack[4];
//    public int timeToAlloy = 300;
//    public int timeAlloyed = 0;
//    public String customName;
//
//    @Override
//    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate)
//    {
//        return false;
//    }
//
//    @Override
//    public int getSizeInventory()
//    {
//        return slots.length;
//    }
//
//    @Nullable
//    @Override
//    public ItemStack getStackInSlot(int index)
//    {
//        return slots[index];
//    }
//
//    @Nullable
//    @Override
//    public ItemStack decrStackSize(int index, int count)
//    {
//        if(slots[index] != null)
//        {
//            ItemStack stack;
//
//            if(slots[index].stackSize <= count)
//            {
//                stack = slots[index];
//                slots[index] = null;
//                return stack;
//            }
//            else
//            {
//                stack = slots[index].splitStack(count);
//
//                if(slots[index].stackSize == 0)
//                    slots[index] = null;
//
//                return stack;
//            }
//        }
//        else
//            return null;
//    }
//
//    @Nullable
//    @Override
//    public ItemStack removeStackFromSlot(int index)
//    {
//        if(slots[index] != null)
//        {
//            ItemStack stack = slots[index];
//            slots[index] = null;
//            return stack;
//        }
//        else
//            return null;
//    }
//
//    @Override
//    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
//    {
//        boolean isSame = stack != null && stack.isItemEqual(slots[index]) && ItemStack.areItemStackTagsEqual(stack, slots[index]);
//        slots[index] = stack;
//
//        if(stack != null && stack.stackSize > getInventoryStackLimit())
//        {
//            stack.stackSize = getInventoryStackLimit();
//        }
//
//        if(index < 3 && !isSame)
//        {
//            timeAlloyed = 0;
//            markDirty();
//        }
//    }
//
//
//    public void setCustomInventoryName(String cn)
//    {
//        customName = cn;
//    }
//
//    @Override
//    public void readFromNBT(NBTTagCompound tag)
//    {
//        super.readFromNBT(tag);
//        NBTTagList l = tag.getTagList("Items", 10);
//        slots = new ItemStack[4];
//
//        for(int i = 0; i < l.tagCount(); i++)
//        {
//            NBTTagCompound tagItm = l.getCompoundTagAt(i);
//
//            byte slot = tagItm.getByte("Slot");
//
//            if(slot >= 0 && slot < slots.length)
//            {
//                slots[i] = ItemStack.loadItemStackFromNBT(tagItm);
//            }
//        }
//
//        timeAlloyed = tag.getInteger("timeAlloyed");
//
//        if(tag.hasKey("CustomName", 8))
//        {
//            customName = tag.getString("CustomName");
//        }
//    }
//
//    @Override
//    public NBTTagCompound writeToNBT(NBTTagCompound compound)
//    {
//        NBTTagCompound tag = new NBTTagCompound();
//        tag.setInteger("timeAlloyed", timeAlloyed);
//
//        NBTTagList l = new NBTTagList();
//        for(int i = 0; i < slots.length; i++)
//        {
//            if(slots[i] != null)
//            {
//                NBTTagCompound tagItm = new NBTTagCompound();
//                tagItm.setByte("Slot", (byte)i);
//                slots[i].writeToNBT(tagItm);
//                l.appendTag(tagItm);
//            }
//        }
//
//        tag.setTag("Items", l);
//
//        if(hasCustomName())
//            tag.setString("CustomName", customName);
//
//        return tag;
//    }
//
//    @Override
//    public int getInventoryStackLimit()
//    {
//        return 64;
//    }
//
//    @Override
//    public boolean isUseableByPlayer(EntityPlayer player)
//    {
//        return getWorld().getTileEntity(getPos()) == this && player.getDistanceSq(getPos().getX() + 0.5D, getPos().getY() + 0.5D, getPos().getZ() + 0.5D) <= 64D;
//    }
//
//    @Override
//    public void openInventory(EntityPlayer player)
//    {
//
//    }
//
//    @Override
//    public void closeInventory(EntityPlayer player)
//    {
//
//    }
//
//    @Override
//    public boolean isItemValidForSlot(int index, ItemStack stack)
//    {
//        return index < 3;
//    }
//
//    @Override
//    public int getField(int id)
//    {
//        switch (id)
//        {
//            case 0:
//                return timeAlloyed;
//        }
//
//    }
//
//    @Override
//    public void setField(int id, int value)
//    {
//        switch (id)
//        {
//            case 0:
//                timeAlloyed = value;
//        }
//    }
//
//    @Override
//    public int getFieldCount()
//    {
//        return 1;
//    }
//
//    @Override
//    public void clear()
//    {
//        for(int i = 0; i < slots.length; i++)
//        {
//            slots[i] = null;
//        }
//    }
//
//    @Override
//    public String getName()
//    {
//        return hasCustomName() ? customName : "container.magicalAlloyer";
//    }
//
//    @Override
//    public boolean hasCustomName()
//    {
//        return customName != null && StringUtils.isNullOrEmpty(customName);
//    }
//
//    @Override
//    public ITextComponent getDisplayName()
//    {
//        return hasCustomName() ? new TextComponentString(customName) : new TextComponentString("container.magicalAlloyer");
//    }
//
//    @Override
//    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
//    {
//        //TODO
//        return null;
//    }
//
//    @Override
//    public String getGuiID()
//    {
//        return Main.ModID + ":magicalAlloyer";
//    }
//
//    @Override
//    public int[] getSlotsForFace(EnumFacing side)
//    {
//        if(side == EnumFacing.DOWN)
//            return new int[]{3};
//        else
//            return new int[]{0, 1, 2};
//    }
//
//    @Override
//    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
//    {
//        return isItemValidForSlot(index, itemStackIn);
//    }
//
//    @Override
//    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
//    {
//        return true;
//    }
//
//    @Override
//    public void update()
//    {
//        if(!getWorld().isRemote)
//        {
//            if(areSlotsPresent())
//            {
//                ItemStack out = MagicalAlloyerRecipes.instance.getResult(new MagicalAlloyerIn(slots[0], slots[1], slots[3]));
//                if(canAlloy(out))
//                {
//                    //start
//                    if(!isAlloying())
//                    {
//                        timeAlloyed++;
//                    }
//                    //continue
//                    else
//                    {
//                        timeAlloyed++;
//                        if(canStopAlloying())
//                            alloy(out);
//                    }
//                }
//                else timeAlloyed = 0;
//            }
//            else timeAlloyed = 0;
//        }
//    }
//
//    public boolean isAlloying()
//    {
//        if (timeAlloyed > 0)
//            return true;
//        return false;
//    }
//
//    public boolean canStopAlloying()
//    {
//        if(timeAlloyed >= 301)
//            return true;
//        return false;
//    }
//
//    public boolean areSlotsPresent()
//    {
//        if(slots[0] != null && slots[1] != null && slots[2] != null)
//        {
//            return true;
//        }
//        return false;
//    }
//
//    public boolean canAlloy(ItemStack out)
//    {
//        if(out != null)
//        {
//            if(slots[3] != null)
//            {
//                if (ItemStack.areItemsEqual(out, slots[3]) && slots[3].stackSize < slots[3].getMaxStackSize())
//                {
//                    return true;
//                }
//            }
//            else return true;
//        }
//        return false;
//    }
//
//    public void alloy(ItemStack out)
//    {
//        if(slots[3] == null)
//        {
//            slots[3] = out.copy();
//        }
//        else
//        {
//            slots[3].stackSize++;
//        }
//
//
//        for(int i = 0; i < 3; i++)
//        {
//            if(slots[i].stackSize > 0)
//            {
//                --slots[i].stackSize;
//            }
//            else
//                slots[i] = null;
//        }
//
//        timeAlloyed = 0;
//    }
//}
