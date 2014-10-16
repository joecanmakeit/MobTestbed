package mypackage;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class MyMobRender extends RenderLiving {

    public MyMobRender(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	private static final ResourceLocation myTexture = new ResourceLocation("myassets:textures/entity/jellyfishtest.png");
	
	@Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return myTexture;
    }
	
    protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
            return -1;
    }
    
    public void doRender(EntityLivingBase par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((MyMobEntity)par1Entity, par2, par4, par6, par8, par9);
    }

}
