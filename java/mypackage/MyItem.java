package mypackage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyItem extends Item {
	
	String name;
	
	public MyItem(CreativeTabs tab) {
		super();
		this.name = MyMod.class.getDeclaredFields()[MyMod.varCount++].getName();
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(tab);
		this.setTextureName("myassets:" + this.name);
	}

}