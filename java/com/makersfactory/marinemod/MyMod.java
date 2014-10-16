package com.makersfactory.marinemod;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; // used in 1.6.2
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="NAME_GOES_HERE_ID", name="NAME_GOES_HERE", version="0.1.0")
public class MyMod {
	@Instance(value = "1")
	public static MyMod instance;
	@SidedProxy(clientSide="com.makersfactory.marinemod.client.ClientProxy", serverSide="com.makersfactory.marinemod.CommonProxy")
	public static CommonProxy proxy;
	
	// NEW FIELDS GO HERE
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		// Register the two Event Listener files
		MinecraftForge.EVENT_BUS.register(new MyForgeEvents());
		FMLCommonHandler.instance().bus().register(new MyWorldEvents());
		
		// Register mobs
		int entityID = 0;
		MyMobSetup.mainRegistry(this);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		GameRegistry.registerWorldGenerator(new MyGenerator(), 1000);		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
