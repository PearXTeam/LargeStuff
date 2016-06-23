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
    textureWidth = 64;
    textureHeight = 64;
    
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(0F, 0F, 0F, 16, 1, 16);
      Base.setRotationPoint(-8F, 23F, -8F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Oneborder = new ModelRenderer(this, 0, 17);
      Oneborder.addBox(0F, 0F, 0F, 4, 1, 1);
      Oneborder.setRotationPoint(-2F, 22F, -3F);
      Oneborder.setTextureSize(64, 64);
      Oneborder.mirror = true;
      setRotation(Oneborder, 0F, 0F, 0F);
      Twoborder = new ModelRenderer(this, 10, 17);
      Twoborder.addBox(0F, 0F, 0F, 4, 1, 1);
      Twoborder.setRotationPoint(-2F, 22F, 2F);
      Twoborder.setTextureSize(64, 64);
      Twoborder.mirror = true;
      setRotation(Twoborder, 0F, 0F, 0F);
      Threeborder = new ModelRenderer(this, 20, 17);
      Threeborder.addBox(0F, 0F, 0F, 1, 1, 4);
      Threeborder.setRotationPoint(-3F, 22F, -2F);
      Threeborder.setTextureSize(64, 64);
      Threeborder.mirror = true;
      setRotation(Threeborder, 0F, 0F, 0F);
      Fourborder = new ModelRenderer(this, 30, 17);
      Fourborder.addBox(0F, 0F, 0F, 1, 1, 4);
      Fourborder.setRotationPoint(2F, 22F, -2F);
      Fourborder.setTextureSize(64, 64);
      Fourborder.mirror = true;
      setRotation(Fourborder, 0F, 0F, 0F);
      Mechhandone = new ModelRenderer(this, 0, 19);
      Mechhandone.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhandone.setRotationPoint(-10F, 14F, -10F);
      Mechhandone.setTextureSize(64, 64);
      Mechhandone.mirror = true;
      setRotation(Mechhandone, 0.1745329F, 0F, -0.1745329F);
      Mechhandtwo = new ModelRenderer(this, 4, 19);
      Mechhandtwo.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhandtwo.setRotationPoint(-10F, 14F, 9F);
      Mechhandtwo.setTextureSize(64, 64);
      Mechhandtwo.mirror = true;
      setRotation(Mechhandtwo, -0.1745329F, 0F, -0.1745329F);
      Mechhandthree = new ModelRenderer(this, 4, 19);
      Mechhandthree.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhandthree.setRotationPoint(9F, 14F, 9F);
      Mechhandthree.setTextureSize(64, 64);
      Mechhandthree.mirror = true;
      setRotation(Mechhandthree, -0.1745329F, 0F, 0.1745329F);
      Mechhandfour = new ModelRenderer(this, 4, 19);
      Mechhandfour.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhandfour.setRotationPoint(9F, 14F, -10F);
      Mechhandfour.setTextureSize(64, 64);
      Mechhandfour.mirror = true;
      setRotation(Mechhandfour, 0.1745329F, 0F, 0.1745329F);
      Focus = new ModelRenderer(this, 0, 30);
      Focus.addBox(0F, 0F, 0F, 4, 1, 4);
      Focus.setRotationPoint(-2F, 22F, -2F);
      Focus.setTextureSize(64, 64);
      Focus.mirror = true;
      setRotation(Focus, 0F, 0F, 0F);
      Mechhand2one = new ModelRenderer(this, 0, 19);
      Mechhand2one.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhand2one.setRotationPoint(-8F, 4.5F, -8F);
      Mechhand2one.setTextureSize(64, 64);
      Mechhand2one.mirror = true;
      setRotation(Mechhand2one, -0.1745329F, 0F, 0.1745329F);
      Mechhand2two = new ModelRenderer(this, 1, 19);
      Mechhand2two.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhand2two.setRotationPoint(-8F, 4.5F, 7F);
      Mechhand2two.setTextureSize(64, 64);
      Mechhand2two.mirror = true;
      setRotation(Mechhand2two, 0.1745329F, 0F, 0.1745329F);
      Mechhand2three = new ModelRenderer(this, 1, 19);
      Mechhand2three.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhand2three.setRotationPoint(7F, 4.5F, 7F);
      Mechhand2three.setTextureSize(64, 64);
      Mechhand2three.mirror = true;
      setRotation(Mechhand2three, 0.1745329F, 0F, -0.1745329F);
      Mechhand2four = new ModelRenderer(this, 1, 19);
      Mechhand2four.addBox(0F, 0F, 0F, 1, 10, 1);
      Mechhand2four.setRotationPoint(7F, 4.5F, -8F);
      Mechhand2four.setTextureSize(64, 64);
      Mechhand2four.mirror = true;
      setRotation(Mechhand2four, -0.1745329F, 0F, -0.1745329F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean renderEye)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base.render(f5);
    Oneborder.render(f5);
    Twoborder.render(f5);
    Threeborder.render(f5);
    Fourborder.render(f5);
    Mechhandone.render(f5);
    Mechhandtwo.render(f5);
    Mechhandthree.render(f5);
    Mechhandfour.render(f5);
    if(renderEye)
      Focus.render(f5);
    Mechhand2one.render(f5);
    Mechhand2two.render(f5);
    Mechhand2three.render(f5);
    Mechhand2four.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
  }

}
