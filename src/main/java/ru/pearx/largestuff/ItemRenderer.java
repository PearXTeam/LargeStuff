package ru.pearx.largestuff;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by mrAppleXZ on 08.03.2016.
 */
public class ItemRenderer
{
    public static void reg(Item itm)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itm, 0 , new ModelResourceLocation("largestuff:" + itm.getRegistryName().toString().substring(Main.ModID.length() + 1), "inventory"));
    }
}
