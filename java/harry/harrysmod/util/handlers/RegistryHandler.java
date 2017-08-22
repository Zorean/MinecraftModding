package harry.harrysmod.util.handlers;

import harry.harrysmod.init.BiomeInit;
import harry.harrysmod.init.BlockInit;
import harry.harrysmod.world.feature.tree.CopperTree;
import harry.harrysmod.world.feature.tree.TreeGeneration;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryHandler 
{
	public static void Client()
	{
		
	}
	
	public static void Common()
	{
		BlockInit.init();
		BlockInit.register();
		BlockInit.registerRenders();
		
		BiomeInit.init();
		BiomeInit.register();
		
		GameRegistry.registerWorldGenerator(new TreeGeneration(), 0);
	}
}
