package ru.pearx.largestuff;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import ru.pearx.largestuff.items.LSItems;

/**
 * Created by mrAppleXZ on 19.03.2016.
 */
public class LSEvents
{
    @SubscribeEvent
    public void OnDrops(LivingDropsEvent e)
    {
        Entity ent = e.getEntity();
        if(ent instanceof EntityEnderman)
        {
            int i = ent.getEntityWorld().rand.nextInt(5) + e.getLootingLevel();
            e.getEntityLiving().entityDropItem(new ItemStack(LSItems.EndermanFlash, i), 2);
        }
    }

    @SubscribeEvent
    public void OnTooltip(ItemTooltipEvent e)
    {
        if(e.isShowAdvancedItemTooltips() && Main.ShowOreDict)
        {
            int[] ids = OreDictionary.getOreIDs(e.getItemStack());
            if(ids.length != 0)
            {
                e.getToolTip().add(I18n.format("largestuff.oreDictNames"));
                for(int i : ids)
                {
                    e.getToolTip().add(" -" +OreDictionary.getOreName(i));
                }
            }
        }
    }
}
