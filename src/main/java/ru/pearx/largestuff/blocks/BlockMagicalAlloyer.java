//package ru.pearx.largestuff.blocks;
//
//import net.minecraft.block.BlockContainer;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.inventory.InventoryHelper;
//import net.minecraft.item.ItemStack;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.EnumHand;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import ru.pearx.largestuff.Main;
//import ru.pearx.largestuff.te.TEMagicalAlloyer;
//
//import javax.annotation.Nullable;
//
///**
// * Created by mrAppleXZ on 04.06.2016.
// */
//public class BlockMagicalAlloyer extends ModelBlockBase
//{
//    public BlockMagicalAlloyer()
//    {
//        super(Material.ROCK);
//        setUnlocalizedName("magicalAlloyer");
//        setRegistryName(Main.ModID, "magicalAlloyer");
//        setHardness(1.5F);
//        setResistance(10F);
//    }
//
//    @Override
//    public TileEntity createNewTileEntity(World worldIn, int meta)
//    {
//        return new TEMagicalAlloyer();
//    }
//
//    @Override
//    public boolean onBlockActivated(World w, BlockPos pos, IBlockState state, EntityPlayer p, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
//    {
//        if(!w.isRemote)
//        {
//            //open gui
//        }
//        return true;
//    }
//
//    @Override
//    public void breakBlock(World w, BlockPos pos, IBlockState state)
//    {
//        TileEntity te = w.getTileEntity(pos);
//        if(te instanceof TEMagicalAlloyer)
//        {
//            InventoryHelper.dropInventoryItems(w, pos, (TEMagicalAlloyer)te);
//        }
//
//        super.breakBlock(w, pos, state);
//    }
//}
