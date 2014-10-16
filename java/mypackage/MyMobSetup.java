package mypackage;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MyMobSetup {
	
	public static void mainRegistry(MyMod mod) {
		registerEntity(mod);
	}
	
	public static void registerEntity(MyMod mod) {
		createEntity(mod, MyMobEntity.class, "MyMob", 0xE7ABFF, 0x7700A6);
	}
	
	public static void createEntity(MyMod mod, Class entityClass, String entityName, int solidColor, int spotColor) {
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, mod, 80, 1, true);
		createEgg(randomID, solidColor, spotColor);
	}

	private static void createEgg(int randomID, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
	}
}
