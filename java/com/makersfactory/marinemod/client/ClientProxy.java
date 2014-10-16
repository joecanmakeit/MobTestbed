package com.makersfactory.marinemod.client;

import com.makersfactory.marinemod.CommonProxy;
import com.makersfactory.marinemod.ModelJellyfishTest;
import com.makersfactory.marinemod.MyMobEntity;
import com.makersfactory.marinemod.MyMobRender;
import com.makersfactory.marinemod.MyMod;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(MyMobEntity.class, new MyMobRender(new ModelJellyfishTest(), 0.7F));
	}
}
