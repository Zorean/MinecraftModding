package harry.harrysmod.proxy;


import harry.harrysmod.util.Reference;
import harry.harrysmod.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		Reference.logger.info("Client Pre Init");
	}
	
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
		Reference.logger.info("Client Init");
		RegistryHandler.Client();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
		Reference.logger.info("Client Post Init");
	}
}
