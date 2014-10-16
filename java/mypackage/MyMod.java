package mypackage;

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

@Mod(modid="MyModID", name="My Mod", version="1.0.0")
public class MyMod {
	public static int varCount = 5;
	public static int armorCount = 5;
	public static HashMap<String, Integer> armorMap = new HashMap<String, Integer>();

	// AUTHOR NAME: Craig Morgard

	@Instance(value = "1")
	public static MyMod instance;
	@SidedProxy(clientSide="mypackage.client.ClientProxy", serverSide="mypackage.CommonProxy")
	public static CommonProxy proxy;

	// MATERIALS
	
	// NEW ITEMS
	public static MyItem makersIngot = new MyItem(CreativeTabs.tabMaterials);
	public static MyItem makersMineral = new MyItem(CreativeTabs.tabMaterials);
	
	// NEW BLOCKS
	public static MyBlock makersOre = new MyBlock(CreativeTabs.tabBlock, Material.rock);
	public static MyBlock makersBlock = new MyBlock(CreativeTabs.tabBlock, Material.iron);
	
	// NEW ARMOR
	
	// NEW THROWABLE
	public static MyThrowableItem makersThrowable = new MyThrowableItem(CreativeTabs.tabMisc);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		// BLOCK QUALITIES
		makersOre.setHarvestLevel("pickaxe", 1);
		makersOre.setHardness(5.0F);
		makersOre.setResistance(50.0F);
		makersOre.addBlockDropped(makersBlock);

		makersOre.setHarvestLevel("pickaxe", 1);
		makersOre.setHardness(3.0F);
		makersOre.setResistance(15.0F);
		makersOre.addItemDropped(makersMineral,2,4);
		
		// POTION EFFECTS FOR FOOD
		
		// REGISTER ENTITIES
		registerEverything();
		MinecraftForge.EVENT_BUS.register(new MyForgeEvents());
		FMLCommonHandler.instance().bus().register(new MyWorldEvents());
		int entityID = 0;
		MyMobSetup.mainRegistry(this);
		EntityRegistry.registerModEntity(MyThrowableEntity.class, "MyThrowableEntity", EntityRegistry.findGlobalUniqueEntityId(), this, 80, 1, true);
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();
		
		GameRegistry.registerWorldGenerator(new MyGenerator(), 1000);
		
		// ITEM STACKS
		ItemStack oneMakersMineral = new ItemStack(makersMineral);
		ItemStack oneMakersIngot = new ItemStack(makersIngot);
		ItemStack nineMakersIngot = new ItemStack(makersIngot, 9);
		ItemStack oneMakersOre = new ItemStack(makersOre);
		ItemStack oneMakersBlock = new ItemStack(makersBlock);
		ItemStack fourMakersThrowable = new ItemStack(makersThrowable, 4);
		ItemStack oneGunpowder = new ItemStack(Items.gunpowder);
		
		// NEW RECIPES
		GameRegistry.addRecipe(oneMakersBlock, "iii", "iii", "iii", 'i', oneMakersIngot);
		GameRegistry.addRecipe(fourMakersThrowable, " a ", "aba", " a ", 'a', oneMakersIngot, 'b', oneGunpowder);
		GameRegistry.addShapelessRecipe(nineMakersIngot, oneMakersBlock);
		GameRegistry.addSmelting(oneMakersOre, oneMakersIngot, 1.0F);
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
	public static ToolMaterial addToolMaterial(int harvest_level, int durability, float efficiency, float damage, int enchantability) {
		return EnumHelper.addToolMaterial(MyMod.class.getDeclaredFields()[MyMod.varCount++].getName(),harvest_level,durability,efficiency,damage,enchantability);
	}

	public static ArmorMaterial addArmorMaterial(int durability, int[] damage_reductions, int enchantability) {
		armorMap.put(MyMod.class.getDeclaredFields()[MyMod.varCount].getName(), MyMod.armorCount++);
		return EnumHelper.addArmorMaterial(MyMod.class.getDeclaredFields()[MyMod.varCount++].getName(),durability,damage_reductions,enchantability);
	}
	
	private void registerEverything() {
		try {
			for (Field f : this.getClass().getDeclaredFields()) {
				Class c = f.getType();
				if (	c == MyAxe.class || c == MyBoots.class || c == MyChestplate.class || 
						c == MyFood.class || c == MyHelmet.class || c == MyHoe.class || 
						c == MyItem.class || c == MyLeggings.class || c == MyPickaxe.class || 
						c == MySpade.class || c == MySword.class || c == MyThrowableItem.class) {
					Item item = (Item)f.get(this);
					GameRegistry.registerItem(item, item.getUnlocalizedName());
				}
				if (c == MyBlock.class) {
					Block block = (Block)f.get(this);
					GameRegistry.registerBlock(block, block.getUnlocalizedName());
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
