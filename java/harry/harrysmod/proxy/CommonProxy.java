package harry.harrysmod.proxy;

import harry.harrysmod.util.Reference;
import harry.harrysmod.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
	{
		Reference.logger.info("Common Pre Init");
		RegistryHandler.Common();
	}
	
	public void init(FMLInitializationEvent event)
	{
		Reference.logger.info("Common Init");
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		Reference.logger.info("Common Post Init");
	}
}
