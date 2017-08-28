package harry.harrysmod.world.dimension;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class CopperChunkGenerator implements IChunkGenerator 
{
	private final World world;
	private Random random;
	private Biome[] biomesForGen;
	private List<Biome.SpawnListEntry> mobs = Lists.newArrayList(new Biome.SpawnListEntry(EntityPolarBear.class, 100, 1 , 5), (new Biome.SpawnListEntry(EntityLlama.class, 10, 1 , 10)));	
	private NormalTerrainGen terraingen = new NormalTerrainGen();
	
	public CopperChunkGenerator(World world) 
	{
		this.world = world;
		long seed = world.getSeed();
		this.random = new Random(seed);
		terraingen.setup(world, random);
	}
	
	@Override
	public Chunk generateChunk(int x, int z) 
	{
		ChunkPrimer primer = new ChunkPrimer();
		
		this.biomesForGen = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGen, x*4 - 2, z*4 - 2, 10, 10);
		terraingen.setBiomesForGeneration(biomesForGen);
		terraingen.generate(x, z, primer);
		
		this.biomesForGen = this.world.getBiomeProvider().getBiomes(biomesForGen, x*16, z*16, 16, 16);
		terraingen.replaceBiomeBlocks(x, z, primer, this, biomesForGen);
		
		Chunk chunk = new Chunk(this.world, primer, x, z);
		byte[] biomeArray = chunk.getBiomeArray();
        for (int i = 0; i < biomeArray.length; ++i) 
        {
            biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGen[i]);
        }
        
		return chunk;
	}
	
	@Override
	public void populate(int x, int z) 
	{
		int i = x*16, j = z*16;
		BlockPos pos = new BlockPos(i, 0, j);
		Biome biome = this.world.getBiome(pos.add(16,0,16));
		
		biome.decorate(world, random, pos);
		WorldEntitySpawner.performWorldGenSpawning(world, biome, i+8, j+8, 16, 16, random);
	}
	
	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) 
	{
		return false;
	}
	
	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) 
	{
		Biome biome = this.world.getBiome(pos);
		return biome.getSpawnableList(creatureType);
	}
	
	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) 
	{
		return null;
	}
	
	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) 
	{
		return false;
	}
	
	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {}

}
