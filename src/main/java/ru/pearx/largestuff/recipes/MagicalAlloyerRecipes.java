package ru.pearx.largestuff.recipes;

import com.google.common.collect.Maps;
import net.minecraft.item.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by mrAppleXZ on 15.06.2016.
 */
public class MagicalAlloyerRecipes
{
    public static MagicalAlloyerRecipes instance = new MagicalAlloyerRecipes();

    public Map<MagicalAlloyerIn, ItemStack> recipes = Maps.newHashMap();

    private MagicalAlloyerRecipes()
    {

    }

    public void addRecipe(MagicalAlloyerIn in, ItemStack out)
    {
        recipes.put(in, out);
    }

    public ItemStack getResult(MagicalAlloyerIn input)
    {
        ArrayList<MagicalAlloyerIn> in = new ArrayList(recipes.keySet());
        ArrayList<ItemStack> out = new ArrayList(recipes.values());
        for(int i = 0; i < recipes.size(); i++)
        {
            MagicalAlloyerIn mai = in.get(i);
            if(ItemStack.func_179545_c(mai.one, input.one) && ItemStack.func_179545_c(mai.two, input.two) && ItemStack.func_179545_c(mai.three, input.three))
            {
                return out.get(i);
            }
        }
        return null;
    }

}
