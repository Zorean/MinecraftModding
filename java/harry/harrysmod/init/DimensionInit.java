package harry.harrysmod.init;

import com.sun.jna.platform.win32.WinDef.WPARAM;

import harry.harrysmod.util.Reference;
import harry.harrysmod.world.dimension.WorldProviderCopper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DimensionInit 
{
	public static final DimensionType COPPER = DimensionType.register("COPPER", "_copper", Reference.copper_dim_id, WorldProviderCopper.class, false);
	
	public static void register()
	{
		registerDimension(Reference.copper_dim_id, COPPER);
	}
	
	public static void registerDimension(int id, DimensionType dimension)
	{
		DimensionManager.registerDimension(id, dimension);
	}
}
