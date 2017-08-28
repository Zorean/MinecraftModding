package harry.harrysmod.world.dimension;

import harry.harrysmod.init.BiomeInit;
import harry.harrysmod.init.DimensionInit;
import harry.harrysmod.util.Reference;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.storage.WorldInfo;

public class WorldProviderCopper extends WorldProvider
{	
	@Override
	protected void init() 
	{
		this.biomeProvider = new BiomeProviderSingle(BiomeInit.COPPER);
	}

	@Override
	public DimensionType getDimensionType() 
	{
		return DimensionInit.COPPER;
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int x, int z) 
	{
		return false;
	}
	
	@Override
	public boolean canRespawnHere() 
	{
		return false;
	}
	
	@Override
	public boolean doesXZShowFog(int x, int z) 
	{
		return false;
	}
	
	@Override
	public Vec3d getFogColor(float x, float z) 
	{
		return new Vec3d(0.4D, 0.5D, 0.1D);
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() 
	{
		return new CopperChunkGenerator(world);
	}
}
