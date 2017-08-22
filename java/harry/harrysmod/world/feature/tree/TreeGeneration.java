package harry.harrysmod.world.feature.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TreeGeneration implements IWorldGenerator
{
	private final WorldGenerator gen_copper_tree = new CopperTree(5);
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
		{
		case -1:
			
			
			break;
			
		case 0:
			
			runGenerator(gen_copper_tree, world, random, chunkX, chunkZ, 1, -1, 0, BiomePlains.class);
			
			break;
			
		case 1:
					
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chancesToSpawn, int minHeight, int maxHeight, Class<?>... classe) 
	{
		if (chancesToSpawn < 1) 
		{
				if (random.nextDouble() < chancesToSpawn)
				{
					chancesToSpawn = 1;	
				}
				else
				{
					chancesToSpawn = 0;
				}
		}
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classe));
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) 
		{
			BlockPos pos = new BlockPos(chunkX * 16 + 10 + random.nextInt(15), minHeight + random.nextInt(heightDiff), chunkZ * 16 + 10 + random.nextInt(15));
			if (minHeight < 0) pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if (classesList.contains(biome) || classe.length == 0) generator.generate(world, random, pos);
		}
	}

	
	
}
