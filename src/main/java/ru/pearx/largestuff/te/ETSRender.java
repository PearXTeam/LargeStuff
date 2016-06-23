package ru.pearx.largestuff.te;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class ETSRender extends TileEntitySpecialRenderer
{
    @Override
    public void func_180535_a(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        TE_ETS ets =(TE_ETS)te;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        ResourceLocation textures = (new ResourceLocation("largestuff:textures/blocks/BlockETS.png"));
        Minecraft.func_71410_x().field_71446_o.func_110577_a(textures);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        new ETSModel().render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F, ets.isSetuped());
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
