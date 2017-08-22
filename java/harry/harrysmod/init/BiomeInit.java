package harry.harrysmod.init;

import harry.harrysmod.util.Reference;
import harry.harrysmod.world.biome.BiomeCopper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.common.BiomeManager;
import scala.actors.threadpool.Arrays;

public class BiomeInit 
{
	public static Biome biome_copper;
	
	public static void init()
	{
		biome_copper = new BiomeCopper(new BiomeProperties("Copper"));
	}
	
	public static void register()
	{
		registerBiome(Reference.copper_id, "Copper", biome_copper, Type.FOREST);
	}
	
	public static void registerBiome(int ID, String name, Biome biome, Type type)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeManager.addSpawnBiome(biome);
		BiomeDictionary.addTypes(biome, type);
	}
}
