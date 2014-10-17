package com.makersfactory.marinemod.client;

import com.makersfactory.marinemod.CommonProxy;
import com.makersfactory.marinemod.MarineMod;
import com.makersfactory.marinemod.entity.EntityJellyfish;
import com.makersfactory.marinemod.model.ModelJellyfish;
import com.makersfactory.marinemod.renderer.RenderJellyfish;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, new RenderJellyfish(new ModelJellyfish(1), new ModelJellyfish(0), 1.0F));
	}
}
