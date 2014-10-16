package mypackage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class MyPickaxe extends ItemPickaxe {
	
	String name;
	
	public MyPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		this.name = MyMod.class.getDeclaredFields()[MyMod.varCount++].getName();
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("myassets:" + this.name);
	}


}
