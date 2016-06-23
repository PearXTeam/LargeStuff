package ru.pearx.largestuff.te;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ETSModel extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Oneborder;
    ModelRenderer Twoborder;
    ModelRenderer Threeborder;
    ModelRenderer Fourborder;
    ModelRenderer Mechhandone;
    ModelRenderer Mechhandtwo;
    ModelRenderer Mechhandthree;
    ModelRenderer Mechhandfour;
    ModelRenderer Focus;
    ModelRenderer Mechhand2one;
    ModelRenderer Mechhand2two;
    ModelRenderer Mechhand2three;
    ModelRenderer Mechhand2four;
  
  public ETSModel()
  {
    field_78090_t = 64;
    field_78089_u = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.func_78789_a(0F, 0F, 0F, 16, 1, 16);
      Base.func_78793_a(-8F, 23F, -8F);
      Base.func_78787_b(64, 64);
      Base.field_78809_i = true;
      setRotation(Base, 0F, 0F, 0F);
      Oneborder = new ModelRenderer(this, 0, 17);
      Oneborder.func_78789_a(0F, 0F, 0F, 4, 1, 1);
      Oneborder.func_78793_a(-2F, 22F, -3F);
      Oneborder.func_78787_b(64, 64);
      Oneborder.field_78809_i = true;
      setRotation(Oneborder, 0F, 0F, 0F);
      Twoborder = new ModelRenderer(this, 10, 17);
      Twoborder.func_78789_a(0F, 0F, 0F, 4, 1, 1);
      Twoborder.func_78793_a(-2F, 22F, 2F);
      Twoborder.func_78787_b(64, 64);
      Twoborder.field_78809_i = true;
      setRotation(Twoborder, 0F, 0F, 0F);
      Threeborder = new ModelRenderer(this, 20, 17);
      Threeborder.func_78789_a(0F, 0F, 0F, 1, 1, 4);
      Threeborder.func_78793_a(-3F, 22F, -2F);
      Threeborder.func_78787_b(64, 64);
      Threeborder.field_78809_i = true;
      setRotation(Threeborder, 0F, 0F, 0F);
      Fourborder = new ModelRenderer(this, 30, 17);
      Fourborder.func_78789_a(0F, 0F, 0F, 1, 1, 4);
      Fourborder.func_78793_a(2F, 22F, -2F);
      Fourborder.func_78787_b(64, 64);
      Fourborder.field_78809_i = true;
      setRotation(Fourborder, 0F, 0F, 0F);
      Mechhandone = new ModelRenderer(this, 0, 19);
      Mechhandone.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhandone.func_78793_a(-10F, 14F, -10F);
      Mechhandone.func_78787_b(64, 64);
      Mechhandone.field_78809_i = true;
      setRotation(Mechhandone, 0.1745329F, 0F, -0.1745329F);
      Mechhandtwo = new ModelRenderer(this, 4, 19);
      Mechhandtwo.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhandtwo.func_78793_a(-10F, 14F, 9F);
      Mechhandtwo.func_78787_b(64, 64);
      Mechhandtwo.field_78809_i = true;
      setRotation(Mechhandtwo, -0.1745329F, 0F, -0.1745329F);
      Mechhandthree = new ModelRenderer(this, 4, 19);
      Mechhandthree.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhandthree.func_78793_a(9F, 14F, 9F);
      Mechhandthree.func_78787_b(64, 64);
      Mechhandthree.field_78809_i = true;
      setRotation(Mechhandthree, -0.1745329F, 0F, 0.1745329F);
      Mechhandfour = new ModelRenderer(this, 4, 19);
      Mechhandfour.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhandfour.func_78793_a(9F, 14F, -10F);
      Mechhandfour.func_78787_b(64, 64);
      Mechhandfour.field_78809_i = true;
      setRotation(Mechhandfour, 0.1745329F, 0F, 0.1745329F);
      Focus = new ModelRenderer(this, 0, 30);
      Focus.func_78789_a(0F, 0F, 0F, 4, 1, 4);
      Focus.func_78793_a(-2F, 22F, -2F);
      Focus.func_78787_b(64, 64);
      Focus.field_78809_i = true;
      setRotation(Focus, 0F, 0F, 0F);
      Mechhand2one = new ModelRenderer(this, 0, 19);
      Mechhand2one.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhand2one.func_78793_a(-8F, 4.5F, -8F);
      Mechhand2one.func_78787_b(64, 64);
      Mechhand2one.field_78809_i = true;
      setRotation(Mechhand2one, -0.1745329F, 0F, 0.1745329F);
      Mechhand2two = new ModelRenderer(this, 1, 19);
      Mechhand2two.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhand2two.func_78793_a(-8F, 4.5F, 7F);
      Mechhand2two.func_78787_b(64, 64);
      Mechhand2two.field_78809_i = true;
      setRotation(Mechhand2two, 0.1745329F, 0F, 0.1745329F);
      Mechhand2three = new ModelRenderer(this, 1, 19);
      Mechhand2three.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhand2three.func_78793_a(7F, 4.5F, 7F);
      Mechhand2three.func_78787_b(64, 64);
      Mechhand2three.field_78809_i = true;
      setRotation(Mechhand2three, 0.1745329F, 0F, -0.1745329F);
      Mechhand2four = new ModelRenderer(this, 1, 19);
      Mechhand2four.func_78789_a(0F, 0F, 0F, 1, 10, 1);
      Mechhand2four.func_78793_a(7F, 4.5F, -8F);
      Mechhand2four.func_78787_b(64, 64);
      Mechhand2four.field_78809_i = true;
      setRotation(Mechhand2four, -0.1745329F, 0F, -0.1745329F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean renderEye)
  {
    super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
    func_78087_a(f, f1, f2, f3, f4, f5, entity);
    Base.func_78785_a(f5);
    Oneborder.func_78785_a(f5);
    Twoborder.func_78785_a(f5);
    Threeborder.func_78785_a(f5);
    Fourborder.func_78785_a(f5);
    Mechhandone.func_78785_a(f5);
    Mechhandtwo.func_78785_a(f5);
    Mechhandthree.func_78785_a(f5);
    Mechhandfour.func_78785_a(f5);
    if(renderEye)
      Focus.func_78785_a(f5);
    Mechhand2one.func_78785_a(f5);
    Mechhand2two.func_78785_a(f5);
    Mechhand2three.func_78785_a(f5);
    Mechhand2four.func_78785_a(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.field_78795_f = x;
    model.field_78796_g = y;
    model.field_78808_h = z;
  }
  
  public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.func_78087_a(f, f1, f2, f3, f4, f5, e);
  }

}
