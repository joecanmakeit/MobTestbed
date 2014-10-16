package mypackage;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class MySpade extends ItemSpade {
	
	String name;
	
	public MySpade(ToolMaterial material) {
		super(material);
		this.name = MyMod.class.getDeclaredFields()[MyMod.varCount++].getName();
		this.setUnlocalizedName(this.name);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setTextureName("myassets:" + this.name);
	}

}
