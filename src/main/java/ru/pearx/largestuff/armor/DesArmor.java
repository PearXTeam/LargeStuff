package ru.pearx.largestuff.armor;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.util.EnumHelper;
import ru.pearx.largestuff.Main;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mrAppleXZ on 31.05.2016.
 */
public class DesArmor extends ItemArmor implements ISpecialArmor
{
    public static ItemArmor.ArmorMaterial Des = EnumHelper.addArmorMaterial("DesArmor", Main.ModID + ":desArmor", 165, new int[]{1, 1, 1, 1}, 1, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.1F);

    public DesArmor(ArmorMaterial material, int render, EntityEquipmentSlot slot)
    {
        super(material, render, slot);

        String unloc = "";
        switch (slot)
        {
            case HEAD:
                unloc = "desHelmet";
                break;
            case CHEST:
                unloc = "desSuit";
                break;
            case LEGS:
                unloc = "desLeggings";
                break;
            case FEET:
                unloc = "desBoots";
                break;
        }
        setUnlocalizedName(unloc);
        setRegistryName(unloc);
        setCreativeTab(Main.TabLargeStuff);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase p, ItemStack armor, DamageSource source, double damage, int slot)
    {
        if(isFullSet(p))
            return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 2));
        return new ArmorProperties(1, 1, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
    {
        return 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
    {
        stack.damageItem(damage, entity);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer p, List<String> l, boolean advanced)
    {
        Iterable<ItemStack> v = p.getArmorInventoryList();

        if(isFullSet(p))
            l.add(I18n.format("item.desArmor.enabled"));
        else
            l.add(I18n.format("item.desArmor.disabled"));
    }

    public static boolean isFullSet(EntityLivingBase p)
    {
        ArrayList<ItemStack> l = Lists.newArrayList(p.getArmorInventoryList());
        boolean b = true;
        for(ItemStack s : l)
        {
            if(s != null)
            {
                if(!(s.getItem() instanceof DesArmor))
                {
                    b = false;
                }
            }
            else b = false;
        }
        return b;
    }
}