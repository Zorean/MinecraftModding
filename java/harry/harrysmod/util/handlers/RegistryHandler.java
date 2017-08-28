package harry.harrysmod.util.handlers;

import harry.harrysmod.init.BiomeInit;
import harry.harrysmod.init.BlockInit;
import harry.harrysmod.init.DimensionInit;
import harry.harrysmod.util.Reference;
import harry.harrysmod.world.dimension.WorldProviderCopper;
import harry.harrysmod.world.feature.tree.TreeGeneration;
import net.minecraft.world.DimensionType;
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
		DimensionInit.register();
		
	}
}
