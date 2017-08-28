package harry.harrysmod.init;

import java.util.logging.Logger;

import harry.harrysmod.util.Reference;
import harry.harrysmod.world.biome.BiomeCopper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit 
{
	public static Biome COPPER;
	
	public static void init()
	{
		COPPER = new BiomeCopper();
		Logger.getLogger(Reference.MODID).config("Biome Initialized");
	}
	
	public static void register()
	{
		registerBiome(COPPER, 100, "copper", BiomeType.COOL);
	}
	
	public static void registerBiome(Biome biome, int spawnWeight, String name, BiomeType type)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(biome, spawnWeight));
	}
}
